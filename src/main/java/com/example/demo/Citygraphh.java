package com.example.demo;

import java.util.*;
import java.io.*;
import org.springframework.core.io.ClassPathResource;

public class Citygraphh {

    // Shared graph data
    public static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    public static int location = 0, road = 0;

    public static class Pair {
        public int node;
        public int weight;
        public int originalWeight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
            this.originalWeight = weight;
        }
    }

    // ✅ FIXED: No Scanner(System.in), works in Spring Boot
    public static void loadGraph() {
        try {
            // Read file from resources folder
            File file = new ClassPathResource("City.txt").getFile();

            Scanner sc = new Scanner(file);

            location = sc.nextInt();
            road = sc.nextInt();

            adj = new ArrayList<>();
            for (int i = 0; i <= location; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < road; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();

                adj.get(u).add(new Pair(v, w));
                adj.get(v).add(new Pair(u, w));
            }

            sc.close();
            System.out.println("✅ City Map Loaded Successfully");

        } catch (Exception e) {
            System.out.println("❌ Error loading graph: " + e.getMessage());
        }
    }

    // Helper method
    public static String getLocationName(int node) {
        switch (node) {
            case 1: case 10: case 15: return "Hospital";
            case 2: case 9: return "Fire Station";
            case 3: case 8: case 11: return "Police HQ";
            case 13: return "IT Tech Park";
            case 14: return "Airport";
            default: return "Zone " + node;
        }
    }
}