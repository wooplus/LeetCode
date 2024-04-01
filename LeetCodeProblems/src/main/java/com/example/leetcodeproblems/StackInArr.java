package com.example.leetcodeproblems;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackInArr {
    public int[] stack;
    public int top;

    public StackInArr(int capacity) {
        top = -1;
        stack = new int[capacity];
    }
    public StackInArr() {
        this(10);
    }

    public void push(int data) {
        if(isFull()) {
            throw new RuntimeException("Stack is full");
        }
        top++;
        stack[top] = data;
    }

    public int peek() {
        return stack[top];
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        int result = stack[top];
        stack[top] = 0;
        top--;
        return result;
    }

    public boolean isFull() {
        return stack.length == size();
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public String reverseString(String sentence) {
        char[] charArr = sentence.toCharArray();
        java.util.Stack<Character> stack = new Stack<>();

        for(char c : charArr) {
            stack.push(c);
        }

        for(int i = 0; i < charArr.length; i++) {
            charArr[i] = stack.pop();
        }

        return new String(charArr);
    }

    public int[] nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[arr.length];

        for(int i = arr.length -1; i >= 0; i--) {
            if(!stack.isEmpty()) {
                while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }

            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return  result;

    }

    public boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();

        for(char ch : charArr) {
            if(ch == '(' || ch=='{' || ch=='[') {
                stack.push(ch);
            } else {
                if(!stack.isEmpty()) {
                    char peakElement = stack.peek();
                    if((ch==')' && peakElement=='(') || (ch=='}' && peakElement=='{') || (ch==']' && peakElement=='[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackInArr stack = new StackInArr(5);
//        stack.push(10);
//        stack.push(15);
//        stack.push(20);
//        stack.push(30);
//        stack.push(40);
//        stack.push(50);
//        stack.pop();
//        System.out.println(stack.peek() );
//
        System.out.println(stack.reverseString("hello world"));

        int[] arr = {4,7,3,4,8,1};
        int[] greaterArr = stack.nextGreaterElement(arr);

        for(int i: greaterArr) {
            System.out.print(i + " ");
        }

        String str = "(})";
        System.out.println(stack.validParentheses(str));

    }
}
