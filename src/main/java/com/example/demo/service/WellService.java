package com.example.demo.service;

import me.project.humanstarter.annotations.WeylandWatchingYou;
import me.project.humanstarter.data.AuditMode;
import me.project.humanstarter.data.Command;
import me.project.humanstarter.data.KafkaProperties;
import me.project.humanstarter.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WellService {

    @Autowired
    private TaskService processor;

    private final KafkaProperties kafkaProperties;

    public WellService(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @WeylandWatchingYou(value = AuditMode.CONSOLE)
    public void proc(Command commandDto){
        processor.process(commandDto);
    }


}
