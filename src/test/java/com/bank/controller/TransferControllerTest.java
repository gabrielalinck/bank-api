package com.bank.controller;

import com.bank.entity.BankPostingEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransferControllerTest {

    @Autowired
    private TransferController controller;

    @Test
    void shouldReturnAllCheckingAccounts() throws Exception {
        int originAccount = 1;
        int recipientAccountId = 2;
        int transferValue = 5;
        var actual = controller.transfer(originAccount, recipientAccountId, transferValue);
        var expected = buildBankPosting(5);

        assertEquals(expected, actual);
    }

    private BankPostingEntity buildBankPosting(Integer total) {
        var bankPostingEntity = new BankPostingEntity();
        bankPostingEntity.setPostingId(4);
        bankPostingEntity.setPostingDate(LocalDate.now());
        bankPostingEntity.setOriginAccount(1);
        bankPostingEntity.setRecipientAccount(2);
        bankPostingEntity.setTotalValue(total);

        return bankPostingEntity;
    }

}