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
    public int distributeCoins(TreeNode root) {
        distribute(root);
        return ans;
    }
    int distribute(TreeNode root){
        if(root==null) return 0;
        int left=distribute(root.left);
        int right=distribute(root.right);
        ans+=Math.abs(left)+Math.abs(right);
        return (left)+(right)+(root.val-1);
    }
}