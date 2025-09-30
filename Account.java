package BankAccountSimulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with basic deposit and withdrawal functionality.
 */
class Account {
    private String accountNumber;
    private double balance;
    // List to store all transactions for this account
    private List<Transaction> history; 

    /**
     * Constructs a new Account.
     * @param accountNumber The unique identifier for the account.
     * @param initialBalance The starting balance of the account.
     */
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.history = new ArrayList<>();
        // Add initial balance as a special 'SETUP' transaction (optional)
        this.history.add(new Transaction("SETUP", initialBalance)); 
    }

    /**
     * Adds an amount to the account balance.
     * @param amount The amount to deposit.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            this.history.add(new Transaction("DEPOSIT", amount));
            System.out.printf("✅ Deposit successful. New balance: $%.2f%n", this.balance);
        } else {
            System.out.println("❌ Deposit failed: Amount must be positive.");
        }
    }

    /**
     * Removes an amount from the account balance, checking for sufficient funds.
     * @param amount The amount to withdraw.
     * @return true if the withdrawal was successful, false otherwise.
     */
    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (this.balance >= amount) {
                this.balance -= amount;
                this.history.add(new Transaction("WITHDRAWAL", amount));
                System.out.printf("✅ Withdrawal successful. New balance: $%.2f%n", this.balance);
                return true;
            } else {
                System.out.printf("❌ Withdrawal failed: Insufficient funds. Current balance: $%.2f%n", this.balance);
                return false;
            }
        } else {
            System.out.println("❌ Withdrawal failed: Amount must be positive.");
            return false;
        }
    }

    /**
     * Prints the current account balance.
     */
    public void checkBalance() {
        System.out.printf("--- Account %s Balance: $%.2f ---%n", this.accountNumber, this.balance);
    }

    /**
     * Prints the entire transaction history for the account.
     */
    public void printHistory() {
        System.out.printf("\n--- Transaction History for Account %s ---%n", this.accountNumber);
        if (history.isEmpty()) {
            System.out.println("No transactions recorded.");
            return;
        }
        for (Transaction t : history) {
            System.out.println(t);
        }
        System.out.println("----------------------------------------");
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
