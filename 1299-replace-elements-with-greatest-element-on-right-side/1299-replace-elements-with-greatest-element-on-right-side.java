
class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int max = arr[i + 1];

            for (int j = i + 1; j < n; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }

            result[i] = max;
        }

        result[n - 1] = -1;

        return result;
    }
}
