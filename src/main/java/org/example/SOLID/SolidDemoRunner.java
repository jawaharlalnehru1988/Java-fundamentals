package org.example.SOLID;

import org.example.SOLID.s_srp.SRPRemediation;
import org.example.SOLID.o_ocp.OCPRemediation;
import org.example.SOLID.l_lsp.LSPRemediation;
import org.example.SOLID.i_isp.ISPRemediation;
import org.example.SOLID.d_dip.DIPRemediation;

import java.util.List;

/**
 * ============================================================================
 * SOLID PRINCIPLES - DEMO RUNNER
 * ============================================================================
 * Run this main class to see all 5 SOLID principles in action!
 */
public class SolidDemoRunner {

    public static void main(String[] args) {
        printHeader("1. S - SINGLE RESPONSIBILITY PRINCIPLE (SRP)");
        demonstrateSRP();

        printHeader("2. O - OPEN / CLOSED PRINCIPLE (OCP)");
        demonstrateOCP();

        printHeader("3. L - LISKOV SUBSTITUTION PRINCIPLE (LSP)");
        demonstrateLSP();

        printHeader("4. I - INTERFACE SEGREGATION PRINCIPLE (ISP)");
        demonstrateISP();

        printHeader("5. D - DEPENDENCY INVERSION PRINCIPLE (DIP)");
        demonstrateDIP();

        System.out.println("\n============================================================");
        System.out.println("All SOLID principle demonstrations completed successfully!");
        System.out.println("============================================================\n");
    }

    private static void demonstrateSRP() {
        SRPRemediation.Invoice invoice = new SRPRemediation.Invoice("INV-1001", 250.00, 0.18);
        SRPRemediation.InvoiceRepository repo = new SRPRemediation.InvoiceRepository();
        SRPRemediation.InvoiceEmailService emailService = new SRPRemediation.InvoiceEmailService();

        System.out.println("Invoice ID: " + invoice.getId() + ", Calculated Total: $" + invoice.calculateTotal());
        repo.save(invoice);
        emailService.sendReceipt(invoice, "customer@example.com");
    }

    private static void demonstrateOCP() {
        OCPRemediation.PaymentProcessor processor = new OCPRemediation.PaymentProcessor();

        OCPRemediation.PaymentMethod card = new OCPRemediation.CreditCardPayment("4111-2222-3333-4444");
        OCPRemediation.PaymentMethod paypal = new OCPRemediation.PayPalPayment("user@paypal.com");
        OCPRemediation.PaymentMethod upi = new OCPRemediation.UpiPayment("user@oksbi");
        OCPRemediation.PaymentMethod googlePay = new OCPRemediation.GooglePayPayment("user@googlepay");
        OCPRemediation.PaymentMethod applePay = new OCPRemediation.ApplePayPayment("user@applepay");


        processor.processPayment(card, 150.00);
        processor.processPayment(paypal, 75.50);
        processor.processPayment(upi, 42.00);
        processor.processPayment(googlePay, 99.99);
        processor.processPayment(applePay, 120.00);

    }

    private static void demonstrateLSP() {
        LSPRemediation.Bird sparrow = new LSPRemediation.Sparrow();
        LSPRemediation.Bird ostrich = new LSPRemediation.Ostrich();

        // Both honor the base Bird contract safely
        List<LSPRemediation.Bird> sanctuaryBirds = List.of(sparrow, ostrich);
        for (LSPRemediation.Bird bird : sanctuaryBirds) {
            bird.eat();
        }

        // Only flying birds implement Flyable
        if (sparrow instanceof LSPRemediation.Flyable flyingBird) {
            flyingBird.fly();
        }
        if (ostrich instanceof LSPRemediation.Ostrich runningBird) {
            runningBird.run();
        }
    }

    private static void demonstrateISP() {
        ISPRemediation.BasicPrinter simplePrinter = new ISPRemediation.BasicPrinter();
        ISPRemediation.AdvancedOfficeMachine allInOne = new ISPRemediation.AdvancedOfficeMachine();

        simplePrinter.print("Quarterly_Report.pdf");

        allInOne.print("Employee_Handbook.docx");
        allInOne.scan("Passport_Scan.png");
        allInOne.fax("Legal_Contract.pdf");
    }

    private static void demonstrateDIP() {
        // High-level NotificationManager receives dependency injected via constructor
        DIPRemediation.MessageService emailService = new DIPRemediation.EmailService();
        DIPRemediation.MessageService smsService = new DIPRemediation.SmsService();
        DIPRemediation.MessageService whatsAppService = new DIPRemediation.WhatsAppService();

        DIPRemediation.NotificationManager emailNotifier = new DIPRemediation.NotificationManager(emailService);
        emailNotifier.notifyUser("alice@example.com", "Your order #123 has been shipped!");

        DIPRemediation.NotificationManager smsNotifier = new DIPRemediation.NotificationManager(smsService);
        smsNotifier.notifyUser("+1-555-0199", "Your OTP is 482910");

        DIPRemediation.NotificationManager waNotifier = new DIPRemediation.NotificationManager(whatsAppService);
        waNotifier.notifyUser("+1-555-0199", "Your delivery driver is arriving soon!");
    }

    private static void printHeader(String title) {
        System.out.println("\n------------------------------------------------------------");
        System.out.println(title);
        System.out.println("------------------------------------------------------------");
    }
}
