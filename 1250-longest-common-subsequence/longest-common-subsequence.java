import java.util.Arrays;
class Solution {
    public int fun(String s1, String s2, int n, int m, int i, int j,int[][]dp){
        if(i==n|| j==m ) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]= 1+fun(s1,s2,n,m,i+1,j+1,dp);
        int c1=fun(s1,s2,n,m,i,j+1,dp);
        int c2=fun(s1,s2,n,m,i+1,j,dp);
        return dp[i][j]=Math.max(c1,c2);
    }
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int [][] dp=new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        return fun(s1,s2,n,m,0,0,dp);
    }
}