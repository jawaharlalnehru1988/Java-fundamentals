package org.example.SOLID.d_dip;

/**
 * ============================================================================
 * D - DEPENDENCY INVERSION PRINCIPLE (DIP) - REFACTORED / SOLUTION
 * ============================================================================
 * Solution:
 * 1. Introduce an abstraction `MessageService` interface.
 * 2. Low-level modules (`EmailService`, `SmsService`, `WhatsAppService`) implement this interface.
 * 3. High-level module (`NotificationManager`) depends ONLY on the abstraction and receives
 *    the implementation via Constructor Injection.
 *
 * Benefits:
 * - High-level logic is decoupled from low-level communication channels.
 * - Easily mockable for unit tests.
 * - This is the core principle behind Spring's Inversion of Control (IoC) / Dependency Injection (DI)!
 */
public class DIPRemediation {

    // Abstraction
    public interface MessageService {
        void sendMessage(String recipient, String message);
    }

    // Low-level module 1
    public static class EmailService implements MessageService {
        @Override
        public void sendMessage(String recipient, String message) {
            System.out.println("[DIP SOLUTION] Sending Email to " + recipient + ": " + message);
        }
    }

    // Low-level module 2
    public static class SmsService implements MessageService {
        @Override
        public void sendMessage(String recipient, String message) {
            System.out.println("[DIP SOLUTION] Sending SMS to " + recipient + ": " + message);
        }
    }

    // Low-level module 3 (Extensible without altering NotificationManager)
    public static class WhatsAppService implements MessageService {
        @Override
        public void sendMessage(String recipient, String message) {
            System.out.println("[DIP SOLUTION] Sending WhatsApp message to " + recipient + ": " + message);
        }
    }

    // High-level module: Depends ONLY on abstraction `MessageService`
    public static class NotificationManager {
        private final MessageService messageService;

        // Constructor Injection (Dependency Inversion in action)
        public NotificationManager(MessageService messageService) {
            this.messageService = messageService;
        }

        public void notifyUser(String recipient, String message) {
            messageService.sendMessage(recipient, message);
        }
    }
}
