package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {
    @Test
    void testDeposit() {
        //Balance= 200 Deposit= 200 New balance= 400
        BankAccount account = new BankAccount();
        account.setBalance(200);
        account.deposit(200);
        assertEquals(400, account.getBalance());
    }
    @Test
    void testDepositNegativeValue() {
        //Balance= 200 Deposit= -200 Error= Value less than 0
        BankAccount account = new BankAccount();
        account.setBalance(200);
        account.deposit(-200);
        assertEquals(400, account.getBalance());
    }
    @Test
    void testWithdrawInLimit() throws ExceedingLimitException, InsufficientBalanceException {
        //Balance= 200 Limit= 110 Withdraw= 100
        BankAccount account = new BankAccount();
        account.setBalance(200);
        account.setLimit(110);
        account.withdraw(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testWithdrawExceedLimit() {
        //Balance= 200 Limit= 50 Withdraw= 55 Exception= ExceedLimit
        BankAccount account = new BankAccount();
        account.setBalance(200);
        account.setLimit(50);
        assertThatThrownBy(() -> {
            account.withdraw(55);
        }).isInstanceOf(ExceedingLimitException.class);
    }
    @Test
    void testWithdrawInsufficientBalance() {
        //Balance= 200 Limit= 500 Withdraw= 255 Exception= InsufficientBalance
        BankAccount account = new BankAccount();
        account.setBalance(200);
        account.setLimit(500);
        assertThatThrownBy(() -> {
            account.withdraw(255);
        }).isInstanceOf(InsufficientBalanceException.class);
    }
}
