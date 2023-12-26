class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibHelper(n, dp);
    }

    public static int fibHelper(int n, int[] dp){
        if (n==1 || n==0){
            return n;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        int a = fibHelper(n-1, dp);
        int b = fibHelper(n-2, dp);

        dp[n] = a+b;
        return a+b;
    }
}