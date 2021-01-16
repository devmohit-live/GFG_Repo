// https://practice.geeksforgeeks.org/problems/normal-bst-to-balanced-bst/1/?category[]=Binary%20Search%20Tree&category[]=Binary%20Search%20Tree&page=1&query=category[]Binary%20Search%20Treepage1category[]Binary%20Search%20Tree#

class NormalToBalanced {
    Node buildBalancedTree(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        traversal(root, arr);
        Node newroot = buildBst(arr, 0, arr.size() - 1);
        return newroot;

    }

    private Node buildBst(ArrayList<Integer> arr, int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            Node node = new Node(arr.get(mid));
            node.left = buildBst(arr, l, mid - 1);
            node.right = buildBst(arr, mid + 1, r);

            return node;
        }
        return null;
    }

    private void traversal(Node node, ArrayList<Integer> res) {
        if (node == null)
            return;

        traversal(node.left, res);
        res.add(node.data);
        traversal(node.right, res);
    }
}