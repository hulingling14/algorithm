class Solution {
    public int[] twoSum(int[] price, int target) {
        int twoSum[] = new int[2];
        int left = 0;
        int right = price.length - 1;
        while (left < right) {
            if (price[left] + price[right] < target) {
                left++;
            } else if (price[left] + price[right] > target) {
                right--;
            } else {
                twoSum[0] = price[left];
                twoSum[1] = price[right];
                break;
            }
        }
        return twoSum;
    }
}