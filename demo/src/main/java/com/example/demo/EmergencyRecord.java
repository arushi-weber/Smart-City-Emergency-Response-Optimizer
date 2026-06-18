package com.example.demo;

import jakarta.persistence.*;

@Entity
public class EmergencyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int location;
    private int station;
    private int distance;

    public EmergencyRecord() {}

    public EmergencyRecord(String type, int location, int station, int distance) {
        this.type = type;
        this.location = location;
        this.station = station;
        this.distance = distance;

    }

    // getters & setters
    public Long getId() { return id; }
    public String getType() { return type; }
    public int getLocation() { return location; }
    public int getStation() { return station; }
    public int getDistance() { return distance; } 

    public void setType(String type) { this.type = type; }
    public void setLocation(int location) { this.location = location; }
    public void setStation(int station) { this.station = station; }
    public void setDistance(int distance) { this.distance = distance; }
}