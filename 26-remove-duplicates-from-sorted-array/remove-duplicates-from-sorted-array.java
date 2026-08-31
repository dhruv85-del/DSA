class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int count = 1;
        int right = 1;
        int left = 0;
        while (right < n) {
            if (nums[right - 1] == nums[right])
                right++;
            else {
                nums[left + 1] = nums[right];
                right++;
                left++;
                count++;
            }
        }
        return count;

    }
}