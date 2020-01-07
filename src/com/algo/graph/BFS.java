package com.algo.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {0, 1, 1}, {0, 0, 9}};
        System.out.println(bfs(arr));
    }

    public static int bfs(int[][] graph) {
        int n = graph.length;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, 0, 0, 1));
        graph[0][0] = 0;
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            if (poll.value == 9) {
                return poll.weight;
            }
            int u = poll.u;
            int v = poll.v;
            // go down
            if (u + 1 < n && graph[u + 1][v] >= 1) {
                queue.add(new Pair(u + 1, v, poll.weight + 1, graph[u + 1][v]));
                graph[u + 1][v] = 0;
            }

            // go right
            if (v + 1 < n && graph[u][v + 1] >= 1) {
                queue.add(new Pair(u, v + 1, poll.weight + 1, graph[u][v + 1]));
                graph[u][v + 1] = 0;
            }

            // go left
            if (v - 1 >= 0 && graph[u][v - 1] >= 1) {
                queue.add(new Pair(u, v - 1, poll.weight + 1, graph[u][v - 1]));
                graph[u][v - 1] = 0;
            }

            // go right
            if (u - 1 >= 0 && graph[u - 1][v] >= 1) {
                queue.add(new Pair(u - 1, v, poll.weight + 1, graph[u - 1][v]));
                graph[u - 1][v] = 0;
            }
        }
        return -1;
    }

    static class Pair {
        int u;
        int v;
        int weight;
        int value;

        public Pair(int u, int v, int weight, int value) {
            this.u = u;
            this.v = v;
            this.weight = weight;
            this.value = value;
        }
    }
}
