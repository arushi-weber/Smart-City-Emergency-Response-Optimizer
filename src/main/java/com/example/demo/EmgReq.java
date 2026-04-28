package com.example.demo;

public class EmgReq {

    public int location;
    public int priority;
    public String type;
    public long startTime;

    // Constructor
    public EmgReq(int location, int priority, String type) {
        this.location = location;
        this.priority = priority;
        this.type = type;
        this.startTime = System.currentTimeMillis();
    }

    // Default constructor (IMPORTANT for Spring)
    public EmgReq() {}

    // Getters & Setters (good practice)
    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getStartTime() {
        return startTime;
    }
}