import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author devmohit-live
 * 
 *         Greedy Algo: Steps: 1: Sort the edges in increasing order of their
 *         weight
 * 
 *         2: Traverse through these edges : 3: if adding the particular edge
 *         causes cycle then ignore it else add it to mst and res+=e.wt
 */

public class Kruskal {

    static class Edge implements Comparable<Edge> {
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

        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }

    }

    /**
     * Find and Union takes amortize O(1) time -> constact as they are implemeted
     * using Rank and Path Compression even if we don't do path compression =>
     * parent[x]=find(parent[x],parent) we would be having O(logn), here we have
     * implemeted path compression too so we have constant time operation
     */

    static int find(int[] parent, int x) {
        if (x == parent[x])
            return x;
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    static void uniounByRank(int repx, int repy, int[] parent, int[] rank) {
        if (rank[repx] > rank[repy]) {
            parent[repy] = repx;
        } else if (rank[repx] < rank[repy]) {
            parent[repx] = repy;
        } else {
            parent[repy] = repx;
            rank[repx]++; // height increased by 1
        }
    }

    static void kruskal(Edge[] edges, int V) {
        // initalizing for disjoint set for cycle detection in edges
        int parent[] = new int[V];
        int rank[] = new int[V]; // here we maintained rank for each node initally 0

        // O(V)
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; // initally everyone is parent of themself
        }

        // Sorting edges --> O(ElogE)
        Arrays.sort(edges);

        Edge[] op = new Edge[V - 1]; // MST contains V-1 Edges
        int cost = 0, count = 0;

        // O(E)
        for (Edge e : edges) {
            if (count == V - 1)
                break;
            // constant time operation
            int repx = find(parent, e.src);
            int repy = find(parent, e.nbr);
            if (repx != repy) {
                cost += e.wt;
                op[count] = e;
                count++;
                uniounByRank(repx, repy, parent, rank); // comstant time operation
            }
        }

        for (int i = 0; i < op.length; i++) {
            System.out.println("Edge " + (i + 1) + " : " + edges[i].src + " -> " + edges[i].nbr + " with weight "
                    + edges[i].wt + " is selected");
        }
        System.out.println("Cost is " + cost);
    }

    public static void main(String[] args) {
        // int V = 5;
        // int E = 4;
        final Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        // ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        Edge[] edges = new Edge[E];
        // no use of adj list here
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        kruskal(edges, V);
        sc.close();
    }
}

/**
 * Inp: 5 7 0 1 6 0 2 5 1 3 8 1 2 3 2 4 12 3 4 10 2 3 7
 * 
 * //O(ElogE) + O(V)+ O(EaphaV -> E) => O(ElogE) === O(ElogV)
 * 
 * //without using path compression: //O(ElogE) + O(V)+ O(ElogV) => O(E(logV +
 * logE))
 * 
 * // Space: O(E)+O(V) => O(E)==O(V)
 */