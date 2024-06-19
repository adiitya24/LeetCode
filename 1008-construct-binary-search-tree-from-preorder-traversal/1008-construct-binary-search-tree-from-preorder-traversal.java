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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0) return new TreeNode();
        return createTree(preorder,0,preorder.length-1);
    }
    TreeNode createTree(int[] preorder,int l,int r){
        if(l>r) return null;
        int i=r;
        for(i=l;i<=r;i++){
            if(preorder[i]>preorder[l])
            break;
           
        }
         TreeNode root=new TreeNode(preorder[l]);
            root.left=createTree(preorder,l+1,i-1);
            root.right=createTree(preorder,i,r);
            return root;
    }
}