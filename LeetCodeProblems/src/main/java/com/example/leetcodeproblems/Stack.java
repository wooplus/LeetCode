package com.example.leetcodeproblems;


import java.util.EmptyStackException;

public class Stack {
    private ListNode  top;
    private int length;

    public Stack() {
        this.top = null;
        this.length = 0;
    }

    public class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int d) {
            this.data = d;
        }

        public int getLength() {
            return length;
        }


    }

    public void push(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = top;
        top = newNode;
        length++;
    }

    public int pop() {
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public boolean isEmpty() {
        return length==0;
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.length);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}
