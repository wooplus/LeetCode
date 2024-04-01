package com.example.leetcodeproblems;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private TreeNode root;

    public class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int d) {
            this.data = d;
        }
    }

    private TreeNode createBinaryTree(){
        TreeNode first = new TreeNode(6);
        TreeNode second = new TreeNode(4);
        TreeNode third = new TreeNode(8);
        TreeNode fourth = new TreeNode(2);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(7);
        TreeNode seventh = new TreeNode(9);
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
        return first;
    }
    public TreeNode insert(TreeNode root, int value) {
        if(root == null) {
            TreeNode node = new TreeNode(value);
            return node;
        }
        if(value <= root.data) {
            root.left = insert(root.left, value);
        }
        if(value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void inOrderTraversal (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.println(tmp.data);
            if(tmp.left != null) {
                queue.offer(tmp.left);
            }
            if(tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
    }

    public boolean searchKey(TreeNode root, int key) {
        System.out.println(key +" - " + root.data);
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(key <= root.data ) {
            return searchKey(root.left, key);
        }
        if(key > root.data) {
            return searchKey(root.right, key);
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.createBinaryTree();
        bst.insert(root, 1);
        bst.inOrderTraversal(root);

        System.out.println(bst.searchKey(root, 8));
    }
}
