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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        List<Integer> result = new ArrayList();
        Integer num = 0;
        
        dfs(root, num, result);
        
        return sum(result);
    }
    
    private static void dfs(TreeNode root, Integer num, List<Integer> result) {
        if (root.left == null && root.right == null) {
            num = num * 10 + root.val;
            result.add(num);
            
            return;
        }
        
        num = num * 10 + root.val;
        
        if (root.left != null) {
            dfs(root.left, num, result);
        }
        
        if(root.right != null) {
            dfs(root.right, num, result);
        }
        
        return;
    }
    
    private static int sum(List<Integer> result) {
        int res = 0;
        for (Integer num : result) {
            res += num;
        }
        return res;
    }

}








