import java.util.*;

class Solution {

    int[][][] dp = new int[101][101][201];

    int fun(int i, int j, char[][] grid, int open) {

        int n = grid.length;
        int m = grid[0].length;

        if (i >= n || j >= m)
            return 0;

        if (grid[i][j] == '(')
            open++;
        else
            open--;

        if (open < 0)
            return 0;

        int remaining = (n - 1 - i) + (m - 1 - j);

        if (open > remaining)
            return 0;

        if (i == n - 1 && j == m - 1)
            return open == 0 ? 1 : 0;

        if (dp[i][j][open] != -1)
            return dp[i][j][open];

        int c1 = fun(i + 1, j, grid, open);
        int c2 = fun(i, j + 1, grid, open);

        return dp[i][j][open] = c1 | c2;
    }

    public boolean hasValidPath(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // First character must be '('
        if (grid[0][0] == ')')
            return false;

        // Total path length must be even
        if ((n + m - 1) % 2 != 0)
            return false;

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return fun(0, 0, grid, 0) == 1;
    }
}