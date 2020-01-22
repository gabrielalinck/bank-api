package com.bank.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CheckingAccountControllerTest {

    @Autowired
    private CheckingAccountController checkingAccountController;

    @Test
    @DisplayName("Should return with a hello world")
    void firstTest() {
        var actual = checkingAccountController.get();
        var expected = "Checking Account";
        assertEquals(expected, actual);
    }
}