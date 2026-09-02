package org.example.OOP.Constructors;

/**
 * ============================================================================
 * MODULE 2: CONSTRUCTORS (CLOUD DATABASE POOL CONFIGURATION)
 * ============================================================================
 * Domain: Cloud Microservice Database Connection Pool Bootstrapper
 *
 * Core Concepts Explained:
 *  1. Parameterized Constructor: Full dependency injection & state initialization.
 *  2. Constructor Overloading: Providing flexible config options for Dev / Staging / Prod.
 *  3. Constructor Chaining with 'this(...)': Eliminating code duplication by delegating to primary constructor.
 *  4. Default / No-Arg Constructor: Providing safe local defaults.
 *  5. Copy Constructor: Cloning configurations for multi-region replication.
 * ============================================================================
 */
public class DatabasePoolConfig {
    private String host;
    private int port;
    private String databaseName;
    private String username;
    private String password;
    private int maxPoolSize;
    private int connectionTimeoutMs;
    private boolean sslEnabled;

    // 1. Primary Parameterized Constructor (Full Production Configuration)
    public DatabasePoolConfig(String host, int port, String databaseName, String username, 
                              String password, int maxPoolSize, int connectionTimeoutMs, boolean sslEnabled) {
        this.host = (host != null && !host.trim().isEmpty()) ? host : "localhost";
        this.port = (port > 0) ? port : 5432;
        this.databaseName = (databaseName != null) ? databaseName : "production_db";
        this.username = username;
        this.password = password;
        this.maxPoolSize = Math.max(1, maxPoolSize);
        this.connectionTimeoutMs = Math.max(1000, connectionTimeoutMs);
        this.sslEnabled = sslEnabled;
    }

    // 2. Chained Constructor for Standard Staging/QA Environments (this() delegation)
    public DatabasePoolConfig(String host, int port, String databaseName, String username, String password) {
        // Delegates to primary constructor with standard pool defaults
        this(host, port, databaseName, username, password, 10, 5000, true);
    }

    // 3. Chained Constructor for Local Developer Machine
    public DatabasePoolConfig(String databaseName, String username, String password) {
        // Delegates with localhost defaults
        this("127.0.0.1", 5432, databaseName, username, password, 5, 3000, false);
    }

    // 4. Default / No-Arg Constructor (In-Memory H2 / SQLite test profile)
    public DatabasePoolConfig() {
        this("localhost", 5432, "test_db", "dev_user", "dev_pass", 2, 2000, false);
    }

    // 5. Copy Constructor (Cloning config for multi-region AWS read-replicas)
    public DatabasePoolConfig(DatabasePoolConfig source) {
        if (source != null) {
            this.host = source.host;
            this.port = source.port;
            this.databaseName = source.databaseName;
            this.username = source.username;
            this.password = source.password;
            this.maxPoolSize = source.maxPoolSize;
            this.connectionTimeoutMs = source.connectionTimeoutMs;
            this.sslEnabled = source.sslEnabled;
        }
    }

    public String getConnectionUrl() {
        return String.format("jdbc:postgresql://%s:%d/%s?ssl=%b", host, port, databaseName, sslEnabled);
    }

    public void printConfigSummary(String profileName) {
        System.out.println("  [" + profileName + " Profile]");
        System.out.println("    -> JDBC URL      : " + getConnectionUrl());
        System.out.println("    -> User          : " + username);
        System.out.println("    -> Max Pool Size : " + maxPoolSize + " connections");
        System.out.println("    -> Timeout       : " + connectionTimeoutMs + " ms");
        System.out.println("    -> SSL Required  : " + sslEnabled);
    }

    // Getters and Setters
    public void setHost(String host) { this.host = host; }
    public String getHost() { return host; }
    public int getPort() { return port; }
    public String getDatabaseName() { return databaseName; }
    public int getMaxPoolSize() { return maxPoolSize; }
}
