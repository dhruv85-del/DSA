class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1;
        int first=0;
        int second=1;
        int n=nums.length;

        while(second<n){
            if(nums[second]==nums[second-1]){
                second++;
                continue;
            }else{
                nums[first+1]=nums[second];
                first++;
                second++;
                count++;
            }
        }
        return count;
    }
}