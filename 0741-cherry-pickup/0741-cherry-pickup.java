class Solution {
    int[][][][] dp = new int[51][51][51][51];
    private int fun(int[][] grid, int i, int j, int k, int l){
        int n = grid.length;
        if(i >= n || j >= n || k >= n || l >= n || grid[i][j] == -1 || grid[k][l] == -1) return -1000000;
        if (i == n - 1 && j == n - 1 && k == n - 1 && l == n - 1) {
            return grid[i][j];
        }
        if(dp[i][j][k][l] != -1000000) return dp[i][j][k][l];
        int ans;
        if( i == k && j == l) {
            ans = grid[i][j];
        } else {
            ans = grid[i][j] + grid[k][l];
        }
        int a = fun(grid, i + 1, j, k + 1, l);
        int b = fun(grid, i + 1, j, k, l + 1);
        int c = fun(grid, i, j + 1, k + 1, l);
        int d = fun(grid, i, j + 1, k, l + 1);

        ans += Math.max(Math.max(a, b) , Math.max(c, d));

        return dp[i][j][k][l] = ans;
    }
    public int cherryPickup(int[][] grid) {
        for(int i = 0; i < 51; i++){
            for(int j = 0; j < 51; j++){
                for(int k = 0; k < 51; k++){
                    Arrays.fill(dp[i][j][k], -1000000);
                }
            }
        }
        return Math.max(0, fun(grid, 0, 0, 0, 0));
    }
}