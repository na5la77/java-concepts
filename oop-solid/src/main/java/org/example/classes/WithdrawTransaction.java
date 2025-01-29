package org.example.classes;

import org.example.interfaces.Transaction;

public class WithdrawTransaction implements Transaction {
    private final BankAccount account;
    private final double amount;

    public WithdrawTransaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() throws Exception {
        account.withdraw(amount);
    }

    @Override
    public void undo() {
        account.deposit(amount);
    }
}
