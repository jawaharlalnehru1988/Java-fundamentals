package org.example.SOLID.l_lsp;

/**
 * ============================================================================
 * L - LISKOV SUBSTITUTION PRINCIPLE (LSP) - REFACTORED / SOLUTION
 * ============================================================================
 * Solution:
 * 1. Base class `Bird` only includes properties and behaviors common to ALL birds (e.g., eat, name).
 * 2. Create a separate interface or subtype `FlyingBird` (or `Flyable`) for birds that can fly.
 * 3. `Sparrow` extends `FlyingBird` (or implements `Flyable`), while `Ostrich` extends only `Bird`.
 *
 * Benefits:
 * - Every subclass can safely substitute its parent without throwing unexpected exceptions.
 */
public class LSPRemediation {

    // Base class for all birds
    public static abstract class Bird {
        private final String name;

        public Bird(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void eat() {
            System.out.println("[LSP SOLUTION] " + name + " is eating food.");
        }
    }

    // Capability interface for birds that can fly
    public interface Flyable {
        void fly();
    }

    // Sparrow can fly
    public static class Sparrow extends Bird implements Flyable {
        public Sparrow() {
            super("Sparrow");
        }

        @Override
        public void fly() {
            System.out.println("[LSP SOLUTION] " + getName() + " is flying swiftly.");
        }
    }

    // Ostrich cannot fly, so it doesn't implement Flyable
    public static class Ostrich extends Bird {
        public Ostrich() {
            super("Ostrich");
        }

        public void run() {
            System.out.println("[LSP SOLUTION] " + getName() + " is running at 70 km/h.");
        }
    }
}
