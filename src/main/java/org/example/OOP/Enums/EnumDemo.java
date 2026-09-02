package org.example.OOP.Enums;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * ============================================================================
 * MODULE: ENUMS (ADVANCED JAVA ENUMERATIONS & PATTERNS IN OOP)
 * ============================================================================
 * Domain: Enterprise HTTP Gateway, Payment Fee Strategies, & Order State Machine
 *
 * Core Concepts & Implementation Types Covered:
 *  1. Type-Safe Constants & Built-in Methods (`values()`, `valueOf()`, `name()`, `ordinal()`)
 *  2. Enum with Custom Fields, Private Constructor & Lookup Methods (`HttpStatus`)
 *  3. Enum with Abstract Methods (Constant-Specific Strategy Pattern - `PaymentSettlementTier`)
 *  4. Enum Implementing Interfaces (`CloudStorageTier implements CostCalculatable`)
 *  5. Finite State Machine (FSM) with State Transition Guards (`OrderStatusFSM`)
 *  6. Modern Switch Expressions with Enums (Exhaustive Pattern Matching)
 *  7. High-Performance Enum Collections (`EnumSet` Bitmask & `EnumMap` Array)
 * ============================================================================
 */

// ============================================================================
// TYPE 1: ENUM WITH FIELDS, CONSTRUCTOR & LOOKUP METHODS
// ============================================================================
enum HttpStatus {
    OK(200, "Success", "Request processed successfully"),
    CREATED(201, "Success", "Resource created successfully"),
    BAD_REQUEST(400, "Client Error", "Invalid input syntax or parameters"),
    UNAUTHORIZED(401, "Client Error", "Authentication credentials missing or invalid"),
    FORBIDDEN(403, "Client Error", "Insufficient permissions to access resource"),
    NOT_FOUND(404, "Client Error", "Requested resource does not exist"),
    INTERNAL_SERVER_ERROR(500, "Server Error", "Unexpected server-side error occurred");

    private final int code;
    private final String category;
    private final String description;

    // Enum constructor is implicitly private
    HttpStatus(int code, String category, String description) {
        this.code = code;
        this.category = category;
        this.description = description;
    }

    public int getCode() { return code; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }

    public boolean isSuccess() {
        return this.code >= 200 && this.code < 300;
    }

    public boolean isClientError() {
        return this.code >= 400 && this.code < 500;
    }

    // Static lookup utility by HTTP status code
    public static HttpStatus fromCode(int statusCode) {
        for (HttpStatus status : values()) {
            if (status.code == statusCode) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown HTTP status code: " + statusCode);
    }
}

// ============================================================================
// TYPE 2: ENUM WITH ABSTRACT METHODS (CONSTANT-SPECIFIC STRATEGY PATTERN)
// ============================================================================
enum PaymentProcessingTier {
    STANDARD {
        @Override
        public double calculateProcessingFee(double transactionAmount) {
            // Standard: 2.9% + $0.30 flat fee
            return (transactionAmount * 0.029) + 0.30;
        }

        @Override
        public int getSettlementDays() {
            return 3;
        }
    },
    ENTERPRISE {
        @Override
        public double calculateProcessingFee(double transactionAmount) {
            // Enterprise Volume: 1.5% flat fee
            return transactionAmount * 0.015;
        }

        @Override
        public int getSettlementDays() {
            return 1; // Next-day settlement
        }
    },
    MICRO_TRANSACTION {
        @Override
        public double calculateProcessingFee(double transactionAmount) {
            // Micro-payments (< $5): 5% flat fee with no base fixed fee
            return transactionAmount * 0.05;
        }

        @Override
        public int getSettlementDays() {
            return 2;
        }
    };

    // Abstract methods that each enum constant MUST implement uniquely
    public abstract double calculateProcessingFee(double transactionAmount);
    public abstract int getSettlementDays();
}

// ============================================================================
// TYPE 3: ENUM IMPLEMENTING AN INTERFACE
// ============================================================================
interface BillableStorageTier {
    double calculateMonthlyCostPerGigabyte();
    String getSlaAvailability();
}

enum CloudStorageTier implements BillableStorageTier {
    HOT_STORAGE {
        @Override
        public double calculateMonthlyCostPerGigabyte() { return 0.023; } // $0.023 / GB / month
        @Override
        public String getSlaAvailability() { return "99.99% (Immediate Access)"; }
    },
    COOL_ARCHIVE {
        @Override
        public double calculateMonthlyCostPerGigabyte() { return 0.010; }
        @Override
        public String getSlaAvailability() { return "99.9% (1-minute retrieval)"; }
    },
    GLACIER_DEEP_ARCHIVE {
        @Override
        public double calculateMonthlyCostPerGigabyte() { return 0.00099; }
        @Override
        public String getSlaAvailability() { return "99.0% (12-hour retrieval)"; }
    };
}

// ============================================================================
// TYPE 4: ENUM AS A FINITE STATE MACHINE (FSM WITH TRANSITION RULES)
// ============================================================================
enum OrderState {
    CREATED {
        @Override
        public boolean canTransitionTo(OrderState nextState) {
            return nextState == PAID || nextState == CANCELLED;
        }
    },
    PAID {
        @Override
        public boolean canTransitionTo(OrderState nextState) {
            return nextState == PROCESSING || nextState == REFUNDED;
        }
    },
    PROCESSING {
        @Override
        public boolean canTransitionTo(OrderState nextState) {
            return nextState == SHIPPED || nextState == CANCELLED;
        }
    },
    SHIPPED {
        @Override
        public boolean canTransitionTo(OrderState nextState) {
            return nextState == DELIVERED;
        }
    },
    DELIVERED {
        @Override
        public boolean canTransitionTo(OrderState nextState) {
            return nextState == REFUNDED; // Returns allowed after delivery
        }
    },
    CANCELLED {
        @Override
        public boolean canTransitionTo(OrderState nextState) {
            return false; // Terminal state
        }
    },
    REFUNDED {
        @Override
        public boolean canTransitionTo(OrderState nextState) {
            return false; // Terminal state
        }
    };

