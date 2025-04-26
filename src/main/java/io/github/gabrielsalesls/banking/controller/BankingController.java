package io.github.gabrielsalesls.banking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankingController {

    @GetMapping("/")
    public String handle() {
        return "Hello World";
    }
}
