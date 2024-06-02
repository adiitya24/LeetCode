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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
       return tree(preorder,map,0,0,inorder.length-1);
        
    }
     TreeNode tree(int[] preorder,Map<Integer,Integer> map,int prei,int ileft,int iright){
            int rootv=preorder[prei],imid=map.get(rootv);
            TreeNode root=new  TreeNode(rootv);
            if(imid>ileft){
                root.left=tree(preorder,map,prei+1,ileft,imid-1);
            }
            if(imid<iright){
                root.right=tree(preorder,map,prei+imid-ileft+1,imid+1,iright);

                
            }
            return root;
     }
    
}
