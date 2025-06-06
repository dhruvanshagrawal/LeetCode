import java.util.*;

class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minSuffix = new char[n];
        
        minSuffix[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = (char) Math.min(s.charAt(i), minSuffix[i + 1]);
        }

        Deque<Character> t = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < n || !t.isEmpty()) {
            while (index < n && (t.isEmpty() || t.peekLast() > minSuffix[index])) {
                t.addLast(s.charAt(index));
                index++;
            }
            result.append(t.pollLast());
        }

        return result.toString();
    }
}