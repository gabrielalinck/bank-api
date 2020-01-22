package com.bank.controller;

import com.bank.service.CheckingAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckingAccountController {

    private CheckingAccountService service;

    public CheckingAccountController(CheckingAccountService service) {
        this.service = service;
    }

    @GetMapping
    public String get(){
        return service.getCheckingAccount();
    }

}
