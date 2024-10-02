import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<Integer>();
        // 保存字典中所有单词的频次
        Map<String, Integer> hash1 = new HashMap<String, Integer>();
        for (String str : words)
            hash1.put(str, hash1.getOrDefault(str, 0) + 1);
        int len = words[0].length(), m = words.length;
        for (int i = 0; i < len; i++) // 执?次数
        {
            // 保存窗?内所有单词的频次
            Map<String, Integer> hash2 = new HashMap<String, Integer>();
            for (int left = i, right = i, count = 0; right + len <= s.length(); right += len) {
                // 进窗? + 维护 count
                String in = s.substring(right, right + len);
                hash2.put(in, hash2.getOrDefault(in, 0) + 1);
                if (hash2.get(in) <= hash1.getOrDefault(in, 0))
                    count++;
                // 判断
                if (right - left + 1 > len * m) {
                    // 出窗? + 维护 count
                    String out = s.substring(left, left + len);
                    if (hash2.get(out) <= hash1.getOrDefault(out, 0))
                        count--;
                    hash2.put(out, hash2.get(out) - 1);
                    left += len;
                }
                // 更新结果
                if (count == m)
                    ret.add(left);
            }
        }
        return ret;
    }
}