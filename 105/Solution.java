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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i ++) {
            inMap.put(inorder[i], i);
        }
        
        return getTree(inMap, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode getTree( Map inMap, int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft > preRight || inLeft > inRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRoot = (int)inMap.get(root.val);
        int leftNum = inRoot - inLeft; 

        root.left = getTree(inMap, preorder, inorder, preLeft + 1, preLeft + leftNum, inLeft, inRoot - 1);    
        root.right = getTree(inMap, preorder, inorder, preLeft + leftNum + 1, preRight, inRoot + 1, inRight);
        
        return root;
    }
}