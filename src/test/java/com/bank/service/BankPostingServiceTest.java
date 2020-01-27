package com.bank.service;

import com.bank.entity.BankPostingEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BankPostingServiceTest {

    private BankPostingService service = mock(BankPostingService.class);

    @Test
    void shouldReturnAllBankPostings() {
        when(service.getAllBankPostings()).thenReturn(buildBankPostings());
        var actual = service.getAllBankPostings();
        var expected = buildBankPostings();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBankPostingById() {
        int total = 15;
        when(service.getBankPostingById(1)).thenReturn(buildBankPosting(total));
        var actual = service.getBankPostingById(1);
        var expected = buildBankPosting(total);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBankPostingByOriginAccount() {
        int total = 15;
        when(service.getBankPostingByOriginAccount(1))
                .thenReturn(buildBankPosting(total));
        var actual = service.getBankPostingByOriginAccount(1);
        var expected = buildBankPosting(total);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBankPostingByRecipientAccount() {
        int total = 15;
        when(service.getBankPostingByRecipientAccount(1))
                .thenReturn(buildBankPosting(total));
        var actual = service.getBankPostingByRecipientAccount(1);
        var expected = buildBankPosting(total);
        assertEquals(expected, actual);
    }

    @Test
    void shouldUpdateBankPosting() {
        int total = 20;
        when(service.updateBankPosting(buildBankPosting(total))).thenReturn(true);
        when(service.getBankPostingById(1)).thenReturn(buildBankPosting(total));
        service.updateBankPosting(buildBankPosting(total));
        var rowUpdated = service.getBankPostingById(1);
        var expected = buildBankPosting(total);
        assertEquals(expected, rowUpdated);
    }

    @Test
    void shouldntUpdateBankPosting() {
        int total = 20;
        when(service.updateBankPosting(buildBankPosting(total))).thenReturn(false);
        when(service.getBankPostingById(1)).thenReturn(buildBankPosting(15));
        service.updateBankPosting(buildBankPosting(total));
        var rowUpdated = service.getBankPostingById(1);
        var expected = buildBankPosting(15);
        assertEquals(expected, rowUpdated);
    }

    @Test
    void shouldCreateBankPosting() {
        int total = 20;
        when(service.createBankPosting(buildBankPosting(total))).thenReturn(4);
        when(service.getBankPostingById(4)).thenReturn(buildBankPosting(total));
        service.createBankPosting(buildBankPosting(total));
        var rowUpdated = service.getBankPostingById(4);
        var expected = buildBankPosting(total);
        assertEquals(expected, rowUpdated);
    }

    @Test
    void shouldntCreateBankPosting() {
        int total = 20;
        when(service.createBankPosting(buildBankPosting(total))).thenReturn(4);
        when(service.getBankPostingById(4)).thenReturn(buildBankPosting(15));
        service.createBankPosting(buildBankPosting(total));
        var rowUpdated = service.getBankPostingById(4);
        var expected = buildBankPosting(15);
        assertEquals(expected, rowUpdated);
    }

    private List<BankPostingEntity> buildBankPostings() {
        var bankPostingEntity1 = new BankPostingEntity();
        bankPostingEntity1.setPostingId(1);
        bankPostingEntity1.setPostingDate(LocalDate.of(2020, 1, 1));
        bankPostingEntity1.setOriginAccount(1);
        bankPostingEntity1.setRecipientAccount(2);
        bankPostingEntity1.setTotalValue(20);

        var bankPostingEntity2 = new BankPostingEntity();
        bankPostingEntity2.setPostingId(2);
        bankPostingEntity2.setPostingDate(LocalDate.of(2020, 1, 3));
        bankPostingEntity2.setOriginAccount(3);
        bankPostingEntity2.setRecipientAccount(2);
        bankPostingEntity2.setTotalValue(250);

        var bankPostingEntity3 = new BankPostingEntity();
        bankPostingEntity3.setPostingId(3);
        bankPostingEntity3.setPostingDate(LocalDate.of(2020, 1, 5));
        bankPostingEntity3.setOriginAccount(2);
        bankPostingEntity3.setRecipientAccount(1);
        bankPostingEntity3.setTotalValue(50);

        return List.of(bankPostingEntity1, bankPostingEntity2, bankPostingEntity3);
    }

    private BankPostingEntity buildBankPosting(Integer total) {
        var bankPostingEntity = new BankPostingEntity();
        bankPostingEntity.setPostingId(1);
        bankPostingEntity.setPostingDate(LocalDate.of(2020, 1, 1));
        bankPostingEntity.setOriginAccount(1);
        bankPostingEntity.setRecipientAccount(2);
        bankPostingEntity.setTotalValue(total);

        return bankPostingEntity;
    }
}