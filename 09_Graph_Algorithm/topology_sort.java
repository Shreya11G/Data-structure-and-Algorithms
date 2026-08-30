import java.util.*;
public class topology_sort {
    public static void main(String[] args){
        int n =6;
        List<List<Integer>> graph = new ArrayList<>();
         for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Directed edges

        graph.get(5).add(2);
        graph.get(5).add(0);

        graph.get(4).add(0);
        graph.get(4).add(1);

        graph.get(2).add(3);

        graph.get(3).add(1);

        List<Integer> result = topologicalSort(n, graph);

        System.out.println("Topological Order: " + result);
    }
    public static List<Integer> topologicalSort(int n , List<List<Integer>> graph){
        int[] indegree= new int[n];
        for(int u=0;u<n;u++){
            for(int v: graph.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            result.add(node);
            for(int neigh: graph.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.offer(neigh);
                }
            }
        }
        if(result.size()<n){
            System.out.println("Graph contains cycle");
            return new ArrayList<>();
        }
        return result;
    }
}

// Topological Sort is used for a Directed Acyclic Graph (DAG). It produces an ordering where for every directed edge u → v, u comes before v.

// Here is the Kahn's Algorithm (BFS) version, which is the easiest one to understand initially.
// Complexity

// Time: O(V + E)
// Space: O(V + E)

// 🧠 Remember:
// Topological Sort = Directed Acyclic Graph (DAG) + ordering of vertices based on dependencies.