package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    @Test
    public void testCreateAccount() throws NegativeAmountException, javax.security.auth.login.AccountNotFoundException {
        Bank bank = new Bank();

        bank.createAccount("Serhii Skyba", 3000);

        assertEquals(1, bank.findAccount(1).getAccountNumber());
        assertEquals("Serhii Skyba", bank.findAccount(1).getAccountName());
        assertEquals(3000, bank.findAccount(1).getBalance(), 0.001);
    }
    @Test(expected = NegativeAmountException.class)
    public void testNegativeAmountDeposit() throws NegativeAmountException, AccountNotFoundException, InsufficientFundsException, javax.security.auth.login.AccountNotFoundException {
        Bank bank = new Bank();

        bank.createAccount("Serhii Skyba", 3000);
        bank.findAccount(1).deposit(-500);
    }
    @Test(expected = NegativeAmountException.class)
    public void testCreateAccountWithNegativeInitialDeposit() throws NegativeAmountException {
        Bank bank = new Bank();

        bank.createAccount("Bob Korvat", -500);
    }

    @Test
    public void testTransferMoney() throws AccountNotFoundException, NegativeAmountException, InsufficientFundsException, javax.security.auth.login.AccountNotFoundException {
        Bank bank = new Bank();
        bank.createAccount("Sender", 3000);
        bank.createAccount("Receiver", 2500);

        bank.transferMoney(1, 2, 500);

        assertEquals(2500, bank.findAccount(1).getBalance(), 0.001);
        assertEquals(3000, bank.findAccount(2).getBalance(), 0.001);
    }

    @Test(expected = javax.security.auth.login.AccountNotFoundException.class)
    public void testTransferMoneyWithNonExistingFromAccount() throws NegativeAmountException, AccountNotFoundException, InsufficientFundsException, javax.security.auth.login.AccountNotFoundException {
        Bank bank = new Bank();
        bank.createAccount("Sender", 3000); // Account number 1
        bank.createAccount("Receiver", 500); // Account number 2

        bank.transferMoney(3, 2, 500);
    }
    @Test(expected = javax.security.auth.login.AccountNotFoundException.class)
    public void testTransferMoneyWithNonExistingToAccount() throws NegativeAmountException, javax.security.auth.login.AccountNotFoundException, InsufficientFundsException, org.example.AccountNotFoundException {
        Bank bank = new Bank();
        bank.createAccount("Sender", 3000);

        bank.transferMoney(1, 2, 500);
    }

    @Test(expected = NegativeAmountException.class)
    public void testTransferMoneyWithNegativeAmount() throws NegativeAmountException, AccountNotFoundException, InsufficientFundsException, javax.security.auth.login.AccountNotFoundException {
        Bank bank = new Bank();
        bank.createAccount("Sender", 3000);
        bank.createAccount("Receiver", 500);

        bank.transferMoney(1, 2, -500);
    }

    @Test(expected = InsufficientFundsException.class)
    public void testTransferMoneyWithInsufficientFunds() throws NegativeAmountException, AccountNotFoundException, InsufficientFundsException, AccountNotFoundException, javax.security.auth.login.AccountNotFoundException {
        Bank bank = new Bank();
        bank.createAccount("Sender", 500);
        bank.createAccount("Receiver", 3000);

        bank.transferMoney(1, 2, 3000);
    }
    @Test
    public void testGetAccountSummary() throws NegativeAmountException {
        BankAccount account = new BankAccount(1, "Serhii Skyba", 3000);
        String accountSummary = account.getAccountSummary().trim();
        String expectedSummary = "Account Number:1\nAccount Name:Serhii Skyba\nBalance:3000.0";
        assertEquals(expectedSummary.trim(), accountSummary);
    }
}

