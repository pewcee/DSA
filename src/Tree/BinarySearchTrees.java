package Tree;

import javax.swing.plaf.InsetsUIResource;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTrees<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int count;
        private Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if(x == null) return 0;
        return x.count;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if(node == null) {
            return 0;
        }

        int cmp = key.compareTo(node.key);
        if(cmp < 0) {
            return rank(node.left, key);
        } else if(cmp > 0) {
            return rank(node.right, key);
        } else {
            return size(node.left);
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if(node == null) {
            return new Node(key,value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp > 0) x = x.right;
            else if (cmp < 0) x = x.left;
            else return x.value;
        }
        return null;
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if(x != null) return x.key;
        return null;
    }

    private Node floor(Node node, Key key) {
        if(node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if(cmp == 0) {
            return node;
        }

        if(cmp < 0) {
            return floor(node.left, key);
        }

        Node t = floor(node.right, key);
        if(t != null) {
            return t;
        }

        return node;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if(x != null) {
            return x.key;
        }

        return null;
    }

    private Node ceiling(Node node, Key key) {
        if(node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if(cmp == 0) {
            return node;
        }

        if(cmp > 0) {
            return ceiling(node.right, key);
        }

        Node t = ceiling(node.left, key);
        if(t != null) {
            return t;
        }

        return node;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node node, Queue<Key> q) {
        if(node == null) {
            return;
        }
        inorder(node.left, q);
        q.add(node.key);
        inorder(node.right, q);
    }

    public void deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if(node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if(node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if(cmp < 0) {
            node.left = delete(node.left, key);
        } else if(cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if(node.right == null) {
                return node.left;
            }
            if(node.left == null) {
                return node.right;
            }

            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }

        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }
}

class Solution {
    public static void main(String[] args) {
        BinarySearchTrees bst = new BinarySearchTrees();

        bst.put(50, "A");
        bst.put(30, "B");
        bst.put(70, "C");
        bst.put(20, "D");
        bst.put(40, "E");
        bst.put(60, "F");
        bst.put(80, "G");

        System.out.println("get 60: " + bst.get(60));

        bst.delete(40);

        for(Object it : bst.keys()) {
            System.out.print(it + " ");
        }
    }
}
