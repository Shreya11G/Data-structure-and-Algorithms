import java.util.*;
public class dijkstra {
    public static void main(String[] args){
        int n =6;
        List<List<int[]>> graph=new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new int[]{1, 4});
        graph.get(0).add(new int[]{2, 2});

        graph.get(1).add(new int[]{3, 5});

        graph.get(2).add(new int[]{1, 1});
        graph.get(2).add(new int[]{3, 8});
        graph.get(2).add(new int[]{4, 10});

        graph.get(3).add(new int[]{4, 2});

        graph.get(4).add(new int[]{5, 3});
        dijkstraa(0,graph);
    }
    public static void dijkstraa(int source, List<List<int[]>> graph ){
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE );
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        dist[source]=0;
        pq.offer(new int[]{0,source});
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentDist= current[0];
            int node=current[1];
            if(currentDist>dist[node]) continue;
            for(int[] edge: graph.get(node)){
                int neighbor= edge[0];
                int weight=edge[1];
                if(currentDist+weight<dist[neighbor]){
                    dist[neighbor]=currentDist+weight;
                    pq.offer(new int[]{dist[neighbor],neighbor});
                }
            }
        } 
        System.err.println("Shortest distance from source "+source+":");
        for(int i =0;i<n;i++){
            System.out.println( "Node "+i+"->"+dist[i]);
        }
    }
}
// Complexity

// With an adjacency list + PriorityQueue:
// poll() → O(log V)
// Time: O((V + E) log V)
// Usually written as O(E log V) for connected graphs.

// Space: O(V + E).

// And one thing to remember for interviews:

// Dijkstra = shortest path + weighted graph + NO negative weights + PriorityQueue.