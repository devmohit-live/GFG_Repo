// Java program to find minimum time required
// to burn the binary tree completely
/**
 * The height is calculated in terms of nodes but the root node is counted only
 * once not for both(left subtree and right subtree) the answer required was =>
 * lh + rh +1 (in terms of node height)
 * 
 * Approach: calculate lh,rh in terms of edges(root node isn't counted in
 * anyone) add 2 => +1 form root node , extra one req by ans
 */
public class Tried_BurinigTree {

    // Tree Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node node, Node cproot) {
        if (node == null)
            return -1;
        int lh = height(node.left, cproot);
        int rh = height(node.right, cproot);

        if (node == cproot) {
            res = lh + rh + 2;
            // +1 for node(root) itself
            // extra +1 for req ans
        }
        return Math.max(lh, rh) + 1;
    }

    static int ht = -1;
    static int res;

    // Driver Code
    public static void main(String args[]) {

        /*
         * inp1: op:6 Node root = new Node(1); root.left = new Node(2); root.right = new
         * Node(3); root.left.left = new Node(4); root.left.right = new Node(5);
         * root.right.left = new Node(6); root.left.left.left = new Node(8);
         * root.left.right.left = new Node(9); root.left.right.right = new Node(10);
         * root.left.right.left.left = new Node(11);
         */

        /*
         * inp2: op:7 1 / \ 2 3 / \ \ 4 5 6 / \ \ 7 8 9 \ 10
         * 
         * Node root = new Node(1);
         * 
         * root.left = new Node(2); root.left.left = new Node(4); root.left.right = new
         * Node(5); root.left.right.left = new Node(7); root.left.right.right = new
         * Node(8);
         * 
         * root.right = new Node(3); root.right.right = new Node(6);
         * root.right.right.right = new Node(9); root.right.right.right.right = new
         * Node(10);
         */

        Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);

        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);

        height(root, root);
        System.out.println(res);
    }
}
