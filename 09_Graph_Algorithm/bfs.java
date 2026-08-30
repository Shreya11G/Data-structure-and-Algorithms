import java.util.*;
public class bfs {
    public static void bfs_traversal(List<List<Integer>> adj, int n){
        boolean vis[]= new boolean[n];
        Queue<Integer> q= new LinkedList<>();
        q.offer(0);
        vis[0]= true;
        while(!q.isEmpty()){
            int node =q.poll();
            System.out.print(node+" ");
            for(int neighbor: adj.get(node)){
                if(vis[neighbor]==false){
                    vis[neighbor]=true;
                    q.offer(neighbor);
                }
            }
        }

    }
    public static void main(String[] args) {
        // Your code here
        int n =6;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(5);
        System.out.println("BFS Traversal of the graph is: ");
        bfs_traversal(adj, n);

    }
}
