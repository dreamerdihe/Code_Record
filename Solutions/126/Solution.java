class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();        
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        if(!wordSet.contains(endWord)) {
            return result;
        }
        
        Map<String, Integer> helperMap = getLevel(beginWord, endWord, wordSet);
        if(!helperMap.containsKey(beginWord)) {
            return result;
        }
        int depth = helperMap.get(beginWord);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(depth-1, helperMap, path ,result);
        
        return result;
        
    }
    
    private void dfs(int depth, Map<String, Integer> helperMap, List<String> path, List<List<String>> result) {
        if(depth == 0) {
            result.add(new ArrayList(path));
            return;
        }
        
        for(String str : getNext(path.get(path.size()-1), helperMap.keySet())) {
            if(str != null && helperMap.get(str) == depth) {
                path.add(str);
                dfs(depth - 1, helperMap, path, result);
                path.remove(path.size() - 1);    
            }
        }
        
        return;
    }
    
    private Map<String, Integer> getLevel(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Integer> result = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(endWord);
        wordList.remove(endWord);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level ++;
            for(int i = 0; i < size; i++) {
                String now = queue.poll();
                result.put(now, level);
                if(now.equals(beginWord)) {
                    return result;
                }
                for(String str : getNext(now, wordList)) {
                    queue.offer(str);
                    wordList.remove(str);
                }
            }
        }
        
        return result;
    }
    
    private List<String> getNext(String str, Set<String> wordList) {
        List<String> next = new ArrayList<>();
        for(int i = 0; i < str.length(); i ++) {
            for(char j = 'a'; j <= 'z'; j ++) {
                String candidate = replace(str, i, j);
                if(candidate != str && wordList.contains(candidate)) {
                    next.add(candidate);
                }
            }
        }
        
        return next;
    }
    
    private String replace(String str, int i, char c) {
        char[] temp = str.toCharArray();
        temp[i] = c;
        return String.valueOf(temp);
    }
}