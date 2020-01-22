package com.bank;

import com.bank.entity.CheckingAccountEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CheckingAccountDAOTest {

    @Autowired
    private CheckingAccountDAO checkingAccountDAO;

    @Test
    void shouldReturnAllCheckingAccounts() {
        var actual = checkingAccountDAO.getAccounts();
        var expected = buildCheckingAccounts();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCheckingAccountById() {
        var actual = checkingAccountDAO.getAccountById(1);
        var expected = buildCheckingAccount();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCheckingAccountBySocialNumber() {
        var actual = checkingAccountDAO.getAccountBySocialNumber("028.899.220-20");
        var expected = buildCheckingAccount();
        assertEquals(expected, actual);
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

    private CheckingAccountEntity buildCheckingAccount() {
        var checkingAccountEntity1 = new CheckingAccountEntity();
        checkingAccountEntity1.setId(1);
        checkingAccountEntity1.setFirstName("Aliko");
        checkingAccountEntity1.setLastName("Dangote");
        checkingAccountEntity1.setTotalSavings(15);
        checkingAccountEntity1.setSocialNumber("028.899.220-20");

        return checkingAccountEntity1;
    }

}