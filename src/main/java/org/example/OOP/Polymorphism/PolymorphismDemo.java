package org.example.OOP.Polymorphism;

/**
 * ============================================================================
 * MODULE 6: POLYMORPHISM (MULTI-PROVIDER PAYMENT GATEWAY ORCHESTRATOR)
 * ============================================================================
 * Domain: Global Fintech Payment Routing & Settlement Engine
 *
 * Core Concepts Explained:
 *  1. Compile-Time Polymorphism (Static Binding / Method Overloading):
 *     - Same method signature name (`initiatePayment`), multiple parameter configurations
 *       (Credit Card, Bank Wire ACH, UPI, Apple Pay).
 *  2. Runtime Polymorphism (Dynamic Method Dispatch / Method Overriding):
 *     - Polymorphic Gateway interface/class (`PaymentGatewayProvider`).
 *     - Concrete providers (`StripeProvider`, `PayPalProvider`, `RazorpayProvider`)
 *       implementing different fee structures and API calls.
 *  3. Upcasting & Downcasting:
 *     - Upcasting to generic provider for dynamic routing.
 *     - Safe downcasting with `instanceof` to access provider-specific 3D-Secure or chargeback APIs.
 * ============================================================================
 */

// 1. Compile-Time Polymorphism: Method Overloading in Payment Service
class PaymentInitiationService {
    // Overload 1: Credit / Debit Card
    public void initiatePayment(String orderId, double amount, String cardNumber, String cvv, String expiry) {
        String maskedCard = "****-****-****-" + cardNumber.substring(Math.max(0, cardNumber.length() - 4));
        System.out.printf("  [Overload: Card] Order %s | Amount $%.2f | Card: %s | Expiry: %s\n", 
                          orderId, amount, maskedCard, expiry);
    }

    // Overload 2: Bank Wire / ACH Transfer
    public void initiatePayment(String orderId, double amount, String accountNumber, String routingNumber) {
        System.out.printf("  [Overload: ACH Wire] Order %s | Amount $%.2f | Account: %s | Routing: %s\n", 
                          orderId, amount, accountNumber, routingNumber);
    }

    // Overload 3: Instant UPI (Unified Payments Interface)
    public void initiatePayment(String orderId, double amount, String upiVirtualAddress) {
        System.out.printf("  [Overload: UPI VPA] Order %s | Amount $%.2f | VPA: %s\n", 
                          orderId, amount, upiVirtualAddress);
    }
}

// 2. Runtime Polymorphism: Base Payment Gateway Provider
abstract class PaymentGatewayProvider {
    protected final String providerName;
    protected final double transactionFeePercentage;

    public PaymentGatewayProvider(String providerName, double transactionFeePercentage) {
        this.providerName = providerName;
        this.transactionFeePercentage = transactionFeePercentage;
    }

    // Abstract method: Each gateway executes transaction over its own REST/gRPC API
    public abstract boolean executeTransaction(String txId, double amount, String currency);

    public double calculateFee(double amount) {
        return amount * (this.transactionFeePercentage / 100.0);
    }
}

// Subclass 1: Stripe Gateway Provider
class StripeGatewayProvider extends PaymentGatewayProvider {
    public StripeGatewayProvider() {
        super("Stripe Payments API v2024", 2.9);
    }

    @Override
    public boolean executeTransaction(String txId, double amount, String currency) {
        double fee = calculateFee(amount);
        System.out.printf("  [Stripe REST API] Processed %s %.2f (Fee: $%.2f). 3D-Secure 2.0 passed. TxID: %s\n", 
                          currency, amount, fee, txId);
        return true;
    }

    // Stripe-specific capability
    public void triggerStripeRadarFraudCheck(String txId) {
        System.out.println("  [Stripe Radar ML] Machine Learning fraud score: 98/100 (Safe transaction for " + txId + ")");
    }
}

// Subclass 2: PayPal Gateway Provider
class PayPalGatewayProvider extends PaymentGatewayProvider {
    public PayPalGatewayProvider() {
        super("PayPal Express Checkout", 3.49);
    }

    @Override
    public boolean executeTransaction(String txId, double amount, String currency) {
        double fee = calculateFee(amount);
        System.out.printf("  [PayPal OAuth2] Captured %s %.2f via Buyer Wallet (Fee: $%.2f). TxID: %s\n", 
                          currency, amount, fee, txId);
        return true;
    }
}

// Subclass 3: Razorpay Gateway Provider (India / APAC)
class RazorpayGatewayProvider extends PaymentGatewayProvider {
    public RazorpayGatewayProvider() {
        super("Razorpay APAC Infrastructure", 2.0);
    }

    @Override
    public boolean executeTransaction(String txId, double amount, String currency) {
        double fee = calculateFee(amount);
        System.out.printf("  [Razorpay Gateway] Instant UPI / NetBanking settlement %s %.2f (Fee: $%.2f). TxID: %s\n", 
                          currency, amount, fee, txId);
        return true;
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("  JAVA OOP: MODULE 6 - POLYMORPHISM (GLOBAL PAYMENT GATEWAY ORCHESTRATOR) ");
        System.out.println("==========================================================================\n");

        // 1. Compile-Time Polymorphism (Method Overloading)
        System.out.println("--- 1. Compile-Time Polymorphism (Method Overloading) ---");
        PaymentInitiationService service = new PaymentInitiationService();
        service.initiatePayment("ORD-101", 149.99, "4111222233334444", "123", "12/28");
        service.initiatePayment("ORD-102", 5000.00, "9876543210", "ROUTING-021000021");
        service.initiatePayment("ORD-103", 25.00, "merchant@upi");
        System.out.println();

        // 2. Runtime Polymorphism (Dynamic Method Dispatch via Polymorphic Array)
        System.out.println("--- 2. Runtime Polymorphism (Dynamic Method Dispatch) ---");
        PaymentGatewayProvider[] activeGateways = {
                new StripeGatewayProvider(),
                new PayPalGatewayProvider(),
                new RazorpayGatewayProvider()
        };

        // Same method call executed against polymorphic references
        String testTxId = "TX-GLOBAL-99120";
        for (PaymentGatewayProvider gateway : activeGateways) {
            gateway.executeTransaction(testTxId, 250.00, "USD");
        }
        System.out.println();

        // 3. Upcasting and Safe Downcasting with instanceof
        System.out.println("--- 3. Upcasting & Safe Downcasting (Provider-Specific ML Fraud API) ---");
        PaymentGatewayProvider primaryRouter = new StripeGatewayProvider(); // Upcasting
        primaryRouter.executeTransaction("TX-RISK-5501", 1200.00, "USD");

        // Check actual runtime type before downcasting
        if (primaryRouter instanceof StripeGatewayProvider stripeProvider) {
            stripeProvider.triggerStripeRadarFraudCheck("TX-RISK-5501"); // Downcasted method invocation
        }

        System.out.println("\n==========================================================================");
    }
}
