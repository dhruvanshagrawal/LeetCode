public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = 0, count = 0;

                for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); ++x) {
                    for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); ++y) {
                        sum += img[x][y];
                        count++;
                    }
                }

                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
