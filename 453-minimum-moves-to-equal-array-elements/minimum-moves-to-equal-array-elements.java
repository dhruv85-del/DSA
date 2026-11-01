class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int operation=0;
        int min_idx=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min_idx=Math.min(min_idx,nums[i]);
        }
        for(int j=0;j<n;j++){
             operation+=nums[j] - min_idx;
        }
        return operation;
    }
}