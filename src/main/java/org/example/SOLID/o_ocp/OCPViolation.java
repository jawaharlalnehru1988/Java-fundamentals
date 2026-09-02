package org.example.SOLID.o_ocp;

/**
 * ============================================================================
 * O - OPEN / CLOSED PRINCIPLE (OCP) - VIOLATION EXAMPLE
 * ============================================================================
 * Definition: Software entities (classes, modules, functions) should be
 * OPEN for extension, but CLOSED for modification.
 *
 * Problem with this class:
 * - Whenever we want to add a new payment method (e.g., Apple Pay, Crypto),
 *   we MUST modify the existing `processPayment` method.
 * - Modifying tested, working code introduces risks of regression bugs.
 */
public class OCPViolation {

    public static class PaymentService {

        public void processPayment(String paymentType, double amount) {
            if ("CREDIT_CARD".equalsIgnoreCase(paymentType)) {
                System.out.println("[VIOLATION] Processing Credit Card payment of $" + amount);
                // Credit card specific logic...
            } else if ("PAYPAL".equalsIgnoreCase(paymentType)) {
                System.out.println("[VIOLATION] Processing PayPal payment of $" + amount);
                // PayPal specific logic...
            } else if ("UPI".equalsIgnoreCase(paymentType)) {
                System.out.println("[VIOLATION] Processing UPI payment of $" + amount);
                // UPI specific logic...
            } else if ("GooglePay".equalsIgnoreCase(paymentType)) {
                System.out.println("[VIOLATION] Processing Google Pay payment of $" + amount);
                // Google Pay specific logic...

            } else if ("ApplePay".equalsIgnoreCase(paymentType)) {
                System.out.println("[VIOLATION] Processing Apple Pay payment of $" + amount);
                // Apple Pay specific logic...
            }
            else  {
                throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
            }
        }
    }
}
