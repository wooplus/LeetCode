package com.example.leetcodeproblems;

public class Graph {
    int[][] matrix;
    int V;
    int E;

    public Graph(int node) {
        this.V = node;
        this.E = 0;
        matrix = new int[node][node];
    }

    public void addEdge(int u,int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;
        E+=1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for(int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for(int w : matrix[v]) {
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
