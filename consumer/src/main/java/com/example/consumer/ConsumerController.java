package com.example.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    @Value("${provider.port}")
    private Integer providerPort;

    ConsumerController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/consumer/{personId}")
    public String getFirstname(@PathVariable("personId") int personId) {
        UserResponse user = this.restTemplate.getForObject(
                "http://localhost:"+ providerPort +"/users/{personId}", UserResponse.class,
                personId);
        return "Hello " + user.getFirstname();
    }

}
