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
    List<Integer> ans= new ArrayList<>();
    public void solve(TreeNode root){
        if(root==null) return;
        solve(root.left);//left
        ans.add(root.val);//root
        solve(root.right);//right
    
       
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        solve(root);
        return ans;
    }
}