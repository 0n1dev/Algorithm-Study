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
    List<Integer> list;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        
        return list;
    }
    
    public void inorder(TreeNode tr) {
        if (tr != null) {
            if (tr.left != null)
                inorder(tr.left);
            
            list.add(tr.val);
            
            if (tr.right != null)
                inorder(tr.right);
        }
    }
}