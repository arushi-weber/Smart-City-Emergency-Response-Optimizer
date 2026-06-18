package com.example.demo;

import java.util.*;

public class EmgSystem {

    // ✅ Main method removed, converted into reusable method
	public static String processEmergencies(List<EmgReq> requests, EmergencyService service) {

        // 1. Load Graph
        Citygraphh.loadGraph();

        // 2. Apply Traffic
        TrafficSim.applyRandomTraffic();

        // 3. Queue processing (FCFS)
        Queue<EmgReq> queue = new LinkedList<>(requests);

        StringBuilder result = new StringBuilder();
        result.append("\n--- [DISPATCHING RESPONDERS] ---\n");

        while (!queue.isEmpty()) {
            EmgReq req = queue.poll();

            // Simulate delay (optional)
            try { Thread.sleep(200); } catch (InterruptedException e) {}

            // Call your logic
            String response = NearestSer.findNearestService(req, service);

            result.append(response).append("\n");
        }

        result.append("\nDispatch complete ✅");

        return result.toString();
    }
}