import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String ss, String pp) {
        List<Integer> ret = new ArrayList<Integer>();
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        int[] hash1 = new int[26]; // ͳ���ַ��� p ��ÿ?���ַ����ֵĸ���
        for (char ch : p)
            hash1[ch - 'a']++;
        int[] hash2 = new int[26]; // ͳ�ƴ�?��ÿ?���ַ����ֵĸ���
        int m = p.length;
        for (int left = 0, right = 0, count = 0; right < s.length; right++) {
            char in = s[right];
            // ����? + ά�� count
            if (++hash2[in - 'a'] <= hash1[in - 'a'])
                count++;
            if (right - left + 1 > m) // �ж�
            {
                char out = s[left++];
                // ����? + ά�� count
                if (hash2[out - 'a']-- <= hash1[out - 'a'])
                    count--;
            }
            // ���½��
            if (count == m)
                ret.add(left);
        }
        return ret;
    }
}