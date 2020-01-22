package com.bank.service;

import com.bank.CheckingAccountDAO;
import com.bank.entity.CheckingAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckingAccountService {

    @Autowired
    private CheckingAccountDAO dao;

    public CheckingAccountService(CheckingAccountDAO dao) {
        this.dao = dao;
    }

    public List<CheckingAccountEntity> getAllCheckingAccounts() {
        return dao.getAccounts();
    }
}
