class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = ret[1] = -1;
        // ����߽����
        if (nums.length == 0) return ret;
        // 1. ?����˵�
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        // �ж��Ƿ��н��
        if (nums[left] != target) return ret;
        else ret[0] = right;
        // 2. ?���Ҷ˵�
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) left = mid;
            right = mid - 1;
        }
        ret[1] = left;
        return ret;
    }
}