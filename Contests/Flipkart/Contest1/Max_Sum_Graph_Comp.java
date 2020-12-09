import java.io.*;
import java.util.*;

class Max_Sum_Graph_Comp {
    List<List<Integer>> adj;
    int[] vis;

    long dfs(int node, int[] Values) {
        long sum = Values[node];
        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            if (vis[adj.get(node).get(i)] == 0)
                sum += dfs(adj.get(node).get(i), Values);
        }
        return sum;
    }

    long solve(int V, int E, int[] Values, int[][] Edges) {
        long answer = 0;
        adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
        vis = new int[V];
        Arrays.fill(vis, 0);
        for (int i = 0; i < E; i++) {
            Edges[i][0] -= 1;
            Edges[i][1] -= 1;
            adj.get(Edges[i][0]).add(Edges[i][1]);
            adj.get(Edges[i][1]).add(Edges[i][0]);
        }
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                long x = dfs(i, Values);
                if (answer < x)
                    answer = x;
            }
        }
        return answer;
    }
}