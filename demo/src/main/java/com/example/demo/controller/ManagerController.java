package com.example.demo.controller;

import com.example.demo.business.abstracts.ManagerService;
import com.example.demo.configuration.ManagerScheduler;
import jakarta.persistence.Id;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ManagerController {

    @Autowired
    ManagerScheduler managerScheduler;

    @Autowired
    ManagerService managerService;

    @GetMapping("/suspend-manager-for-72-hours/{Id}")
    public ResponseEntity<String> suspend(@PathVariable Long Id) throws SchedulerException {
        System.out.println(new Date());
        managerScheduler.scheduleJob(Id);
        return ResponseEntity.ok("başardın");
    }
}
