import java.util.*;
public class tarjan_scc{
    static int timer=0;
    static int discovery[];
    static int low[];
    static Stack<Integer> stack;
    static boolean instack[];
    static List<List<Integer>> graph;

    public static void main(String[] args){
        int n =5;
        graph = new ArrayList<>();
        for(int i =0;i<n ;i++){
            graph.add(new ArrayList<>());
        }
         // Directed graph

        graph.get(0).add(1);

        graph.get(1).add(2);

        graph.get(2).add(0);
        graph.get(2).add(3);

        graph.get(3).add(4);

        graph.get(4).add(3);

        discovery= new int[n];
        low= new int[n];
        instack = new boolean[n];
        stack = new Stack<>();
        Arrays.fill(discovery, -1);
        for(int i=0;i<n;i++){
            if(discovery[i]==-1){
                tarjan(i);
            }
        }
    }
    public static void tarjan(int node){
        discovery[node]=low[node]=timer++;
        stack.push(node);
        instack[node]=true;
        for(int neigh: graph.get(node)){
            if(discovery[neigh]==-1){
                tarjan(neigh);
                low[node]=Math.min(low[node], low[neigh]);
            }else if(instack[node]){
                low[node]=Math.min(low[node], discovery[neigh]);
            }
        }
        if(low[node]==discovery[node]){
            System.out.print("SCC: ");
            while(true){
                int current = stack.pop();
                instack[current]=false;
                System.out.print(current+" ");
                if(current == node){
                    break;
                }
            }
            System.out.println();
        }
    }
}
/** 
Tarjan's Algorithm
Which DSA topic?

Tarjan's Algorithm comes under:

Graph Algorithms

More specifically, it is commonly used for:

Strongly Connected Components (SCC) in directed graphs
Bridges in undirected graphs
Articulation Points in undirected graphs

There are slightly different Tarjan algorithms for each problem. The most common one to learn first is Tarjan's SCC algorithm.

Short definition

Tarjan's Algorithm finds all Strongly Connected Components (SCCs) of a directed graph in O(V + E) time using DFS, discovery times, and low-link values.

Time = O(V + E)
Space = O(V)
**/