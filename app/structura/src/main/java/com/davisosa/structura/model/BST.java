package com.davisosa.structura.model;

import android.util.Pair;

import com.davisosa.structura.view.EdgeView;
import com.davisosa.structura.view.NodeView;

/**
 * Created by Sean on 28/03/2015.
 */
public class BST {

    private BSTNode root;

    private class BSTNode {
        private Pair<NodeView, EdgeView> view;
        private BSTNode left, right, parent;

        public BSTNode(Pair<NodeView, EdgeView> view){
            this.view = view;
        }
    }

    public BST(){
    }

    public BSTNode search(int id){
        BSTNode x = this.root;
        while (x != null || x.view.first.getId() != id){
            if (x.view.first.getId() < id){
                x = x.left;
            } else x = x.right;
        } return x;
    }

    public BSTNode insert(Pair<NodeView, EdgeView> view){
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
                return n;
            }
        }
        if (parent == null){ // then this.root == null
            this.root = x;
            return this.root;
        } else if (x.view.first.getId() < parent.view.first.getId()){
            x.parent = parent;
            parent.left = x;
            return parent.left;
        } else {
            x.parent = parent;
            parent.right = x;
            return parent.right;
        }
    }



    public BSTNode delete(int id){
        BSTNode x = this.root;
        while (x != null || x.view.first.getId() != id){
            if (x.view.first.getId() < id){
                x = x.left;
            } else x = x.right;
        }
        remove(x);
        return x;
    }

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

    private BSTNode treeMinimum(BSTNode x){
        while (x.left != null){
            x = x.left;
        } return x;
    }

}
