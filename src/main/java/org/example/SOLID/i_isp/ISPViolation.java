package org.example.SOLID.i_isp;

/**
 * ============================================================================
 * I - INTERFACE SEGREGATION PRINCIPLE (ISP) - VIOLATION EXAMPLE
 * ============================================================================
 * Definition: Clients should not be forced to depend upon interfaces/methods
 * that they do not use.
 *
 * Problem with this interface:
 * - `MultiFunctionDevice` is a "fat" interface containing print, scan, and fax.
 * - A basic printer that can only print is forced to implement `scan()` and `fax()`,
 *   often leaving them empty or throwing `UnsupportedOperationException`.
 */
public class ISPViolation {

    // "Fat" Interface
    public interface MultiFunctionDevice {
        void print(String document);
        void scan(String document);
        void fax(String document);
    }

    // Advanced machine uses all functions
    public static class AdvancedOfficePrinter implements MultiFunctionDevice {
        @Override
        public void print(String document) {
            System.out.println("[VIOLATION] Advanced printer printing: " + document);
        }

        @Override
        public void scan(String document) {
            System.out.println("[VIOLATION] Advanced printer scanning: " + document);
        }

        @Override
        public void fax(String document) {
            System.out.println("[VIOLATION] Advanced printer faxing: " + document);
        }
    }

    // Basic printer does not have scan or fax, but is forced to implement them!
    public static class BasicPrinter implements MultiFunctionDevice {
        @Override
        public void print(String document) {
            System.out.println("[VIOLATION] Basic printer printing: " + document);
        }

        @Override
        public void scan(String document) {
            // Unused / forced dummy implementation
            throw new UnsupportedOperationException("[VIOLATION ERROR] Basic printer cannot scan!");
        }

        @Override
        public void fax(String document) {
            // Unused / forced dummy implementation
            throw new UnsupportedOperationException("[VIOLATION ERROR] Basic printer cannot fax!");
        }
    }
}
