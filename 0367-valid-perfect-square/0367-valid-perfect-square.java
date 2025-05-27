class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        return perfect(num, 2, num / 2);
    }

    public boolean perfect(int num, int left, int right) {
        if (left > right) return false; // Base case

        int mid = left + (right - left) / 2;
        long square = (long) mid * mid;

        if (square == num) return true;
        else if (square > num)
            return perfect(num, left, mid - 1);
        else
            return perfect(num, mid + 1, right);
    }
}
