class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }

        int n = word.length();
        String ans = "";

        for (int i = 0; i < n; ++i) {
            int maxLen = Math.min(n - i, n - numFriends + 1);
            String current = word.substring(i, i + maxLen);
            if (current.compareTo(ans) > 0) {
                ans = current;
            }
        }

        return ans;
    }
}
