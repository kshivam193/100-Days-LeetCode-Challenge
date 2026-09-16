class Solution {
    int[][] dp;

    int fun(int i, int j, String s, String t) {
        if(i == s.length() || j == t.length())
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = 1 + fun(i+1, j+1, s, t);

        return dp[i][j] = Math.max(
            fun(i+1, j, s, t),
            fun(i, j+1, s, t)
        );
    }

    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();

        dp = new int[s.length()][s.length()];

        for(int[] x : dp)
            java.util.Arrays.fill(x, -1);

        return fun(0, 0, s, t);
    }
}