class Solution {
    public void moveZeroes(int[] nums) {
        int dest = -1;
        int cur = 0;
        int tmp;
        while (cur != nums.length) {
            if (nums[cur] == 0)
                cur++;
            else {
                dest++;
                tmp = nums[cur];
                nums[cur] = nums[dest];
                nums[dest] = tmp;
                cur++;
            }
        }
    }
}