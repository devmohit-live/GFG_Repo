public class UnionByRank {
    /**
     * Improves time complexity of find and union from O(N) => log(N)
     * 
     */
    static int find(int x, int parent[]) {
        if (parent[x] == x)
            return x; // self parent
        return find(parent[x], parent); // find x's parent's parent
    }

    static void unionByRank(int x, int y, int parent[], int rank[]) {
        int repx = find(x, parent);
        int repy = find(y, parent);

        if (repx == repy) {
            System.out.println("Already friends!!");
            return;
        } else {
            if (rank[repx] > rank[repy]) {
                parent[repy] = repx;
            } else if (rank[repx] < rank[repy]) {
                parent[repx] = repy;
            } else {
                parent[repy] = repx;
                rank[repx]++; // height increased by 1
            }
        }
    }

    static boolean areFriends(int x, int y, int[] parent) {
        int rep_x = find(x, parent);
        int rep_y = find(y, parent);

        if (rep_x == rep_y)
            return true; // belongs to same group
        return false;
    }

    static void makeFriends(int x, int y, int[] parent, int rank[]) {
        // order x,y doesn't matter x will be parent of y
        unionByRank(x, y, parent, rank);
    }

    public static void main(String[] args) {

        int N = 6;
        int parent[] = new int[N];
        int rank[] = new int[N]; // here we maintained rank for each node initally 0
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; // initally everyone is parent of themself
        }
        System.out.println("Parent of 0 : " + find(0, parent));

        System.out.println("Making 1 and 2 friends  : ");
        makeFriends(1, 2, parent, rank);
        System.out.println("Are 1 and 2 friends?  : " + areFriends(1, 2, parent));
        System.out.println("Making 2 and 3 friends : ");
        makeFriends(2, 3, parent, rank);
        System.out.println("Making 2 and 4 friends : ");
        makeFriends(2, 4, parent, rank);
        System.out.println("Are 1 and 3 friends? : " + areFriends(1, 3, parent));
        System.out.println("Find 3's group Represntative : " + find(3, parent));

        System.out.println("Making 0 and 3 friends : ");
        makeFriends(0, 3, parent, rank); // here order doesn't matters
        System.out.println("Are 0 and 3 friends? : " + areFriends(3, 0, parent));

        System.out.println("Parent/Group Rep of 0 : " + find(0, parent));

        // for (int i = 0; i < rank.length; i++) {
        // System.out.println(i + "'s rank ' " + rank[i]);
        // System.out.println(i + "'s parent ' " + parent[i]);
        // }
    }
}
