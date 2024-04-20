package com.example.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class HelloController {

    @GetMapping("/")
    String hello() {
        return "Hello, world! change1";
    }

    @GetMapping("/test-outbound")
    String testOutbound() {
        String apiUrl = "https://www.google.com";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class);
        return "Outbound request to " + apiUrl + " Successful. Response: " + response;
    }
}
