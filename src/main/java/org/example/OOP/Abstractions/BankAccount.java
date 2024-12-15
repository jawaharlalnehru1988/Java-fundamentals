package org.example.OOP.Abstractions;

abstract class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    public void getAccountDetails(){
        System.out.printf("Account No: %s, Account Holder: %s, Balance: %.2f%n", accountNumber, accountHolderName, balance);
    }
}

class SavingsAccount extends BankAccount{
    private double minimumBalance;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double minimumBalance){
        super(accountNumber, accountHolderName, balance);
        this.minimumBalance = minimumBalance;
    }

    @Override
    void deposit(double amount){
        balance += amount;
        System.out.println("new balance: " + balance);
    }

    @Override
    void withdraw(double amount){
        if((balance - amount) > minimumBalance ){
            balance -= amount;
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Withdrawel denied. Balance would fall below minimum balance of " + minimumBalance);
        }
    }
}

class CurrentAccount extends BankAccount{
    private double overdraftlimit;

    public CurrentAccount(String accountNumber, String accountHolderName, double balance, double overdraftlimit){
        super(accountNumber, accountHolderName, balance);
        this.overdraftlimit = overdraftlimit;
    }

    @Override
    void deposit(double amount){
        balance += amount;
        System.out.println("New Balance: " + balance);
    }

    @Override
    void withdraw(double amount){
        if((balance - amount) >= (-overdraftlimit)){
            balance -= amount;
            System.out.println("New Balance: " + balance);
        } else{
            System.out.println("Withdrawl denied. Overdraft limit of " + overdraftlimit + " exceeded.");
        }
    }
}

class ExecutionBankTransaction {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("323489237492", "Hari Krishna", 5000.00, 1000);
        BankAccount current = new CurrentAccount("729234923424", "Keshava", 4000.00, 5000.00);

        savings.getAccountDetails();
        savings.deposit(3000.00);
        savings.withdraw(2000.00);
        System.out.println("-------------------------");

        current.getAccountDetails();
        current.deposit(50000.00);
        savings.withdraw(32212.00);



    }
}
