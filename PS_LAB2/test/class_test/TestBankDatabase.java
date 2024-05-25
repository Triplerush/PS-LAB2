package class_test;

import ATMCaseStudy.BankDatabase;

public class TestBankDatabase extends BankDatabase {
    private double balance = 0;

    @Override
    public void credit(int accountNumber, double amount) {
        balance += amount;
    }

    @Override
    public void debit(int accountNumber, double amount) {
        balance -= amount;
    }

    public double getBalance(int accountNumber) {
        return balance;
    }

    public void setBalance(int accountNumber, double balance) {
        this.balance = balance;
    }
}
