class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        slow = sum(slow);
        fast = sum(fast);
        fast = sum(fast);
        while (slow != fast) {
            slow = sum(slow);
            fast = sum(fast);
            fast = sum(fast);
        }
        if (slow == 1)
            return true;
        else
            return false;
    }

    public int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}