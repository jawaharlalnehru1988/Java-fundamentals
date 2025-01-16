package org.example.Concepts;

interface InterfaceA{
    default void show(){
        System.out.println("Interface A");
    }
}

interface InterfaceB{
    default void show(){
        System.out.println("Interface B");
    }
}

 class DefaultKeyWord implements InterfaceA, InterfaceB {
   @Override
     public void show(){
       InterfaceA.super.show();
       InterfaceB.super.show();
       System.out.println("My class Implementation");
   }
}

interface Example{
    void abstractMethod();

    default void defaultMethod(){
        System.out.println("Default method");
    }
}


class RunClass{


public static void main(String[] args) {
 DefaultKeyWord defaultKeyWord = new DefaultKeyWord();
 defaultKeyWord.show();
}
}
