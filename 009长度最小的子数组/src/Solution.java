class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int sum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum >= target) {
                len = Math.min(len, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
        // public static void main(String[] args) {
        // int[] nums={2,3,1,2,4,3};
        // System.out.println(minSubArrayLen(7, nums));
        // }
    }
}
