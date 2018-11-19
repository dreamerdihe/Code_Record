class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sCount = new int[256];
        int[] tCount = new int[256];
        
        for(int i = 0; i < s.length(); i++) { 
            if(sCount[s.charAt(i)] != tCount[t.charAt(i)]) return false;
            sCount[s.charAt(i)] = i + 5;
            tCount[t.charAt(i)] = i + 5;
        }
        
        return true;
    }
}