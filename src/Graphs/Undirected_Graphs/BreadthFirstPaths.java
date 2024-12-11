package Graphs.Undirected_Graphs;

import java.util.*;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;

        while(!q.isEmpty()) {
            int v = q. poll();
            for(int w : G.adj(v)) {
                if(!marked[w]) {
                    q.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph G = new Graph(6);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 5);
        G.addEdge(1, 3);
        G.addEdge(3, 4);
        G.addEdge(4, 5);

        int source = 0;
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, source);

        for(int x : bfs.pathTo(2)) {
            if (x == source) System.out.print(x);
            else System.out.print(x + " -> ");
        }
    }
}

