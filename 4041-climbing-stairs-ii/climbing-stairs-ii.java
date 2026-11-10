import java.util.*;
class Solution {
    public int[] dp;
    public int solve(int i,int n, int[] costs){
        //base case
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
    
    int cost=Integer.MAX_VALUE;
    //jump of 1
    int j=i+1;
    if(j<=n){
         cost=Math.min(cost,costs[j-1]+(j-i)*(j-i)+solve(j,n,costs));
    }
    //jump of 2
     j=i+2;
    if(j<=n){
         cost=Math.min(cost,costs[j-1]+(j-i)*(j-i)+solve(j,n,costs));
    }
    //jump of 3
     j=i+3;
    if(j<=n){
        cost=Math.min(cost,costs[j-1]+(j-i)*(j-i)+solve(j,n,costs));
    }
    return dp[i]=cost;
    }
    public int climbStairs(int n, int[] costs) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,n,costs);
    }
}