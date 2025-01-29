package org.example.classes;

public class SavingsAccount extends BankAccount {
    private int withdrawTransactionsThisMonth = 0;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (balance < amount) {
            throw new Exception("You don't have enough balance");
        } else if (withdrawTransactionsThisMonth >= 3) {
            throw new Exception("You have already withdrawn 3 times this month");
        } else {
            balance -= amount;
            withdrawTransactionsThisMonth++;
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void resetMonthlyWithdrawals() {
        withdrawTransactionsThisMonth = 0;
    }

    // Add interest
    public void addInterest() {
        balance += balance * 0.03;
    }
}
