import java.util.*;

public class kruskal {
    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int i) {
            if (i == parent[i]) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        boolean union(int x, int y) {
            int x_parent = find(x);
            int y_parent = find(y);
            if (x_parent == y_parent) {
                return false;
            }
            if (rank[x_parent] > rank[y_parent])
                parent[y_parent] = x_parent;
            else if (rank[x_parent] < rank[y_parent])
                parent[x_parent] = y_parent;
            else {
                parent[y_parent] = x_parent;
                rank[x_parent]++;
            }
            return true;
        }
    }

    public static void kruskal(int n, List<Edge> edges){
        //step 1: Sort edges by weight
        edges.sort((a,b)-> a.weight-b.weight);
        DSU dsu= new DSU(n);
        int mstweight=0;
        int edgecount=0;
        System.out.println("Edges in MST: ");
        //step 2: pick edges one by one
        for(Edge edge: edges){
            int  u = edge.source;
            int v = edge.destination;
            int w = edge.weight;
            // step 3: Add edge onlyu if it doesn't create cycle
            if(dsu.union(u,v)){
                System.out.println(u+"--"+v+" = "+w);
                mstweight+=w;
                edgecount++;
                // MST contains v-1 edges
                if(edgecount==n-1){
                    break;
                }
            }
            
        }
        System.out.println("Minimun spanning Tree Weight = "+mstweight);
    }
    public static void main(String[] args) {
        int n = 5;

        List<Edge> edges = new ArrayList<>();

        // Undirected graph
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));

        kruskal(n, edges);
    }
}


// Kruskal's Algorithm is used to find the Minimum Spanning Tree (MST) of a weighted, undirected graph.

// The main idea is:

// Sort all edges by weight.
// Pick the smallest edge.
// If adding it doesn't create a cycle, add it to MST.
// Use DSU / Union-Find to detect cycles.
// Stop after selecting V - 1 edges.

// TC : O(E log E)

// SC : O(V + E)

// 🧠 Kruskal = Sort edges + DSU + avoid cycles + take V−1 edges.