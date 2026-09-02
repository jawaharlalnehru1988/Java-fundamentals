package org.example.SOLID.s_srp;

/**
 * ============================================================================
 * S - SINGLE RESPONSIBILITY PRINCIPLE (SRP) - VIOLATION EXAMPLE
 * ============================================================================
 * Definition: A class should have one, and only one, reason to change.
 *
 * Problem with this class:
 * 1. It holds invoice data and calculates total (Business logic).
 * 2. It directly saves the invoice to a database (Persistence responsibility).
 * 3. It generates and sends email receipts (Notification responsibility).
 *
 * Why this is bad:
 * - If the tax calculation changes -> Modify this class.
 * - If we switch from MySQL to MongoDB -> Modify this class.
 * - If email formatting or SMTP server changes -> Modify this class.
 * This class has 3 different reasons to change, violating SRP!
 */
public class SRPViolation {

    public static class Invoice {
        private String id;
        private double amount;
        private double taxRate;

        public Invoice(String id, double amount, double taxRate) {
            this.id = id;
            this.amount = amount;
            this.taxRate = taxRate;
        }

        // Responsibility 1: Business Logic / Calculation
        public double calculateTotal() {
            return amount + (amount * taxRate);
        }

        // Responsibility 2: Database Persistence
        public void saveToDatabase() {
            System.out.println("[VIOLATION] Saving Invoice #" + id + " to MySQL Database...");
        }

        // Responsibility 3: Notification
        public void sendEmailNotification(String customerEmail) {
            System.out.println("[VIOLATION] Sending email receipt to " + customerEmail +
                    " for Invoice #" + id + " with Total = $" + calculateTotal());
        }
    }
}
