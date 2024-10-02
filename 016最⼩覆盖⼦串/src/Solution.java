class Solution {
    public String minWindow(String ss, String tt) {
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();
        int[] hash1 = new int[128]; // ͳ���ַ��� t ��ÿ?���ַ���Ƶ��
        int kinds = 0; // ͳ����Ч�ַ��ж�����
        for (char ch : t)
            if (hash1[ch]++ == 0)
                kinds++;
        int[] hash2 = new int[128]; // ͳ�ƴ�?��ÿ���ַ���Ƶ��
        int minlen = Integer.MAX_VALUE, begin = -1;
        for (int left = 0, right = 0, count = 0; right < s.length; right++) {
            char in = s[right];
            if (++hash2[in] == hash1[in])
                count++; // ����? + ά�� count
            while (count == kinds) // �ж�����
            {
                if (right - left + 1 < minlen) // ���½��
                {
                    minlen = right - left + 1;
                    begin = left;
                }
                char out = s[left++];
                if (hash2[out]-- == hash1[out])
                    count--; // ����? + ά�� count
            }
        }
        if (begin == -1)
            return new String();
        else
            return ss.substring(begin, begin + minlen);
    }
}