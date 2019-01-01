class Solution {
    private TreeNode prev = null;
    private int count = 1;
    private int max = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> set = new ArrayList<>();
        dfs(root, set);
        int[] result = new int[set.size()];
        int i = 0;
        for(Integer num : set) {
            result[i] = num;
            i ++;
        }
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> set) {
        if(root == null) {
            return;
        }
        
        dfs(root.left, set);
        
        if(prev != null) {
            if(root.val == prev.val) {
                count ++;
            } else {
                count = 1;
            }
        }
        
        if(count > max) {
            set.clear();
            set.add(root.val);
            max = count;
        } else if(count == max) {
            set.add(root.val);
        }
        
        prev = root;
        
        dfs(root.right, set);
        return;
    }
}