// memorization
class Solution {
    private int result = 0;
    
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        dfs(root, 0, sum, memo);
        return result;
    }
    
    private void dfs(TreeNode root, int now, int target, Map<Integer, Integer> memo) {
        if(root == null) {
            return;
        }
        
        now += root.val;
        result += memo.getOrDefault(now - target, 0);
        memo.put(now, memo.getOrDefault(now, 0) + 1);
        
        dfs(root.left, now, target, memo);
        dfs(root.right, now, target, memo);
        
        memo.put(now, memo.get(now) - 1);
        return;
    }
}
// simply recursion
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        
        return pathFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int pathFrom(TreeNode root, int sum) {  
        if(root == null) {
            return 0;
        }
        
        return pathFrom(root.left, sum - root.val) + pathFrom(root.right, sum - root.val) + (sum - root.val == 0? 1 : 0);
    }
}