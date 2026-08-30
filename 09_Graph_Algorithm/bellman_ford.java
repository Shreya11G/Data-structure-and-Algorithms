import java.util.*;
public class bellman_ford{
    static class Edge{
        int src;
        int dist;
        int weight;
        Edge(int src, int dist, int weight){
            this.src=src;
            this.dist=dist;
            this.weight=weight;
        }
    }
    public static void bellmanFord(int n , List<Edge> edges, int source){
        // Step 1: Initialize distances
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source]=0;
         // Step 2: Relax all edges n - 1 times
        for(int i=1;i<=n-1;i++){
            boolean update=false;
            for(Edge edge: edges){
                int u = edge.src;
                int v= edge.dist;
                int w= edge.weight;
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    update=true;
                }
            }
            if(!update){
                break;
            }
        }
         // Step 3: Check for negative weight cycle
            for(Edge edge: edges){
                int u = edge.src;
                int v= edge.dist;
                int w= edge.weight;
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    System.out.println("Negative weight cycle detected");
                    return;
                }
            }
             // Print shortest distances
        System.out.println("Shortest distances from source " + source + ":");

        for (int i = 0; i < n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Node " + i + " -> INF");
            } else {
                System.out.println("Node " + i + " -> " + dist[i]);
            }
        }
    }
    public static void main(String[] args){
        int n=5;
        List<Edge> edges= new ArrayList<>();
        edges.add(new Edge(0,1,4));
        edges.add(new Edge(0,2,5));
        edges.add(new Edge(1,2,-3));
        edges.add(new Edge(2,3,4));
        edges.add(new Edge(3,4,2));
        bellmanFord(n, edges, 0);
    }
}

// Bellman-Ford Algorithm

// Bellman-Ford is used to find the shortest distance from one source node to all other nodes.

// The biggest advantage over Dijkstra is:

// Bellman-Ford can handle negative edge weights.

// It can also detect a negative weight cycle.

// Time Complexity O(V × E)

// Space Complexity
// dist[] → O(V)
// edges → O(E)

// So:

// O(V + E)


// why n-1 time for loop
// Because with N vertices, the longest possible simple path has at most N−1 edges, so Bellman-Ford needs to relax all edges at most N−1 times to find the shortest paths.