import java.util.*;

public class BFS {
    public static void bfsUtil(ArrayList<ArrayList<Integer>> adj, int src, boolean visited[]) {
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(src);
        while (!q.isEmpty()) {
            int curr = q.remove(); // r
            // m*
            visited[src] = true; // mark*
            // p
            System.out.print(curr + " ");
            // a
            for (int v : adj.get(src)) {
                if (visited[v] == false) {
                    q.add(v);
                    visited[v] = true;
                }
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
                bfsUtil(adj, i, visited);
                System.out.println();
            }
        }

        System.out.println("Connected components are: " + connected);
    }
}