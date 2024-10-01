import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] f) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int left = 0, right = 0; right < f.length; right++) {
            int in = f[right];
            hash.put(in, hash.getOrDefault(in, 0) + 1);
            while (hash.size() > 2) {
                int out = f[left];
                hash.put(out, hash.get(out) - 1);
                if (hash.get(out) == 0) {
                    hash.remove(out);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }
}