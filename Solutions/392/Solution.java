// O(min(m, n))
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }
        
        int i = 0;
        int j = 0;
        boolean[] isContains = new boolean[s.length()];
        while(i < s.length() && j < t.length()) {
            while(j < t.length()){
                if(s.charAt(i) == t.charAt(j)) {
                    isContains[i] = true;
                    i ++;
                    j ++;
                    break;
                }
                
                j ++;
            }
        }
        
        return isContains[s.length() - 1];
    }
}