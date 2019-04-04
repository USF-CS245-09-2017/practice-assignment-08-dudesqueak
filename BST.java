public class BST<String> {
    private Node root;


    public BST() { //constructor
        root = null;
    }

    public void insert(Comparable value) { //helper for insert function
        root = insert(root, value);
    }

    private Node insert(Node node, Comparable value) { // inserts new node in binary tree
        if (node == null) {
            Node newNode = new Node(value);
            node = newNode;
            return node;
        } else if (node.data.compareTo(value) > 0) {
            node.right = insert(node.right, value);
            return node;
        } else {
            node.left = insert(node.left, value);
            return node;
        }
    }

    public Boolean find(Comparable value){ // helper for find function
        return find(root, value);
    }

    private Boolean find(Node root, Comparable value) { //looks for the value of node

        if (root == null) {
            return false;
        }
        if(root.data == value){
            return true;
        }

        if (root.data.compareTo(value) < 0) {
            return find(root.left, value);
        }
        return find(root.right, value);
    }

    public void print() { //helper function for print
        print(root);
    }

    private void print(Node node) { // prints the node
        if (node != null) {
            print(node.left);
            System.out.print(node.data);
            print(node.right);
        }
    }

    public Node delete(Comparable value){ //helper for delete function
        root = delete(root, value);
        return root;
    }


    private Node delete(Node node, Comparable value) { //deletes desired node from BST
        if (node == null) {
            return null;
        }
        else if(node.data.compareTo(value) > 0){
            delete(node.right, value);
        }
        else if(node.data.compareTo(value) < 0){
            delete(node.left, value);
        }
        else if (node.data.compareTo(value) == 0) {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                if (node.right.left == null) {
                    node.data = node.right.data;
                    node.right = node.right.right;
                    return node;
                } else {
                    node.data = removeSmallest(node.right);
                    return node;
                }

            }
        }
        return node;
    }

    private Comparable removeSmallest(Node node){ //removes smallest node from tree
        if(node.left.left == null){
            Node smallest = node.left.right;
            node.right = node.left.right;
            return smallest.data;
        }
        else{
            return removeSmallest(node.left);
        }
    }



}
