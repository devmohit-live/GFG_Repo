import java.util.ArrayList;

public class CycleDetectionDirected {

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int V, int src, boolean[] visited,
            boolean[] rec) {
        visited[src] = true;
        rec[src] = true;

        for (int n : adj.get(src)) {
            if (visited[n] == false) {
                if (detectCycle(adj, V, n, visited, rec)) {
                    return true;
                }
            } else if (rec[n] == true)
                return true;
        }
        rec[src] = false;

        return false;
    }

    public static boolean hasCycleDFS(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        boolean[] rec = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (detectCycle(adj, V, i, visited, rec))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // no cycle
        adj.get(0).add(1);
        adj.get(1).add(3);
        adj.get(2).add(3);
        adj.get(2).add(1);

        // cycle
        // adj.get(0).add(1);
        // adj.get(1).add(2);
        // adj.get(2).add(3);
        // adj.get(3).add(1);

        // cycle
        // adj.get(0).add(1);
        // adj.get(2).add(1);
        // adj.get(2).add(3);
        // adj.get(3).add(4);
        // adj.get(4).add(5);
        // adj.get(5).add(3);

        System.out.println(hasCycleDFS(adj, V));
    }
}