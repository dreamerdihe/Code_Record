// dfs but bottom up
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        if(tickets == null || tickets.length == 0) {
            List<String> corner = new ArrayList<>();
            corner.add("JFK");
            return corner;
        }
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for(String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<String>());
            map.get(ticket[0]).offer(ticket[1]);
        }

        
        LinkedList<String> result = new LinkedList<>();
        dfs(map, "JFK", result);
        return result;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> map, String root, LinkedList<String> result) {
        // System.out.println(Arrays.toString(map.entrySet().toArray()));
        while(map.containsKey(root) && !map.get(root).isEmpty()) {
            dfs(map, map.get(root).poll(), result);
        }
        
        result.addFirst(root);
    }
}

// dfs up to buttom using back-tracking
class Solution {
    private int length;
    
    public List<String> findItinerary(String[][] tickets) {
        if(tickets == null || tickets.length == 0) {
            List<String> corner = new ArrayList<>();
            corner.add("JFK");
            return corner;
        }
        
        length = tickets.length + 1;
        Map<String, LinkedList<String>> map = new HashMap<>();
        
        for(String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new LinkedList<String>());
            map.get(ticket[0]).add(ticket[1]);
        }
        
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        List<String> result = new ArrayList<>();
        dfs(map, "JFK", result);
        return result;
    }
    
    private void dfs(Map<String, LinkedList<String>> map, String root, List<String> result) {
        result.add(root);
        
        if(!map.containsKey(root)) {
            return;
        }
        
        List<String> list = map.get(root);
        for(int i = 0; i < list.size(); i++) {
            String next = list.get(i);
            list.remove(i);
            dfs(map, next, result);
            if(result.size() == length) {
                return;
            }
            result.remove(result.size() - 1);
            list.add(i, next);
        }
        
    }
}