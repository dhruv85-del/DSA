class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int result = Integer.MAX_VALUE;
        int n = nums.size();

        for (int k = l; k <= r; k++) {

            int sum = 0;

            for (int i = 0; i < k; i++) {
                sum += nums.get(i);
            }

            if (sum > 0) {
                result = Math.min(result, sum);
            }

            for (int right = k; right < n; right++) {

                sum += nums.get(right);
                sum -= nums.get(right - k);

                if (sum > 0) {
                    result = Math.min(result, sum);
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}