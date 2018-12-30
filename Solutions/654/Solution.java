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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }
    
    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if(start >= end) {
            return null;
        }
        
        int index = start;
        for(int i = start; i < end; i ++) {
            if(nums[index] < nums[i]) {
                index = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(nums, start, index);
        root.right = constructMaximumBinaryTree(nums, index + 1, end);
        return root;
    }
}