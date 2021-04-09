class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int depth = dfs(root, 1);
        return depth;
    }
    
    private int dfs(TreeNode root, int depth) {
        int leftDepth = depth;
        int rightDepth = depth;
        
        if (root.left != null) {
            leftDepth = dfs(root.left, depth + 1);
        }
        
        if (root.right != null) {
            rightDepth = dfs(root.right, depth + 1);
        }
        
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
}