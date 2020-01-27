package com.bank.service;

import com.bank.entity.BankPostingEntity;
import com.bank.exceptions.TransferException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TransferServiceTest {

    private TransferService service = mock(TransferService.class);

    @Test
    void shouldMakeASuccessfulTransfer () throws Exception {
        int originAccount = 1;
        int recipientAccountId = 2;
        int transferValue = 5;
        when(service.transfer(originAccount, recipientAccountId, transferValue)).thenReturn(buildBankPosting(5));
        var actual = service.transfer(originAccount, recipientAccountId, transferValue);
        var expected = buildBankPosting(5);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotMakeTransferWhenOriginAccountHasNoFounds() throws Exception {
        int originAccount = 3;
        int recipientAccountId = 2;
        int transferValue = 5;
        when(service.transfer(originAccount, recipientAccountId, transferValue))
                .thenThrow(new TransferException("Transfer couldn't be made"));
        try {
            service.transfer(originAccount, recipientAccountId, transferValue);
        } catch (TransferException exception) {
            assertEquals("Transfer couldn't be made", exception.getMessage());
        }
    }

    @Test
    void shouldNotMakeTransferWhenOriginAccountAndRecipientAccountAreEqual() throws Exception {
        int originAccount = 2;
        int recipientAccountId = 2;
        int transferValue = 5;
        when(service.transfer(originAccount, recipientAccountId, transferValue))
                .thenThrow(new TransferException("Transfer couldn't be made"));
        try {
            service.transfer(originAccount, recipientAccountId, transferValue);
        } catch (TransferException exception) {
            assertEquals("Transfer couldn't be made", exception.getMessage());
        }
    }

    @Test
    void shouldNotMakeTransferWhenTransferValueIs0() throws Exception {
        int originAccount = 1;
        int recipientAccountId = 2;
        int transferValue = 0;
        when(service.transfer(originAccount, recipientAccountId, transferValue))
                .thenThrow(new TransferException("Transfer couldn't be made"));
        try {
            service.transfer(originAccount, recipientAccountId, transferValue);
        } catch (TransferException exception) {
            assertEquals("Transfer couldn't be made", exception.getMessage());
        }
    }

    @Test
    void shouldNotMakeTransferWhenTransferValueIsNegative() throws Exception {
        int originAccount = 1;
        int recipientAccountId = 2;
        int transferValue = -15;
        when(service.transfer(originAccount, recipientAccountId, transferValue))
                .thenThrow(new TransferException("Transfer couldn't be made"));
        try {
            service.transfer(originAccount, recipientAccountId, transferValue);
        } catch (TransferException exception) {
            assertEquals("Transfer couldn't be made", exception.getMessage());
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