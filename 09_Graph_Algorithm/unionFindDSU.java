public class unionFindDSU{
    static int[] parent;
    static int[] rank;
    
    public static void initilize(int n){
        parent= new int[n];
        rank= new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public static int find(int i){
        if(i==parent[i]){
            return i;
        }
        return parent[i]= find(parent[i]);
    }
    public static  boolean union(int x, int y){
        int x_parent= find(x);
        int y_parent= find(y);
        if(x_parent==y_parent){
            return false;
        }
        if(rank[x_parent]>rank[y_parent]) parent[y_parent]=x_parent;
        else if(rank[x_parent]< rank[y_parent]) parent[x_parent]=y_parent;
        else{
            parent[y_parent]=x_parent;
            rank[x_parent]++;
        }
        return true;
    }
    public static void main(String[] args){
        int n=6;
        initilize(n);
        union(1,2);
        union(2,3);
        union(0,2);
        union(4,5);

        if(find(1)==find(3)){
            System.out.println("Connected");
        }else{
            System.out.println("Not Connected");
        }
        if(find(1)==find(4)){
            System.out.println("Connected");
        }else{
            System.out.println("Not Connected");
        }
    }
}

// Union-Find (DSU — Disjoint Set Union) is a data structure used to efficiently manage connected components/groups. It is especially useful in Kruskal's Algorithm for detecting cycles.
// Time per operation: approximately O(α(n)), which is effectively almost O(1) in practice.

// Space: O(n).

// 🧠 Remember:
// DSU = Find the group + Union two groups + Path Compression + Union by Rank.