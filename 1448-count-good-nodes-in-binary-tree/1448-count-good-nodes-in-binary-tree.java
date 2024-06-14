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
    int ans=0;
    public int goodNodes(TreeNode root) {
        solve(root,root.val);
        return ans;
    }
    void solve(TreeNode root,int max){
        if(root==null) return ;
        if(root.val>=max) ans++;
        max=Math.max(max,root.val);
        solve(root.left,max);
        solve(root.right,max);
    }
}