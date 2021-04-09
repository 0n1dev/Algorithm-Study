class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        list.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        
        return list.get(k - 1);
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        list.add(root.val);

        if (root.left != null) {
            dfs(root.left, list);
        }

        if (root.right != null) {
            dfs(root.right, list);
        }
    }
}