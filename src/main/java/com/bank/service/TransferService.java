package com.bank.service;

import com.bank.entity.BankPostingEntity;
import com.bank.entity.CheckingAccountEntity;
import com.bank.exceptions.TransferException;
import com.bank.exceptions.UpdateOriginAccountException;
import com.bank.exceptions.UpdateRecipientAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransferService {

    @Autowired
    private CheckingAccountService checkingAccountService;

    @Autowired
    private BankPostingService bankPostingService;

    public BankPostingEntity transfer(Integer originAccountId, Integer recipientAccountId, Integer transferValue) throws Exception {
        var originAccount = checkingAccountService.getCheckingAccountById(originAccountId);

        if(verify(originAccount, recipientAccountId, transferValue)) {
            updateOriginAccount(originAccount, transferValue);
            updateRecipientAccount(recipientAccountId, transferValue);
            var bankPostingId = createBankPosting(originAccountId, recipientAccountId, transferValue);
            return getBankPosting(bankPostingId);
        }

        throw new TransferException("Transfer couldn't be made");

    }

    private Boolean verify(CheckingAccountEntity originAccount, Integer recipientAccountId, Integer transferValue) {
        if(transferValue < 0) return false;
        if(originAccount.getTotalSavings() <= transferValue) return false;
        if(originAccount.getId() == recipientAccountId) return false;

        return true;
    }

    private void updateOriginAccount(
            CheckingAccountEntity originAccount,
            Integer transferValue
    ) throws UpdateOriginAccountException {
        var newValue = originAccount.getTotalSavings() - transferValue;
        originAccount.setTotalSavings(newValue);
        try {
            checkingAccountService.updateCheckingAccount(originAccount);
        } catch (Exception exception) {
            throw new UpdateOriginAccountException("Origin account was not updated" + exception);
        }
    }

    private void updateRecipientAccount(
            Integer recipientAccountId,
            Integer transferValue
    ) throws UpdateRecipientAccountException {
        var recipientAccount = checkingAccountService.getCheckingAccountById(recipientAccountId);
        var newValue = recipientAccount.getTotalSavings() + transferValue;
        recipientAccount.setTotalSavings(newValue);
        try {
            checkingAccountService.updateCheckingAccount(recipientAccount);
        } catch (Exception exception) {
            throw new UpdateRecipientAccountException("Recipient account was not updated" + exception);
        }
    }

    private Integer createBankPosting(Integer originAccountId, Integer recipientAccountId, Integer transferValue) {
        BankPostingEntity bankPostingEntity = getBankPostingEntity(originAccountId, recipientAccountId, transferValue);
        return bankPostingService.createBankPosting(bankPostingEntity);
    }

    private BankPostingEntity getBankPostingEntity(Integer originAccountId, Integer recipientAccountId, Integer transferValue) {
        BankPostingEntity bankPostingEntity = new BankPostingEntity();
        bankPostingEntity.setTotalValue(transferValue);
        bankPostingEntity.setRecipientAccount(recipientAccountId);
        bankPostingEntity.setOriginAccount(originAccountId);
        bankPostingEntity.setPostingDate(LocalDate.now());
        return bankPostingEntity;
    }

    private BankPostingEntity getBankPosting(Integer bankPostingId) {
        return bankPostingService.getBankPostingById(bankPostingId);
    }

}
