package com.bank.controller;

import com.bank.entity.BankPostingEntity;
import com.bank.service.BankPostingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@SpringBootTest
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class BankPostingControllerTest {

    @Autowired
    private BankPostingService service;

    @Test
    void shouldReturnAllBankPostings() {
        var actual = service.getAllBankPostings();
        var expected = buildBankPostings();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBankPostingById() {
        int total = 20;
        var actual = service.getBankPostingById(1);
        var expected = buildBankPosting(total, 1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBankPostingByOriginAccount() {
        int total = 20;
        var actual = service.getBankPostingByOriginAccount(1);
        var expected = buildBankPosting(total, 1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBankPostingByRecipientAccount() {
        int total = 20;
        var actual = service.getBankPostingByRecipientAccount(1);
        var expected = buildBankPosting(total, 1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldUpdateBankPosting() {
        int total = 20;
        service.updateBankPosting(buildBankPosting(total, 1));
        var rowUpdated = service.getBankPostingById(1);
        var expected = buildBankPosting(total, 1);
        assertEquals(expected, rowUpdated);
    }

    @Test
    void shouldCreateBankPosting() {
        int total = 20;
        service.createBankPosting(buildBankPosting(total, 4));
        var rowUpdated = service.getBankPostingById(4);
        var expected = buildBankPosting(total, 4);
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

    private BankPostingEntity buildBankPosting(Integer total, Integer id) {
        var bankPostingEntity = new BankPostingEntity();
        bankPostingEntity.setPostingId(id);
        bankPostingEntity.setPostingDate(LocalDate.of(2020, 1, 1));
        bankPostingEntity.setOriginAccount(1);
        bankPostingEntity.setRecipientAccount(2);
        bankPostingEntity.setTotalValue(total);

        return bankPostingEntity;
    }

}