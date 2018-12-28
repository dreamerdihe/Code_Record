class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if(times == null || times.length == 0) {
            return -1;
        }
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<Integer, Integer>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // {node, weight}
        pq.offer(new int[]{K, 0});
        int result = 0;
        while(!pq.isEmpty()) {
            int[] root = pq.poll();
            int node = root[0];
            int nodeDist = root[1];
            if(visited[node]) {
                continue;
            }
            visited[node] = true;
            N --;
            result = nodeDist;
            if(!map.containsKey(node)) {
                continue;
            }
            
            for(int next : map.get(node).keySet()) {
                if(!visited[next] && dist[node] + map.get(node).get(next) < dist[next]) {
                    dist[next] = dist[node] + map.get(node).get(next);
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        
        return N == 0 ? result : -1;
    }
}