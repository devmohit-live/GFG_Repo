import java.util.ArrayList;
import java.util.Scanner;

public class OtherImplemetation {

    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */

        @Override
        public String toString() {
            return "Edge [src=" + src + ", des=" + des + ", wt=" + wt + "]";
        }

    }

    static class Pair implements Comparable<Pair> {
        int src;
        int wsf;
        String psf;
        int level;
        // and other required attributes acc to question

        @Override
        public int compareTo(OtherImplemetation.Pair o) {
            return this.wsf - o.wsf;
        }

    }

    public static void addEdge(ArrayList<ArrayList<Edge>> adj, int u, int v, int wt) {
        adj.get(u).add(new Edge(u, v, wt));
        adj.get(v).add(new Edge(v, u, wt));
    }

    public static void display(int V, ArrayList<ArrayList<Edge>> adj) {
        System.out.println("*** Dispaly ***");
        for (int i = 0; i < V; i++) {
            System.out.println(i + ":\t" + adj.get(i));
        }
    }

    public static void main(String[] args) {
        int V = 7;
        int E = 8;
        final Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Edge>());
        }

        for (int e = 0; e < E; e++) {
            addEdge(adj, sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        display(V, adj);
    }

}
/**
 * inp: 0 1 30 0 3 40 1 2 10 2 3 10 3 4 2 4 5 3 4 6 8 5 6 3
 */