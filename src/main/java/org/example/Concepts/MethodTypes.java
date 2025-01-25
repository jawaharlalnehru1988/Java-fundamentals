package org.example.Concepts;



public class MethodTypes {
    // Instance variable
    private String name;

    // Instance Method
    public void displayInstanceMethod() {
        System.out.println("Instance Method called. Name: " + name);
    }

    // Static Method
    public static void displayStaticMethod() {
        System.out.println("Static Method called.");
    }

    // Abstract Method
//    public abstract void displayAbstractMethod();

    // Final Method
    public final void displayFinalMethod() {
        System.out.println("Final Method called.");
    }

    // Constructor Method
    public MethodTypes(String name) {
        this.name = name;
    }

    // Getter Method
    public String getName() {
        return name;
    }

    // Setter Method
    public void setName(String name) {
        this.name = name;
    }

    // Overloaded Method
    public void displayOverloadedMethod() {
        System.out.println("No arguments provided.");
    }

    public void displayOverloadedMethod(String message) {
        System.out.println("Message: " + message);
    }

    // Overridden Method Example
    @Override
    public String toString() {
        return "MethodExamples{name='" + name + "'}";
    }

    public static void main(String[] args) {

        MethodTypes obj = new MethodTypes("Java");
        // Calling instance method
        obj.displayInstanceMethod();

        // Calling static method
        MethodTypes.displayStaticMethod();

        // Abstract method
//        obj.displayAbstractMethod();

        // Final method
        obj.displayFinalMethod();

        // Calling Constructor method

        MethodTypes obj1 = new MethodTypes("Java");
        System.out.println("Constructor called");

        // Using getter and setter methods
        System.out.println("Getter: " + obj.getName());
        obj.setName("Updated Name");
        System.out.println("Setter updated name: " + obj.getName());

        // Calling overloaded methods
        obj.displayOverloadedMethod();
        obj.displayOverloadedMethod("Hello from Java!");

        // Calling overridden method
        System.out.println(obj.toString());
    }
}

