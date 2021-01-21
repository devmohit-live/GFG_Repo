import java.util.ArrayList;
import java.util.Stack;

public class ConnectedComp_DFS_Kosaraju {
    static ArrayList<ArrayList<Integer>> transposed;
    static ArrayList<ArrayList<Integer>> adj;

    static void transpose(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            for (int v : adj.get(i)) {
                transposed.get(v).add(i); // reversed edges
            }
        }
    }

    static void dfsUtil(ArrayList<ArrayList<Integer>> adj, Stack<Integer> s, int src, boolean[] visited) {
        visited[src] = true;

        for (int v : adj.get(src)) {
            if (!visited[v]) {
                dfsUtil(adj, s, v, visited);
            }
        }
        s.push(src);
    }

    static void normalDfs(int src, boolean[] tvisited) {
        tvisited[src] = true;
        System.out.print(src + " ");
        for (int v : transposed.get(src)) {
            if (!tvisited[v]) {
                normalDfs(v, tvisited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        // int E=5;
        adj = new ArrayList<>(V);
        transposed = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
            transposed.add(new ArrayList<Integer>());
        }
        // 2 stringly connected components: A: 0,1,2 ---- B: 3,4
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(3).add(4);
        Stack<Integer> s1 = new Stack<>();
        // Stack<Integer> s2 = new Stack<>();
        boolean visited[] = new boolean[V];
        // step 1: do dfs traversal(pusing src in stack at end) to get v's in decreasing
        // time order
        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfsUtil(adj, s1, i, visited);

        // step 2: reverse the direction of edges
        transpose(adj);

        // step 3: normally dfs traverse the transposed adj using stack elements as
        // sources
        boolean tvisited[] = new boolean[V];
        while (!s1.isEmpty()) {
            int src = s1.pop();
            if (!tvisited[src]) {
                normalDfs(src, tvisited);
                System.out.println();
            }
        }
    }
}