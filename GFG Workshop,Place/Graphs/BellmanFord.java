import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    static class Edge {
        int src;
        int nbr;
        int wt;

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

    static void bellmanFord(ArrayList<ArrayList<Edge>> adj, int src) {
        int V = adj.size();
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        // getiing all E edges:
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (Edge e : adj.get(i)) {
                edges.add(e);
            }
        }

        // we obtaind the shortest path in V-1 repeation only
        for (int i = 0; i < V - 1; i++) { // ruuning loop V-1 times
            for (Edge e : edges) {
                if (distance[e.nbr] > distance[e.src] + e.wt) {
                    distance[e.nbr] = distance[e.src] + e.wt;
                }
            }
        }

        // detecting negative weight cycle: if we run the loop once again and we found
        // that the distance somewhere os decreased then there exists negative cycle
        for (Edge e : edges) {
            if (distance[e.nbr] > distance[e.src] + e.wt) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // if no negative cycle is detected:
        System.out.println("Source --> Vertex\tDistance");
        for (int i = 0; i < distance.length; i++) {
            System.out.println("   " + src + " --> " + i + " \t\t " + distance[i]);
        }

    }

    public static void main(String[] args) {
        // a->bc
        int V = 4;
        int E = 5;
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        ArrayList<ArrayList<Edge>> adj1 = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Edge>());
            adj1.add(new ArrayList<Edge>());
        }
        // no negative cycle
        adj.get(0).add(new Edge(0, 1, 1));
        adj.get(0).add(new Edge(0, 2, 4));
        adj.get(1).add(new Edge(1, 2, -3));
        adj.get(2).add(new Edge(2, 3, 3));
        adj.get(1).add(new Edge(1, 3, 2));

        // negative cycle
        adj1.get(0).add(new Edge(0, 1, 4));
        adj1.get(0).add(new Edge(0, 2, 8));
        adj1.get(1).add(new Edge(1, 2, -8));
        adj1.get(2).add(new Edge(2, 3, 2));
        adj1.get(3).add(new Edge(3, 1, 3));
        System.out.println("Graph 1: ");
        bellmanFord(adj, 0);
        System.out.println("Graph 2: ");
        bellmanFord(adj1, 0);
    }
}

// Pair[]