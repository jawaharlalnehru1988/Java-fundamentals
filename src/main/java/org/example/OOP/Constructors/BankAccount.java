package org.example.OOP.Constructors;

/**
 * ============================================================================
 * MODULE 2: CONSTRUCTORS (INITIALIZATION & CHAINING)
 * ============================================================================
 * Concepts Covered:
 *  - Default Constructor (compiler-provided vs explicit no-arg)
 *  - Parameterized Constructor (initializing state at object creation)
 *  - Constructor Overloading (different parameter signatures)
 *  - Constructor Chaining using 'this()' (must be first statement)
 *  - Copy Constructor (creating a new instance from an existing one)
 * ============================================================================
 */
public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // 1. Parameterized Constructor (Full Initialization)
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = Math.max(0.0, balance); // Invariant protection
    }

    // 2. Overloaded Constructor (Constructor Chaining using this())
    public BankAccount(String accountNumber, String accountHolderName) {
        this(accountNumber, accountHolderName, 0.0); // Chains to primary constructor
    }

    // 3. Overloaded Constructor with minimum data
    public BankAccount(String accountNumber) {
        this(accountNumber, "Unknown Customer", 0.0);
    }

    // 4. Default / No-Arg Constructor
    public BankAccount() {
        this("ACC-TEMP-000", "Guest", 0.0);
    }

    // 5. Copy Constructor (Deep / Safe copy of another object)
    public BankAccount(BankAccount other) {
        if (other != null) {
            this.accountNumber = other.accountNumber;
            this.accountHolderName = other.accountHolderName;
            this.balance = other.balance;
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("  [Error] Deposit amount must be positive!");
            return;
        }
        this.balance += amount;
        System.out.println("  [Deposit] Account " + accountNumber + " +" + amount + " | Current Balance: " + this.balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  [Error] Withdrawal amount must be positive!");
            return;
        }
        if (amount > this.balance) {
            System.out.println("  [Failed] Insufficient balance for Account " + accountNumber + "! Available: " + this.balance);
        } else {
            this.balance -= amount;
            System.out.println("  [Withdraw] Account " + accountNumber + " -" + amount + " | Current Balance: " + this.balance);
        }
    }

    public void displayAccountInfo() {
        System.out.println("  -> Account No: " + this.accountNumber + 
                           " | Holder: " + this.accountHolderName + 
                           " | Balance: $" + this.balance);
    }

    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }
}
