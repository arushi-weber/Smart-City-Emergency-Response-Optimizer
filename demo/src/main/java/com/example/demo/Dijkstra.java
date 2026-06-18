package com.example.demo;

import java.util.*;

public class Dijkstra extends Citygraphh {

    // Result class
    public static class Result {
        public int[] dist;
        public int[] parent;

        public Result(int[] dist, int[] parent) {
            this.dist = dist;
            this.parent = parent;
        }
    }

    // Helper class for priority queue
    static class Duo {
        int node;
        int distance;

        Duo(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    // ✅ Main Dijkstra logic (unchanged)
    public static Result dk(int V, ArrayList<ArrayList<Pair>> adjList, int S) {

        PriorityQueue<Duo> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int dist[] = new int[V + 1];
        int parent[] = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            dist[i] = (int) 1e9;
            parent[i] = -1;
        }

        dist[S] = 0;
        pq.add(new Duo(0, S));

        while (!pq.isEmpty()) {
            Duo current = pq.poll();
            int u = current.node;

            for (Pair neighbor : adjList.get(u)) {
                if (dist[u] + neighbor.weight < dist[neighbor.node]) {
                    dist[neighbor.node] = dist[u] + neighbor.weight;
                    pq.add(new Duo(dist[neighbor.node], neighbor.node));
                    parent[neighbor.node] = u;
                }
            }
        }

        return new Result(dist, parent);
    }

}