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
    
    class Item {
        TreeNode node;
        int no;
        Item(TreeNode root, int x) {
            node = root;
            no = x;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> leftResult = new ArrayList<>();
        List<List<Integer>> rightResult = new ArrayList<>();
        
        if(root == null) {
            return leftResult;
        }
        
        Deque<Item> queue = new LinkedList<>();
        queue.offer(new Item(root, 0));
        
        while(!queue.isEmpty()) {
            Item now = queue.poll();
            
            if(now.no < 0){
                int index = -(now.no + 1);
                if(leftResult.size() == index) {
                    List<Integer> level = new ArrayList<>();
                    level.add(now.node.val);
                    leftResult.add(level);
                } else {
                    leftResult.get(index).add(now.node.val);
                }
            } else {
                int index = now.no;
                if(rightResult.size() == index) {
                    List<Integer> level = new ArrayList<>();
                    level.add(now.node.val);
                    rightResult.add(level);
                } else {
                    rightResult.get(index).add(now.node.val);
                }   
            }
            
            if(now.node.left != null) {
                queue.offer(new Item(now.node.left, now.no - 1));
            }
            
            if(now.node.right != null) {
                queue.offer(new Item(now.node.right, now.no + 1));
            }
        }
        
        Collections.reverse(leftResult);
        leftResult.addAll(rightResult);
        return leftResult;       
    }
}



