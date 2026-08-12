class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int low = 0;
        int res = 0;

        for (int high = 0; high < nums.length; high++) {

            // Add nums[high]
            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);

            // If frequency becomes greater than k,
            // shrink the window
            while (map.get(nums[high]) > k) {
                map.put(nums[low], map.get(nums[low]) - 1);
                low++;
            }

            // Current window is valid
            res = Math.max(res, high - low + 1);
        }

        return res;
    }
}