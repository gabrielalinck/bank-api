package com.bank.controller;

import com.bank.entity.CheckingAccountEntity;
import com.bank.service.CheckingAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckingAccountController {

    private CheckingAccountService service;

    public CheckingAccountController(CheckingAccountService service) {
        this.service = service;
    }

    @GetMapping("/accounts/all")
    public List<CheckingAccountEntity> getAllCheckingAccounts(){
        return service.getAllCheckingAccounts();
    }

    @GetMapping("/accounts/account/id")
    @ResponseBody
    public CheckingAccountEntity getCheckingAccountById(@RequestParam Integer id){
        return service.getCheckingAccountById(id);
    }

    @GetMapping("/accounts/account/social-number")
    @ResponseBody
    public CheckingAccountEntity getCheckingAccountBySocialNumber(@RequestParam String socialNumber){
        return service.getCheckingAccountBySocialNumber(socialNumber);
    }

    @PutMapping("/accounts/account/update")
    @ResponseBody
    public Boolean updateCheckingAccount(@RequestBody CheckingAccountEntity entity){
        return service.updateCheckingAccount(entity);
    }

}
