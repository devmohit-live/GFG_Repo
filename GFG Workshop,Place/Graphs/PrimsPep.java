import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 
 */
public class PrimsPep {
    static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

    }

    static class Pair implements Comparable<Pair> {
        int v;
        int acv;
        int wt;

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }

        public Pair(int v, int acv, int wt) {
            this.v = v;
            this.acv = acv;
            this.wt = wt;
        }

    }

    public static void addEdge(ArrayList<ArrayList<Edge>> adj, int u, int v, int wt) {
        adj.get(u).add(new Edge(u, v, wt));
        adj.get(v).add(new Edge(v, u, wt));
    }

    public static void main(String[] args) {
        int V = 7;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Edge>());
        }
        addEdge(adj, 0, 1, 10);
        addEdge(adj, 1, 2, 10);
        addEdge(adj, 2, 3, 10);
        addEdge(adj, 1, 3, 40);
        addEdge(adj, 2, 4, 2);
        addEdge(adj, 4, 5, 3);
        addEdge(adj, 4, 6, 8);
        addEdge(adj, 5, 6, 3);
        // intially src=0,parent=-1,wt=0
        int sum = 0;
        pq.add(new Pair(0, -1, 0));
        boolean[] visited = new boolean[V];
        while (!pq.isEmpty()) {
            // rm*wa*
            Pair rm = pq.remove();
            if (visited[rm.v] == true) {
                continue;
            }
            visited[rm.v] = true;
            sum += rm.wt;
            if (rm.acv != -1) {
                System.out.println(rm.v + " through " + rm.acv + " via weight " + rm.wt);
            }
            // a
            for (Edge e : adj.get(rm.v)) {
                if (!visited[e.nbr]) {
                    pq.add(new Pair(e.nbr, rm.v, e.wt));
                }
            }
        }
        System.out.println("Total cost of MST : " + sum);
    }
}