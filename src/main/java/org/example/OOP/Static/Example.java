package org.example.OOP.Static;

public class Example {
    static int staticVar = 10;
    int instanceVar = 20;

     static void staticMethod(){
        System.out.println("Static Variable: " + staticVar);
//        System.out.println("Instance Variable: " + instanceVar);
    }

     void nonStaticMethod(){
         System.out.println("Static Variable: " + staticVar);
         System.out.println("Instance Variable: " + instanceVar);
     }
}
