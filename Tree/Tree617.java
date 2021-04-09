class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode root = new TreeNode();

        dfs(root, root1);
        dfs(root, root2);
        
        return root;
    }
    
    private void dfs(TreeNode root, TreeNode target) {
        if (target == null) return;
        else root.val += target.val;
        
        if (target.left != null) {
            if (root.left == null) {
                root.left = new TreeNode();
            }
            dfs(root.left, target.left);
        }

        if (target.right != null) {
            if (root.right == null) {
                root.right = new TreeNode();
            }
            dfs(root.right, target.right);
        }
    }
}