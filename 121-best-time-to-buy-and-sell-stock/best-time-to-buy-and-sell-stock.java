class Solution {
    int fun(int[] prices, int n,int i,int k,int[][] dp){
        if(i==n) return 0;
        if(k==0) return 0;
        if(dp[i][k]!=-1) return dp[i][k];
        if(k==2){
        int c1=fun(prices,n,i+1,k-1,dp)-prices[i];
        int c2=fun(prices,n,i+1,k,dp);
        return dp[i][k]=Math.max(c1,c2);
        }else{
            int c1=fun(prices,n,i+1,k-1,dp)+prices[i];
            int c2=fun(prices,n,i+1,k,dp);
            return dp[i][k]= Math.max(c1,c2);
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int k=2;
        int[][] dp=new int[n][k+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        int profit=fun(prices,n,0,k,dp);
        return Math.max(0,profit);
    }
}