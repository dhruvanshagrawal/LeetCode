public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];
        int[] directions = {-1, 0, 1}; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0, count = 0;
                for (int dx : directions) {
                    for (int dy : directions) {
                        int ni = i + dx;
                        int nj = j + dy;

                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                            sum += img[ni][nj];
                            count++;
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
}
