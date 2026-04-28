package com.example.demo;

import java.util.Random;

public class TrafficSim extends Citygraphh {

    public static void applyRandomTraffic() {

        if (adj == null || adj.isEmpty()) return;

        Random rand = new Random();

        for (int i = 1; i <= location; i++) {
            for (Pair p : adj.get(i)) {

                // 30% chance of traffic
                if (rand.nextFloat() < 0.3) {
                    int delay = rand.nextInt(15) + 1;
                    p.weight += delay;
                }
            }
        }
    }

    // ✅ Optional: Reset traffic back to original weights
    public static void resetTraffic() {
        if (adj == null || adj.isEmpty()) return;

        for (int i = 1; i <= location; i++) {
            for (Pair p : adj.get(i)) {
                p.weight = p.originalWeight;
            }
        }
    }
}