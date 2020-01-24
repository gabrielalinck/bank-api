package com.bank.service;

import com.bank.dao.BankPostingDAO;
import com.bank.entity.BankPostingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankPostingService {

    @Autowired
    private BankPostingDAO dao;

    public BankPostingService(BankPostingDAO dao) {
        this.dao = dao;
    }

    public List<BankPostingEntity> getAllBankPostings() {
        return dao.getAllBankPosting();
    }

    public BankPostingEntity getBankPostingById(Integer id) {
        return dao.getBankPostingById(id);
    }

    public BankPostingEntity getBankPostingByOriginAccount(Integer originAccount) {
        return dao.getBankPostingByOriginAccount(originAccount);
    }

    public BankPostingEntity getBankPostingByRecipientAccount(Integer recipientAccount) {
        return dao.getBankPostingByOriginAccount(recipientAccount);
    }

    public Boolean updateBankPosting(BankPostingEntity bankPostingEntity) {
        return dao.updateBankPosting(bankPostingEntity) == 1;
    }
}
