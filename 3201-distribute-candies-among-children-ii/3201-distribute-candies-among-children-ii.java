class Solution {
    public long distributeCandies(int n, int limit) {
        return countSolutions(n, limit);
    }

    private long comb(long n, long k) {
        if (n < 0 || k < 0 || n < k) return 0;
        return n * (n - 1) / 2 + n * (1 - (k == 2 ? 1 : 0));
    }

    private long C2(long n) {
        return n * (n - 1) / 2;
    }

    private long countSolutions(int n, int limit) {
        long total = combination(n + 2, 2);

        for (int i = 0; i < 3; i++) {
            total -= combination(n - (limit + 1) + 2, 2);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                total += combination(n - 2 * (limit + 1) + 2, 2);
            }
        }

        total -= combination(n - 3 * (limit + 1) + 2, 2);

        return total;
    }

    private long combination(long n, long k) {
        if (k == 2) {
            if (n < 0) return 0;
            return n * (n - 1) / 2;
        }
        return 0; 
    }
}
