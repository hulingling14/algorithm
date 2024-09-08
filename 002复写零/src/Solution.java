class Solution {
    public static void duplicateZeros(int[] arr) {
        // 1.�ҵ����һ��Ҫ��д����
        int dest = 0;
        int cur = 0;
        for (dest = -1, cur = 0; dest < arr.length - 1; cur++) {
            if (arr[cur] == 0)
                dest += 2;
            else
                dest++;
        }
        cur--;
        // 2.�ж��Ƿ����
        if (dest == arr.length) {
            arr[arr.length - 1] = 0;
            cur--;
            dest -= 2;
        }
        // 3.�Ӻ���ǰ��д
        for (; cur >= 0; cur--) {
            if (arr[cur] == 0) {
                arr[dest] = 0;
                arr[dest - 1] = 0;
                dest -= 2;
            } else {
                arr[dest] = arr[cur];
                dest--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
    }
}