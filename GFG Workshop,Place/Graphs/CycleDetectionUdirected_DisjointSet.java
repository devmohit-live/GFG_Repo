
// import java.util.ArrayList;
import java.util.Scanner;

/**
 * Here we represent graph woth V vertices and E edge pairs not with adjanct
 * list
 */
class BasicDisjoint {

    int V;
    int[] parent;

    public BasicDisjoint(int V, int[] parent) {
        this.V = V;
        this.parent = parent;
    }

    int find(int x, int parent[]) {
        if (parent[x] == x)
            return x; // self parent
        return find(parent[x], parent); // find x's parent's parent
    }

    void unioun(int x, int y, int[] parent) {
        // if both doesn't belong to same group we make second element child of first
        // one
        int rep_x = find(x, parent);
        int rep_y = find(y, parent);
        if (rep_x != rep_y) {
            // group y is now child of group x
            parent[rep_y] = rep_x;
        } else
            System.out.println("Already Friends!!");
        return;
    }

    // boolean areFriends(int x, int y, int[] parent) {
    // int rep_x = find(x, parent);
    // int rep_y = find(y, parent);

    // if (rep_x == rep_y)
    // return true; // belongs to same group
    // return false;
    // }

    // void makeFriends(int x, int y, int[] parent) {
    // // order x,y matter x will be parent of y
    // unioun(x, y, parent);
    // }
}

public class CycleDetectionUdirected_DisjointSet {
    static class Edge {
        int src;
        int des;

        Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static boolean hasCycle(Edge edges[], int V) {
        int parent[] = new int[V];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        BasicDisjoint ob = new BasicDisjoint(V, parent);

        // System.out.println("Find chcke " + ob.find(edges[2].src, parent));
        // System.out.println("Union chckek");
        // ob.unioun(edges[0].src, edges[0].des, parent);

        // traverse
        for (int i = 0; i < V; i++) {
            int x = ob.find(edges[i].src, parent);
            int y = ob.find(edges[i].des, parent);
            if (x == y)
                return true;

            ob.unioun(x, y, parent);
        }

        return false;
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int V = 5;
        int E = 4;
        // boolean visited[] = new boolean[V];
        Edge[] edges = new Edge[V];
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge(sc.nextInt(), sc.nextInt());
            System.out.println("Edge " + edges[i].src + "  " + edges[i].des);
        }
        sc.close();
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

        System.out.println("Cycle using DFS :" + hasCycle(edges, V));
        // System.out.println("Cycle using BFS :" + hasCycleBfs(adj, V));

    }

}
// inp no cycle
/**
 * 0 1 1 2 1 3 3 4
 */
