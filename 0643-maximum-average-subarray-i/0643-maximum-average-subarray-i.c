double findMaxAverage(int* nums, int numsSize, int k) {
    int sum = 0;
    
    // Initial window sum
    for (int i = 0; i < k; i++) {
        sum += nums[i];
    }
    
    int maxSum = sum;

    // Slide the window
    for (int i = k; i < numsSize; i++) {
        sum += nums[i] - nums[i - k];
        if (sum > maxSum) {
            maxSum = sum;
        }
    }

    return (double)maxSum / k;
}
