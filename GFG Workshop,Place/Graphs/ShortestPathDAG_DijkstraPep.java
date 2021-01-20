import java.util.*;

public class ShortestPathDAG_DijkstraPep {
    // Pep
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int wsf;
        String psf;

        Pair(int v, int wsf, String psf) {
            this.v = v;
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    public static Pair dijkstra_Directed(ArrayList<ArrayList<Edge>> adj, int src, int V) {
        Pair toreturn = null;
        boolean[] visited = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0, src + ""));

        while (!pq.isEmpty()) {
            // rm*wa*
            Pair rem = pq.remove();

            // m*
            if (!visited[rem.v]) {
                visited[rem.v] = true;
                // w
                // System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);
                toreturn = rem;
                // a*
                for (Edge e : adj.get(rem.v)) {
                    if (!visited[e.nbr]) {
                        pq.add(new Pair(e.nbr, e.wt + rem.wsf, rem.psf + e.nbr));
                    }
                }
            } else {
                continue;
            }
        }
        return toreturn;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Edge>());
        }

        adj.get(0).add(new Edge(0, 1, 2));
        adj.get(0).add(new Edge(0, 4, 1));
        adj.get(1).add(new Edge(1, 2, 3));
        adj.get(2).add(new Edge(2, 3, 6));
        adj.get(4).add(new Edge(4, 2, 2));
        adj.get(4).add(new Edge(4, 5, 4));
        adj.get(5).add(new Edge(5, 3, 1));

        Pair p = dijkstra_Directed(adj, 0, V);

        System.out.println("Shortest Path: " + p.psf + " with Cost: " + p.wsf);

    }

}