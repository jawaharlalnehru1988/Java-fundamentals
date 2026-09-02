package org.example.OOP.ClassesAndObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================
 * MODULE 1: CLASSES AND OBJECTS (PRODUCTION ENTERPRISE ARCHITECTURE)
 * ============================================================================
 * Domain: E-Commerce Order Fulfillment & Shopping Cart Processing Pipeline
 *
 * Core Concepts Explained:
 *  1. Class as a Blueprint: Defines fields (state) and methods (behavior) in Metaspace.
 *  2. Object as a Runtime Instance: Physical entity created with 'new' allocated on the Heap.
 *  3. The 'this' Reference: Points to the specific object executing the method.
 *  4. Instance Isolation: Multiple orders hold completely independent state in memory.
 * ============================================================================
 */

// Line Item inside an Order
class OrderItem {
    String sku;
    String productName;
    double unitPrice;
    int quantity;

    OrderItem(String sku, String productName, double unitPrice, int quantity) {
        this.sku = sku;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    double calculateSubtotal() {
        return this.unitPrice * this.quantity;
    }
}

// Order Status Enum
enum OrderStatus {
    PENDING, PAYMENT_CONFIRMED, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}

// The E-Commerce Order Aggregate
class ECommerceOrder {
    // State (Instance Variables - allocated per object on the Heap)
    String orderId;
    String customerEmail;
    OrderStatus status;
    List<OrderItem> items;
    double discountPercentage;
    double taxRate;

    // Behavior: Initialize Order
    void initialize(String orderId, String customerEmail, double taxRate) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.status = OrderStatus.PENDING;
        this.items = new ArrayList<>();
        this.discountPercentage = 0.0;
        this.taxRate = taxRate;
    }

    // Behavior: Add item
    void addItem(String sku, String name, double price, int qty) {
        if (this.status != OrderStatus.PENDING) {
            System.out.println("  [Error] Cannot modify order " + this.orderId + " once locked in status: " + this.status);
            return;
        }
        OrderItem item = new OrderItem(sku, name, price, qty);
        this.items.add(item);
        System.out.println("  [Cart] Added item: " + name + " (Qty: " + qty + ", Price: $" + price + ") to Order: " + this.orderId);
    }

    // Behavior: Apply Promo Code
    void applyDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
        System.out.println("  [Promo] Applied " + discountPercentage + "% discount to Order: " + this.orderId);
    }

    // Behavior: Calculate Grand Total
    double calculateGrandTotal() {
        double subtotal = 0.0;
        for (OrderItem item : this.items) {
            subtotal += item.calculateSubtotal();
        }
        double discountedSubtotal = subtotal * (1.0 - (this.discountPercentage / 100.0));
        double taxAmount = discountedSubtotal * (this.taxRate / 100.0);
        return discountedSubtotal + taxAmount;
    }

    // Behavior: State Transition
    void confirmPayment() {
        if (this.items.isEmpty()) {
            System.out.println("  [Payment Error] Cannot confirm empty order " + this.orderId);
            return;
        }
        this.status = OrderStatus.PAYMENT_CONFIRMED;
        System.out.printf("  [Payment Gateway] Order %s successfully paid! Grand Total: $%.2f\n", 
                          this.orderId, this.calculateGrandTotal());
    }

    void printOrderInvoice() {
        System.out.println("\n  ==================== INVOICE: " + this.orderId + " ====================");
        System.out.println("  Customer: " + this.customerEmail + " | Status: " + this.status);
        System.out.println("  Line Items:");
        for (OrderItem item : this.items) {
            System.out.printf("    - [%s] %-25s x%d @ $%.2f = $%.2f\n", 
                              item.sku, item.productName, item.quantity, item.unitPrice, item.calculateSubtotal());
        }
        System.out.printf("  Discount Applied: %.1f%%\n", this.discountPercentage);
        System.out.printf("  Applicable Tax  : %.1f%%\n", this.taxRate);
        System.out.printf("  GRAND TOTAL     : $%.2f\n", this.calculateGrandTotal());
        System.out.println("  ==============================================================");
    }
}

public class ClassesAndObjectsDemo {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("    JAVA OOP: MODULE 1 - CLASSES & OBJECTS (E-COMMERCE ORDER PIPELINE)    ");
        System.out.println("==========================================================================\n");

        // 1. Instantiating first independent Order on the Heap
        System.out.println("--- 1. Creating Order 1 (Enterprise B2B Client) ---");
        ECommerceOrder enterpriseOrder = new ECommerceOrder();
        enterpriseOrder.initialize("ORD-2024-B2B-8901", "procurement@techcorp.com", 8.25);
        enterpriseOrder.addItem("SKU-SRV-01", "Dell PowerEdge Server", 3200.00, 2);
        enterpriseOrder.addItem("SKU-SW-02", "Cisco Catalyst 48-Port Switch", 1150.00, 4);
        enterpriseOrder.applyDiscount(10.0); // 10% B2B corporate discount
        enterpriseOrder.confirmPayment();
        enterpriseOrder.printOrderInvoice();
        System.out.println();

        // 2. Instantiating second independent Order on the Heap
        System.out.println("--- 2. Creating Order 2 (Consumer Retail Customer) ---");
        ECommerceOrder retailOrder = new ECommerceOrder();
        retailOrder.initialize("ORD-2024-RET-5412", "sarah.connor@gmail.com", 6.50);
        retailOrder.addItem("SKU-MNT-99", "LG 34\" UltraWide Monitor", 499.99, 1);
        retailOrder.addItem("SKU-KBD-11", "Keychron Mechanical Keyboard", 89.99, 1);
        retailOrder.confirmPayment();
        retailOrder.printOrderInvoice();

        System.out.println("\n  [Heap Memory Insight]:");
        System.out.println("  'enterpriseOrder' and 'retailOrder' hold isolated state on the JVM heap.");
        System.out.println("  Total orders exist independently without state bleed.");
        System.out.println("\n==========================================================================");
    }
}
