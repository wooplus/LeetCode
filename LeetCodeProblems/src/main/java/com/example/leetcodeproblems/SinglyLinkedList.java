package com.example.leetcodeproblems;

import javafx.scene.shape.Line;

public class SinglyLinkedList {

    private LinkNode head;
    public static class LinkNode {
        public int data;
        public LinkNode next;

        public LinkNode(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public void printNodesInsll(LinkNode head) {
        LinkNode current = head;
        while(current != null ) {
            if(current.next != null ) {
                System.out.print(current.data + "->");
            } else {
                System.out.print(current.data + "\n");
            }
            current = current.next;
        }
    }

    public int getNumberOfNodes() {
        int count = 0;
        LinkNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertBeginning(int value) {
        LinkNode newNode = new LinkNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int value) {
        LinkNode newNode = new LinkNode(value);
        if(head == null) {
            head = newNode;
            return;
        }

        LinkNode current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public LinkNode deleteFirst() {
        if(head == null) {
            return null;
        }
        LinkNode tmp = head;
        head = head.next;
        tmp.next = null;
        return tmp;
    }

    public LinkNode deleteLast() {
        if(head == null) {
            return null;
        } else if (head.next == null) {
            head = null;
            return head;
        }
        LinkNode currNode = head;

        while (currNode.next.next != null){
            currNode = currNode.next;
        }
        currNode.next = null;
        return currNode;
    }

    public void deleteAtPosition(int position) {
        if(position ==1) {
            head = head.next;
            return ;
        }
        int count = 1;
        LinkNode prevNode = head;
        while(count < position-1) {
            prevNode = prevNode.next;
            count++;
        }
        LinkNode currentNode = prevNode.next;
        prevNode.next = currentNode.next;
    }

    public boolean searchElement(int searchValue) {
        LinkNode currentNode = head;
        int count = 1;
        while (currentNode != null ) {
            if(currentNode.data == searchValue) {
                System.out.println("Found the element at position: " + count);
                return true;
            }
            currentNode = currentNode.next;
            count++;
        }
        return false;
    }

    public LinkNode reverseSLL(LinkNode head) {
        LinkNode current = head;
        LinkNode next = null;
        LinkNode previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public LinkNode getNthNodeFromEnd(int n) {
        LinkNode mainPtr = head;
        LinkNode refPtr = head;
        int count = 0;
        while (count < n) {
            refPtr = refPtr.next;
            count +=1;
        }
        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        return mainPtr;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.head = new ListNode(10);
//        ListNode secondNode = new ListNode(1);
//        ListNode thirdNode = new ListNode(8);
//        ListNode fourthNode = new ListNode(21);
//        sll.head.next = secondNode; // 10 -> 1 -> null
//        secondNode.next = thirdNode; // 10 -> 1 -> 8 -> null
//        thirdNode.next = fourthNode; // 10 -> 1 -> 8 -> 21

//        sll.insertBeginning(11);
//        sll.insertBeginning(24);
//        sll.insertBeginning(35);

        sll.insertAtEnd(11);
        sll.insertAtEnd(24);
        sll.insertAtEnd(35);
        sll.insertAtEnd(16);
        sll.insertAtEnd(19);

//        sll.deleteAtPosition(1);

        sll.printNodesInsll(sll.head);
        System.out.println(sll.getNumberOfNodes());
        System.out.println(sll.searchElement(5));

//        LinkNode reverseSLL = sll.reverseSLL(sll.head);
//        sll.printNodesInsll(reverseSLL);

        System.out.println(sll.getNthNodeFromEnd(4 ).data);

    }
}
