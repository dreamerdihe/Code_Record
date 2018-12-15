// memorization
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {        
        return wordBreak(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
    }
    
    private boolean wordBreak(String s, Set<String> words, int start, Boolean[] memo) {
        if(start == s.length()) {
            return true;
        }
        
        if(memo[start] != null) {
            return memo[start];
        }
        
        for(String word : words) {
            if(s.substring(start).startsWith(word) && wordBreak(s, words, start + word.length(), memo)) {
                    return true;
            }
        }
        
        return memo[start] = false;
    }
}

// DP
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        Set<String> words = new HashSet<>();
        for(String word : wordDict) {
            words.add(word);
        }
        
        for(int i = 0; i <= s.length(); i ++) {
            for(int j = 0; j < i; j ++) {
                if(dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}