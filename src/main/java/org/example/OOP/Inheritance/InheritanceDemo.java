package org.example.OOP.Inheritance;

import java.util.HashSet;
import java.util.Set;

/**
 * ============================================================================
 * MODULE 5: INHERITANCE (ENTERPRISE ROLE-BASED ACCESS CONTROL - RBAC)
 * ============================================================================
 * Domain: Enterprise Cloud User Identity & Permission Hierarchy
 *
 * Core Concepts Explained:
 *  1. IS-A Relationship: Customer IS-A UserAccount; SecurityAdmin IS-A StaffMember IS-A UserAccount.
 *  2. 'extends' Keyword: Inheriting core identity fields, authentication logic, and audit logging.
 *  3. 'super(...)' Constructor Chaining: Passing credentials up to base UserAccount constructor.
 *  4. Single, Multilevel, and Hierarchical Inheritance:
 *      - Single: CustomerAccount -> UserAccount
 *      - Multilevel: SecurityAdminAccount -> StaffMemberAccount -> UserAccount
 *      - Hierarchical: Multiple account types branching from UserAccount
 *  5. Method Overriding (@Override): Customizing permission checking per authorization role.
 * ============================================================================
 */

// Base Class (Superclass)
class BaseUserAccount {
    protected final String userId;
    protected final String email;
    protected String roleName;
    protected Set<String> grantedPermissions;
    protected boolean mfaEnabled;

    public BaseUserAccount(String userId, String email, String roleName, boolean mfaEnabled) {
        this.userId = userId;
        this.email = email;
        this.roleName = roleName;
        this.mfaEnabled = mfaEnabled;
        this.grantedPermissions = new HashSet<>();
        this.grantedPermissions.add("PROFILE_READ");
        this.grantedPermissions.add("PASSWORD_RESET");
    }

    public boolean authenticate(String token) {
        System.out.println("  [Auth Engine] Base authentication succeeded for user: " + this.email + " (" + this.roleName + ")");
        return true;
    }

    public boolean hasPermission(String permission) {
        return this.grantedPermissions.contains(permission);
    }

    public void displayAccountSummary() {
        System.out.printf("  -> User ID: %-15s | Email: %-25s | Role: %-15s | MFA: %b\n", 
                          userId, email, roleName, mfaEnabled);
    }
}

// 1. Single Inheritance: CustomerAccount IS-A BaseUserAccount
class CustomerAccount extends BaseUserAccount {
    private String loyaltyTier;
    private double walletCredit;

    public CustomerAccount(String userId, String email, String loyaltyTier, double walletCredit) {
        super(userId, email, "CUSTOMER", false); // Invoke parent constructor
        this.loyaltyTier = loyaltyTier;
        this.walletCredit = walletCredit;
        this.grantedPermissions.add("ORDER_CREATE");
        this.grantedPermissions.add("PAYMENT_EXECUTE");
    }

    public void checkoutOrder(double orderAmount) {
        System.out.printf("  [Customer Action] %s placing order for $%.2f (Loyalty Tier: %s)\n", 
                          this.email, orderAmount, this.loyaltyTier);
    }

    @Override
    public void displayAccountSummary() {
        super.displayAccountSummary();
        System.out.printf("     [Customer Extra] Loyalty Tier: %s | Wallet Credit: $%.2f\n", 
                          loyaltyTier, walletCredit);
    }
}

// 2. Multilevel Inheritance Step 1: StaffMemberAccount IS-A BaseUserAccount
class StaffMemberAccount extends BaseUserAccount {
    protected String department;
    protected String employeeBadgeId;

    public StaffMemberAccount(String userId, String email, String department, String badgeId, String role) {
        super(userId, email, role, true); // MFA mandatory for staff
        this.department = department;
        this.employeeBadgeId = badgeId;
        this.grantedPermissions.add("INTERNAL_DASHBOARD_ACCESS");
        this.grantedPermissions.add("TICKET_MANAGE");
    }

    public void resolveSupportTicket(String ticketId) {
        System.out.printf("  [Staff Action] Staff %s (%s) resolving customer ticket #%s\n", 
                          this.email, this.department, ticketId);
    }
}

// 2. Multilevel Inheritance Step 2: SecurityAdminAccount IS-A StaffMemberAccount IS-A BaseUserAccount
class SecurityAdminAccount extends StaffMemberAccount {
    private final int securityClearanceLevel;

    public SecurityAdminAccount(String userId, String email, String badgeId, int clearanceLevel) {
        super(userId, email, "INFRASTRUCTURE_SECURITY", badgeId, "SECURITY_ADMIN");
        this.securityClearanceLevel = clearanceLevel;
        // Escalated Privileges
        this.grantedPermissions.add("DATABASE_DROP");
        this.grantedPermissions.add("KMS_KEY_ROTATE");
        this.grantedPermissions.add("USER_SESSION_TERMINATE");
    }

    @Override
    public boolean authenticate(String token) {
        // Enforce Strict Hardware Token MFA for Security Admins
        System.out.println("  [Auth Engine] SECURITY_ADMIN Authentication -> Verifying YubiKey Hardware Token...");
        return super.authenticate(token);
    }

    public void rotateEncryptionKeys() {
        System.out.printf("  [ADMIN Sudo Action] Admin %s (Clearance L%d) rotating AWS KMS Master Keys...\n", 
                          this.email, this.securityClearanceLevel);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("   JAVA OOP: MODULE 5 - INHERITANCE (ENTERPRISE RBAC USER HIERARCHY)      ");
        System.out.println("==========================================================================\n");

        // 1. Single Inheritance (CustomerAccount -> BaseUserAccount)
        System.out.println("--- 1. Single Inheritance (CustomerAccount -> BaseUserAccount) ---");
        CustomerAccount customer = new CustomerAccount("USR-CUST-1001", "alex.morgan@retail.com", "PLATINUM", 250.0);
        customer.displayAccountSummary();
        customer.authenticate("AUTH_SESSION_TOKEN_123");
        customer.checkoutOrder(89.50);
        System.out.println("Can Customer place orders? " + customer.hasPermission("ORDER_CREATE"));
        System.out.println("Can Customer drop database? " + customer.hasPermission("DATABASE_DROP"));
        System.out.println();

        // 2. Multilevel Inheritance (SecurityAdminAccount -> StaffMemberAccount -> BaseUserAccount)
        System.out.println("--- 2. Multilevel Inheritance (Admin -> Staff -> BaseUser) ---");
        SecurityAdminAccount admin = new SecurityAdminAccount("USR-SEC-9009", "admin.sarah@enterprise.io", "BADGE-SEC-01", 5);
        admin.displayAccountSummary();
        admin.authenticate("YUBIKEY_HARDWARE_FIDO2_TOKEN");
        admin.resolveSupportTicket("INCIDENT-CRITICAL-502");
        admin.rotateEncryptionKeys();
        System.out.println("Can Admin rotate KMS keys? " + admin.hasPermission("KMS_KEY_ROTATE"));
        System.out.println("Can Admin manage tickets?  " + admin.hasPermission("TICKET_MANAGE"));

        System.out.println("\n==========================================================================");
    }
}
