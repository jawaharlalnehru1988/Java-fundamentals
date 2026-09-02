package org.example.SOLID.o_ocp;

/**
 * ============================================================================
 * O - OPEN / CLOSED PRINCIPLE (OCP) - REFACTORED / SOLUTION
 * ============================================================================
 * Solution:
 * 1. Define a `PaymentMethod` interface (abstraction).
 * 2. Implement concrete payment strategies (CreditCardPayment, PayPalPayment, UpiPayment, etc.).
 * 3. `PaymentProcessor` depends on the abstraction and does not care which
 *    concrete payment is passed.
 *
 * Benefits:
 * - To add a new payment method (e.g., ApplePayPayment), just create a new class
 *   implementing `PaymentMethod`. No existing code is touched!
 * - Open for extension (new payment methods), Closed for modification (existing classes untouched).
 */
public class OCPRemediation {

    // Abstraction
    public interface PaymentMethod {
        void pay(double amount);
    }

    // Concrete implementation 1: Credit Card
    public static class CreditCardPayment implements PaymentMethod {
        private final String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay(double amount) {
            System.out.println("[OCP SOLUTION] Paid $" + amount + " using Credit Card (ends with " +
                    cardNumber.substring(Math.max(0, cardNumber.length() - 4)) + ").");
        }
    }

    // Concrete implementation 2: PayPal
    public static class PayPalPayment implements PaymentMethod {
        private final String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(double amount) {
            System.out.println("[OCP SOLUTION] Paid $" + amount + " using PayPal account: " + email);
        }
    }

    // Concrete implementation 3: UPI
    public static class UpiPayment implements PaymentMethod {
        private final String upiId;

        public UpiPayment(String upiId) {
            this.upiId = upiId;
        }

        @Override
        public void pay(double amount) {
            System.out.println("[OCP SOLUTION] Paid $" + amount + " using UPI ID: " + upiId);
        }
    }

    // Concrete implementation 4: Google Pay
    public static class GooglePayPayment implements PaymentMethod {
        private final String googlePayId;
        public GooglePayPayment(String googlePayId) {
            // No specific fields needed for this example
            this.googlePayId = googlePayId; // Placeholder ID
        }
        @Override
        public void pay(double amount) {
            System.out.println(
                    "Paid $" + amount + " using Google Pay"
            );
        }
    }

    public static class ApplePayPayment implements PaymentMethod {
        private final String applePayId;
        public ApplePayPayment(String applePayId) {
            // No specific fields needed for this example
            this.applePayId = applePayId; // Placeholder ID
        }
        @Override
        public void pay(double amount) {
            System.out.println(
                    "Paid $" + amount + " using Apple Pay"
            );
        }
    }
    // High-level processor: Never changes when new payment types are introduced!
    public static class PaymentProcessor {
        public void processPayment(PaymentMethod paymentMethod, double amount) {
            paymentMethod.pay(amount);
        }
    }
}
