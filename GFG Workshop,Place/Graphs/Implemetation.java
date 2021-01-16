// package Graph;

import java.util.*;

public class Implemetation {
    static Scanner sc = new Scanner(System.in);

    public static void createGraph(int V, int E) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        // ArrayList<Integer>[] adj2 = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // for (int i = 0; i < V; i++) {
        // adj2[i] = new ArrayList<Integer>();
        // }

        System.out.println("Enter" + E + "Edges in u,v format");

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // Undirected
            adj.get(u).add(v);
            adj.get(v).add(u);

            // adj2[u].add(v);
            // adj2[v].add(u);
            // Directed
            // adj.get(u).add(v);
        }

        display(adj, V, E);
    }

    private static void display(ArrayList<ArrayList<Integer>> adj, int V, int E) {// ArrayList<Integer>[] adj2
        System.out.println("Graph: ");
        for (int i = 0; i < V; i++) {
            System.out.println(i + ": " + adj.get(i));
        }
        // System.out.println("Adj list 2 : ");
        // for (int i = 0; i < V; i++) {
        // System.out.println(i + ": " + adj2[i]);
        // }
    }

    public static void main(String[] args) {

        int V = sc.nextInt();
        int E = sc.nextInt();
        createGraph(V, E);
    }
}