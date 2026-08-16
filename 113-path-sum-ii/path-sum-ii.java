/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void solve(TreeNode root,int sum,int target,List<Integer> diary,List<List<Integer>> res){
        
        if(root==null) return;
        sum+=root.val;
        diary.add(root.val);

        if(root.left==null && root.right==null){
            if(sum==target){
                res.add(new ArrayList<>(diary));
                diary.remove(diary.size()-1);
                return;
            }
        }
        solve(root.left,sum,target,diary,res);
        solve(root.right,sum,target,diary,res);
        diary.remove(diary.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> diary=new ArrayList<>();
        List<List<Integer>> res= new ArrayList<>();

        solve(root,0,target,diary,res);
        return res;
    }
}