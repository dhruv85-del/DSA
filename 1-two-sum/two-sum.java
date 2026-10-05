class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int sec = target - first;
            if (map.containsKey(sec)) {
                res[0] = map.get(sec);
                res[1] = i;
                return res;
            } else {
                map.put(first, i);
            }
        }
        return res;
    }
}