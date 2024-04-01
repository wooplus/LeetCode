package com.example.leetcodeproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {


    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;
        public TreeNode(int d) {
            this.data = d;
        }
    }

    private TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode first = new TreeNode(2);
        TreeNode second = new TreeNode(3);
        TreeNode third = new TreeNode(4);
        TreeNode fourth = new TreeNode(5);
        root.left = first;
        root.right = second;
        first.left = third;
        first.right = fourth;
        return root;
    }

    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderInStack(TreeNode root) {
        if(root == null ) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            System.out.println(tmp.data);
            if(tmp.right != null) {
                stack.push(tmp.right);
            }
            if(tmp.left != null) {
                stack.push(tmp.left);
            }
        }
    }

    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public void inOrderInStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while(!stack.isEmpty() || tmp != null) {
            if(tmp == null) {
                tmp = stack.pop();
                System.out.println(tmp.data);
                tmp = tmp.right;
            }else {
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
    }

    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
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

    public int findMax(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        int max = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > max) {
            max = left;
        }
        if(right > max) {
            max = right;
        }
        return max;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createBinaryTree();
//        bt.preOrder(root);
//        bt.preOrderInStack(root);
//

//        bt.postOrder(root);
        bt.levelOrder(root);

        System.out.println(bt.findMax(root));
    }






}
