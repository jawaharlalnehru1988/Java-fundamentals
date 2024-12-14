package org.example.OOP.Encapsulation;

public class BankAccount {


    private String accountNumber;
    private double balance;
    static String bankname;

    BankAccount(){
        bankname = "XYZ Bank";
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void changeBankName(String newName){
        bankname = newName;
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        System.out.println(BankAccount.bankname);
        BankAccount.changeBankName("State Bank");
        System.out.println(BankAccount.bankname);
    }

}
