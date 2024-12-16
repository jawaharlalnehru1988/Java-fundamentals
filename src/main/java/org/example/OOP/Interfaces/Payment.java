package org.example.OOP.Interfaces;

public interface Payment {
    void processPayment(double amount);
    void generateReceipt();
}

class CreditCardPayment implements Payment{
    @Override
    public void processPayment(double amount){
        System.out.println("payment processed successfully" + amount);
    }

    @Override
    public void generateReceipt(){
        System.out.println("Receipt: Payment successfull using credit card");
    }
}

class UPIPayment implements Payment {
    @Override
    public void processPayment(double amount){
        System.out.println("Payment of $" + amount+ "processed sucessfully");
    }

    @Override
    public void generateReceipt(){
        System.out.println("Receipt: payment successfully using UPI");
    }
}

class ExecutePayment{
    public static void main(String[] args) {
        Payment creditCard = new CreditCardPayment();
        Payment upiPay = new UPIPayment();

        creditCard.processPayment(2000.23);
        creditCard.generateReceipt();

        upiPay.processPayment(40000.00);
        upiPay.generateReceipt();

    }
}