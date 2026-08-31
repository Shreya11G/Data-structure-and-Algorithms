import java.util.*;
public class prims {
    public static void main(String[] args){
        int n=5;
        List<List<int[]>> graph= new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        // Undirected edges

        graph.get(0).add(new int[]{1, 2});
        graph.get(1).add(new int[]{0, 2});

        graph.get(0).add(new int[]{3, 6});
        graph.get(3).add(new int[]{0, 6});

        graph.get(1).add(new int[]{2, 3});
        graph.get(2).add(new int[]{1, 3});

        graph.get(1).add(new int[]{3, 8});
        graph.get(3).add(new int[]{1, 8});

        graph.get(1).add(new int[]{4, 5});
        graph.get(4).add(new int[]{1, 5});

        graph.get(2).add(new int[]{4, 7});
        graph.get(4).add(new int[]{2, 7});

        graph.get(3).add(new int[]{4, 9});
        graph.get(4).add(new int[]{3, 9});

        prims_(n, graph);
    }
    public static void prims_(int n , List<List<int[]>> graph){
        boolean[] vis= new boolean[n];
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.add(new int[]{0,0});
       
        int edgecount=0;
        int mstweight=0;

        while(!pq.isEmpty() && edgecount<n){
            int[] curr= pq.poll();
            int weight=curr[1];
            int node= curr[0];
            if(vis[node]) continue;
            vis[node] = true;
            edgecount++;
            mstweight+=weight;
            System.out.print("mst node: ");
            System.out.println(node + " with weight: "+ weight);
            for(int neigh[]:graph.get(node)){
                int neighnode=neigh[0];
                int neighweight=neigh[1];
                if(!vis[neighnode]){
                    pq.offer(new int[]{neighnode, neighweight});
                }
            }

        }
        System.out.println("Total minimun weight: "+mstweight);
    }
}

// Prim's Algorithm is also used to find the Minimum Spanning Tree (MST) of a weighted, undirected graph.

// Unlike Kruskal, Prim grows the MST from one starting vertex.

// Complexity

// With Adjacency List + PriorityQueue:

// Time:  O(E log V)
// Space: O(V + E)
// 🧠 Remember the difference

// Kruskal:

// Sort all edges → use DSU → avoid cycles.

// Prim:

// Start from one vertex → PriorityQueue → keep taking the cheapest edge to an unvisited vertex.
