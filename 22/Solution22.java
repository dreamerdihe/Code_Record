class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) {
            return result;
        }
        
        String combination = "";
        dfs(n, n, combination, result);
        return result;
    }
    
    private void dfs(int left, int right, String combination, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(new String(combination));
            return;
        }
        
        if(left > 0) {
            combination += "(";
            dfs(left - 1, right, combination, result);
            combination = combination.substring(0, combination.length() - 1);
        }
        
        if(right > 0 && right > left) {
            combination += ")";
            dfs(left, right - 1, combination, result);
            combination = combination.substring(0, combination.length() - 1);
        }
        
        return;
    }
}