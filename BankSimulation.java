package BankAccountSimulation;

/**
 * Main class to simulate and demonstrate bank account operations.
 */
public class BankSimulation {
    public static void main(String[] args) {
        System.out.println("--- Starting Bank Account Simulation ---");

        // 1. Create a new account
        Account myAccount = new Account("123456789", 500.00);
        System.out.printf("Created Account %s with initial balance: $%.2f%n", 
            myAccount.getAccountNumber(), myAccount.getBalance());

        // 2. Check the initial balance
        myAccount.checkBalance();
        
        // 3. Perform a successful deposit
        System.out.println("\n--- Performing Deposit ---");
        myAccount.deposit(150.50);
        
        // 4. Perform a successful withdrawal
        System.out.println("\n--- Performing Withdrawal ---");
        myAccount.withdraw(75.00);
        
        // 5. Check balance again
        myAccount.checkBalance();
        
        // 6. Attempt an unsuccessful withdrawal (Insufficient funds)
        System.out.println("\n--- Attempting Large Withdrawal ---");
        myAccount.withdraw(1000.00); // Should fail
        
        // 7. Attempt an invalid transaction
        System.out.println("\n--- Attempting Invalid Deposit ---");
        myAccount.deposit(-20.00); // Should fail

        // 8. Print the complete transaction history
        myAccount.printHistory();
        
        System.out.println("--- Simulation Ended ---");
    }
}
