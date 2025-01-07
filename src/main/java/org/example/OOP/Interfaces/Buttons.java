package org.example.OOP.Interfaces;

public interface Buttons extends Calculator {

    public static void main(String[] args) {
        Calculator cal = new Calculator() {
            @Override
            public int operate(int a, int b) {
                return 0;
            };



        };


    }

}
