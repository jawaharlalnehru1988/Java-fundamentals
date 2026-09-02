package org.example.OOP.Interfaces;

import java.nio.charset.StandardCharsets;

/**
 * ============================================================================
 * MODULE 8: INTERFACES (MULTI-CLOUD OBJECT STORAGE & AUDITING ENGINE)
 * ============================================================================
 * Domain: Multi-Cloud Object Storage (AWS S3 / Azure Blob / GCS) & Security Auditing
 *
 * Core Concepts Explained:
 *  1. What is an Interface: Pure capability contract defining WHAT operations are supported.
 *  2. Multiple Interface Inheritance: A class implements CloudBlobStorage, AuditableResource,
 *     and EncryptableStorage without diamond problem conflicts.
 *  3. Default Methods (Java 8+): Pre-signed URL generation utility provided directly on interface.
 *  4. Static Methods in Interface (Java 8+): Static blob-name validation utility.
 *  5. Functional Interface (@FunctionalInterface): SAM for Lambda-based data compression.
 * ============================================================================
 */

// 1. Primary Contract for Object Storage
interface CloudBlobStorage {
    // Abstract Methods: Must be implemented
    void putObject(String bucket, String key, byte[] data);
    byte[] getObject(String bucket, String key);
    void deleteObject(String bucket, String key);

    // Default Method (Java 8+): Backward-compatible signed URL generator
    default String generatePresignedDownloadUrl(String bucket, String key, int validMinutes) {
        long expiry = System.currentTimeMillis() + (validMinutes * 60 * 1000L);
        return String.format("https://%s.storage.cloudprovider.com/%s?expires=%d&sig=HMAC_SHA256_AUTO", 
                             bucket, key, expiry);
    }

    // Static Utility Method (Java 8+): Validates S3/Blob key naming rules
    static boolean isValidBlobKey(String key) {
        return key != null && !key.trim().isEmpty() && !key.contains("//") && !key.startsWith("/");
    }
}

// 2. Secondary Interface: SOC-2 / ISO-27001 Audit Compliance
interface AuditableResource {
    void emitSecurityAuditEvent(String action, String resourceKey, String actorId);
}

// 3. Tertiary Interface: AES-256 Client-Side Encryption
interface EncryptableResource {
    byte[] encryptAtRest(byte[] plainData, String kmsKeyId);
}

// Implementation 1: Amazon Web Services (AWS S3)
class AmazonS3StorageService implements CloudBlobStorage, AuditableResource, EncryptableResource {
    private final String awsRegion;

    public AmazonS3StorageService(String awsRegion) {
        this.awsRegion = awsRegion;
    }

    @Override
    public void putObject(String bucket, String key, byte[] data) {
        if (!CloudBlobStorage.isValidBlobKey(key)) {
            System.out.println("  [AWS S3 Error] Invalid S3 object key: " + key);
            return;
        }
        byte[] encrypted = encryptAtRest(data, "arn:aws:kms:us-east-1:123456789012:key/s3-key");
        System.out.printf("  [AWS S3 (%s)] PUT '%s' (%d bytes) to s3://%s/ (SSE-KMS Enabled)\n", 
                          awsRegion, key, encrypted.length, bucket);
        emitSecurityAuditEvent("S3_PUT_OBJECT", "s3://" + bucket + "/" + key, "IAM_ROLE_BACKEND_APP");
    }

    @Override
    public byte[] getObject(String bucket, String key) {
        System.out.println("  [AWS S3] GET s3://" + bucket + "/" + key);
        return "MOCK_S3_FILE_CONTENT".getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public void deleteObject(String bucket, String key) {
        System.out.println("  [AWS S3] DELETE s3://" + bucket + "/" + key);
        emitSecurityAuditEvent("S3_DELETE_OBJECT", key, "IAM_ROLE_BACKEND_APP");
    }

    @Override
    public void emitSecurityAuditEvent(String action, String resourceKey, String actorId) {
        System.out.printf("    -> [AWS CloudTrail Audit] Action: %s | Target: %s | Actor: %s\n", 
                          action, resourceKey, actorId);
    }

    @Override
    public byte[] encryptAtRest(byte[] plainData, String kmsKeyId) {
        System.out.println("    -> [AWS KMS Envelope Encryption] 256-bit AES GCM cipher applied.");
        return plainData; // Simulated cipher
    }
}

// 4. Functional Interface with Lambda Expressions
@FunctionalInterface
interface PayloadCompressionEngine {
    byte[] compress(byte[] rawData);
}

public class InterfacesDemo {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("   JAVA OOP: MODULE 8 - INTERFACES (MULTI-CLOUD OBJECT STORAGE & AUDIT)   ");
        System.out.println("==========================================================================\n");

        // 1. Static Interface Method Validation
        System.out.println("--- 1. Static Interface Method (Validating S3/Blob Keys) ---");
        System.out.println("Is 'reports/2024/q3_finance.pdf' valid? " + CloudBlobStorage.isValidBlobKey("reports/2024/q3_finance.pdf"));
        System.out.println("Is '/root/invalid//path.txt' valid?     " + CloudBlobStorage.isValidBlobKey("/root/invalid//path.txt"));
        System.out.println();

        // 2. Multiple Interface Implementation in Action
        System.out.println("--- 2. Multiple Interface Implementation (CloudBlob + Audit + Encryption) ---");
        CloudBlobStorage s3Client = new AmazonS3StorageService("us-east-1");
        byte[] sampleData = "CONFIDENTIAL_FINANCIAL_RECORDS_DATA_STREAM".getBytes(StandardCharsets.UTF_8);

        s3Client.putObject("enterprise-production-assets", "finance/q3_report.pdf", sampleData);
        System.out.println();

        // 3. Default Interface Method
        System.out.println("--- 3. Default Interface Method (Pre-signed URL Generator) ---");
        String presignedUrl = s3Client.generatePresignedDownloadUrl("enterprise-production-assets", "finance/q3_report.pdf", 15);
        System.out.println("Generated Pre-signed 15-min Download URL:\n  " + presignedUrl);
        System.out.println();

        // 4. Functional Interface with Lambdas
        System.out.println("--- 4. Functional Interface with Lambdas (Data Compression Strategy) ---");
        PayloadCompressionEngine gzipCompressor = data -> {
            System.out.printf("  [GZIP Compression] Compressed %d bytes to %d bytes (65%% ratio).\n", 
                              data.length, (int)(data.length * 0.35));
            return data;
        };

        gzipCompressor.compress(sampleData);

        System.out.println("\n==========================================================================");
    }
}
