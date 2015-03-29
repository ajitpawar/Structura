package com.davisosa.structura.model;

import android.util.Pair;

import com.davisosa.structura.view.EdgeView;
import com.davisosa.structura.view.NodeView;

import java.util.Stack;


/**
 * Created by Sean on 28/03/2015.
 */
public class BST {

    private BSTNode root;
    private Stack<BSTNode> colored;

    private class BSTNode {
        private Pair<NodeView, EdgeView> view;
        private BSTNode left, right, parent;

        public BSTNode(Pair<NodeView, EdgeView> view){
            this.view = view;
        }

        public void resetColor(){
            this.view.first.resetColor();
        }
    }

    public BST(){
        this.colored = new Stack<BSTNode>();
    }

    /**
     * Finds the node in the BST with the given ID.
     *
     * @param id node ID
     * @return {@code true} if node was found, {@code false} otherwise.
     */
    public boolean search(int id){
        BSTNode x = this.root;
        while (x != null || x.view.first.getId() != id){
            if (x.view.first.getId() < id){
                x = x.left;
            } else x = x.right;
        }
        if (x != null){
            return true;
        }
        return false;
    }

    /**
     * Finds the node in the BST with the given ID, while colouring the nodes
     * it passes along the way.
     *
     * @param id node ID
     * @param search colour given to nodes passed
     * @param found colour given to the discovered node
     * @return {@code true} if node was found, {@code false} otherwise.
     */
    public boolean search(int id, int search, int found){
        BSTNode x = this.root;
        while (x != null || x.view.first.getId() != id){
            x.view.first.setColor(search);
            colored.push(x);
            if (x.view.first.getId() < id){
                x = x.left;
            } else x = x.right;
        }
        if (x != null){
            x.view.first.setColor(found);
            colored.push(x);
            return true;
        }
        return false;
    }

    /**
     * Creates a new node from a given NodeView, EdgeView pair, then
     * returns it upon insertion into the BST.
     *
     * @param view the NodeView, EdgeView pair
     */
    public void insert(Pair<NodeView, EdgeView> view){
        BSTNode x = new BSTNode(view);
        BSTNode parent = null;
        BSTNode n = this.root;
        while (n != null){
            parent = n;
            if (x.view.first.getId() < n.view.first.getId()){
                n = n.left;
            } else if (x.view.first.getId() > n.view.first.getId()){
                n = n.right;
            } else {
                n.view = x.view;
            }
        }
        if (parent == null){ // then this.root == null
            this.root = x;
        } else if (x.view.first.getId() < parent.view.first.getId()){
            x.parent = parent;
            parent.left = x;
        } else {
            x.parent = parent;
            parent.right = x;
        }
    }

    /**
     * Removes the node with the given ID from the tree.
     *
     * @param id the node ID.
     * @return {@code true} if node was found, {@code false} otherwise.
     */
    public boolean delete(int id){
        BSTNode x = this.root;
        while (x != null || x.view.first.getId() != id){
            if (x.view.first.getId() < id){
                x = x.left;
            } else x = x.right;
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
        while (x != null || x.view.first.getId() != id){
            x.view.first.setColor(search);
            colored.push(x);
            if (x.view.first.getId() < id){
                x = x.left;
            } else x = x.right;
        }
        if (x != null) {
            x.view.first.setColor(remove);
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
    private void transplant(BSTNode x, BSTNode z){
        if (x.parent == null){
            this.root = z;
        } else if (x == x.parent.left){
            x.parent.left = z;
        } else {
            x.parent.right = z;
        }
        if (z != null){
            z.parent = x.parent;
        }
    }

    /**
     * Removes the given node from the tree.
     *
     * @param x
     */
    private void remove(BSTNode x){
        if(x.left == null){
            transplant(x, x.right);
        } else if (x.right == null){
            transplant(x, x.left);
        } else {
            BSTNode n = treeMinimum(x.right);
            if (n.parent != x){
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
    private BSTNode treeMinimum(BSTNode x){
        while (x.left != null){
            x = x.left;
        } return x;
    }

    public void resetColors(){
        if (!colored.isEmpty()) {
            BSTNode x;
            while (!colored.isEmpty()) {
                x = colored.pop();
                x.resetColor();
            }
        }
    }

}
