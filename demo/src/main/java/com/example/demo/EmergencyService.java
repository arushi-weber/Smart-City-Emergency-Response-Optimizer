package com.example.demo;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class EmergencyService {

    private final EmergencyRepository repo;

    EmergencyService(EmergencyRepository repo) {
        this.repo = repo;
    }

    public void save(String type, int loc, int station, int dist) {
        EmergencyRecord record = new EmergencyRecord(type, loc, station, dist);
        repo.save(record);
    }
    public List<EmergencyRecord> getAllRecords() {
        return repo.findAll();
    }
}