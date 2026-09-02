package org.example.OOP.Abstraction;

/**
 * ============================================================================
 * MODULE 7: ABSTRACTION (ENTERPRISE MULTI-CHANNEL NOTIFICATION PIPELINE)
 * ============================================================================
 * Domain: Multi-Channel Cloud Alert & Notification Dispatching System
 *
 * Core Concepts Explained:
 *  1. What is Abstraction: Hiding protocol complexity (SMTP, SMS telco APIs, FCM WebSockets)
 *     behind a clean high-level dispatcher contract.
 *  2. Abstract Class ('abstract'): Common state (retries, channelName, audit logs) & constructors.
 *  3. Abstract Method: Must be implemented uniquely by each channel delivery engine.
 *  4. Template Method Pattern: Concrete workflow method (`dispatchWithRetry`) orchestrating
 *     the abstract delivery method with standardized error handling.
 * ============================================================================
 */

// Abstract Base Notification Dispatcher
abstract class NotificationDispatcher {
    protected final String channelName;
    protected final int maxRetries;
    protected final int timeoutMs;

    // Abstract class constructor called by subclasses via super()
    public NotificationDispatcher(String channelName, int maxRetries, int timeoutMs) {
        this.channelName = channelName;
        this.maxRetries = maxRetries;
        this.timeoutMs = timeoutMs;
    }

    // Abstract Method: Subclasses MUST implement channel-specific transport
    protected abstract boolean deliverMessage(String recipient, String messageBody);

    // Concrete Template Method: Shared enterprise retry and audit pipeline
    public final void dispatchWithRetry(String recipient, String messageBody) {
        System.out.printf("  [Notification Pipeline] Starting dispatch via %s (Recipient: %s)...\n", 
                          channelName, recipient);
        int attempts = 0;
        boolean success = false;

        while (attempts < maxRetries && !success) {
            attempts++;
            try {
                success = deliverMessage(recipient, messageBody);
                if (success) {
                    System.out.printf("  [Delivered 200 OK] %s delivered successfully on attempt %d.\n", 
                                      channelName, attempts);
                }
            } catch (Exception e) {
                System.out.printf("  [Retry Warning] Attempt %d failed: %s\n", attempts, e.getMessage());
            }
        }

        if (!success) {
            System.out.printf("  [DEAD LETTER QUEUE] %s failed after %d retries for %s. Moved to DLQ.\n", 
                              channelName, maxRetries, recipient);
        }
        System.out.println();
    }
}

// Concrete Dispatcher 1: SendGrid Email Delivery Engine
class SendGridEmailDispatcher extends NotificationDispatcher {
    private final String apiKey;

    public SendGridEmailDispatcher(String apiKey) {
        super("SendGrid Email (SMTP/REST)", 3, 5000);
        this.apiKey = apiKey;
    }

    @Override
    protected boolean deliverMessage(String recipient, String messageBody) {
        if (!recipient.contains("@")) {
            throw new IllegalArgumentException("Invalid RFC-5322 email address format");
        }
        System.out.printf("    -> [SendGrid TLS Handshake] Rendering HTML email template to <%s>...\n", recipient);
        System.out.printf("    -> [SendGrid API] 250 OK: Message-ID <%s.sendgrid.net>\n", System.currentTimeMillis());
        return true;
    }
}

// Concrete Dispatcher 2: Twilio SMS Delivery Engine
class TwilioSmsDispatcher extends NotificationDispatcher {
    private final String accountSid;

    public TwilioSmsDispatcher(String accountSid) {
        super("Twilio Global SMS Carrier Gateway", 2, 3000);
        this.accountSid = accountSid;
    }

    @Override
    protected boolean deliverMessage(String recipient, String messageBody) {
        if (!recipient.startsWith("+")) {
            throw new IllegalArgumentException("Phone number must follow E.164 international standard (+1...)");
        }
        System.out.printf("    -> [Twilio Telephony] Routing 160-char SMS packet to carrier: %s\n", recipient);
        System.out.println("    -> [Twilio API] SMS SID: SM" + Long.toHexString(System.currentTimeMillis()) + " queued.");
        return true;
    }
}

// Concrete Dispatcher 3: Firebase Cloud Messaging (FCM) Push Engine
class FirebasePushDispatcher extends NotificationDispatcher {
    private final String fcmServerKey;

    public FirebasePushDispatcher(String fcmServerKey) {
        super("Firebase Cloud Messaging (FCM Push / APNs)", 3, 2000);
        this.fcmServerKey = fcmServerKey;
    }

    @Override
    protected boolean deliverMessage(String recipient, String messageBody) {
        System.out.printf("    -> [FCM Push] Broadcasting silent JSON payload to device token: %s...\n", recipient);
        System.out.println("    -> [Google APNs Gateway] APNs badge + sound notification delivered.");
        return true;
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("  JAVA OOP: MODULE 7 - ABSTRACTION (MULTI-CHANNEL NOTIFICATION PIPELINE)  ");
        System.out.println("==========================================================================\n");

        // Abstract references holding concrete channel instances
        NotificationDispatcher emailService = new SendGridEmailDispatcher("SG.prod_live_key_998811");
        NotificationDispatcher smsService = new TwilioSmsDispatcher("AC_twilio_account_sid_445566");
        NotificationDispatcher pushService = new FirebasePushDispatcher("FCM_SERVER_KEY_778899");

        // 1. Dispatching Email Notification
        System.out.println("--- 1. Dispatching Email Alert ---");
        emailService.dispatchWithRetry("admin.ops@datacenter.io", "CRITICAL ALERT: CPU load spike > 95%");

        // 2. Dispatching SMS OTP with Validation Failure Handling
        System.out.println("--- 2. Dispatching SMS Alert with Retry Handling ---");
        smsService.dispatchWithRetry("+14155552671", "Your 2FA Security Code is: 849201");

        // 3. Dispatching Mobile Push Notification
        System.out.println("--- 3. Dispatching Mobile App Push Notification ---");
        pushService.dispatchWithRetry("DEVICE_TOKEN_iOS_iPhone15Pro_d87a9f", "New Payment Received: +$2,500.00");

        System.out.println("==========================================================================");
    }
}
