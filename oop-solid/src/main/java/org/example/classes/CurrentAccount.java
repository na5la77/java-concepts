package org.example.classes;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        double limit = 10000.0;
        if (balance + limit < amount) {
            throw new Exception("You don't have enough balance or limit");
        } else {
            balance -= amount;
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
