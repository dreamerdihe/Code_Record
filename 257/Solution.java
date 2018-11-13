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
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> result = new ArrayList<>();
       if(root == null) {
           return result;
       }

       String path = "";

       dfs(root, path, result);
       return result;
   }

   private static void dfs(TreeNode root, String path, List<String> result) {
       if(root.left == null && root.right == null) {
           path += String.valueOf(root.val);
           result.add(path);
           return;
       }
       path += (String.valueOf(root.val) + "->");

       if(root.left != null) {
           dfs(root.left, path, result);
       }

       if(root.right != null) {
           dfs(root.right, path, result);
       }
       
       return;
   }
}