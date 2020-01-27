package com.bank.service;

import com.bank.entity.CheckingAccountEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
class CheckingAccountServiceTest {

    private CheckingAccountService service = mock(CheckingAccountService.class);

    @Test
    void shouldReturnAllCheckingAccounts() {
        when(service.getAllCheckingAccounts()).thenReturn(buildCheckingAccounts());
        var actual = service.getAllCheckingAccounts();
        var expected = buildCheckingAccounts();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCheckingAccountById() {
        int total = 15;
        when(service.getCheckingAccountById(1)).thenReturn(buildCheckingAccount(total));
        var actual = service.getCheckingAccountById(1);
        var expected = buildCheckingAccount(total);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCheckingAccountBySocialNumber() {
        int total = 15;
        when(service.getCheckingAccountBySocialNumber("028.899.220-20"))
                .thenReturn(buildCheckingAccount(total));
        var actual = service.getCheckingAccountBySocialNumber("028.899.220-20");
        var expected = buildCheckingAccount(total);
        assertEquals(expected, actual);
    }

    @Test
    void shouldUpdateCheckingAccount() {
        int total = 20;
        when(service.updateCheckingAccount(buildCheckingAccount(total))).thenReturn(true);
        when(service.getCheckingAccountById(1)).thenReturn(buildCheckingAccount(total));
        service.updateCheckingAccount(buildCheckingAccount(total));
        var rowUpdated = service.getCheckingAccountById(1);
        var expected = buildCheckingAccount(total);
        assertEquals(expected, rowUpdated);
    }

    @Test
    void shouldntUpdateCheckingAccount() {
        int total = 20;
        when(service.updateCheckingAccount(buildCheckingAccount(total))).thenReturn(false);
        when(service.getCheckingAccountById(1)).thenReturn(buildCheckingAccount(15));
        service.updateCheckingAccount(buildCheckingAccount(total));
        var rowUpdated = service.getCheckingAccountById(1);
        var expected = buildCheckingAccount(15);
        assertEquals(expected, rowUpdated);
    }

    private List<CheckingAccountEntity> buildCheckingAccounts() {
        var checkingAccountEntity1 = new CheckingAccountEntity();
        checkingAccountEntity1.setId(1);
        checkingAccountEntity1.setFirstName("Aliko");
        checkingAccountEntity1.setLastName("Dangote");
        checkingAccountEntity1.setTotalSavings(15);
        checkingAccountEntity1.setSocialNumber("028.899.220-20");

        var checkingAccountEntity2 = new CheckingAccountEntity();
        checkingAccountEntity2.setId(2);
        checkingAccountEntity2.setFirstName("Bill");
        checkingAccountEntity2.setLastName("Gates");
        checkingAccountEntity2.setTotalSavings(15);
        checkingAccountEntity2.setSocialNumber("028.899.220-21");

        var checkingAccountEntity3 = new CheckingAccountEntity();
        checkingAccountEntity3.setId(3);
        checkingAccountEntity3.setFirstName("Folrunsho");
        checkingAccountEntity3.setLastName("Alakija");
        checkingAccountEntity3.setTotalSavings(15);
        checkingAccountEntity3.setSocialNumber("028.899.220-22");

        return List.of(checkingAccountEntity1, checkingAccountEntity2, checkingAccountEntity3);
    }

    private CheckingAccountEntity buildCheckingAccount(Integer total) {
        var checkingAccountEntity = new CheckingAccountEntity();
        checkingAccountEntity.setId(1);
        checkingAccountEntity.setFirstName("Aliko");
        checkingAccountEntity.setLastName("Dangote");
        checkingAccountEntity.setTotalSavings(total);
        checkingAccountEntity.setSocialNumber("028.899.220-20");

        return checkingAccountEntity;
    }
}