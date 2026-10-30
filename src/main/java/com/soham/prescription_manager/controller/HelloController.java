package com.soham.prescription_manager.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController

public class HelloController
{
    @GetMapping("/hello")
    public Map<String, String> hello()
    {
        return Map.of("status:", "up",
                "message:", "hello controller is working successfully!",
                "application:", "Prescription Manager");
    }
}
