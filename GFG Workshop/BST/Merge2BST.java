//https://practice.geeksforgeeks.org/problems/merge-two-bst-s/0/?category[]=Binary%20Search%20Tree&category[]=Binary%20Search%20Tree&page=1&query=category[]Binary%20Search%20Treepage1category[]Binary%20Search%20Tree
public class Merge2BST {
    // Return a integer of integers having all the nodes in both the BSTs in a
    // sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> res = new ArrayList<Integer>();

        ArrayList<Integer> t1 = new ArrayList<>();
        ArrayList<Integer> t2 = new ArrayList<>();
        traversal(root1, t1);
        traversal(root2, t2);

        int i = 0, j = 0;
        while (i < t1.size() && j < t2.size()) {
            int a = t1.get(i);
            int b = t2.get(j);
            if (a <= b) {
                res.add(a);
                i++;
            } else {
                res.add(b);
                j++;
            }
        }
        while (i < t1.size()) {
            res.add(t1.get(i));
            i++;
        }
        while (j < t2.size()) {
            res.add(t2.get(j));
            j++;
        }

        t1 = null;
        t2 = null;
        return res;
    }

    private void traversal(Node node, ArrayList<Integer> op) {
        if (node == null)
            return;

        traversal(node.left, op);
        op.add(node.data);
        traversal(node.right, op);
    }
}
