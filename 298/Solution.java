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
    private int maxSeq = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int cur = 0;
        dfs(root, cur, root.val);
        return maxSeq;
    }
    
    private void dfs(TreeNode root, int cur, int target) {
        if(root == null) {
            return;
        }
        
        if(root.val == target) {
            cur ++;
            if(maxSeq < cur) {
                maxSeq = cur;
            }
        } else {
            cur = 1;
        }
        
        dfs(root.left, cur, root.val + 1);
        dfs(root.right, cur, root.val + 1);
        
        return;
    }
    
}