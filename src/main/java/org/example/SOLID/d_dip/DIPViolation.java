package org.example.SOLID.d_dip;

/**
 * ============================================================================
 * D - DEPENDENCY INVERSION PRINCIPLE (DIP) - VIOLATION EXAMPLE
 * ============================================================================
 * Definition:
 * 1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
 * 2. Abstractions should not depend on details. Details should depend on abstractions.
 *
 * Problem with this class:
 * - `NotificationService` (high-level policy) creates concrete instances of
 *   `EmailSender` and `SmsSender` (low-level modules) directly using `new`.
 * - Tightly coupled: We cannot swap out or mock `EmailSender` or `SmsSender` during unit testing.
 * - Adding a new sender (e.g. WhatsAppSender) requires modifying `NotificationService`.
 */
public class DIPViolation {

    // Low-level module 1
    public static class EmailSender {
        public void sendEmail(String message) {
            System.out.println("[VIOLATION] Sending Email: " + message);
        }
    }

    // Low-level module 2
    public static class SmsSender {
        public void sendSms(String message) {
            System.out.println("[VIOLATION] Sending SMS: " + message);
        }
    }

    // High-level module: Tightly coupled to concrete low-level classes!
    public static class NotificationService {
        private final EmailSender emailSender;
        private final SmsSender smsSender;

        public NotificationService() {
            // Hardcoded concrete dependencies using 'new'
            this.emailSender = new EmailSender();
            this.smsSender = new SmsSender();
        }

        public void notifyByEmail(String msg) {
            emailSender.sendEmail(msg);
        }

        public void notifyBySms(String msg) {
            smsSender.sendSms(msg);
        }
    }
}
