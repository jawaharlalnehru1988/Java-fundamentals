package org.example.OOP.Composition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ============================================================================
 * MODULE: COMPOSITION (STRONG "HAS-A" / "PART-OF" RELATIONSHIP)
 * ============================================================================
 * Domain: Enterprise Cloud Order Management & POS Terminal Lifecycle
 *
 * Core Principles of Composition:
 *  1. Strong Ownership ("Part-Of"):
 *     - The parent object (e.g. `Order`, `PaymentTerminal`) creates and strictly
 *       owns the lifecycle of its internal components.
 *     - If the parent object is destroyed or garbage collected, its child
 *       components cease to exist.
 *
 *  2. "Favor Composition over Inheritance" (Design Pattern Best Practice):
 *     - Inheritance (IS-A) creates tight coupling and fragile hierarchies.
 *     - Composition (HAS-A) allows modular, plug-and-play assembly of components
 *       without deep inheritance trees.
 *
 *  3. In this example:
 *     - `Order` HAS-A `PaymentSummary` (Composition)
 *     - `Order` HAS-A `ShippingAddress` (Composition)
 *     - `Order` HAS-A `List<OrderItem>` (Composition - items cannot exist without their order)
 * ============================================================================
 */

// Composed Component 1: Shipping Address (Part of Order)
class ShippingAddress {
    private final String street;
    private final String city;
    private final String state;
    private final String postalCode;
    private final String country;

    public ShippingAddress(String street, String city, String state, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getFormattedAddress() {
        return String.format("%s, %s, %s %s, %s", street, city, state, postalCode, country);
    }
}

// Composed Component 2: Order Item (Part of Order)
class OrderItem {
    private final String itemSku;
    private final String productName;
    private final double unitPrice;
    private final int quantity;

    public OrderItem(String itemSku, String productName, double unitPrice, int quantity) {
        this.itemSku = itemSku;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public double getItemTotal() {
        return this.unitPrice * this.quantity;
    }

    public String getItemDetails() {
        return String.format("    - [%s] %-25s x%d @ $%.2f = $%.2f", 
                             itemSku, productName, quantity, unitPrice, getItemTotal());
    }
}

// Composed Component 3: Payment Record (Part of Order)
class PaymentRecord {
    private final String paymentId;
    private final String paymentMethod;
    private final double amountPaid;
    private final String transactionStatus;

    public PaymentRecord(String paymentId, String paymentMethod, double amountPaid, String transactionStatus) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.transactionStatus = transactionStatus;
    }

    public String getPaymentSummary() {
        return String.format("    - Method: %s | TxID: %s | Paid: $%.2f | Status: %s", 
                             paymentMethod, paymentId, amountPaid, transactionStatus);
    }
}

// Composite Root: The Order (strictly owns Address, Items, and Payment)
class CustomerOrder {
    private final String orderId;
    private final String customerEmail;
    
    // COMPOSITION: These components are strictly owned and managed by this Order
    private final ShippingAddress shippingAddress;
    private final List<OrderItem> orderItems;
    private PaymentRecord paymentRecord; // Instantiated when payment completes

    public CustomerOrder(String orderId, String customerEmail, 
                         String street, String city, String state, String zip, String country) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        
        // Composed directly inside Order constructor (Lifecycle bound to Order)
        this.shippingAddress = new ShippingAddress(street, city, state, zip, country);
        this.orderItems = new ArrayList<>();
    }

    // Adding composed items
    public void addItem(String sku, String name, double price, int qty) {
        // Items are created and added directly into this order's internal list
        this.orderItems.add(new OrderItem(sku, name, price, qty));
        System.out.printf("  [Item Added] %s x%d added to Order #%s\n", name, qty, orderId);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem item : orderItems) {
            total += item.getItemTotal();
        }
        return total;
    }

    // Attaching composed payment component upon settlement
    public void processPayment(String paymentMethod, String txId) {
        double total = calculateTotal();
        // PaymentRecord is composed into this order
        this.paymentRecord = new PaymentRecord(txId, paymentMethod, total, "SETTLED_200_OK");
        System.out.printf("  [Payment Composed] Processed $%.2f via %s for Order #%s\n", total, paymentMethod, orderId);
    }

    public void printCompleteOrder() {
        System.out.println("\n  ==================== ORDER SPECIFICATION ====================");
        System.out.println("  Order ID      : " + orderId);
        System.out.println("  Customer Email: " + customerEmail);
        System.out.println("  Shipping Address (Composed Component):");
        System.out.println("    -> " + shippingAddress.getFormattedAddress());
        
        System.out.println("  Order Items (Composed Collection):");
        for (OrderItem item : orderItems) {
            System.out.println(item.getItemDetails());
        }
        System.out.printf("  Grand Total   : $%.2f\n", calculateTotal());

        if (paymentRecord != null) {
            System.out.println("  Payment Information (Composed Component):");
            System.out.println(paymentRecord.getPaymentSummary());
        }
        System.out.println("  =============================================================");
    }
}

public class CompositionDemo {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("       JAVA OOP: MODULE - COMPOSITION (STRONG HAS-A RELATIONSHIP)         ");
        System.out.println("==========================================================================\n");

        // 1. Creating Order with Composed ShippingAddress
        System.out.println("--- 1. Assembling Composed Order with Address & Items ---");
        CustomerOrder order = new CustomerOrder(
                "ORD-2024-99881",
                "sarah.jenkins@cloudtech.com",
                "100 Enterprise Way, Suite 400",
                "San Francisco",
                "CA",
                "94105",
                "USA"
        );

        // 2. Composing Line Items inside the Order
        order.addItem("SKU-MACBOOK-PRO", "Apple MacBook Pro 16\" M3", 2499.00, 1);
        order.addItem("SKU-MAGIC-MOUSE", "Apple Magic Mouse", 99.00, 1);
        order.addItem("SKU-USBC-DOCK", "CalDigit TS4 Thunderbolt Dock", 399.00, 1);
        System.out.println();

        // 3. Composing Payment Component
        System.out.println("--- 2. Composing Payment Record into Order ---");
        order.processPayment("Corporate Amex Card (ending in 4012)", "TX-AMEX-883910");

        // 4. Inspecting Composed Architecture
        order.printCompleteOrder();

        System.out.println("\n  [Composition Architectural Key Takeaways]:");
        System.out.println("  1. Strong Ownership: ShippingAddress, OrderItem, and PaymentRecord belong strictly to CustomerOrder.");
        System.out.println("  2. Lifecycle Dependency: When 'order' is garbage collected, all its composed items and address components are deleted with it.");
        System.out.println("  3. Flexibility: Order does not inherit from Address or Payment; it COMPOSES them!");

        System.out.println("\n==========================================================================");
    }
}
