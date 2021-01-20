import java.util.*;

public class Topological_DFS {

    // in dfs a vertx u goes into to stack only when all of it's desendents(vertices
    // on which u is dependent) goes to stack

    public static void dfsUtil(ArrayList<ArrayList<Integer>> adj, int src, boolean visited[], Stack<Integer> s) {
        if (!visited[src]) {
            visited[src] = true;
            for (Integer v : adj.get(src)) {
                if (!visited[v]) {
                    dfsUtil(adj, v, visited, s);
                }
            }
            // System.out.println("Stack element: " + (s.isEmpty() == false ? s.peek() :
            // "noelement"));
            s.push(src);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 5;
        boolean visited[] = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(0).add(1);
        adj.get(1).add(3);
        adj.get(3).add(4);
        adj.get(2).add(3);
        adj.get(2).add(4);
        // Time complexity = same as DFS => O(V+E)
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfsUtil(adj, i, visited, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}