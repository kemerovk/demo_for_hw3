package com.example.demo.configuration;

import me.project.humanstarter.service.TaskService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties()
public class Configuration {
    @Bean
    public TaskService taskService() {
        return new TaskService();
    }
}
