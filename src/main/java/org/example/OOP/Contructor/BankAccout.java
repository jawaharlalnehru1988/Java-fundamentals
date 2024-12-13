package org.example.OOP.Contructor;

public class BankAccout {
    String accountNumber;
    String accountHolderName;
    double balance;

    BankAccout(String accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    BankAccout(String accountNumber){
        this.accountNumber = accountNumber;
        this.accountHolderName = "Unknown";
        this.balance = 0.0;
    }

    void deposit(double amount){
        System.out.println("Account Number: " + this.accountNumber + ", Account Holder: " + this.accountHolderName + ", Balance: " + this.balance);
        this.balance += amount;
        System.out.println("Deposited: " + amount);

        System.out.println("Balance: " + this.balance);
    }

    void withdraw(double amount){
        if(amount > this.balance){
            System.out.println("Insufficient balance, withdrawl faild");
        } else{
        this.balance -= amount;
        System.out.println("withdrawn: " + amount);
        System.out.println("Balance: " + this.balance);
        }

    }

    public static void main(String[] args) {
        BankAccout bankAccout = new BankAccout("12345");
        bankAccout.deposit(1000.00);
        bankAccout.withdraw(500.00);
    }
}
