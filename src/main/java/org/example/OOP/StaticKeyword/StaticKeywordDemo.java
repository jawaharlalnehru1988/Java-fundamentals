package org.example.OOP.StaticKeyword;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ============================================================================
 * MODULE 3: STATIC KEYWORD (ENTERPRISE DISTRIBUTED API GATEWAY & RATE LIMITER)
 * ============================================================================
 * Domain: High-Throughput API Gateway, Token Security & Cluster Telemetry
 *
 * Core Concepts Explained:
 *  1. Static Variables: Shared global memory in Metaspace; counts requests across all client sessions.
 *  2. Static Methods: Utility and cryptographic verification methods without object instantiation.
 *  3. Static Initialization Block: Executes once on class load to bootstrap SSL certs and config.
 *  4. Static Nested Class: Clean grouping of telemetry metrics independent of gateway instance.
 * ============================================================================
 */

// 1. Static API Rate Limiter
class ApiGatewayRateLimiter {
    // Shared state across all threads and gateway instances
    private static final int MAX_REQUESTS_PER_MINUTE = 100;
    private static final AtomicInteger totalClusterRequests = new AtomicInteger(0);
    private static String gatewayRegion = "us-east-1";

    // Instance fields for a specific client connection
    private final String clientId;
    private final String clientIp;
    private int clientRequestCount;

    public ApiGatewayRateLimiter(String clientId, String clientIp) {
        this.clientId = clientId;
        this.clientIp = clientIp;
        this.clientRequestCount = 0;
    }

    public boolean allowRequest() {
        int currentTotal = totalClusterRequests.incrementAndGet();
        this.clientRequestCount++;

        if (currentTotal > MAX_REQUESTS_PER_MINUTE) {
            System.out.printf("  [RATE LIMIT 429] Client '%s' (%s) throttled! Global cluster count: %d\n", 
                              clientId, clientIp, currentTotal);
            return false;
        }

        System.out.printf("  [GATEWAY 200 OK] Client '%s' request allowed. (Client: %d | Global Cluster: %d)\n", 
                          clientId, this.clientRequestCount, currentTotal);
        return true;
    }

    // Static Method: Cluster-wide administration
    public static int getGlobalClusterRequestCount() {
        return totalClusterRequests.get();
    }

    public static void resetGlobalCounters() {
        totalClusterRequests.set(0);
        System.out.println("  [GATEWAY ADMIN] Global cluster request metrics reset to 0.");
    }
}

// 2. Static Cryptographic Utility Class
class JwtTokenValidator {
    public static final String ALGORITHM = "HmacSHA256";
    public static final int DEFAULT_EXPIRATION_MINUTES = 60;

    // Private constructor prevents instantiation of static utility class
    private JwtTokenValidator() {}

    public static boolean isTokenExpired(long tokenIssuedTimestamp) {
        long currentTimestamp = System.currentTimeMillis();
        long maxLifetimeMs = DEFAULT_EXPIRATION_MINUTES * 60 * 1000L;
        return (currentTimestamp - tokenIssuedTimestamp) > maxLifetimeMs;
    }

    public static String generateAuthHeader(String bearerToken) {
        if (bearerToken == null || bearerToken.trim().isEmpty()) {
            throw new IllegalArgumentException("Bearer token cannot be blank");
        }
        return "Bearer " + bearerToken.trim();
    }
}

// 3. Static Initialization Block: Cloud Key Vault Bootstrap
class SecurityKeyVaultBootstrap {
    public static String activeSigningKeyId;
    public static boolean isVaultReady;

    // Static Block: Guaranteed to run exactly once when class is loaded into JVM
    static {
        System.out.println("  [JVM Static Init] Initializing Hardware Security Module (HSM) Vault...");
        activeSigningKeyId = "KMS-KEY-AES256-V3-PROD-EAST";
        isVaultReady = true;
        System.out.println("  [JVM Static Init] KMS Encryption Key '" + activeSigningKeyId + "' mounted successfully.");
    }

    public static void signPayload(String payload) {
        System.out.println("  [KMS Signer] Cryptographically signing payload with key: " + activeSigningKeyId);
    }
}

// 4. Static Nested Class: Cluster Health Metrics
class ClusterTelemetry {
    private static String clusterName = "EKS-PROD-K8S-CLUSTER";

    // Static Nested Class: Can be instantiated without outer class instance
    public static class MetricsSnapshot {
        private final double cpuUtilization;
        private final double memoryUsageMb;
        private final int activePodCount;

        public MetricsSnapshot(double cpuUtilization, double memoryUsageMb, int activePodCount) {
            this.cpuUtilization = cpuUtilization;
            this.memoryUsageMb = memoryUsageMb;
            this.activePodCount = activePodCount;
        }

        public void printTelemetryReport() {
            System.out.println("  [Cluster Telemetry Report]");
            System.out.println("    -> Cluster Name : " + clusterName); // Direct access to outer static field
            System.out.printf("    -> CPU Load     : %.1f%%\n", cpuUtilization);
            System.out.printf("    -> Memory Usage : %.2f MB\n", memoryUsageMb);
            System.out.println("    -> Active Pods  : " + activePodCount);
        }
    }
}

public class StaticKeywordDemo {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("   JAVA OOP: MODULE 3 - STATIC KEYWORD (API GATEWAY & RATE LIMITER)       ");
        System.out.println("==========================================================================\n");

        // 1. Static Variables across multiple API client connections
        System.out.println("--- 1. Static Variables (Global Shared Rate Limiter Counter) ---");
        ApiGatewayRateLimiter clientA = new ApiGatewayRateLimiter("PAYMENT-SERVICE", "10.0.1.15");
        ApiGatewayRateLimiter clientB = new ApiGatewayRateLimiter("USER-AUTH-SERVICE", "10.0.1.28");
        ApiGatewayRateLimiter clientC = new ApiGatewayRateLimiter("ANALYTICS-ENGINE", "10.0.2.90");

        clientA.allowRequest();
        clientB.allowRequest();
        clientA.allowRequest();
        clientC.allowRequest();

        System.out.println("Total Cluster Requests (via static method): " 
                           + ApiGatewayRateLimiter.getGlobalClusterRequestCount());
        System.out.println();

        // 2. Static Utility Methods (Invoked via ClassName without object creation)
        System.out.println("--- 2. Static Utility Methods (JWT Token Security) ---");
        long tokenTimestamp = System.currentTimeMillis() - (30 * 60 * 1000); // 30 mins ago
        System.out.println("Is 30-min-old JWT Token expired? " + JwtTokenValidator.isTokenExpired(tokenTimestamp));
        System.out.println("Auth Header: " + JwtTokenValidator.generateAuthHeader("eyJhbGciOiJIUzI1NiJ9.payload.sig"));
        System.out.println();

        // 3. Static Initialization Block
        System.out.println("--- 3. Static Initialization Block (Cloud Key Vault Bootstrap) ---");
        SecurityKeyVaultBootstrap.signPayload("TRANSACTION_ID=TX-99881&AMOUNT=5000.00");
        System.out.println();

        // 4. Static Nested Class
        System.out.println("--- 4. Static Nested Class (Cluster Health Telemetry Snapshot) ---");
        ClusterTelemetry.MetricsSnapshot snapshot = new ClusterTelemetry.MetricsSnapshot(42.5, 4096.0, 18);
        snapshot.printTelemetryReport();

        System.out.println("\n==========================================================================");
    }
}
