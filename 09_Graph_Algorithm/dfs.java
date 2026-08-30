/**
 * dfs
 */
import java.util.*;
public class dfs {

    public static void main(String[] args){
        int n=6;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);      
        adj.get(1).add(3);
        adj.get(1).add(4);  
        adj.get(2).add(5);
        boolean[] visited= new boolean[n];
        System.out.print("DFS Traversal of the graph is: ");
        dfs_traversal(adj, 0, visited);
    }
    public static void dfs_traversal(List<List<Integer>> adj, int node, boolean[] visited){
        visited[node]= true;
        System.out.print(node+" ");
        for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
              dfs_traversal(adj, neighbor, visited);
            }
        }
    }
}