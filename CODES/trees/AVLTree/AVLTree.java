package trees.AVLTree;

class Node {
    int data, height;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.height = 1;
    }
}

public class AVLTree {
    Node root;

    public int height(Node node) {
        if (node == null)
            return 0;

        return node.height;
    }

    public int getBalance(Node node) {
        if (node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    public Node getMinimumNode(Node node) {
        Node current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    public Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);

        else if (key > node.data)
            node.right = insert(node.right, key);

        else
            return node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        // LL condition
        if (balance > 1 && key < node.left.data)
            return rightRotation(node);

        // RR condition
        if (balance < -1 && key > node.right.data)
            return leftRotation(node);

        // LR condition
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }

        // RL condition
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        return node;
    }

    public Node delete(Node root, int val) {
        if (root == null)
            return null;

        if (val < root.data)
            root.left = delete(root.left, val);

        else if (val > root.data)
            root.right = delete(root.right, val);

        else {
            if (root.left == null)
                return root.right;

            else if (root.right == null)
                return root.left;

            else {
                Node temp = getMinimumNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }

        int balance = getBalance(root);

        // LL condition
        if (balance == 2 && getBalance(root.left) >= 0)
            return rightRotation(root);

        // RR condition
        if (balance == -2 && getBalance(root.right) <= 0)
            return leftRotation(root);

        // LR condition
        if (balance == 2 && getBalance(root.left) == -1) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        // RL condition
        if (balance == -2 && getBalance(root.right) == 1) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;
    }

    public Node rightRotation(Node y) {
        Node x = y.left;
        Node temp = x.right;

        // make rotation
        x.right = y;
        y.left = temp;

        // update height
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public Node leftRotation(Node x) {
        Node y = x.right;
        Node temp = y.left;

        // make rotation
        y.left = x;
        x.right = temp;

        // update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        tree.preOrder(tree.root);
        System.out.println();
        tree.delete(tree.root, 10);
        tree.preOrder(tree.root);
    }
}
