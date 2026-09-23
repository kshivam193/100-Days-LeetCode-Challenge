class Solution {

    int[][] dp;

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int lcs = fun(0, 0, word1, word2);

        return (n - lcs) + (m - lcs);
    }

    int fun(int i, int j, String a, String b) {

        if(i == a.length() || j == b.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(a.charAt(i) == b.charAt(j)) {
            return dp[i][j] =
                1 + fun(i + 1, j + 1, a, b);
        }

        return dp[i][j] = Math.max(
            fun(i + 1, j, a, b),
            fun(i, j + 1, a, b)
        );
    }
}