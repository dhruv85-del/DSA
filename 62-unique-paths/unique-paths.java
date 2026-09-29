import java.util.Arrays;
class Solution {
    int fun(int i,int j, int m, int n,int[][] dp){
        if(i==n-1 || j==m-1) return 1;
        if(i>=n || j>=m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]= fun(i+1,j,m,n,dp)+fun(i,j+1,m,n,dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[n+1][m+1];
        for(int[] row:dp){

        Arrays.fill(row,-1);
        }
        return fun(0,0,m,n,dp);
    }
}