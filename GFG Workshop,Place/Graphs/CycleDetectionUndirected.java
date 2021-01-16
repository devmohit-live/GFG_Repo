import java.util.*;

public class CycleDetectionUndirected {

    // basically while traversing if we encounter any visited node v which isn't the
    // parent of current node(not coming from that node)
    // then there is a cycke between the current node and the node which is marked
    // visited

    public static boolean dfsCycle(ArrayList<ArrayList<Integer>> adj, int src, int parent, boolean[] visited) {
        visited[src] = true;
        for (int v : adj.get(src)) {
            if (visited[v] == false) {
                visited[v] = true;
                if (dfsCycle(adj, v, src, visited))
                    return true;
            } else if (v != parent)
                return true;
        }
        return false;
    }

    public static boolean hasCycleDfs(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (dfsCycle(adj, i, -1, visited))
                    return true;
            }
        }
        return false;
    }

    // #TODO: Bfs part
    /*
     * public static boolean bfsCycle(ArrayList<ArrayList<Integer>> adj, int V, int
     * src, int parent, boolean[] visited) { Queue<Integer> q = new
     * ArrayDeque<Integer>(); q.add(src); while (!q.isEmpty()) { // rpa int curr =
     * q.remove(); parent = curr; // p
     * 
     * // a for (int v : adj.get(curr)) { if (visited[v] == false) { q.add(v); }
     * else if (v != parent) { return true; } } } return false; }
     * 
     * public static boolean hasCycleBfs(ArrayList<ArrayList<Integer>> adj, int V) {
     * boolean visited[] = new boolean[V]; for (int i = 0; i < V; i++) { if
     * (visited[i] == false) { if (bfsCycle(adj, V, 0, -1, visited)) return true; }
     * } return false; }
     */
    public static void main(String[] args) {
        int V = 6;
        int E = 8;
        boolean visited[] = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(1).add(2);
        adj.get(2).add(1);

        // adj.get(0).add(1);
        // adj.get(1).add(0);
        // adj.get(1).add(3);
        // adj.get(3).add(1);
        // adj.get(1).add(2);
        // adj.get(2).add(1);
        // adj.get(2).add(3);
        // adj.get(3).add(2);

        // adj.get(0).add(1);
        // adj.get(1).add(0);
        // adj.get(0).add(2);
        // adj.get(2).add(0);
        // adj.get(0).add(3);
        // adj.get(3).add(0);
        // adj.get(2).add(3);
        // adj.get(3).add(2);
        // adj.get(1).add(3);
        // adj.get(3).add(1);

        // adj.get(3).add(3); // self loop therefore cycle
        // adj.get(3).add(3); // self loop
        // adj.get(4).add(4); // self loop diconnected
        // adj.get(4).add(4); // self loop diconnected
        // // vertex 5 disconnected

        // calling for unconnected graph -> normally we start with first vetex as src in
        // connected and keep on traversing

        System.out.println("Cycle using DFS :" + hasCycleDfs(V, adj));
        // System.out.println("Cycle using BFS :" + hasCycleBfs(adj, V));

    }
}
