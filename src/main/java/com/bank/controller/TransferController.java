package com.bank.controller;

import com.bank.entity.BankPostingEntity;
import com.bank.service.TransferService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @PutMapping("/transfer")
    @ResponseBody
    public BankPostingEntity transfer(
            @RequestParam Integer originAccount,
            @RequestParam Integer recipientAccountId,
            @RequestParam Integer transferValue
    ) throws Exception {
        return service.transfer(originAccount, recipientAccountId, transferValue);
    }

}
