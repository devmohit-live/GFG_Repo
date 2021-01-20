import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * The idea here is when there is a cycle in directed graph and we de
 * topological sorting then at some point the vertices gaving cycle(dependent on
 * each other) will never obtain the indegree=0.
 * 
 * So during the BFS traversal(Kahn's algo) for every pop operation from Queue
 * incremement counter and due to the above stated reason we will never make the
 * count == V, and in this case we say that the graph has cycle
 */

public class CycleDetection_Kahns {
    public static boolean hasCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        System.out.println("V " + V);
        Queue<Integer> q = new ArrayDeque<>();
        // making indegree
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }

        // adding vetex of indegree 0 in Q
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
            // System.out.println("Indegree of " + i + " is : " + indegree[i]);
        }
        // System.out.println("Queue::before " + q);

        int count = 0;
        while (!q.isEmpty()) {
            // rpa
            int u = q.poll();
            ++count;

            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] <= 0) {
                    q.add(v);
                }
            }
        }

        // System.out.println("Queue::after " + q);

        if (count < V)
            return true;

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        // int V = 4;
        // int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // no cycle
        adj.get(0).add(1);
        adj.get(1).add(3);
        adj.get(2).add(3);
        adj.get(2).add(1);

        // // cycle
        // adj.get(0).add(1);
        // adj.get(1).add(2);
        // adj.get(2).add(3);
        // adj.get(3).add(1);

        // // cycle
        // adj.get(0).add(1);
        // adj.get(2).add(1);
        // adj.get(2).add(3);
        // adj.get(3).add(4);
        // adj.get(4).add(5);
        // adj.get(5).add(3);

        System.out.println(hasCycle(adj));
    }
}