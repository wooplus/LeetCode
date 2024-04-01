package com.example.leetcodeproblems;

public class PriorityQueue {

    public static class MaxPQ {
        Integer[] heap;
        int n;

        public MaxPQ(int capacity) {
            heap = new Integer[capacity+1];
            n = 0;
        }

        public boolean isEmpty() {
            return n == 0;
        }
        public int getSize() {
            return n;
        }
        public void resize(int x) {
            Integer[] tmp = new Integer[x];
            for(int i = 0; i < heap.length; i++) {
                tmp[i] = heap[i];
            }
            heap = tmp;
        }

        public void insert(int x) {
            if(n == heap.length - 1) {
                resize(heap.length * 2);
            }
            ++n;
            heap[n] = x;
            swim(n);

        }

        public void swim (int k) {
            while(k > 1 && heap[k] > heap[k/2]) {
                int tmp = heap[k];
                heap[k] = heap[k/2];
                heap[k/2] = tmp;
                k = k/2;
            }
        }

        public void print() {
            for(int i = 0; i < heap.length ; i++) {
                System.out.print(heap[i] + " ");
            }
        }

        public int deleteMax() {
            int max = heap[1];
            swap(1, n);
            n --;
            sink(1);
            heap[n + 1] = null;

            if(n > 0 && (n == (heap.length -1)/ 4)) {
                resize(heap.length / 2);
            }

            return max;
        }

        public void sink(int k) {
            int j = k * 2;

            while(2 * k <= n) {
                if(j < n && heap[j] < heap[j+1] ) {
                    j++;
                }
                if(heap[k] >= heap[j]) {
                    break;
                }
                swap(k,j);
                k = j;
            }
        }


        public void swap(int a, int b) {
            int tmp = heap[a];
            heap[a] = heap[b];
            heap[b] = tmp;
        }

    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(3);
        System.out.println(pq.getSize());
        System.out.println(pq.isEmpty());
        pq.insert(5);
        pq.insert(4);
        pq.insert(9);
        pq.insert(7);
        pq.insert(1);
        pq.insert(10);
        System.out.println(pq.getSize());
        pq.print();

    }
}
