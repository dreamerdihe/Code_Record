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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;        
        }
        
        dfs(root, result);
        return result;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> result) {
        if(root == null) {
            return -1;
        }
        
        int left = dfs(root.left, result);
        int right = dfs(root.right, result);
        int level = Math.max(left, right) + 1;
        if (result.size() == level) {
            result.add(new ArrayList<Integer>());
        }
        
        result.get(level).add(root.val);
        return level;
    }
}














