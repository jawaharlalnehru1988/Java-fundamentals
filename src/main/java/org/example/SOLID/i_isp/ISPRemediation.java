package org.example.SOLID.i_isp;

/**
 * ============================================================================
 * I - INTERFACE SEGREGATION PRINCIPLE (ISP) - REFACTORED / SOLUTION
 * ============================================================================
 * Solution:
 * Break down the fat interface into smaller, focused, role-specific interfaces:
 * 1. `Printer` -> `print(doc)`
 * 2. `Scanner` -> `scan(doc)`
 * 3. `FaxMachine` -> `fax(doc)`
 *
 * Benefits:
 * - `BasicPrinter` only implements `Printer`.
 * - `AdvancedOfficeMachine` implements `Printer`, `Scanner`, and `FaxMachine`.
 * - No class is forced to implement dummy or unsupported methods.
 */
public class ISPRemediation {

    // Small, segregated interfaces
    public interface Printer {
        void print(String document);
    }

    public interface Scanner {
        void scan(String document);
    }

    public interface FaxMachine {
        void fax(String document);
    }

    // Basic printer implements only what it can do
    public static class BasicPrinter implements Printer {
        @Override
        public void print(String document) {
            System.out.println("[ISP SOLUTION] Basic Printer printing: " + document);
        }
    }

    // Advanced machine implements multiple focused interfaces
    public static class AdvancedOfficeMachine implements Printer, Scanner, FaxMachine {
        @Override
        public void print(String document) {
            System.out.println("[ISP SOLUTION] Advanced Machine printing: " + document);
        }

        @Override
        public void scan(String document) {
            System.out.println("[ISP SOLUTION] Advanced Machine scanning: " + document);
        }

        @Override
        public void fax(String document) {
            System.out.println("[ISP SOLUTION] Advanced Machine faxing: " + document);
        }
    }
}
