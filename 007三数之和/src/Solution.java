import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list1 = new ArrayList<>();
        // List<Integer> list2 = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n;) {
            if (nums[i] > 0)
                break;
            int t = nums[i];
            int left = i + 1;
            int right = n - 1;
            //int sum = nums[left] + nums[right];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum + t > 0) {
                    right--;
                } else if (sum + t < 0) {
                    left++;
                } else {
                    // list2.add(nums[left]);
                    // list2.add(nums[right]);
                    // list2.add(nums[i]);
                    // list1.add(list2);
                    list1.add(new ArrayList<Integer>(Arrays.asList(nums[i],
                            nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && right <= n - 2 && nums[right] == nums[right + 1])
                        right--;
                }
//                while (left < right && nums[left] == nums[left - 1])
//                    left++;
//                while (left < right && right <= n - 2 && nums[right] == nums[right + 1])
//                    right--;
            }
            i++;
            while (i < n && nums[i] == nums[i - 1])
                i++;
        }
        return list1;
    }
}