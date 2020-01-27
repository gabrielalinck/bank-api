package com.bank.controller;

import com.bank.entity.BankPostingEntity;
import com.bank.exceptions.TransferException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

@SpringBootTest
@DirtiesContext(classMode = BEFORE_CLASS)
class TransferControllerTest {

    @Autowired
    private TransferController controller;

    @Test
    void shouldMakeASuccessfulTransfer() throws Exception {
        int originAccount = 1;
        int recipientAccountId = 2;
        int transferValue = 5;
        var actual = controller.transfer(originAccount, recipientAccountId, transferValue);
        var expected = buildBankPosting(5);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotMakeTransferWhenOriginAccountHasNoFounds() throws Exception {
        int originAccount = 3;
        int recipientAccountId = 2;
        int transferValue = 5;
        try {
            controller.transfer(originAccount, recipientAccountId, transferValue);
        } catch (TransferException exception) {
            assertEquals(exception.getMessage(), "Transfer couldn't be made");
        }
    }

    @Test
    void shouldNotMakeTransferWhenOriginAccountAndRecipientAccountAreEqual() throws Exception {
        int originAccount = 2;
        int recipientAccountId = 2;
        int transferValue = 5;
        try {
            controller.transfer(originAccount, recipientAccountId, transferValue);
        } catch (TransferException exception) {
            assertEquals(exception.getMessage(), "Transfer couldn't be made");
        }
    }

    @Test
    void shouldNotMakeTransferWhenTransferValueIs0() throws Exception {
        int originAccount = 1;
        int recipientAccountId = 2;
        int transferValue = 0;
        try {
            controller.transfer(originAccount, recipientAccountId, transferValue);
        } catch (TransferException exception) {
            assertEquals(exception.getMessage(), "Transfer couldn't be made");
        }
    }

    @Test
    void shouldNotMakeTransferWhenTransferValueIsNegative() throws Exception {
        int originAccount = 1;
        int recipientAccountId = 2;
        int transferValue = -15;
        try {
            controller.transfer(originAccount, recipientAccountId, transferValue);
        } catch (TransferException exception) {
            assertEquals(exception.getMessage(), "Transfer couldn't be made");
        }
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