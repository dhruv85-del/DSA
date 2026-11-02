import java.util.Arrays;
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves=0;
        int mid=nums.length/2;
        int median=nums[mid];
        for(int i=0;i<nums.length;i++){
             moves+=Math.abs(nums[i]-median);
        }
        return moves;
    }
}