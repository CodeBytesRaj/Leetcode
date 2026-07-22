class Solution {

    private int start = 0;
    private int maxLen = 1;

    public String longestPalindrome(String s) {
        int n = s.length();

        if (n == 1) return s;

        for (int i = 0; i < n; i++) {
            expand(s, i, i);       // Odd length
            expand(s, i, i + 1);   // Even length
        }

        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        int len = right - left - 1;

        if (len > maxLen) {
            maxLen = len;
            start = left + 1;
        }
    }
}