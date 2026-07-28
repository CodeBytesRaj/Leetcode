class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        char middle = 0;

        // Build the first half in lexicographical order
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                firstHalf.append((char) ('a' + i));
            }

            if (freq[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }
        }

        // Build the second half by reversing the first half
        StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();

        // Construct the final palindrome
        if (middle != 0) {
            return firstHalf.toString() + middle + secondHalf.toString();
        }

        return firstHalf.toString() + secondHalf.toString();
    }
}