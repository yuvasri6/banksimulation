package BankAccountSimulation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single financial transaction on an account.
 */
class Transaction {
    private String type; // "DEPOSIT" or "WITHDRAWAL"
    private double amount;
    private LocalDateTime timestamp;
    private final DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Constructs a new Transaction.
     * @param type The type of the transaction ("DEPOSIT" or "WITHDRAWAL").
     * @param amount The amount involved in the transaction.
     */
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Provides a formatted string representation of the transaction.
     * @return A string with transaction details.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s: $%.2f",
            this.timestamp.format(formatter),
            this.type,
            this.amount
        );
    }
}
