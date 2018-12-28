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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }
        
        return buildTree(map, inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    
    private TreeNode buildTree(Map<Integer, Integer> map,  int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if(inRight == inLeft || postLeft == postRight) {
            return null;
        }
        
        int rootVal = postorder[postRight - 1];
        int rootId = map.get(rootVal);
        
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(map, inorder, inLeft, rootId, postorder, postLeft, postLeft + (rootId - inLeft));
        root.right = buildTree(map, inorder, rootId + 1, inRight, postorder, postLeft + (rootId - inLeft), postRight - 1);
        return root;
    }
}