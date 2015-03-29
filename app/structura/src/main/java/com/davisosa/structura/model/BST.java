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

       /** public BSTNode treeSearch(int id){
            if (this.view.first.getId() == id){
                return this;
            } else if (this.view.first.getId() < id){
                if (this.left == null){
                    return this.left;
                }
                return this.left.treeSearch(id);
            } else {
                if (this.right == null){
                    return this.right;
                }
                return this.right.treeSearch(id);
            }
        }

        public BSTNode treeInsert(Pair<NodeView, EdgeView> view){
            if (this.view.first.getId() == view.first.getId()){
                this.view = view;
                return this;
            } else if (this.view.first.getId() < view.first.getId()){
                if (this.left == null){
                    this.left = new BSTNode(view);
                    return this.left;
                } else {
                    return this.left.treeInsert(view);
                }
            } else {
                if (this.right == null){
                    this.right = new BSTNode(view);
                    return this.right;
                } else {
                    return this.right.treeInsert(view);
                }
            }
        }

        public BSTNode treeDelete(int id){

        }

        public Pair<NodeView, EdgeView> removeMin(){
            if (this.left.left == null){
                BSTNode x = this.left;
                this.left = this.left.right;
                return x.view;
            } else return this.left.removeMin();
        }**/
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
        /*if (this.root == null){
            return this.root;
        }
        return this.root.treeSearch(id);*/
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

        /*if (this.root == null){
            this.root = new BSTNode(view);
            return this.root;
        }
        return this.root.treeInsert(view);*/
    }

    private void transplant(){

    }

    public BSTNode delete(int id){


        /*if (this.root == null){
            return this.root;
        } else if (this.root.view.first.getId() == id){
            BSTNode x = this.root;
            if (this.root.left == null || this.root.right == null){
                if (this.root.left == null){
                    this.root = root.right;
                } else {
                    this.root = root.left;
                }
            } else {
                this.root.view = this.root.right.removeMin();
            }
            return x;
        } else if (this.root.view.first.getId() < id){
            if (root.lef)
        } else {
            return this.root.treeDelete(id);
        }*/
    }

}
