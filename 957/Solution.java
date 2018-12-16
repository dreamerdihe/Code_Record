class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] result = new int[cells.length];
        if(N == 0) {
            return cells;
        }
        
        Map<String, Integer> seen = new HashMap<>();
        while(N > 0){     
            for(int j = 1; j < 7; j ++) {
                result[j] = cells[j-1] == cells[j+1]? 1 : 0;
            }
            
            seen.put(Arrays.toString(cells), N --);
            
            copy(cells, result);
            
            if(seen.containsKey(Arrays.toString(result))) {
                N %= seen.get(Arrays.toString(result)) - N;
            }
        }
        
        return result;
    }
    
    // a = b
    private void copy(int[] a, int[] b) {
        for(int i = 0; i < a.length; i ++) {
            a[i] = b[i];
        }
        
        return;
    }
}