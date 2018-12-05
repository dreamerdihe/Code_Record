/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = slow;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            last = slow;
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        
        last.next = null;
        
        TreeNode root = new TreeNode(slow.val);
        if(left != slow) {
            root.left = sortedListToBST(left);    
        }
        root.right = sortedListToBST(right);
        
        return root;
    }
}