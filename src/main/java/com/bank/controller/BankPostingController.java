package com.bank.controller;

import com.bank.entity.BankPostingEntity;
import com.bank.service.BankPostingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankPostingController {

    private BankPostingService service;

    public BankPostingController(BankPostingService service) {
        this.service = service;
    }

    @GetMapping("/bank-posting/all")
    public List<BankPostingEntity> getAllBankPostings(){
        return service.getAllBankPostings();
    }

    @GetMapping("/bank-posting/id")
    @ResponseBody
    public BankPostingEntity getBankPostingById(@RequestParam Integer id){
        return service.getBankPostingById(id);
    }

    @GetMapping("/bank-posting/origin-account")
    @ResponseBody
    public BankPostingEntity getBankPostingByOriginAccount(@RequestParam Integer originAccount){
        return service.getBankPostingByOriginAccount(originAccount);
    }

    @GetMapping("/bank-posting/recipient-account")
    @ResponseBody
    public BankPostingEntity getBankPostingByRecipientAccount(@RequestParam Integer recipientAccount){
        return service.getBankPostingByRecipientAccount(recipientAccount);
    }

    @PutMapping("/bank-posting/update")
    @ResponseBody
    public Boolean updateBankPosting(@RequestBody BankPostingEntity entity){
        return service.updateBankPosting(entity);
    }
}
