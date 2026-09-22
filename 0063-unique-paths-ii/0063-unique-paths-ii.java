class Solution {
    int[][] dp;
    int fun(int i, int j, int[][] a){
        if(i>=a.length || j>=a[0].length || a[i][j]==1)
        return 0;

        if(i==a.length-1 && j==a[0].length-1)
        return 1;

        if(dp[i][j]!= -1)
        return dp[i][j];

        return dp[i][j] = fun(i+1,j,a) + fun(i,j+1,a);     
    }

    public int uniquePathsWithObstacles(int[][] a){
        dp = new int[a.length][a[0].length];

        for(int[] x : dp)
        java.util.Arrays.fill(x, -1);

        return fun(0,0,a);
    }


}