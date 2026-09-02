# ☕ Enterprise Masterclass: Object-Oriented Programming (OOP) in Java

Welcome to the **Production-Grade Java Object-Oriented Programming (OOP) Guide**. Every module is built around **real-world enterprise systems** (Fintech payment gateways, cloud infrastructure, distributed rate limiters, e-commerce order pipelines, and microservice clusters) rather than academic toy examples.

---

## 🎬 YouTube Video Curriculum & Package Architecture

```
org.example.OOP
│
├── 📂 ClassesAndObjects/                   # Module 1: E-Commerce Order Fulfillment & Cart Pipeline
│   └── ClassesAndObjectsDemo.java
│
├── 📂 Constructors/                       # Module 2: Cloud Database Connection Pool & Env Cloner
│   ├── DatabasePoolConfig.java
│   ├── Student.java
│   └── ConstructorsDemo.java
│
├── 📂 StaticKeyword/                      # Module 3: Distributed API Gateway, Rate Limiter & Token KMS
│   └── StaticKeywordDemo.java
│
├── 📂 Encapsulation/                      # Module 4: Fintech Digital Wallet & KYC Compliance Invariants
│   ├── DigitalWalletAccount.java
│   ├── Employee.java
│   └── EncapsulationDemo.java
│
├── 📂 Inheritance/                        # Module 5: Enterprise Role-Based Access Control (RBAC) System
│   └── InheritanceDemo.java
│
├── 📂 Polymorphism/                       # Module 6: Global Multi-Provider Payment Gateway Orchestrator
│   └── PolymorphismDemo.java
│
├── 📂 Abstraction/                        # Module 7: Multi-Channel Alert Notification Pipeline (SendGrid/Twilio/FCM)
│   └── AbstractionDemo.java
│
├── 📂 Interfaces/                         # Module 8: Multi-Cloud Object Storage (S3/Azure/GCS) & Auditing
│   └── InterfacesDemo.java
│
├── 📂 AssociationCompositionAggregation/  # Module 9: Kubernetes Microservices & API Gateway Cluster
│   └── AssociationDemo.java
│
└── 📂 Composition/                        # Dedicated Module: Enterprise Order, Items & Payment Composition
    └── CompositionDemo.java
```

---

## 📋 Production Curriculum Breakdown & YouTube Walkthrough

### Module 1: Classes & Objects (`ClassesAndObjects/`)
- **Enterprise Domain**: **E-Commerce Order Fulfillment & Shopping Cart Processing Pipeline**
- **Core Concepts**:
  - Class Blueprint in Metaspace vs Physical Order Instances on the JVM Heap.
  - State (`orderId`, `status`, `items`, `taxRate`) and Behavior (`addItem`, `applyDiscount`, `confirmPayment`).
  - Heap memory isolation across concurrent enterprise customer orders.
- **Demo Runner**: [`ClassesAndObjectsDemo.java`](./ClassesAndObjects/ClassesAndObjectsDemo.java)
- **Execution Command**:
  ```bash
  java -cp target/classes org.example.OOP.ClassesAndObjects.ClassesAndObjectsDemo
  ```

---

### Module 2: Constructors & Constructor Chaining (`Constructors/`)
- **Enterprise Domain**: **Cloud Database Connection Pool Provisioner (`DatabasePoolConfig`)**
- **Core Concepts**:
  - Full Parameterized Constructor (AWS RDS Production with SSL and high connection limits).
  - Constructor Chaining via `this(...)` (Staging, Local Dev, and In-Memory CI/CD testing profiles).
  - Copy Constructor for multi-region read-replica cloning (`new DatabasePoolConfig(prodConfig)`).
- **Demo Runner**: [`ConstructorsDemo.java`](./Constructors/ConstructorsDemo.java)
- **Execution Command**:
  ```bash
  java -cp target/classes org.example.OOP.Constructors.ConstructorsDemo
  ```

---

### Module 3: The `static` Keyword (`StaticKeyword/`)
- **Enterprise Domain**: **Distributed API Gateway, Global Rate Limiter & JWT Key Vault**
- **Core Concepts**:
  - `static AtomicInteger`: Shared cluster-wide request counters in Metaspace.
  - `static` Cryptographic Utilities (`JwtTokenValidator` with private constructor).
  - `static { ... }` Block: Bootstrapping Hardware Security Module (HSM) KMS keys on JVM startup.
  - `static class`: Nested cluster health telemetry snapshots decoupled from gateway instances.
