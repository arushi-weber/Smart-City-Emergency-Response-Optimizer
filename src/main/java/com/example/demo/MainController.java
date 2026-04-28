package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MainController {

    @Autowired
    private EmergencyService service;   // ✅ ADD THIS


    @GetMapping("/run")
    public String runSystem() {
        return "System Executed ✅";
    }

    @GetMapping("/emergency-test")
    public String testEmergency() {
        List<EmgReq> list = new ArrayList<>();
        list.add(new EmgReq(5, 1, "Fire"));

        // ✅ PASS service here
        return EmgSystem.processEmergencies(list, service);
    }
    
    @GetMapping("/history")
    public List<EmergencyRecord> getAll() {
        return service.getAllRecords();
    }
    
    @PostMapping("/emergency")
    public String handle(@RequestBody List<EmgReq> list) {
        return EmgSystem.processEmergencies(list, service);
    }
    
    @GetMapping("/history/type/{type}")
    public List<EmergencyRecord> getByType(@PathVariable String type) {
        return service.getAllRecords()
                      .stream()
                      .filter(e -> e.getType().equalsIgnoreCase(type))
                      .toList();
    }
}