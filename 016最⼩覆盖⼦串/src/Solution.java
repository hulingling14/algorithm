class Solution {
    public String minWindow(String ss, String tt) {
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();
        int[] hash1 = new int[128]; // 统计字符串 t 中每?个字符的频次
        int kinds = 0; // 统计有效字符有多少种
        for (char ch : t)
            if (hash1[ch]++ == 0)
                kinds++;
        int[] hash2 = new int[128]; // 统计窗?内每个字符的频次
        int minlen = Integer.MAX_VALUE, begin = -1;
        for (int left = 0, right = 0, count = 0; right < s.length; right++) {
            char in = s[right];
            if (++hash2[in] == hash1[in])
                count++; // 进窗? + 维护 count
            while (count == kinds) // 判断条件
            {
                if (right - left + 1 < minlen) // 更新结果
                {
                    minlen = right - left + 1;
                    begin = left;
                }
                char out = s[left++];
                if (hash2[out]-- == hash1[out])
                    count--; // 出窗? + 维护 count
            }
        }
        if (begin == -1)
            return new String();
        else
            return ss.substring(begin, begin + minlen);
    }
}