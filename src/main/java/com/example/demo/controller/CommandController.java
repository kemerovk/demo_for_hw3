package com.example.demo.controller;

import com.example.demo.service.WellService;
import me.project.humanstarter.data.Command;
import me.project.humanstarter.exceptions.QueueOverflowException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commands")
public class CommandController {

    @Autowired
    private WellService taskService;

    @PostMapping
    public ResponseEntity<?> submitCommand(@RequestBody Command command) {
        try {
            taskService.proc(command);
            return ResponseEntity.accepted().build();
        } catch (QueueOverflowException e) {
            return ResponseEntity.status(429).body("Queue is full, try again later.");
        }
    }
}