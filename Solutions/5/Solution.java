class Solution {
    private int left = -1;
    private int right = 0;
    
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i ++) {
            dp(s, i - 1, i + 1);
            if(i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp(s, i - 1, i + 2);
            }
        }
        
        return s.substring(left + 1, right);
    }
    
    private void dp(String s, int low, int high) {
        while(low > -1 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low --;
            high ++;
        }
        
        if((high - low) > (right - left)) {
            right = high;
            left = low;
        }
        
        return;
    }
}