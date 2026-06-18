package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private final EmergencyService service;

    MainController(EmergencyService service) {
        this.service = service;
    }   

    @GetMapping("/run")
    public String runSystem() {
        return "System Executed ✅";
    }

    @GetMapping("/emergency-test")
    public String testEmergency() {
        List<EmgReq> list = new ArrayList<>();
        list.add(new EmgReq(5, "Fire"));

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
    
}