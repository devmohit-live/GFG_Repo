import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * STeps: 1. Find the topologocal Sort of Graph (as it is directed) => O(V+E)
 * 
 * 2. Using the sequence obtained from above traverse throug vertices and do
 * relax operation if distance[v] => O(E) Time => O(V+E) Space =>O(V)
 * 
 */
public class ShortestPathDAG {

    static class Edge {
        int src, nbr, wt;

        /**
         * @param src
         * @param nbr
         * @param wt
         */
        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

    }

    private static void dfsUtil(ArrayList<ArrayList<Edge>> adj, boolean[] visited, Stack<Integer> s, int src) {
        visited[src] = true;
        for (Edge e : adj.get(src)) {
            if (!visited[e.nbr]) {
                dfsUtil(adj, visited, s, e.nbr);
            }
        }
        s.push(src);
    }

    static Stack<Integer> topological(ArrayList<ArrayList<Edge>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < adj.size(); i++) {
            for (Edge e : adj.get(i)) {
                if (!visited[e.nbr]) {
                    dfsUtil(adj, visited, s, i);
                }
            }
        }
        return s;
    }

    private static void shortestDAG(ArrayList<ArrayList<Edge>> adj, int src) {
        // step 1 -> O(V+E)
        Stack<Integer> s = topological(adj);
        int distance[] = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        // step2:
        // O(V+ E) as this is a directed acyclic graph in we are processing the vertices
        // in forward manner (topological manner)
        while (!s.isEmpty()) {
            int u = s.peek();
            for (Edge e : adj.get(u)) {
                int v = e.nbr;
                // remember not to update the distance of src
                if (v != src) {
                    if (distance[v] > distance[u] + e.wt) {
                        distance[v] = distance[u] + e.wt;
                    }
                }

                // System.out.format("u is %d v is %d disatnce of v is %d \n", u, v,
                // distance[v]);
            }
            s.pop();
        }
        // op
        for (int i = 0; i < distance.length; i++) {
            System.out.println("src: " + src + " to: " + i + " cost : "
                    + (distance[i] == Integer.MAX_VALUE ? "infinity" : distance[i]));
        }

    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("V and E  :");
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Edge>());
        System.out.println("Input Edges: ");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();
            adj.get(u).add(new Edge(u, v, wt));
        }
        System.out.println("Input src: ");
        int src = sc.nextInt();
        shortestDAG(adj, src);
        sc.close();
    }

}
/**
 * inp1: 6 7 0 1 2 0 4 1 1 2 3 2 3 6 4 2 2 4 5 4 5 3 1 0
 * 
 * inp2: 4 4 0 1 1 1 2 3 2 3 4 1 3 2 1
 */