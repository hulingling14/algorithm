class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int v = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                v = height[left] * (right - left);
                if (v > max)
                    max = v;
                left++;
            } else {
                v = height[right] * (right - left);
                if (v > max)
                    max = v;
                right--;
            }
        }
        return max;
    }
}