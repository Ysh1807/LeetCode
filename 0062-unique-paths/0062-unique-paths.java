class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
         for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(m-1, n-1, dp);
    }

    public int helper(int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 1;
        }
        if (dp[m][n] != -1){
            return dp[m][n];
        }
        int x = helper(m-1, n, dp);
        int y = helper(m, n-1, dp);
        dp[m][n] = x+y;
        return x+y;
    }
}