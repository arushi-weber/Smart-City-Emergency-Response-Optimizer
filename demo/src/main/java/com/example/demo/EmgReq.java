package com.example.demo;

public class EmgReq {

    public int location;
    public int priority;
    public String type;
	public long startTime;

    // Constructor
    public EmgReq(int location,  String type) {
        this.location = location;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}