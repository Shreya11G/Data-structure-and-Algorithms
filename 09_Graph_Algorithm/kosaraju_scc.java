import java.util.*;

public class kosaraju_scc{
    public static void main(String[] arges){
        int n =5;
        List<List<Integer>> graph= new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(4).add(3);
       
        kosaraju(n, graph);
    }

    public static void dfsfill(int i, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack){
        visited[i]=true;
        for(int neigh: graph.get(i)){
            if(!visited[neigh]){
                dfsfill(neigh, graph, visited, stack);
            }
        }
        //Add after visiting all neighbor 
        stack.push(i);
    }
    public static void dfs(int i, List<List<Integer>> revGraph, boolean[] vis){
        vis[i]=true;
        System.out.print(i+" ");
        for(int neigh: revGraph.get(i)){
            if(!vis[neigh]){
                dfs(neigh, revGraph, vis);
            }
        }
    }
    public static void kosaraju(int n , List<List<Integer>> graph){

        // --------------------------------
        // Step 1: First DFS (fill node in stack in topo order)
        // --------------------------------

        boolean[] visited = new boolean[n];
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfsfill(i, graph, visited, stack);
            }
        }

        // --------------------------------
        // Step 2: Reverse the graph 
        // --------------------------------
        
        List<List<Integer>> reverseGraph= new ArrayList<>();
        for(int i=0;i<n;i++){
            reverseGraph.add(new ArrayList<>());
        }
        for(int u=0;u<n;u++){
            for(int v: graph.get(u)){
                reverseGraph.get(v).add(u);
            }
        }

          // --------------------------------
        // Step 3: DFS on reverse graph
        // --------------------------------

        Arrays.fill(visited, false);
        System.out.println("Strongly connected Components:");
        int count=0;
        while(!stack.isEmpty()){
            int node =stack.pop();
            if(!visited[node]){
                count++;
                dfs(node, reverseGraph, visited);
                System.out.println();
            }
        }
        System.out.println("Total SCC: "+count);

    }
}

// Kosaraju's Algorithm finds all Strongly Connected Components in a directed graph using two DFS traversals and graph reversal.
// Time Complexity
// First DFS: O(V + E)
// Reverse graph: O(V + E)
// Second DFS: O(V + E)

// Total: Time = O(V + E)

// Space

// We store:

// Original graph → O(V + E)
// Reverse graph → O(V + E)
// Visited → O(V)
// Stack → O(V)

// Therefore:

// Space = O(V + E)