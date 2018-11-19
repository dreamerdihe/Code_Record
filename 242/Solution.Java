class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] s_ = new int[256];
        int[] t_ = new int[256];
        
        for(int i = 0; i < s.length(); i++) {
            s_[s.charAt(i)] += 1;
            t_[t.charAt(i)] += 1;
        }
        
        for(int i = 0; i < 256; i++) {
            if(s_[i] != t_[i]) {
                return false;
            }
        }
        
        return true;
    }
}