package org.example.OOP.Encapsulation;

/**
 * ============================================================================
 * MODULE 4: ENCAPSULATION DEMO (FINTECH DIGITAL WALLET & INVARIANTS)
 * ============================================================================
 * Demonstrates data hiding, invariant validation, and defense against illegal state.
 * ============================================================================
 */
public class EncapsulationDemo {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("   JAVA OOP: MODULE 4 - ENCAPSULATION (FINTECH DIGITAL WALLET SYSTEM)     ");
        System.out.println("==========================================================================\n");

        // 1. Creating a Digital Wallet Account with initial constraints
        System.out.println("--- 1. Initializing Encapsulated Digital Wallet (Unverified Tier) ---");
        DigitalWalletAccount wallet = new DigitalWalletAccount("WLT-FIN-8821", "David Miller", 500.0, false);
        System.out.println("Wallet ID        : " + wallet.getWalletId());
        System.out.println("Holder Name      : " + wallet.getAccountHolderName());
        System.out.println("Initial Balance  : $" + wallet.getCurrentBalance());
        System.out.println("KYC Verified     : " + wallet.isKycVerified());
        System.out.println("Daily Limit      : $" + wallet.getDailyTransferLimit());
        System.out.println();

        // 2. Testing Invariant Protection (Guarding against illegal operations)
        System.out.println("--- 2. Testing Invariant Protections ---");

        // A. Attempting negative deposit
        try {
            System.out.println("Attempting negative deposit (-$100.00):");
            wallet.deposit(-100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  -> [Protected] Intercepted invalid input: " + e.getMessage());
        }

        // B. Attempting transfer exceeding KYC tier limit ($1000 limit)
        System.out.println("\nAttempting transfer of $3,500.00 on unverified account ($1,000.00 limit):");
        wallet.transfer("WLT-RECIPIENT-9999", 3500.0);

        // C. Legitimate deposit and transfer
        System.out.println("\nPerforming legitimate deposit of $800.00:");
        wallet.deposit(800.0);

        System.out.println("\nPerforming valid transfer of $250.00:");
        wallet.transfer("WLT-RECIPIENT-9999", 250.0);
        System.out.println();

        // 3. KYC Upgrade (Controlled state transition)
        System.out.println("--- 3. Controlled State Transition (KYC Verification Upgrade) ---");
        wallet.verifyKyc("NATIONAL-ID-987654321");
        System.out.println("New Daily Transfer Limit: $" + wallet.getDailyTransferLimit());

        // Now high-value transfer succeeds
        System.out.println("\nRetrying high-value transfer of $5,000.00 after deposit:");
        wallet.deposit(6000.0);
        wallet.transfer("WLT-RECIPIENT-9999", 5000.0);
        System.out.println();

        // 4. Inspecting Read-Only Audit Ledger
        System.out.println("--- 4. Immutable Audit Ledger (Defensive Copy) ---");
        for (String record : wallet.getTransactionAuditLedger()) {
            System.out.println("  [Audit Log] " + record);
        }

        System.out.println("\n==========================================================================");
    }
}
