package org.example;

import org.example.classes.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount savings = new SavingsAccount("12345", 5000);
        BankAccount current = new CurrentAccount("67890", 3000);

        DepositTransaction deposit = new DepositTransaction(savings, 1000);
        WithdrawTransaction withdraw = new WithdrawTransaction(savings, 500);
        DepositTransaction depositCurrent = new DepositTransaction(current, 1000);
        WithdrawTransaction withdrawCurrent = new WithdrawTransaction(current, 500);

        deposit.execute();
        withdraw.execute();
        depositCurrent.execute();
        withdrawCurrent.execute();

        System.out.println("Savings Account Balance: " + savings.getBalance());

        deposit.undo();
        withdraw.undo();
        depositCurrent.undo();
        withdrawCurrent.undo();

        System.out.println("After Undo - Savings Account Balance: " + savings.getBalance());
    }
}
