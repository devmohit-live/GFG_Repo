import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Topological_BFS {
    /**
     * KAHN'S ALGORITHM -> uses BFS
     * 
     * add all 0 indegree vertices in q first the vertex with indegree=0 will pe
     * popped out in bfs as it is not dependent on any other before popping it will
     * reduce the indegree of it's neighbours by 1
     * 
     * Since we need to decrease the indegree during traversal multiple times so we
     * don't need to keep track of visited vertices
     * 
     * Calcultion and representation of indegree: we eill be using an array[V]
     * Case1: When we are the one creating graph from scrath having access to
     * addEdge function: we add an edge u->v and at that time we will do
     * indegree[v]++
     * 
     * Case2: When we don't have that access => we eill traverse the adj list and
     * for very vertex in adj we do indegree[v]++;
     * 
     */

    static void kahn(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        Queue<Integer> q = new ArrayDeque<>();

        // case2
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        // System.out.println("*** Indegree ***");
        // for (int i : indegree) {
        // System.out.print(i + " ");
        // }
        // System.out.println("**Queue** " + q);

        bfsTopological(adj, indegree, q);

    }

    static void bfsTopological(ArrayList<ArrayList<Integer>> adj, int[] indegree, Queue<Integer> q) {
        // rpa -> don;t need visited here
        while (!q.isEmpty()) {
            int u = q.remove();

            System.out.print(u + " ");

            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] <= 0)
                    q.add(v);
            }

        }

    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v, int[] indegree) {
        adj.get(u).add(v);
        indegree[v]++;
    }

    public static void main(String[] args) {
        int V = 5;
        // boolean visited[] = new boolean[V]; no need of visited array
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(1);
        adj.get(1).add(3);
        adj.get(3).add(4);
        adj.get(2).add(3);
        adj.get(2).add(4);

        kahn(V, adj);
        /*
         * // case1 : int V1 = 5; int E1 = 5; ArrayList<ArrayList<Integer>> adj1 = new
         * ArrayList<>(V); for (int i = 0; i < V; i++) { adj1.add(new
         * ArrayList<Integer>()); }
         * 
         * int indegree[] = new int[V1]; adj.get(0).add(1); addEdge(adj, 0, 1,
         * indegree); addEdge(adj, 1, 3, indegree); addEdge(adj, 3, 4, indegree);
         * addEdge(adj, 2, 3, indegree); addEdge(adj, 2, 4, indegree);
         */
    }
}
