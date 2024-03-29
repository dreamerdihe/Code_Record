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
    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length);
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        if(left == right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = helper(nums, left, mid);
        root.right = helper(nums, mid + 1, right);
        
        return root;
    }
}