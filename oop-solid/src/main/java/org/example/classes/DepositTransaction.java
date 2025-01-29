package org.example.classes;

import org.example.interfaces.Transaction;

public class DepositTransaction implements Transaction {
    private final BankAccount account;
    private final double amount;

    public DepositTransaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
    }

    @Override
    public void undo() throws Exception {
        account.withdraw(amount);
    }
}
