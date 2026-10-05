class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int first=0;
        int sec=n-1;
        int[] res=new int[2];
        for(int i=0;i<n;i++){
            if(nums[first]+nums[sec]==target){
                res[0]=first+1;
                res[1]=sec+1;
                return res;
            }else if(nums[first]+nums[sec]<target){
                first++;
            }else{
                sec--;
            }

        }
        return res;
    }
}