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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        dfs(root, new HashMap(), result);
        return result;
    }
    
    private String dfs(TreeNode root, Map<String, Integer> memo, List<TreeNode> result) {
        if(root == null) {
            return "#";
        }
        String left = dfs(root.left, memo, result);
        String right = dfs(root.right, memo, result);
        String id = String.valueOf(root.val) + left  + right;
        
        if(memo.getOrDefault(id, 0) == 1) {
            result.add(root);
        }
        memo.put(id, memo.getOrDefault(id, 0) + 1);

        return id;
    }
}