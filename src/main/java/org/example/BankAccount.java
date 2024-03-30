package org.example;

public class BankAccount {
    private double balance;
    private double limit;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double deposit(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value less than 0");
        }
        return balance += value;
    }

    public double withdraw(double value) throws ExceedingLimitException, InsufficientBalanceException {
        if (value < 0) {
            throw new IllegalArgumentException("Value less than 0");
        }
        if (value > limit) {
            throw new ExceedingLimitException("Limit exceeded");
        }
        if (value > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        return balance -= value;
    }
}
