
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int total = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];

                int length = j - i + 1;

                if (length % 2 != 0) {
                    total += sum;
                }
            }
        }

        return total;
    }
}
