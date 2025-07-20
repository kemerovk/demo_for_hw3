package com.example.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.project.humanstarter.data.Command;
import me.project.humanstarter.data.Priority;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class CommandSender implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void run(String... args) {
        String url = "http://localhost:8080/api/commands";

        for (int i = 1; i <= 200; i++) {
            Command command = new Command(
                    "desc: " + i,
                    i % 2 == 0 ? Priority.COMMON : Priority.CRITICAL,
                    "auth: " + i,
                    ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT)
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Command> request = new HttpEntity<>(command, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        }
    }
}