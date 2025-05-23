import java.util.*;

class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        long[] res = dfs(0, -1, nums, graph, k);
        return res[0]; // we want the max sum with even number of XORs in the whole tree
    }

    private long[] dfs(int node, int parent, int[] nums, List<List<Integer>> graph, int k) {
        // dp[0] = max sum when node is NOT XORed
        // dp[1] = max sum when node IS XORed
        long[] dp = new long[2];
        dp[0] = nums[node];       // not XORed
        dp[1] = nums[node] ^ k;   // XORed

        for (int nei : graph.get(node)) {
            if (nei == parent) continue;

            long[] child = dfs(nei, node, nums, graph, k);

            long ndp0 = Math.max(
                dp[0] + child[0],   // even-even = even
                dp[1] + child[1]    // odd-odd = even
            );

            long ndp1 = Math.max(
                dp[0] + child[1],   // even-odd = odd
                dp[1] + child[0]    // odd-even = odd
            );

            dp[0] = ndp0;
            dp[1] = ndp1;
        }

        return dp;
    }
}
