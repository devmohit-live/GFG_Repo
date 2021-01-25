import java.util.ArrayList;

public class CycleDetectionUndirected_Disjoint {
    private static int find(int x, int[] parent) {
        if (x == parent[x])
            return x;

        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private static void uniounByRank(int x, int y, int[] parent, int[] rank) {
        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else if (rank[y] > rank[x]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }

    public static boolean hasCycle(ArrayList<ArrayList<Integer>> adj) {
        int parent[] = new int[adj.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int rank[] = new int[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            for (int v : adj.get(i)) {
                int repx = find(i, parent); // src
                int repy = find(v, parent); // nbr
                if (repx == repy) {
                    return true;
                    // cycle
                }
                uniounByRank(repx, repy, parent, rank);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 4;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // no cycle
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(2).add(1);
        adj.get(1).add(2);

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
        System.out.println(hasCycle(adj));
    }

}
