package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyService {

    @Autowired
    private EmergencyRepository repo;

    public void save(String type, int loc, int station, int dist, double time) {
        EmergencyRecord record = new EmergencyRecord(type, loc, station, dist, time);
        repo.save(record);
    }
    public List<EmergencyRecord> getAllRecords() {
        return repo.findAll();
    }
}