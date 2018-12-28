class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n == 0) {
            return result;
        }
        
        boolean[] visited = new boolean[n];
        List<Integer> permutation = new ArrayList<>();
        search(n, n, visited, permutation, result);
        
        return result;
    }
    
    private void search(int n, int left, boolean[] visited, List<Integer> permutation, List<List<String>> result) {
        if(left == 0) {
            result.add(display(permutation));
            return;
        }
        
        for(int i = 0; i < n; i ++) {
            if(visited[i]) {
                continue;
            }
            
            if(isCrash(i, permutation)) {
                continue; 
            }
            
            permutation.add(i);
            visited[i] = true;
            search(n, left - 1, visited, permutation, result);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
    
    private boolean isCrash(int k, List<Integer> permutation) {
        int sumK1 = permutation.size() + k;
        int sumK2 = permutation.size() - k;
        for(int i = 0; i < permutation.size(); i++) {
            int sumI1 = i + permutation.get(i);
            int sumI2 = i - permutation.get(i);
            if(sumK1 == sumI1 || sumK2 == sumI2) {

                return true;
            }
        }
        
        return false;
    }
    
    private List<String> display(List<Integer> permutation) {
        int n = permutation.size();
        List<String> solution = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            char[] level = new char[n];
            for(int j = 0; j < n; j++) {
                level[j] = '.';
            }
            level[permutation.get(i)] = 'Q';
            solution.add(String.valueOf(level));
        }
        return solution;
    }
}





