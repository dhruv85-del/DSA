class Solution {
    private void solve(int[] candidates, int n, int idx, List<Integer> diary, int sum, List<List<Integer>> res, int target){
        //base case
        if(idx == n){
            if(sum==target){
                res.add(new ArrayList<>(diary));
            }
            return;
        }
        //choice:1 Do not take this element
        solve(candidates,n,idx+1,diary,sum,res,target);
        
        //choice:2 Take the current element (if possible)
        if(sum+candidates[idx] <=target){
            diary.add(candidates[idx]);
            sum+=candidates[idx];
            //stay at same idx because element can be reuseed
            solve(candidates,n,idx,diary,sum,res,target);
            //bactracking
            diary.remove(diary.size()-1);
            sum -= candidates[idx];
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        solve(candidates,candidates.length,0,new ArrayList<>(),0,res,target);

        return res;
        
    }
}