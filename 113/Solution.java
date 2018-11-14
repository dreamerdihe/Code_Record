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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, path, result);
        return result;
        
    }
    
    private static void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            if (sum - root.val == 0) {
                result.add(new ArrayList(path));
            }
            
            return;
        }
        
        path.add(root.val);
        
        if (root.left != null) {
            dfs(root.left, sum - root.val, path, result);
            path.remove(path.size() - 1);
        }
        
        if(root.right != null) {
            dfs(root.right, sum - root.val, path, result);
            path.remove(path.size() - 1);
        }
        
        return;
    }
}


