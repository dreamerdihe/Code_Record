class Solution {
    private int count = 0;
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i ++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        
        return count;
    }
    
    private void extend(String s, int start, int end) {
        while(end < s.length() && start >-1 && s.charAt(start) == s.charAt(end)) {
            count ++;
            end ++;
            start --;
        }
        
        return;
    }
}