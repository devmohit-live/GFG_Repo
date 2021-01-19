public class BasicDisjoint {

    static int find(int x, int parent[]) {
        if (parent[x] == x)
            return x; // self parent
        return find(parent[x], parent); // find x's parent's parent
    }

    static void unioun(int x, int y, int[] parent) {
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

    static boolean areFriends(int x, int y, int[] parent) {
        int rep_x = find(x, parent);
        int rep_y = find(y, parent);

        if (rep_x == rep_y)
            return true; // belongs to same group
        return false;
    }

    static void makeFriends(int x, int y, int[] parent) {
        // order x,y matter x will be parent of y
        unioun(x, y, parent);
    }

    public static void main(String[] args) {
        int N = 5;
        int parent[] = new int[N];
        // int rank[]=new int[N];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; // initally everyone is parent of themself
        }
        System.out.println("Parent of 0 : " + find(0, parent));
        System.out.println("Making 1 and 2 friends  : ");
        makeFriends(1, 2, parent);
        System.out.println("Are 1 and 2 friends?  : " + areFriends(1, 2, parent));
        System.out.println("Making 2 and 3 friends : ");
        makeFriends(2, 3, parent);
        System.out.println("Are 1 and 3 friends? : " + areFriends(1, 3, parent));
        System.out.println("Find 3's group Represntative : " + find(3, parent));
        System.out.println("Making 0 and 3 friends : ");
        makeFriends(3, 0, parent);
        System.out.println("Are 0 and 3 friends? : " + areFriends(3, 0, parent));

        System.out.println("Parent/Group Rep of 0 : " + find(0, parent));
        // for (int i = 0; i < N; i++) {
        // System.out.println(i + " : Parent: " + parent[i]);
        // }
    }
}
