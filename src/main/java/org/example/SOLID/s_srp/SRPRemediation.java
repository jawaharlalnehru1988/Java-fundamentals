package org.example.SOLID.s_srp;

/**
 * ============================================================================
 * S - SINGLE RESPONSIBILITY PRINCIPLE (SRP) - REFACTORED / SOLUTION
 * ============================================================================
 * Solution:
 * Separate the 3 concerns into 3 dedicated classes:
 * 1. Invoice: Solely responsible for invoice state and total calculation.
 * 2. InvoiceRepository: Solely responsible for database operations.
 * 3. InvoiceEmailService: Solely responsible for sending email notifications.
 *
 * Benefits:
 * - Each class has exactly ONE reason to change.
 * - Classes are reusable, maintainable, and easy to unit test independently.
 */
public class SRPRemediation {

    // 1. Invoice model & calculation logic only
    public static class Invoice {
        private final String id;
        private final double amount;
        private final double taxRate;

        public Invoice(String id, double amount, double taxRate) {
            this.id = id;
            this.amount = amount;
            this.taxRate = taxRate;
        }

        public String getId() {
            return id;
        }

        public double getAmount() {
            return amount;
        }

        public double calculateTotal() {
            return amount + (amount * taxRate);
        }
    }

    // 2. Persistence responsibility only
    public static class InvoiceRepository {
        public void save(Invoice invoice) {
            System.out.println("[SRP SOLUTION] Saving Invoice #" + invoice.getId() +
                    " (Total: $" + invoice.calculateTotal() + ") to Database.");
        }
    }

    // 3. Notification responsibility only
    public static class InvoiceEmailService {
        public void sendReceipt(Invoice invoice, String customerEmail) {
            System.out.println("[SRP SOLUTION] Sending email to " + customerEmail +
                    " for Invoice #" + invoice.getId() + " [Amount: $" + invoice.calculateTotal() + "]");
        }
    }
}
