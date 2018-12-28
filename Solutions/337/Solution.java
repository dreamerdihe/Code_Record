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
    public int rob(TreeNode root) {
        return helper(root, new HashMap<TreeNode, Integer>());
    }
    
    private int helper(TreeNode root, Map<TreeNode, Integer> hashMap) {    
        if(root == null) {
            return 0;
        }
        
        if(hashMap.containsKey(root)){
            return hashMap.get(root);
        }
        
        int val = 0;
        
        if(root.left != null) {
            val += helper(root.left.left, hashMap) + helper(root.left.right, hashMap);
        }
        
        
        if(root.right != null) {
            val += helper(root.right.left, hashMap) + helper(root.right.right, hashMap);
        }
        
        int res = Math.max(root.val + val, helper(root.left, hashMap) + helper(root.right, hashMap));
        hashMap.put(root, res);
        
        return res;
    }
}











