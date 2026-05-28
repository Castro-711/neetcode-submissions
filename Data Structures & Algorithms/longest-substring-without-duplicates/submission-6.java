class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;

        // INVARIANT: A valid substring must contain unique characters
        Set<Character> encounteredChars = new HashSet<>();

        while (right < s.length()) {
            if (!encounteredChars.contains(s.charAt(right))) {
                encounteredChars.add(s.charAt(right));
                if (maxLen < right - left + 1) {
                    maxLen = right - left + 1;
                }
                right++;
            } else {
                encounteredChars.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}
