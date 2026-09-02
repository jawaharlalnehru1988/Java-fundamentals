package org.example.OOP.AssociationCompositionAggregation;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================
 * MODULE 9: HAS-A RELATIONSHIPS (COMPOSITION VS AGGREGATION IN MICROSERVICES)
 * ============================================================================
 * Domain: Kubernetes Cloud Microservices Architecture & API Gateway Cluster
 *
 * Core Concepts Explained:
 *  1. IS-A vs HAS-A: Favor Composition over Inheritance principle.
 *  2. Composition (Strong HAS-A / Part-Of):
 *     - The child object lifecycle is completely controlled and owned by the parent.
 *     - Example: `MicroservicePod` HAS-A `InternalMemoryCache` and `WorkerThreadPool`.
 *       When the Pod is terminated in Kubernetes, the internal cache and thread pool
 *       are immediately destroyed with it.
 *  3. Aggregation (Weak HAS-A):
 *     - The child object has an independent lifecycle outside the parent.
 *     - Example: `ApiGatewayRouter` HAS-A `List<MicroserviceEndpoint>`.
 *       Microservice endpoints are passed into the gateway from outside; if the gateway
 *       is restarted, the underlying microservices continue running independently.
 * ============================================================================
 */

// ============================================================================
// 1. COMPOSITION: Strong Part-Of (Lifecycle Tied to Parent)
// ============================================================================

// Internal Memory Cache Component
class InternalMemoryCache {
    private final String cacheRegion;
    private int cachedEntriesCount;

    public InternalMemoryCache(String cacheRegion) {
        this.cacheRegion = cacheRegion;
        this.cachedEntriesCount = 0;
    }

    public void put(String key, String value) {
        cachedEntriesCount++;
    }

    public void purge() {
        System.out.println("      -> [Cache Purge] Evacuating " + cachedEntriesCount + " entries from L1 cache: " + cacheRegion);
        cachedEntriesCount = 0;
    }
}

// Microservice Pod Aggregate (COMPOSITION Root)
class MicroservicePod {
    private final String podId;
    private final String serviceName;
    private final InternalMemoryCache l1Cache; // Composition: Owned exclusively by this Pod

    public MicroservicePod(String podId, String serviceName) {
        this.podId = podId;
        this.serviceName = serviceName;
        // The L1 Cache is created directly inside the Pod constructor
        this.l1Cache = new InternalMemoryCache(podId + "-l1-cache");
    }

    public void handleRequest(String endpoint) {
        System.out.printf("    [Pod %s (%s)] Handling request to '%s'\n", podId, serviceName, endpoint);
        l1Cache.put(endpoint, "CACHED_RESPONSE_DATA");
    }

    public void terminatePod() {
        System.out.println("  [K8s Pod Termination] Terminating Pod: " + podId);
        // Destroying internal composition components
        l1Cache.purge();
        System.out.println("  [K8s Pod Termination] Pod " + podId + " resources deallocated.");
    }
}

// ============================================================================
// 2. AGGREGATION: Weak Has-A (Independent Lifecycles)
// ============================================================================

// Independent Microservice Endpoint Component
class MicroserviceEndpoint {
    private final String serviceName;
    private final String healthUrl;

    public MicroserviceEndpoint(String serviceName, String healthUrl) {
        this.serviceName = serviceName;
        this.healthUrl = healthUrl;
    }

    public String getServiceName() { return serviceName; }
    public String getHealthUrl() { return healthUrl; }
}

// API Gateway Cluster (AGGREGATION)
class ApiGatewayCluster {
    private final String clusterName;
    private final List<MicroserviceEndpoint> registeredRoutes; // Aggregation (Endpoints exist externally)

    public ApiGatewayCluster(String clusterName) {
        this.clusterName = clusterName;
        this.registeredRoutes = new ArrayList<>();
    }

    // Endpoints are injected from the outside
    public void registerService(MicroserviceEndpoint endpoint) {
        this.registeredRoutes.add(endpoint);
        System.out.printf("  [Gateway Registry] Registered '%s' at %s to Cluster: %s\n", 
                          endpoint.getServiceName(), endpoint.getHealthUrl(), this.clusterName);
    }

    public void displayRoutingTable() {
        System.out.println("\n  [Gateway Active Routing Table: " + clusterName + "]");
        for (MicroserviceEndpoint ep : registeredRoutes) {
            System.out.printf("    -> Route: /api/v1/%-20s -> Health: %s\n", 
                              ep.getServiceName().toLowerCase(), ep.getHealthUrl());
        }
    }
}

public class AssociationDemo {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println(" JAVA OOP: MODULE 9 - COMPOSITION VS AGGREGATION (MICROSERVICES CLOUD)   ");
        System.out.println("==========================================================================\n");

        // 1. Composition Demo (Strong Ownership & Lifecycle Binding)
        System.out.println("--- 1. COMPOSITION (MicroservicePod strongly owns its L1 Memory Cache) ---");
        MicroservicePod paymentPod = new MicroservicePod("k8s-pod-pay-7f9a1", "PAYMENT-SERVICE");
        paymentPod.handleRequest("/v1/charge");
        paymentPod.handleRequest("/v1/refund");
        paymentPod.terminatePod(); // Cache is purged and destroyed with the Pod
        System.out.println();

        // 2. Aggregation Demo (Independent Lifecycles)
        System.out.println("--- 2. AGGREGATION (API Gateway references independent Microservices) ---");
        // Microservices exist independently across the Kubernetes network
        MicroserviceEndpoint authService = new MicroserviceEndpoint("AUTH-SERVICE", "http://10.244.1.5:8080/health");
        MicroserviceEndpoint orderService = new MicroserviceEndpoint("ORDER-SERVICE", "http://10.244.1.8:8080/health");
        MicroserviceEndpoint inventoryService = new MicroserviceEndpoint("INVENTORY-SERVICE", "http://10.244.2.14:8080/health");

        ApiGatewayCluster gateway = new ApiGatewayCluster("PROD-KONG-GATEWAY-CLUSTER");
        gateway.registerService(authService);
        gateway.registerService(orderService);
        gateway.registerService(inventoryService);

        gateway.displayRoutingTable();

        System.out.println("\n  [Lifecycle Decoupling Insight]:");
        System.out.println("  Even if 'gateway' object is shut down, '" + authService.getServiceName() 
                           + "' continues running unharmed on its remote Kubernetes node!");
        System.out.println("\n==========================================================================");
    }
}
