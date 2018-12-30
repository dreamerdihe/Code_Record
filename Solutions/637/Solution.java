// bfs version
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Double> list = new ArrayList<>();
        if (root == null) return list;
        dq.offerFirst(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            int i = 0; 
            long sum = 0;
            while (i < size) {
                TreeNode cur = dq.pollLast();
                sum += cur.val;
                if (cur.left != null) dq.offerFirst(cur.left);
                if (cur.right != null) dq.offerFirst(cur.right);
                i++;
            }
            list.add(sum * 1.0 / size);
        }
        return list;
    }
}

// dfs version
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        List<Integer> count = new ArrayList<>();
        
        dfs(root, 0, result, count);
        for(int i = 0; i < result.size(); i ++) {
            result.set(i, result.get(i) / count.get(i));
        }
        
        return result;
    }
    
    private void dfs(TreeNode root, int height, List<Double> level, List<Integer> count) {
        if(root == null) {
            return;
        }
        
        if(level.size() == height) {
            level.add(root.val * 1.0);
            count.add(1);
        } else {
            level.set(height, level.get(height) + root.val);
            count.set(height, count.get(height) + 1);
        }
        
        dfs(root.left, height + 1, level, count);
        dfs(root.right, height + 1, level, count);
        
        return;
        
    }
}