    public abstract boolean canTransitionTo(OrderState nextState);
}

// ============================================================================
// DEMONSTRATION RUNNER
// ============================================================================
public class EnumDemo {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("       JAVA OOP: MODULE - ADVANCED ENUMS & DESIGN PATTERNS                ");
        System.out.println("==========================================================================\n");

        // 1. Enum with Custom Fields & Lookup
        System.out.println("--- 1. Enum with Fields, Constructors & Static Lookup ---");
        HttpStatus status404 = HttpStatus.fromCode(404);
        System.out.printf("HTTP %d [%s] -> %s (Is Client Error: %b)\n", 
                          status404.getCode(), status404.getCategory(), 
                          status404.getDescription(), status404.isClientError());

        HttpStatus status201 = HttpStatus.CREATED;
        System.out.printf("HTTP %d [%s] -> %s (Is Success: %b)\n", 
                          status201.getCode(), status201.getCategory(), 
                          status201.getDescription(), status201.isSuccess());
        System.out.println();

        // 2. Enum with Abstract Methods (Strategy Pattern)
        System.out.println("--- 2. Enum with Abstract Methods (Constant-Specific Strategy) ---");
        double orderAmount = 1000.00;
        for (PaymentProcessingTier tier : PaymentProcessingTier.values()) {
            double fee = tier.calculateProcessingFee(orderAmount);
            System.out.printf("  [%-18s] Order: $%.2f | Fee: $%.2f | Settlement: %d Business Days\n", 
                              tier.name(), orderAmount, fee, tier.getSettlementDays());
        }
        System.out.println();

        // 3. Enum Implementing Interfaces
        System.out.println("--- 3. Enum Implementing Interfaces (Cloud Storage Billing) ---");
        int gigabytes = 5000; // 5 TB
        for (CloudStorageTier storage : CloudStorageTier.values()) {
            double totalMonthlyBill = storage.calculateMonthlyCostPerGigabyte() * gigabytes;
            System.out.printf("  [%-21s] Monthly Bill for %d GB: $%.2f | SLA: %s\n", 
                              storage.name(), gigabytes, totalMonthlyBill, storage.getSlaAvailability());
        }
        System.out.println();

        // 4. Finite State Machine (FSM) State Transitions
        System.out.println("--- 4. Enum as Finite State Machine (Order Lifecycle Guards) ---");
        OrderState currentState = OrderState.CREATED;
        System.out.println("Current Order State: " + currentState);

        // Valid transition: CREATED -> PAID
        if (currentState.canTransitionTo(OrderState.PAID)) {
            System.out.println("  [Valid Transition] CREATED -> PAID allowed.");
            currentState = OrderState.PAID;
        }

        // Invalid illegal transition: PAID -> DELIVERED (must go through PROCESSING and SHIPPED)
        boolean canJumpToDelivered = currentState.canTransitionTo(OrderState.DELIVERED);
        System.out.printf("  [Guard Check] Can PAID jump directly to DELIVERED? %b (Prevented by FSM!)\n", 
                          canJumpToDelivered);
        System.out.println();

        // 5. Modern Switch Expressions with Enum (Java 14/17/21)
        System.out.println("--- 5. Modern Switch Expressions with Enums ---");
        String actionMessage = switch (currentState) {
            case CREATED -> "Order waiting for payment authorization.";
            case PAID -> "Payment confirmed. Routing order to fulfillment warehouse.";
            case PROCESSING -> "Order being picked and packed.";
            case SHIPPED -> "Order in transit with courier.";
            case DELIVERED -> "Order successfully received by customer.";
            case CANCELLED, REFUNDED -> "Order terminated.";
        };
        System.out.println("  [Switch Expression Dispatch]: " + actionMessage);
        System.out.println();

        // 6. High-Performance Enum Collections: EnumSet & EnumMap
        System.out.println("--- 6. High-Performance Collections: EnumSet & EnumMap ---");

        // EnumSet: Extremely fast bit-vector bitmask for Enum values
        EnumSet<HttpStatus> errorStatuses = EnumSet.of(
                HttpStatus.BAD_REQUEST, 
                HttpStatus.UNAUTHORIZED, 
                HttpStatus.FORBIDDEN, 
                HttpStatus.NOT_FOUND, 
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        System.out.println("  EnumSet of Error Statuses: " + errorStatuses);

        // EnumMap: Array-backed O(1) map optimized specifically for Enum keys
        EnumMap<PaymentProcessingTier, String> merchantRoutingTable = new EnumMap<>(PaymentProcessingTier.class);
        merchantRoutingTable.put(PaymentProcessingTier.STANDARD, "Stripe Standard Router");
        merchantRoutingTable.put(PaymentProcessingTier.ENTERPRISE, "Adyen Custom Direct Pipe");
        merchantRoutingTable.put(PaymentProcessingTier.MICRO_TRANSACTION, "Razorpay Fast-Batch Rail");

        System.out.println("  EnumMap Routing Entries:");
        merchantRoutingTable.forEach((tier, router) -> 
            System.out.printf("    -> %-18s maps to %s\n", tier, router)
        );

        System.out.println("\n==========================================================================");
    }
}
