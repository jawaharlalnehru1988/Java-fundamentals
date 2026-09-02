package org.example.SOLID.l_lsp;

/**
 * ============================================================================
 * L - LISKOV SUBSTITUTION PRINCIPLE (LSP) - VIOLATION EXAMPLE
 * ============================================================================
 * Definition: Subtypes must be substitutable for their base types without
 * breaking client expectations or correctness.
 *
 * Problem with this code:
 * - `Ostrich` is a `Bird`, but ostriches cannot fly.
 * - Calling `fly()` on an `Ostrich` throws `UnsupportedOperationException`,
 *   which breaks any client expecting all `Bird` instances to fly without crashing!
 */
public class LSPViolation {

    public static class Bird {
        private final String name;

        public Bird(String name) {
            this.name = name;
        }

        public void fly() {
            System.out.println("[VIOLATION] " + name + " is flying high in the sky!");
        }

        public String getName() {
            return name;
        }
    }

    public static class Sparrow extends Bird {
        public Sparrow() {
            super("Sparrow");
        }
    }

    public static class Ostrich extends Bird {
        public Ostrich() {
            super("Ostrich");
        }

        @Override
        public void fly() {
            // Violating LSP: Cannot honor the base class contract!
            throw new UnsupportedOperationException("[VIOLATION ERROR] Ostriches cannot fly!");
        }
    }
}
