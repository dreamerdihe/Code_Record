class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.remove(beginWord);
        int length = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String now = queue.poll();
                if(now.equals(endWord)) {
                        return length;
                    }
                for(String str : getNext(now, set)) {
                    queue.offer(str);
                }    
            }
            length ++;
        }
        
        return 0;
    } 
    
    private String replace(String word, int i, char a) {
        char[] temp = word.toCharArray();
        temp[i] = a;
        return String.valueOf(temp);
    }
    
    private List<String> getNext(String now, HashSet<String> set) {
        List<String> next = new ArrayList<>();
        for(int i = 0; i < now.length(); i++) {
            for(char j = 'a'; j < 'z'; j ++) {
                String candidate = replace(now, i, j);
                if(set.contains(candidate)) {
                    next.add(candidate);
                    set.remove(candidate);
                }
            }
        }
        return next;
    }
}