class Solution {
    public int longestPalindrome(String[] words) {
        // Map to count all word occurrences
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();

            // If reverse exists, form a palindrome pair
            if (map.getOrDefault(reverse, 0) > 0) {
                result += 4; // each word has 2 letters => 2 + 2 = 4
                map.put(reverse, map.get(reverse) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Check for any "aa", "bb", etc. that can go in the middle
        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                result += 2;
                break; // only one such word can go in the middle
            }
        }

        return result;
    }
}
