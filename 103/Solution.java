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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return result;
        }
        
        stack.push(root);
        int depth = 0;
        while(!stack.isEmpty()) {
            int size = stack.size();
            Stack<TreeNode> stack2 = new Stack<>();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode now = stack.pop();
                level.add(now.val);
                
                if(depth % 2 == 0) {
                    if(now.left != null) {
                        stack2.push(now.left);
                    }
                
                    if(now.right != null) {
                        stack2.push(now.right);
                    }    
                } else {
                    if(now.right != null) {
                        stack2.push(now.right);
                    }    
                    
                    if(now.left != null) {
                        stack2.push(now.left);
                    }
                }
                
            }
            stack = stack2;
            depth ++;
            result.add(level);
        }
        
        return result;
    }
}