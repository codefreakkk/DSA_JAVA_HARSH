package trees.RedBlackTree;

class Node {
    int data;
    Node left, right, parent;
    char color;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.color = 'R';
    }
}

class RedBlackTree {
    public Node root;

    public RedBlackTree() {
        this.root = null;
    }

    public Node rotateLeft(Node node) {
        Node x = node.right;
        Node y = x.left;
        x.left = node;
        node.right = y;
        node.parent = x;

        if (y != null)
            y.parent = node;
        return x;
    }

    public Node rotateRight(Node node) {
        Node x = node.left;
        Node y = x.right;
        x.right = node;
        node.left = y;
        node.parent = x;

        if (y != null)
            y.parent = node;

        return x;
    }

    boolean ll = false;
    boolean rr = false;
    boolean lr = false;
    boolean rl = false;

    public Node insertHelper(Node root, int data) {
        boolean f = false;

        if (root == null)
            return (new Node(data));
        else if (data < root.data) {
            root.left = insertHelper(root.left, data);
            root.left.parent = root;
            if (root != this.root) {
                if (root.color == 'R' && root.left.color == 'R')
                    f = true;
            }
        } else {
            root.right = insertHelper(root.right, data);
            root.right.parent = root;
            if (root != this.root) {
                if (root.color == 'R' && root.right.color == 'R')
                    f = true;
            }
        }

        // rotations
        if (this.ll) {
            root = rotateLeft(root);
            root.color = 'B';
            root.left.color = 'R';
            this.ll = false;
        } else if (this.rr) {
            root = rotateRight(root);
            root.color = 'B';
            root.right.color = 'R';
            this.rr = false;
        } else if (this.lr) {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.color = 'B';
            root.right.color = 'R';
            this.lr = false;
        } else if (this.rl) {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.color = 'B';
            root.left.color = 'R';
            this.rl = false;
        }

        // red red conflict
        if (f) {
            if (root.parent.right == root) {
                // when parent sibling is black
                if (root.parent.left == null || root.parent.left.color == 'B') {
                    // check for rotations
                    if (root.left != null && root.left.color == 'R')
                        this.rl = true;
                    else if (root.right != null && root.right.color == 'R')
                        this.ll = true;
                } else { // when parent sibling is red
                    root.parent.left.color = 'B';
                    root.color = 'B';
                    if (root.parent != this.root)
                        root.parent.color = 'R';
                }

            } else {
                // when parent sibling is black
                if (root.parent.right == null || root.parent.right.color == 'B') {
                    // check for rotations
                    if (root.left != null && root.left.color == 'R')
                        this.rr = true;
                    else if (root.right != null && root.right.color == 'R')
                        this.lr = true;
                } else { // when parent sibling is red
                    root.parent.right.color = 'B';
                    root.color = 'B';
                    if (root.parent != this.root)
                        root.parent.color = 'R';
                }
            }
            f = false;
        }
        return root;
    }

    public void insert(int data) {
        if (this.root == null) {
            this.root = new Node(data);
            this.root.color = 'B';
        } else
            this.root = insertHelper(this.root, data);
    }

    public void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void main(String[] args) {
        RedBlackTree t = new RedBlackTree();
        int[] arr = {1,4,6,3,5,7,8,2,9};
        for(int i=0;i<9;i++)
        {
            t.insert(arr[i]);
        };
        t.inorder(t.root);
    }
}
