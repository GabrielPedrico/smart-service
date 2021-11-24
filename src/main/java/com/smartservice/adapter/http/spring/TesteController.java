package com.smartservice.adapter.http.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @PostMapping
    ResponseEntity<?> postHelloWorld(){
        return ResponseEntity.ok().body("Hello world");
    }
}
