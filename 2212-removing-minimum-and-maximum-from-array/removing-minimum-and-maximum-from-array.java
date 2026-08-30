class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int minpos=0;
        int maxpos=0;

        for(int i=1;i<n;i++){
            if(nums[i]<nums[minpos]){
                minpos=i;
            }
            if(nums[i]>nums[maxpos]){
                maxpos=i;
            }
        }
        int left=Math.min(minpos,maxpos);
        int right=Math.max(minpos,maxpos);
        int fromfront=right+1;
        int fromback=n-left;
        int fromboth=(left+1)+(n - right);

        return Math.min(fromfront, Math.min(fromback, fromboth));
    }
}