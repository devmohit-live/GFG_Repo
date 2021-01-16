//https://practice.geeksforgeeks.org/problems/print-common-nodes-in-bst/0/?category[]=Binary%20Search%20Tree&category[]=Binary%20Search%20Tree&page=1&query=category[]Binary%20Search%20Treepage1category[]Binary%20Search%20Tree#

public class CommmonNodein2Bst {
    // print a list containing the intersection of the two BSTs in a sorted order
    public static ArrayList<Integer> printCommon(Node root1, Node root2) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        traversal(root1, hs, res);
        traversal(root2, hs, res);
        return res;
    }

    private static void traversal(Node node, HashSet<Integer> hs, ArrayList<Integer> res) {
        if (node == null)
            return;

        traversal(node.left, hs, res);
        if (hs.add(node.data) == false) {
            res.add(node.data);
        }
        traversal(node.right, hs, res);
    }
}
