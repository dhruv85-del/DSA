class Solution {
     public int maxsum(int[] nums) {
        int sum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxsum=Math.max(sum,maxsum);
            if(sum<0) sum=0;
        }
        return maxsum;
    }
     public int minsum(int[] nums) {
        int sum=0;
        int minsum=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            minsum=Math.min(sum,minsum);
            if(sum>0) sum=0;
        }
        return minsum;
    }
    public int maxAbsoluteSum(int[] nums) {
        int maxsum=Math.abs(maxsum(nums));
        int minsum=Math.abs(minsum(nums));
        int result=Math.max(maxsum,minsum);
        return result;
    }
}