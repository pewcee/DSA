package Tree.BalancedSearchTrees;

import Tree.BinarySearchTrees;

public class RedBlackSearchTrees<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        boolean color;
    }

    private boolean isRed(Node x) {
        if(x == null) {
            return false;
        }
        return x.color == RED;
    }

    /**
     * xoay trái
     * cho nút phải(x) lên làm nút gốc, kéo nút gốc(h) sang làm con trái.
     * đặt con phải của h thành con trái của x, để cho chỗ đấy là phần tử lớn hơn h nhỏ hơn x.
     * gắn h làm con trái của x, đặt màu của x là màu của h, đặt màu của h là đỏ.
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        assert isRed(h.right);
        Node x  = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * xoay phải.
     * tương tự như xoay trái
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        assert isRed(h.left);
        Node x  = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * nếu gốc là đen, 2 con trái phải đều là đỏ.
     * thì chuyển gốc là đỏ, 2 con trái phải là đen.
     *
     * @param h
     */
    private void flipColor(Node h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert  isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    
}