- **Demo Runner**: [`StaticKeywordDemo.java`](./StaticKeyword/StaticKeywordDemo.java)
- **Execution Command**:
  ```bash
  java -cp target/classes org.example.OOP.StaticKeyword.StaticKeywordDemo
  ```

---

### Module 4: Encapsulation & Data Hiding (`Encapsulation/`)
- **Enterprise Domain**: **Fintech Digital Wallet & KYC Invariant Protection (`DigitalWalletAccount`)**
- **Core Concepts**:
  - Data Hiding (`private` balance, KYC status, and security limits).
  - Business Invariant Enforcement: Preventing negative deposits, overdrawing beyond balance, and enforcing tiered transfer limits based on KYC verification.
  - Defensive Copying: Read-only views of the transaction audit ledger.
- **Demo Runner**: [`EncapsulationDemo.java`](./Encapsulation/EncapsulationDemo.java)
- **Execution Command**:
  ```bash
  java -cp target/classes org.example.OOP.Encapsulation.EncapsulationDemo
  ```

---

### Module 5: Inheritance (`Inheritance/`)
- **Enterprise Domain**: **Enterprise Identity & Role-Based Access Control (RBAC) Hierarchy**
- **Core Concepts**:
  - Base Superclass: `BaseUserAccount` (authentication, base permissions, MFA flags).
  - Single Inheritance: `CustomerAccount` (`loyaltyTier`, `walletCredit`, `ORDER_CREATE`).
  - Multilevel Inheritance: `BaseUserAccount` $\rightarrow$ `StaffMemberAccount` $\rightarrow$ `SecurityAdminAccount` (Hardware FIDO2 YubiKey authentication, KMS key rotation).
  - `super(...)` constructor chaining and permission escalation.
- **Demo Runner**: [`InheritanceDemo.java`](./Inheritance/InheritanceDemo.java)
- **Execution Command**:
  ```bash
  java -cp target/classes org.example.OOP.Inheritance.InheritanceDemo
  ```

---

### Module 6: Polymorphism (`Polymorphism/`)
- **Enterprise Domain**: **Global Multi-Provider Payment Gateway & Merchant Settlement Orchestrator**
- **Core Concepts**:
  - **Compile-Time Polymorphism (Method Overloading)**: `PaymentInitiationService.initiatePayment(...)` overloaded for Credit Card, Bank Wire ACH, and UPI.
  - **Runtime Polymorphism (Dynamic Method Dispatch)**: Base `PaymentGatewayProvider` resolved at runtime into `StripeGatewayProvider`, `PayPalGatewayProvider`, or `RazorpayGatewayProvider`.
  - Upcasting to generic gateway router and safe downcasting via `instanceof` to access provider-specific ML fraud detection (Stripe Radar).
- **Demo Runner**: [`PolymorphismDemo.java`](./Polymorphism/PolymorphismDemo.java)
- **Execution Command**:
  ```bash
  java -cp target/classes org.example.OOP.Polymorphism.PolymorphismDemo
  ```

---

### Module 7: Abstraction (`Abstraction/`)
- **Enterprise Domain**: **Multi-Channel Alert Notification Pipeline (SendGrid / Twilio / Firebase FCM)**
- **Core Concepts**:
  - Abstract Class (`NotificationDispatcher`): Common timeout, retry counts, and dead-letter queue (DLQ) logic.
  - Template Method Pattern: `dispatchWithRetry(...)` managing retries while delegating abstract `deliverMessage(...)` to specific channels.
  - Concrete Implementations: `SendGridEmailDispatcher` (HTML SMTP), `TwilioSmsDispatcher` (E.164 carrier routing), `FirebasePushDispatcher` (FCM/APNs JSON push).
- **Demo Runner**: [`AbstractionDemo.java`](./Abstraction/AbstractionDemo.java)
- **Execution Command**:
  ```bash
  java -cp target/classes org.example.OOP.Abstraction.AbstractionDemo
  ```

---

