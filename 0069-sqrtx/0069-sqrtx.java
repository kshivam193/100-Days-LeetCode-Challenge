class Solution {
    public int mySqrt(int x) {
        int ans = 0;

        for (int i = 1; i <= x; i++) {
            if (i > x / i) {
                break;
            }
            ans = i;
        }

        return ans;
    }
}