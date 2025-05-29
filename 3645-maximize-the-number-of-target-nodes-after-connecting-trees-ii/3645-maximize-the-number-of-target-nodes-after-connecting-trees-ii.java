import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Build adjacency lists for both trees
        List<Integer>[] graph1 = buildGraph(edges1, n);
        List<Integer>[] graph2 = buildGraph(edges2, m);

        // Arrays to store parity (even or odd depth) for each node
        boolean[] parity1 = new boolean[n];
        boolean[] parity2 = new boolean[m];

        // Count nodes at even depth in both trees
        int evenCount1 = dfs(graph1, 0, -1, parity1, true);
        int evenCount2 = dfs(graph2, 0, -1, parity2, true);

        int oddCount1 = n - evenCount1;
        int oddCount2 = m - evenCount2;

        int[] result = new int[n];

        // For each node in the first tree, calculate the maximum number of target nodes
        for (int i = 0; i < n; i++) {
            int sameParityCount = parity1[i] ? evenCount1 : oddCount1;
            int maxTargetNodes = sameParityCount + Math.max(evenCount2, oddCount2);
            result[i] = maxTargetNodes;
        }

        return result;
    }

    // Helper method to build the adjacency list for a tree
    private List<Integer>[] buildGraph(int[][] edges, int nodeCount) {
        List<Integer>[] graph = new ArrayList[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }

    // Depth-First Search to determine parity and count of even-depth nodes
    private int dfs(List<Integer>[] graph, int currentNode, int parent, boolean[] parity, boolean isEven) {
        parity[currentNode] = isEven;
        int count = isEven ? 1 : 0;
        for (int neighbor : graph[currentNode]) {
            if (neighbor != parent) {
                count += dfs(graph, neighbor, currentNode, parity, !isEven);
            }
        }
        return count;
    }
}
