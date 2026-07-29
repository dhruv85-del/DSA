class Solution {
    private void solve(int[] nums, int n, int idx, List<Integer> diary, List<List<Integer>> res) {
        if (idx == n) {
            res.add(new ArrayList<>(diary));
            return;
        }
        //dont pick
         solve(nums, n, idx + 1, diary, res);
         //pick
         diary.add(nums[idx]);
         solve(nums, n, idx + 1, diary, res);
         diary.remove(diary.size()-1);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();

        solve(nums, nums.length, 0, new ArrayList<>(), res);
        return res;
    }
}