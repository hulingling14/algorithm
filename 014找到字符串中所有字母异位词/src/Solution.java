import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String ss, String pp) {
        List<Integer> ret = new ArrayList<Integer>();
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        int[] hash1 = new int[26]; // 统计字符串 p 中每?个字符出现的个数
        for (char ch : p)
            hash1[ch - 'a']++;
        int[] hash2 = new int[26]; // 统计窗?中每?个字符出现的个数
        int m = p.length;
        for (int left = 0, right = 0, count = 0; right < s.length; right++) {
            char in = s[right];
            // 进窗? + 维护 count
            if (++hash2[in - 'a'] <= hash1[in - 'a'])
                count++;
            if (right - left + 1 > m) // 判断
            {
                char out = s[left++];
                // 出窗? + 维护 count
                if (hash2[out - 'a']-- <= hash1[out - 'a'])
                    count--;
            }
            // 更新结果
            if (count == m)
                ret.add(left);
        }
        return ret;
    }
}