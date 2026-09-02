package org.example.OOP.Encapsulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ============================================================================
 * MODULE 4: ENCAPSULATION (FINTECH DIGITAL WALLET & INVARIANT SECURITY)
 * ============================================================================
 * Domain: Production Fintech Digital Wallet & KYC Tier Invariant Protection
 *
 * Core Concepts Explained:
 *  1. Data Hiding (private fields): Balance, KYC status, and security keys cannot be tampered with directly.
 *  2. Invariant Enforcement: Setters and operations validate business constraints (preventing negative funds or unverified transfers).
 *  3. Defensive Copying: Exposing immutable read-only views of ledger transaction histories.
 * ============================================================================
 */
public class DigitalWalletAccount {
    // Encapsulated Private Fields
    private final String walletId;
    private String accountHolderName;
    private double currentBalance;
    private boolean kycVerified;
    private double dailyTransferLimit;
    private boolean isFrozen;
    private final List<String> transactionAuditLedger;

    public DigitalWalletAccount(String walletId, String accountHolderName, double initialDeposit, boolean kycVerified) {
        if (walletId == null || walletId.trim().isEmpty()) {
            throw new IllegalArgumentException("Wallet ID cannot be null or empty");
        }
        this.walletId = walletId;
        this.setAccountHolderName(accountHolderName);
        this.currentBalance = Math.max(0.0, initialDeposit);
        this.kycVerified = kycVerified;
        this.dailyTransferLimit = kycVerified ? 50000.0 : 1000.0; // Tiered limit based on KYC
        this.isFrozen = false;
        this.transactionAuditLedger = new ArrayList<>();
        this.transactionAuditLedger.add("WALLET_INITIALIZED: Initial Balance = $" + this.currentBalance);
    }

    // Encapsulated Business Method: Safe Deposit
    public void deposit(double amount) {
        if (this.isFrozen) {
            System.out.println("  [Transaction Blocked] Wallet " + walletId + " is currently frozen due to compliance!");
            return;
        }
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Deposit amount must be strictly greater than $0.00");
        }
        this.currentBalance += amount;
        String logEntry = String.format("CREDIT: +$%.2f | New Balance: $%.2f", amount, this.currentBalance);
        this.transactionAuditLedger.add(logEntry);
        System.out.println("  [Deposit Successful] " + logEntry);
    }

    // Encapsulated Business Method: Safe Transfer with Invariant Checks
    public void transfer(String recipientWalletId, double amount) {
        if (this.isFrozen) {
            System.out.println("  [Transfer Blocked] Cannot transfer from frozen wallet " + walletId);
            return;
        }
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (amount > this.dailyTransferLimit) {
            System.out.printf("  [KYC Compliance Error] Amount $%.2f exceeds your daily limit of $%.2f. Complete KYC to upgrade.\n", 
                              amount, this.dailyTransferLimit);
            return;
        }
        if (amount > this.currentBalance) {
            System.out.printf("  [Insufficient Funds] Requested: $%.2f | Available: $%.2f\n", amount, this.currentBalance);
            return;
        }

        this.currentBalance -= amount;
        String logEntry = String.format("DEBIT: -$%.2f to %s | New Balance: $%.2f", amount, recipientWalletId, this.currentBalance);
        this.transactionAuditLedger.add(logEntry);
        System.out.println("  [Transfer Successful] " + logEntry);
    }

    // Controlled KYC Upgrade
    public void verifyKyc(String nationalIdNumber) {
        if (nationalIdNumber != null && nationalIdNumber.length() >= 8) {
            this.kycVerified = true;
            this.dailyTransferLimit = 50000.0;
            this.transactionAuditLedger.add("KYC_UPGRADE: Verified with National ID");
            System.out.println("  [KYC Upgrade] Wallet " + walletId + " verified! Limit elevated to $50,000.00/day.");
        } else {
            System.out.println("  [KYC Failed] Invalid National ID document provided.");
        }
    }

    // Getters and Setters with Invariant Validation
    public String getWalletId() { return walletId; }
    public double getCurrentBalance() { return currentBalance; }
    public boolean isKycVerified() { return kycVerified; }
    public double getDailyTransferLimit() { return dailyTransferLimit; }
    public boolean isFrozen() { return isFrozen; }
    public void setFrozen(boolean frozen) { this.isFrozen = frozen; }

    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be blank");
        }
        this.accountHolderName = accountHolderName.trim();
    }

    // Defensive Copy of Audit Ledger
    public List<String> getTransactionAuditLedger() {
        return Collections.unmodifiableList(transactionAuditLedger);
    }
}
