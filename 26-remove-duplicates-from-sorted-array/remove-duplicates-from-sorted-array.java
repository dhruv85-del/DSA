class Solution {
    public int removeDuplicates(int[] nums) {
        int f=0;
        int n=nums.length;
        int s=1;
        int count=1;

        while(s<n){
            if(nums[s-1]==nums[s]){
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