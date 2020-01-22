package com.bank.controller;

import com.bank.entity.CheckingAccountEntity;
import com.bank.service.CheckingAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckingAccountController {

    private CheckingAccountService service;

    public CheckingAccountController(CheckingAccountService service) {
        this.service = service;
    }

    @GetMapping
    public List<CheckingAccountEntity> getAllCheckingAccounts(){
        return service.getAllCheckingAccounts();
    }

}
