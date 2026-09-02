class Solution {
    public int solve(int[] nums,int n, int i, int[] dp){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int c1=nums[i]+solve(nums,n,i+2,dp);
        int c2=solve(nums,n,i+1,dp);
        dp[i]=Math.max(c1,c2);
        return dp[i];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,n,0,dp);
    }
}