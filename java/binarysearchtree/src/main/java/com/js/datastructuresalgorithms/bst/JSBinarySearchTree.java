package com.js.datastructuresalgorithms.bst;

public class JSBinarySearchTree<T extends Comparable<T>> {

    //*****************
    // Class Members **
    //*****************
    private Node mRoot;
    private class Node {
        private T mValue;
        private Node mLeft;
        private Node mRight;

        private Node(T value, Node left, Node right) {
            mValue = value;
            mLeft = left;
            mRight = right;
        }

        private T value() { return mValue; }
        private void value(T value) { mValue = value; }

        private Node left() { return mLeft; }
        private void left(Node left) { mLeft = left; }

        private Node right() { return mRight; }
        private void right(Node right) { mRight = right; }
    }

    public void add(T value) {
        if(root() == null) {
            mRoot = new Node(value, null, null);
        } else {
            add(root(), value);
        }
    }

    public void clear() { mRoot = null; }

    public boolean contains(T value) { return findNode(value) != null; }

    public boolean remove(T value) { return remove(findNode(value)); }

    //*******************
    // Private Members **
    //*******************

    private boolean remove(Node node)
    {
        Node parent = findParent(node);

        if (parent != null) {
            if (node.right() != null && node.left() != null) {
                Node min = min(node.right());
                remove(min);
                node.value(min.value());
            } else if (node.right() == null && node.left() == null) {
                deleteChild(parent, node);
            } else {
                moveChild(parent, node);
            }
        }

        return parent != null;
    }

    private void moveChild(Node parent, Node child)
    {
        Node update = child.right() == null ? child.left() : child.right();
        if(equal(parent.left(), child)) {
            parent.left(update);
        } else if(equal(parent.right(), child)) {
            parent.right(update);
        }
    }

    private Node min(Node node) {
        while(node.left() != null) {
            node = node.left();
        }
        return node;
    }

    private void deleteChild(Node parent, Node child) {
        if(equal(parent.left(), child)) {
            parent.left(null);
        } else if(equal(parent.right(), child)) {
            parent.right(null);
        }
    }

    private Node findParent(Node node)
    {
        Node next = root();
        while(!isParent(next, node)) {
            next = whichWay(next, node);
        }
        return next;
    }

    private Node whichWay(Node node, Node child) {
        return compare(node, child) > 0 ? node.left() : node.right();
    }

    private boolean isParent(Node node, Node child)
    {
        return equal(node.left(), child) || equal(node.right(), child);
    }

    private Node findNode(T value) {
        Node next = root();
        while(next != null && !equal(next, value)) {
            next = compare(next, value) > 0 ? next.left() : next.right();
        }
        return next;
    }

    private int compare(Node one, T value) {
        return one.value().compareTo(value);
    }

    private int compare(Node one, Node two) {
        return one.value().compareTo(two.value());
    }

    private boolean equal(Node one, Node two) {
        return one == two || one != null && one.value().compareTo(two.value()) == 0;
    }

    private boolean equal(Node one, T value) {
        return one != null && one.value().compareTo(value) == 0;
    }

    private void add(Node node, T value)
    {
        int compare = node.value().compareTo(value);
        if(compare > 0) {
            if(node.left() == null) {
                node.left(new Node(value, null, null));
            } else {
                add(node.left(), value);
            }
        } else if(compare < 0) {
            if(node.right() == null) {
                node.right(new Node(value, null, null));
            } else {
                add(node.right(), value);
            }
        }
    }

    private Node root() { return mRoot; }
}
