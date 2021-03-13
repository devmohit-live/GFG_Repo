import java.util.*;

public class ArticulationPoint {
    /**
     * A vertex to be said an articulation point if removing the vertx along woth
     * it's edges increases the no. of connected components
     * 
     * 1. if root has 2 children => root is articulation point => making 2 entiely
     * disconnected things connected
     * 
     * Discovery Time: the time when the visit is first visited Low Value: The
     * lowest dicovery time of the vertices(that can be reached from current vertex)
     * using direct and backedges
     * 
     * 2. for edge u --> v if lowvalue[v] >= discovery[u] then u is an articulation
     * point
     * 
     */

    static int time = 0;

    public static void dfsUtil(ArrayList<ArrayList<Integer>> adj, int u, int[] parent, int[] disc, int[] lowv,
            boolean[] visited, boolean[] aps) {

        visited[u] = true;
        int childern = 0;
        disc[u] = lowv[u] = ++time;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                childern++;
                parent[v] = u;
                dfsUtil(adj, v, parent, disc, lowv, visited, aps);
                // 1. u is root and children>=2
                if (parent[u] == -1 && childern > 1) {
                    aps[u] = true;
                }
                // 2. No backedge is found
                else if (lowv[v] >= disc[u]) {
                    aps[u] = true;
                }
            } else if (v != parent[u])
                lowv[u] = Math.min(lowv[u], disc[v]);
        }
    }

    public static void articulationPoint(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] parent = new int[V];
        int[] disc = new int[V];
        int[] lowv = new int[V];
        boolean visited[] = new boolean[V];
        boolean aps[] = new boolean[V];
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfsUtil(adj, i, parent, disc, lowv, visited, aps);
        }
        System.out.println("Following are the articulation points in a graph: ");
        for (int i = 0; i < aps.length; i++) {
            if (aps[i])
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        System.out.println("Articulation points in first graph ");
        ArrayList<ArrayList<Integer>> g1 = new ArrayList<>(5);
        addEdge(g1, 1, 0);
        addEdge(g1, 0, 2);
        addEdge(g1, 2, 1);
        addEdge(g1, 0, 3);
        addEdge(g1, 3, 4);
        articulationPoint(g1);
        System.out.println();

        System.out.println("Articulation points in Second graph");
        ArrayList<ArrayList<Integer>> g2 = new ArrayList<>(4);
        addEdge(g2, 0, 1);
        addEdge(g2, 1, 2);
        addEdge(g2, 2, 3);
        articulationPoint(g2);
        System.out.println();

        System.out.println("Articulation points in Third graph ");
        ArrayList<ArrayList<Integer>> g3 = new ArrayList<>(7);
        addEdge(g3, 0, 1);
        addEdge(g3, 1, 2);
        addEdge(g3, 2, 0);
        addEdge(g3, 1, 3);
        addEdge(g3, 1, 4);
        addEdge(g3, 1, 6);
        addEdge(g3, 3, 5);
        addEdge(g3, 4, 5);
        articulationPoint(g3);
    }
}
