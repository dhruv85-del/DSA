class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int[] res= new int[n];
        int idx=n-1;
        while(left<=right){
            int leftsq=nums[left]*nums[left];
            int rightsq=nums[right]*nums[right];
            if(leftsq<rightsq){
                res[idx]=rightsq;
                right--;
            }else{
                res[idx]=leftsq;
                left++;
            }
            idx--;

        }
        return res;
    }
}