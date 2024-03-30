package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        BankAccount account = new BankAccount();
        int option;
        System.out.println("Enter your current balance:");
        account.setBalance(keyboard.nextDouble());
        System.out.println("Enter the account limit:");
        account.setLimit(keyboard.nextDouble());
        do {
            System.out.println("Choose an option: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter how much you want to deposit:");
                    double valueD = keyboard.nextDouble();
                    System.out.println("-------------");
                    System.out.println("Current balance: " + account.deposit(valueD));
                    System.out.println("-------------");
                    break;
                case 2:
                    System.out.println("Enter how much you want to withdraw:");
                    double valueW = keyboard.nextDouble();
                    try {
                        System.out.println("-------------");
                        System.out.println("Current balance: " + account.withdraw(valueW));
                        System.out.println("-------------");
                    } catch (ExceedingLimitException | InsufficientBalanceException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (option < 3);
    }
}