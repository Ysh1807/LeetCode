class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][m];
        for (int i=0; i<m; i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        int result = helper(grid, 0, 0, 0, dp);

        if(result == Integer.MIN_VALUE){
            return 0;
        }else{
            return result;
        }
    }

    public static int helper(int[][] grid, int row1, int col1, int row2, int[][][] dp){
        int col2 = row1 + col1 - row2;
        if (row1 >= grid.length || row2 >= grid.length || col1 >= grid[0].length || col2 >= grid[0].length) {
            return Integer.MIN_VALUE;
        }
        if (grid[row1][col1] == -1 || grid[row2][col2] == -1){
            return Integer.MIN_VALUE;
        }
        if (row1 == grid.length-1 && row2 == grid.length-1 && col1 == grid[0].length-1 && col2 == grid[0].length-1) {
            return grid[row1][col1];
        }
        if (dp[row1][col1][row2] != -1){
            return dp[row1][col1][row2];
        }

        int path1 = helper(grid, row1+1, col1, row2+1, dp);
        int path2 = helper(grid, row1+1, col1, row2, dp);
        int path3 = helper(grid, row1, col1+1, row2, dp);
        int path4 = helper(grid, row1, col1+1, row2+1, dp);

        int contri;
        if (row1==row2 || col1==col2){
            contri = grid[row1][col1];
        }else {
            contri = grid[row1][col1] + grid[row2][col2];
        }
        int ans = Math.max(Math.max(path1, path2), Math.max(path3, path4));

        if (ans == Integer.MIN_VALUE) {
            dp[row1][col1][row2] = Integer.MIN_VALUE;
            return ans;
        }else {
            ans = ans + contri;
            dp[row1][col1][row2] = ans;
            return ans;
        }
    }
}