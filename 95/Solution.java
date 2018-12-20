/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
        List<List<TreeNode>> dp = new ArrayList<>(n + 1);
        List<TreeNode> init = new ArrayList<>();
        init.add(null);
        dp.add(init);

        for(int i = 1; i < n + 1; i ++) {
            List<TreeNode> level = new ArrayList<>();
            
            for(int j = 1; j < i + 1; j ++) {
                for(TreeNode left : dp.get(j - 1)) {
                    for(TreeNode right : dp.get(i - j)) {
                        TreeNode root = new TreeNode(j);
                        root.left = clone(left, 0);
                        root.right = clone(right, j);
                        level.add(root);
                    }
                }
            }  
            
            dp.add(level);
        }
        
        return dp.get(n);
    }
    
    private TreeNode clone(TreeNode node, int offset) {
        if(node == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(node.val + offset);
        root.left = clone(node.left, offset);
        root.right = clone(node.right, offset);
        return root;
    }
}