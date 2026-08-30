import java.util.*;
public class floyd_warshall {
    public static void main(String[] args){
        int INF= Integer.MAX_VALUE;
        int[][] graph={
            {0,4,1,INF},
            {INF,0,INF,2},
            {INF,1,0,5},
            {INF,INF,INF,0},
        };
        floydWarshall(graph);
    }
    public static void floydWarshall(int[][] graph){
        int n= graph.length;
        int[][] dist = new int[n][n];
        //copy graph distance
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]= graph[i][j];
            }
        }
        //floyd-warshall algo 
        //intermediate
        for(int k=0;k<n;k++){
            //source
            for(int i=0;i<n;i++){
                //destination
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
                        dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        System.out.println("Shortest distance between every pair: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dist[i][j]==Integer.MAX_VALUE){
                    System.out.print("INF ");
                }else{
                    System.out.print(dist[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}

// Floyd-Warshall is used to find the shortest distance between every pair of vertices.

// Unlike Dijkstra/Bellman-Ford, which start from one source, Floyd-Warshall calculates for all pairs.

// Complexity
// Time:  O(N³)
// Space: O(N²)