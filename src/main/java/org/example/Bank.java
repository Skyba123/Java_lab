package org.example;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;
public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String accountName, double initialDeposit) throws NegativeAmountException {
        if (initialDeposit < 0) {
            throw new NegativeAmountException("Initial deposit can not be negative");
        }
        int accountNumber = accounts.size() + 1;
        BankAccount newAccount = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.add(newAccount);

    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }

        }
        throw new AccountNotFoundException("Account not found with number: " + accountNumber);
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws AccountNotFoundException, NegativeAmountException, InsufficientFundsException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);


        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}

