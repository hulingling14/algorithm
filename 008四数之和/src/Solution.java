import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        // 1. ����
        Arrays.sort(nums);
        // 2. ��?˫ָ��������
        int n = nums.length;
        for (int i = 0; i < n; ) // �̶��� a
        {
            // ����֮��
            for (int j = i + 1; j < n; ) // �̶��� b
            {
                // ˫ָ��
                int left = j + 1, right = n - 1;
                long aim = (long) target - nums[i] - nums[j];
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum > aim)
                        right--;
                    else if (sum < aim)
                        left++;
                    else {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[left++],
                                nums[right--]));
                        // ȥ��?
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    }
                }
                // ȥ��?
                j++;
                while (j < n && nums[j] == nums[j - 1])
                    j++;
            }
            // ȥ����
            i++;
            while (i < n && nums[i] == nums[i - 1])
                i++;
        }
        return ret;
    }
}