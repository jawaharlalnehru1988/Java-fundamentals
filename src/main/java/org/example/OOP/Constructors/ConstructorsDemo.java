package org.example.OOP.Constructors;

/**
 * ============================================================================
 * CONSTRUCTORS DEMO RUNNER (PRODUCTION ENTERPRISE WALKTHROUGH)
 * ============================================================================
 * Demonstrates all forms of constructors, chaining, and copy construction.
 * ============================================================================
 */
public class ConstructorsDemo {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("  JAVA OOP: MODULE 2 - CONSTRUCTORS (CLOUD DATABASE POOL PROVISIONER)     ");
        System.out.println("==========================================================================\n");

        // 1. Parameterized Constructor (Full Production Config)
        System.out.println("--- 1. Full Production Parameterized Constructor ---");
        DatabasePoolConfig prodConfig = new DatabasePoolConfig(
                "aws-rds-primary.cluster-xyz.us-east-1.rds.amazonaws.com",
                5432,
                "finance_ledger_db",
                "admin_app_user",
                "SecretVaultPass#2024",
                50,     // 50 connections
                10000,  // 10s timeout
                true    // SSL enabled
        );
        prodConfig.printConfigSummary("AWS RDS Production");
        System.out.println();

        // 2. Chained Constructor with this() (Staging Environment)
        System.out.println("--- 2. Staging Config (Constructor Chaining with this()) ---");
        DatabasePoolConfig stagingConfig = new DatabasePoolConfig(
                "staging-db.internal.net",
                5432,
                "finance_staging",
                "staging_user",
                "StagingPass#123"
        );
        stagingConfig.printConfigSummary("Staging / QA");
        System.out.println();

        // 3. Local Developer Machine Constructor
        System.out.println("--- 3. Local Developer Constructor (Minimal Parameters) ---");
        DatabasePoolConfig devConfig = new DatabasePoolConfig(
                "local_app_db",
                "postgres",
                "root"
        );
        devConfig.printConfigSummary("Local Developer");
        System.out.println();

        // 4. No-Arg Default Constructor (Test / CI/CD)
        System.out.println("--- 4. No-Arg Default Constructor (CI / Unit Testing) ---");
        DatabasePoolConfig testConfig = new DatabasePoolConfig();
        testConfig.printConfigSummary("CI/CD Test Profile");
        System.out.println();

        // 5. Copy Constructor (Cloning for Read-Replica in eu-central-1)
        System.out.println("--- 5. Copy Constructor (Cloning for Disaster Recovery Replica) ---");
        DatabasePoolConfig replicaConfig = new DatabasePoolConfig(prodConfig);
        replicaConfig.setHost("aws-rds-replica.eu-central-1.rds.amazonaws.com");

        replicaConfig.printConfigSummary("EU Central Read-Replica");
        System.out.println("Are prodConfig and replicaConfig distinct objects in Heap? " 
                           + (prodConfig != replicaConfig));
        System.out.println("\n==========================================================================");
    }
}
