package org.example.Concepts;

import java.util.ArrayList;
import java.util.List;

public class FinalKeywords {
   public static final int maxValue = 100;
//    maxValue = 200;

//    with reference
   public static final List<String> list = new ArrayList<>();


   //final with Parameters

    public void calculate(final int value){
//        value = value + 10;  // Compilation error: Cannot reassign a final parameter
    }


    //final with local variable

    public void method(){
        final int x = 10;
        System.out.println(x);
//        x = 20;  // Compilation error: Cannot reassign a final variable
    }

    public static void main(String[] args) {
            list.add("ram");
            list.add("shyam");
        System.out.println(list);
        System.out.println(maxValue);


    }
}


class Parent {
    public final void display() {
        System.out.println("this is a final method");
    }
}

class child extends Parent{

//    @Override
//    public void display(){
//        System.out.println("Trying to override");
//    }
}

final class FinalClass{
    public void show(){
        System.out.println("this is final class");
    }
}
//class Children extends FinalClass{
//
//}
