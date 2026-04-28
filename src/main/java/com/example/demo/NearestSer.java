package com.example.demo;

import java.util.*;
import java.io.*;

public class NearestSer extends Citygraphh {

    private static final Map<String, List<Integer>> SERVICE_LOCATIONS = Map.of(
        "HOSPITAL", List.of(1, 10, 15),
        "FIRE", List.of(2, 9),
        "POLICE", List.of(3, 8, 11)
    );

    public static String findNearestService(EmgReq req, EmergencyService service){

        if (adj == null || adj.isEmpty()) loadGraph();

        Dijkstra.Result result = Dijkstra.dk(location, adj, req.location);

        String category = getCategory(req.type);
        List<Integer> stations = SERVICE_LOCATIONS.get(category);

        int nearestNode = -1;
        int minDistance = Integer.MAX_VALUE;

        if (stations != null) {
            for (int stationNode : stations) {
                if (result.dist[stationNode] < minDistance) {
                    minDistance = result.dist[stationNode];
                    nearestNode = stationNode;
                }
            }
        }

        if (nearestNode != -1 && minDistance != (int) 1e9) {

            long endTime = System.currentTimeMillis();
            double responseTime = (endTime - req.startTime) / 1000.0;

            service.save(req.type, req.location, nearestNode, minDistance, responseTime);

            // ✅ RETURN instead of print
            return "[DISPATCH] " + req.type +
                    " at node " + req.location +
                    " → handled by station " + nearestNode +
                    " | Distance: " + minDistance +
                    " | Time: " + responseTime + "s";
        }

        return "❌ No service available for " + req.type + " at node " + req.location;
    }

    private static String getCategory(String type) {
        type = type.toUpperCase();

        if (type.contains("INJURY") || type.contains("ACCIDENT"))
            return "HOSPITAL";

        if (type.contains("FIRE"))
            return "FIRE";

        return "POLICE";
    }

    private static void saveInfo(String type, int loc, int station, int dist, double time) {

        File fp = new File("Emergency_Data.csv");
        boolean exists = fp.exists();

        try (PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter(fp, true)))) {

            if (!exists) {
                pout.println("Timestamp,Emergency_Type,Location_Node,Assigned_Station,Path_Distance,Response_Time_Sec");
            }

            String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            String row = String.format("%s,%s,%d,%d,%d,%.2f",
                    timestamp, type, loc, station, dist, time);

            pout.println(row);

        } catch (IOException e) {
            System.err.println("CSV Logging Error: " + e.getMessage());
        }
    }
}