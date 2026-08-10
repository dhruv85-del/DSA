class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int low = 0;
        int high = 0;
        int n = nums.length;
        int sum = 0;
        double res = -1e9;

        while (high < n) {
            sum += nums[high];
            while (high - low + 1 == k) {
                double avg = (double) sum / k;
                res = Math.max(res, avg);
                sum -= nums[low];
                low++;
            }
            high++;
        }
        return res;
    }
}