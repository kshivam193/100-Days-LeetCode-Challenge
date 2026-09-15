class Solution {

    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, 0, text1, text2);
    }

    int fun(int i, int j, String text1, String text2) {

        if(i == text1.length() || j == text2.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] =
                1 + fun(i + 1, j + 1, text1, text2);
        }

        return dp[i][j] = Math.max(
            fun(i + 1, j, text1, text2),
            fun(i, j + 1, text1, text2)
        );
    }
}