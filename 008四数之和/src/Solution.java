import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        // 1. 排序
        Arrays.sort(nums);
        // 2. 利?双指针解决问题
        int n = nums.length;
        for (int i = 0; i < n; ) // 固定数 a
        {
            // 三数之和
            for (int j = i + 1; j < n; ) // 固定数 b
            {
                // 双指针
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
                        // 去重?
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    }
                }
                // 去重?
                j++;
                while (j < n && nums[j] == nums[j - 1])
                    j++;
            }
            // 去重三
            i++;
            while (i < n && nums[i] == nums[i - 1])
                i++;
        }
        return ret;
    }
}