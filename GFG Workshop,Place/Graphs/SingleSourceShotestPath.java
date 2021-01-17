import java.util.*;

/**
 * For Unweighted Graph
 * 
 */
public class SingleSourceShotestPath {
    // shortest path using bfs
    static class Pair {
        int v;
        int w;
        // String path;
        // private int gt;
        // private double st;

        Pair(int v, int w) {
            this.v = v;
            this.w = w;
            // this.path = path;
        }
    }

    public static void shortestPathBFS(ArrayList<ArrayList<Integer>> adj, int V, int src) {
        boolean[] visited = new boolean[V];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));

        System.out.println("Vertex:\t Distance From source " + src);
        // System.out.println(src + ":\t " + 0);
        visited[src] = true;
        while (!q.isEmpty()) {
            // rpa
            Pair curr = q.remove();

            // p
            System.out.println(curr.v + ":\t " + curr.w);

            // a
            for (int v : adj.get(curr.v)) {
                if (!visited[v]) {
                    Pair neighbour = new Pair(v, curr.w + 1);
                    q.add(neighbour);
                    visited[v] = true;
                    // System.out.println(neighbour.v + ":\t " + neighbour.w); -> this is working
                    // fine too
                }
            }
        }

    }

    public static void shortestPathBFS(ArrayList<ArrayList<Integer>> adj, int V, int src, boolean[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));

        System.out.println("Vertex:\t Distance From source " + src);
        // System.out.println(src + ":\t " + 0);
        visited[src] = true;
        while (!q.isEmpty()) {
            // rpa
            Pair curr = q.remove();

            // p
            System.out.println(curr.v + ":\t " + curr.w);

            // a
            for (int v : adj.get(curr.v)) {
                if (!visited[v]) {
                    Pair neighbour = new Pair(v, curr.w + 1);
                    q.add(neighbour);
                    visited[v] = true;
                    // System.out.println(neighbour.v + ":\t " + neighbour.w); -> this is working
                    // fine too
                }
            }
        }

    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Graph 1: ");
        /*
         * //connected: 0 1 1 2 2 3 3 4 0 5 1 5 5 6 2 6 6 4
         */
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
        int E = 9;
        System.out.println("Edges for Grph1: ");
        for (int i = 0; i < E; i++) {
            addEdge(adj, sc.nextInt(), sc.nextInt());
        }
        int src = 0;
        shortestPathBFS(adj, V, src);

        /**
         * diconnected: 0 1 0 2 1 3 2 3 2 4 5 6 6 7
         */

        System.out.println("Graph 2:");
        int V1 = 8;
        int E1 = 7;
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>(V1);
        for (int i = 0; i < V1; i++)
            adj1.add(new ArrayList<Integer>());

        System.out.println("Edges for Graph2 : ");
        for (int i = 0; i < E1; i++) {
            addEdge(adj1, sc.nextInt(), sc.nextInt());
        }
        boolean visited[] = new boolean[V1];
        int count = 0;
        for (int i = 0; i < V1; i++) {
            if (!visited[i])
                shortestPathBFS(adj1, V1, i, visited);
            count++;
        }
        if (count > 0)
            System.out.println("Disconnected graph");

        sc.close();

    }

}
