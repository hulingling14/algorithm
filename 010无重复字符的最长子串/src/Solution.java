class Solution {
    public int lengthOfLongestSubstring(String ss) {
        char[] s = ss.toCharArray();
        int[] hash = new int[128];
        int n = ss.length();
        int left = 0, right = 0, len = 0;
        while (right < n) {
            hash[s[right]]++;
            while (hash[s[right]] > 1) {
                hash[s[left++]]--;
            }
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}