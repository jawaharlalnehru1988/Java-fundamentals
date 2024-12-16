package org.example.OOP.Interfaces;

@FunctionalInterface
public interface Runnable {
    int run(int a, int b);
}

class Running{
    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public int run(int a, int b) {
//                System.out.println("this is running");
//                return a + b;
//            }
//        };

        Runnable runnable = (a, b) -> {
            System.out.println("calculation is running");
            return a + b;
        };


        System.out.println( runnable.run(10, 20));
    }
}
