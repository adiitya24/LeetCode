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
    public List<TreeNode> generateTrees(int n) {
        return n>0?createTree(1,n):new ArrayList<>();
    }
    List<TreeNode> createTree(int start,int end){
        List<TreeNode> list=new ArrayList<>();
        if(start>end){
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left=createTree(start,i-1);
            List<TreeNode> right=createTree(i+1,end);

            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode curr=new TreeNode(i);
                    curr.left=l;
                    curr.right=r;
                    list.add(curr);
                }
            }
        }
        return list;
    }
}