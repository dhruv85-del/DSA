class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int f=0;
        int s=1;
        int count=1;
        while(s<n){
            if(nums[s]==nums[s-1]){
                s++;
            }else{
                nums[f+1]=nums[s];
                s++;
                f++;
                count++;
            }
        }
        return count;
    }
}