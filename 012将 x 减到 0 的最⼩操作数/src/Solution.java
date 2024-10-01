class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int a : nums)
            sum += a;
        int target = sum - x;
        // ´¦ÀíÏ¸½Ú
        if (target < 0)
            return -1;
        int ret = -1;
        for (int left = 0, right = 0, tmp = 0; right < nums.length; right++) {
            tmp += nums[right];
            while (tmp > target) {
                tmp -= nums[left++];
            }
            if (tmp == target)
                ret = Math.max(ret, right - left + 1);
        }
        if (ret == -1)
            return -1;
        else
            return nums.length - ret;
    }
}