### Module 8: Interfaces (`Interfaces/`)
- **Enterprise Domain**: **Multi-Cloud Object Storage (AWS S3 / Azure Blob / GCS) & Auditing Engine**
- **Core Concepts**:
  - Multiple Interface Inheritance: `AmazonS3StorageService` implements `CloudBlobStorage`, `AuditableResource`, and `EncryptableResource`.
  - Default Methods (Java 8+): Pre-signed download URL generation on interface.
  - Static Interface Methods (Java 8+): S3/Blob key validation utility.
  - Functional Interface (`@FunctionalInterface`): Lambda-based GZIP/Brotli payload compression.
- **Demo Runner**: [`InterfacesDemo.java`](./Interfaces/InterfacesDemo.java)
- **Execution Command**:
  ```bash
  java -cp target/classes org.example.OOP.Interfaces.InterfacesDemo
  ```

---

### Module 9: Association, Composition & Aggregation (`AssociationCompositionAggregation/`)
- **Enterprise Domain**: **Kubernetes Microservices Architecture & API Gateway Cluster**
- **Core Concepts**:
  - **Composition (Strong Part-Of)**: `MicroservicePod` strictly owns its `InternalMemoryCache`. When the Pod terminates, the cache is purged and destroyed.
  - **Aggregation (Weak HAS-A)**: `ApiGatewayCluster` references independent `MicroserviceEndpoint` instances running across remote Kubernetes nodes.
  - "Favor Composition over Inheritance" in enterprise architecture.
- **Demo Runner**: [`AssociationDemo.java`](./AssociationCompositionAggregation/AssociationDemo.java)
- **Execution Command**:
  ```bash
  java -cp target/classes org.example.OOP.AssociationCompositionAggregation.AssociationDemo
  ```

---

### Dedicated Module: Composition ("Part-Of" Strong Ownership) (`Composition/`)
- **Enterprise Domain**: **Enterprise Cloud Order, Immutable Line Items & Composed Payment Record**
- **Core Concepts**:
  - `CustomerOrder` strictly owns and instantiates `ShippingAddress`, `List<OrderItem>`, and `PaymentRecord`.
  - When the `CustomerOrder` is destroyed or garbage collected, its composed components are deallocated.
  - "Favor Composition over Inheritance": How composition avoids fragile base classes.
- **Demo Runner**: [`CompositionDemo.java`](./Composition/CompositionDemo.java)
- **Execution Command**:
  ```bash
  java -cp target/classes org.example.OOP.Composition.CompositionDemo
  ```

---

## ⚖️ Interview Comparison Matrix

| Feature | Abstract Class | Interface |
| :--- | :--- | :--- |
| **Inheritance** | Single class inheritance (`extends`) | Multiple interface inheritance (`implements`) |
| **Methods** | Abstract, concrete, final, static, private | Abstract, `default`, `static`, `private` (Java 9+) |
| **State / Variables** | Instance variables + constants | Only `public static final` constants |
| **Constructors** | Yes (invoked via `super()`) | No constructors allowed |
| **Design Intent** | Partial implementation / code reuse in a hierarchy | Contract specification / capability tagging |

---

## 🚀 How to Run All Demonstrations
```bash
# Compile the entire project
mvn compile

# Module 1: Classes & Objects
java -cp target/classes org.example.OOP.ClassesAndObjects.ClassesAndObjectsDemo

# Module 2: Constructors
java -cp target/classes org.example.OOP.Constructors.ConstructorsDemo

# Module 3: Static Keyword
java -cp target/classes org.example.OOP.StaticKeyword.StaticKeywordDemo

# Module 4: Encapsulation
java -cp target/classes org.example.OOP.Encapsulation.EncapsulationDemo

# Module 5: Inheritance
java -cp target/classes org.example.OOP.Inheritance.InheritanceDemo

# Module 6: Polymorphism
java -cp target/classes org.example.OOP.Polymorphism.PolymorphismDemo

# Module 7: Abstraction
java -cp target/classes org.example.OOP.Abstraction.AbstractionDemo

# Module 8: Interfaces
java -cp target/classes org.example.OOP.Interfaces.InterfacesDemo

# Module 9: Composition vs Aggregation
java -cp target/classes org.example.OOP.AssociationCompositionAggregation.AssociationDemo

# Dedicated: Composition
java -cp target/classes org.example.OOP.Composition.CompositionDemo
```
