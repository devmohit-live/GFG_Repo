import java.util.*;
// import java.io.*;

public class DFS {

    public static void dfsUtil(ArrayList<ArrayList<Integer>> adj, int src, boolean visited[]) {
        if (!visited[src]) {
            visited[src] = true;
            System.out.print(src + " ");
            for (int v : adj.get(src)) {
                if (!visited[v])
                    dfsUtil(adj, v, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        int E = 8;
        boolean visited[] = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(3).add(3); // self loop
        adj.get(3).add(3); // self loop
        adj.get(4).add(4); // self loop diconnected
        adj.get(4).add(4); // self loop diconnected
        // vertex 5 disconnected

        // calling for unconnected graph -> normally we start with first vetex as src in
        // connected and keep on traversing
        int connected = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                connected++;
                dfsUtil(adj, i, visited);
                System.out.println();
            }
        }
        System.out.println("Connected components are: " + connected);
    }
}
