/**
 * Created by 1 on 22.03.2017.
 */
public class AVLTree<K extends Comparable, E> {
    private int size;
    private Node root;

    AVLTree() {


    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean contain(K key) {
        Node node = root;
        boolean contain = false;
        while (node != null) {
            if (key.equals(node.key)) {
                contain = true;
                break;

            } else if (key.compareTo(node.key) == -1) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return contain;
    }

    E get(K key) {
        Node node = root;
        while (node != null) {
            if (key.equals(node.key)) {
                break;
            } else if (key.compareTo(node.key) == -1) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return (E) node.value;

    }

    void put(K key, E value) {
        if (!contain(key)) {
            size++;
        }
        root = insert(root, key, value);

    }

    private Node insert(Node node, K key, E value) {
        if (node == null) {
            node = new Node(key, value);
        } else {
            if (key.compareTo(node.key) == -1) {

                node.left = insert(node.left, key, value);
                if (balanceFactor(node) == 2) {
                    if (key.compareTo(node.left.key) == -1) {

                        node = rightRotate(node);
                    } else {

                        node = leftRightRotate(node);
                    }
                }
            } else if (key.compareTo(node.key) == 1) {

                node.right = insert(node.right, key, value);
                if (balanceFactor(node) == -2) {

                    if (key.compareTo(node.right.key) == 1) {

                        node = leftRotate(node);
                    } else {

                        node = rightLeftRotate(node);
                    }
                }

            } else if (key.compareTo(node.key) == 0) {
                while (true) {
                    if (key.equals(node.key)) {
                        node.setValue(value);
                        break;

                    } else if (key.compareTo(node.key) == -1) {
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        } else {
            return node.height;
        }
    }

    private Node rightRotate(Node node) {
        Node nodeLeft = node.left;
        node.left = nodeLeft.right;
        nodeLeft.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        nodeLeft.height = Math.max(height(nodeLeft.left), height(node)) + 1;
        return nodeLeft;
    }

    private Node leftRotate(Node node) {
        Node nodeRight = node.right;
        node.right = nodeRight.left;
        nodeRight.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        nodeRight.height = Math.max(height(nodeRight.right), height(node)) + 1;
        return nodeRight;
    }

    private Node leftRightRotate(Node node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    private Node rightLeftRotate(Node node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }


    private class Node {
        Node left;
        Node right;
        K key;
        int height;
        E value;

        Node(K k, E v) {
            key = k;
            left = null;
            right = null;
            value = v;
            height = 0;

        }

        public void setValue(E value) {
            this.value = value;
        }
    }

}
