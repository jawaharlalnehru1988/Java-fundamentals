package org.example.OOP.Encapsulation;

public class BankAccount {


    private String accountHolderName;
    private String accountNumber;
    private double balance;
    static double interestRate;
    static String bankname;

    BankAccount(){
        bankname = "XYZ Bank";
    }

    public void setInterestRate(double interestRate){
        BankAccount.interestRate = interestRate;
    }

    public double getInterestRate(){
        return BankAccount.interestRate;
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

    public static void changeBankName(String newName) {
        bankname = newName;

    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        System.out.println(BankAccount.bankname);
        BankAccount.changeBankName("State Bank");
        System.out.println(BankAccount.bankname);
    }

}
