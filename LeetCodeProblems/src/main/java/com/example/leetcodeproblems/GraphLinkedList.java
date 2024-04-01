package com.example.leetcodeproblems;

import java.util.LinkedList;

public class GraphLinkedList {
    int V;
    int E;
    LinkedList<Integer>[] adj;

    public GraphLinkedList(int nodes) {
        this.adj = new LinkedList[nodes];
        this.V = nodes;
        for(int i = 0; i < nodes; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges." + "\n");
        for(int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for(int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph gp = new Graph(4);
        gp.addEdge(0,1);
        gp.addEdge(1,2);
        gp.addEdge(2,3);
        gp.addEdge(3,0);
        System.out.println(gp);
    }

}
