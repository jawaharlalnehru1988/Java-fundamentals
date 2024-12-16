package org.example.OOP.Interfaces;

@FunctionalInterface
public interface Calculator {
    int operate(int a, int b);
}

class ExecuteCalculator {

    public static void main(String[] args) {

        Calculator addition = new Calculator() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
//        Calculator addition = (a, b) ->{
//            return a + b;
//        };

        Calculator subtraction = (a, b) -> a -b;
        Calculator multiplication = (a, b) -> a*b;
        Calculator division = (a, b) -> {
            if( b == 0){
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a /b;
        };

        System.out.println("Addition result: " + addition.operate(10, 5));
        System.out.println("Subtraction result: " + subtraction.operate(34, 2));
        System.out.println("multiplication result: " + multiplication.operate(54 , 3));
        try{
            System.out.println("Division result: " + division.operate(32, 2));
        } catch (ArithmeticException e){
            System.out.println("Execption: " + e.getMessage() );
        }
    }


}