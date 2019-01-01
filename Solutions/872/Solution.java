class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> values1 = new ArrayList<>();
        ArrayList<Integer> values2 = new ArrayList<>();
        findLeaves(root1, values1);
        findLeaves(root2, values2);
        
        if(values1.size() != values2.size()) {
            return false;
        }
        
        for(int i = 0; i < values1.size(); i ++) {
            if(values1.get(i) != values2.get(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private void findLeaves(TreeNode root, List<Integer> values) {
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null) {
            values.add(root.val);
            return;
        }
        
        findLeaves(root.left, values);
        findLeaves(root.right,values);
        
        return;
    }
}