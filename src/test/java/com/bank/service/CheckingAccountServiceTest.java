package com.bank.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CheckingAccountServiceTest {

    @Autowired
    private CheckingAccountService service;

    @Test
    @DisplayName("Should get checking account")
    void test() {
        var actual = service.getCheckingAccount();
        String expected = "Checking Account";
        assertEquals(expected, actual);
    }

}