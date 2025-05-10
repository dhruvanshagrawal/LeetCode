public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first window of size k
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;

        // Slide the window over the array
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        // Return the maximum average
        return maxSum / k;
    }
}
