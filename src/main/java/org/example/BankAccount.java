package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount (int accountNumber, String accountName,  double balance){
        this.accountNumber = accountNumber;
        this.accountName =  accountName;
        this.balance = balance;
    }
    public void deposit (double amount) throws NegativeAmountException, InsufficientFundsException{
        if (amount < 0){
            throw new NegativeAmountException("Deposit can not be negative");
        }
        else if (amount > balance){
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount < 0) {
            throw new NegativeAmountException("Withdrawal amount cannot be negative");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
    }

    public int getAccountNumber(){
        return accountNumber;
    }
    public String getAccountName(){
        return accountName;
    }
    public double getBalance(){
        return balance;
    }

    public String getAccountSummary(){
        return "Account Number:" + accountNumber + "\nAccount Name:" + accountName + "\nBalance:" + balance;
    }
}
