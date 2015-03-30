package com.davisosa.structura.model;

import android.util.Pair;

import com.davisosa.structura.view.EdgeView;
import com.davisosa.structura.view.NodeView;

import java.util.Stack;

import timber.log.Timber;


/**
 * Created by Sean on 28/03/2015.
 */
public class BST {

    public BSTNode root;
    private Stack<BSTNode> colored;

    public BST() {
        this.colored = new Stack<>();
    }

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Finds the node in the BST with the given ID.
     *
     * @param id node ID
     * @return {@code true} if node was found, {@code false} otherwise.
     */
    public Pair<NodeView, EdgeView> search(int id) {
        BSTNode x = this.root;
        while (x != null && x.pair.first.getNodeId() != id) {
            if (x.pair.first.getNodeId() < id) {
                x = x.right;
            } else {
                x = x.left;
            }
        }
        return x.pair;
    }

    public BSTNode searchNode(int id) {
        BSTNode x = this.root;
        while (x != null && x.pair.first.getNodeId() != id) {
            if (x.pair.first.getNodeId() < id) {
                x = x.right;
            } else {
                x = x.left;
            }
        }
        return x;

    }

    /**
     * Finds the node in the BST with the given ID, while colouring the nodes
     * it passes along the way.
     *
     * @param id     node ID
     * @param search colour given to nodes passed
     * @param found  colour given to the discovered node
     * @return {@code true} if node was found, {@code false} otherwise.
     */
    public boolean search(int id, int search, int found) {
        BSTNode x = this.root;
        while (x != null && x.pair.first.getNodeId() != id) {
            x.pair.first.setColor(search);
            colored.push(x);
            if (x.pair.first.getNodeId() < id) {
                x = x.right;
            } else {
                x = x.left;
            }
        }
        if (x != null) {
            x.pair.first.setColor(found);
            colored.push(x);
            return true;
        }
        return false;
    }

    /**
     * Creates a new node from a given NodeView, EdgeView pair, then
     * returns it upon insertion into the BST.
     *
     * @param pair the NodeView, EdgeView pair
     */
    public void insert(Pair<NodeView, EdgeView> pair) {
        BSTNode x = new BSTNode(pair);
        BSTNode parent = null;
        BSTNode n = this.root;
        while (n != null) {
            parent = n;
            if (x.pair.first.getNodeId() < n.pair.first.getNodeId()) {
                n = n.left;
            } else if (x.pair.first.getNodeId() > n.pair.first.getNodeId()) {
                n = n.right;
            } else {
                n.pair = x.pair;
            }
        }
        if (parent == null) { // then this.root == null
            this.root = x;
        } else if (x.pair.first.getNodeId() < parent.pair.first.getNodeId()) {
            x.parent = parent;
            parent.left = x;
        } else {
            x.parent = parent;
            parent.right = x;
        }

//        printout(root);
    }

    /**
     * Removes the node with the given ID from the tree.
     *
     * @param id the node ID.
     * @return {@code true} if node was found, {@code false} otherwise.
     */
    public boolean delete(int id) {
        BSTNode x = this.root;
        while (x != null && x.pair.first.getNodeId() != id) {
            if (x.pair.first.getNodeId() < id) {
                x = x.right;
            } else {
                x = x.left;
            }
        }
        if (x != null) {
            remove(x);
            return true;
        }
        return false;
    }

    /**
     * Removes the node with the given ID from the tree while colouring
     * the nodes it passes along the way.
     *
     * @param id the node ID.
     * @param search colour given to nodes passed
     * @param remove colour given to the discovered node
     * @return the removed node.
     */
    public boolean delete(int id, int search, int remove){
        BSTNode x = this.root;
        while (x != null && x.pair.first.getNodeId() != id) {
            x.pair.first.setColor(search);
            colored.push(x);
            if (x.pair.first.getNodeId() < id) {
                x = x.right;
            } else {
                x = x.left;
            }
        }
        if (x != null) {
            x.pair.first.setColor(remove);
            remove(x);
            return true;
        }
        return false;
    }

    /**
     * Swaps two subtrees.
     *
     * @param x the root of a subtree.
     * @param z the root of a different subtree.
     */
    private void transplant(BSTNode x, BSTNode z) {
        if (x.parent == null) {
            this.root = z;
        } else if (x == x.parent.left) {
            x.parent.left = z;
        } else {
            x.parent.right = z;
        }
        if (z != null) {
            z.parent = x.parent;
        }
    }

    /**
     * Removes the given node from the tree.
     *
     * @param x the node to be removed
     */
    private void remove(BSTNode x) {
        if (x.left == null) {
            transplant(x, x.right);
        } else if (x.right == null) {
            transplant(x, x.left);
        } else {
            BSTNode n = treeMinimum(x.right);
            if (n.parent != x) {
                transplant(n, n.right);
                n.right = x.right;
                n.right.parent = n;
            }
            transplant(x, n);
            n.left = x.left;
            x.left.parent = n;
        }
    }

    /**
     * Returns the minimum node in the given subtree.
     *
     * @param x the root of the subtree
     * @return the minimum node.
     */
    private BSTNode treeMinimum(BSTNode x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    public void resetColors() {
        if (!colored.isEmpty()) {
            BSTNode x;
            while (!colored.isEmpty()) {
                x = colored.pop();
                x.resetColor();
            }
        }
    }

    public void printout(BSTNode x) {
        if (x != null) {
            if (x.pair.first.getNodeId() == root.pair.first.getNodeId()) {
                Timber.d("This is the root: " + String.valueOf(x.pair.first.getNodeId()));
            }
            Timber.d("---");
            Timber.d("Node: " + String.valueOf(x.pair.first.getNodeId()));
            Timber.d("Parent: " + String.valueOf(x.parent));
            Timber.d("Left: " + String.valueOf(x.left));
            Timber.d("Right: " + String.valueOf(x.right));
            Timber.d("---");
            printout(x.left);
            printout(x.right);
        } else {
            Timber.d(String.valueOf(x));
        }
    }

    public class BSTNode {
        public Pair<NodeView, EdgeView> pair;
        public BSTNode left, right, parent;

        public BSTNode(Pair<NodeView, EdgeView> pair) {
            this.pair = pair;
        }

        public void resetColor() {
            this.pair.first.resetColor();
        }
    }
}
