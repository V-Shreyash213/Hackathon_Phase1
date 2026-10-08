import java.util.*;
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public void deposite(double amount){
        if (amount > 0){
            balance+=amount;
            System.out.println("Successfully deposited: "+amount);
        }
        else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
        } else if (amount > balance) {
            System.out.println("Transaction failed: Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public double checkBalance() {
        return balance;
    }
    public void displayAccount() {
        System.out.println(" Account Details ");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}
public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNum = input.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String holderName = input.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = input.nextDouble();

        BankAccount account = new BankAccount(accNum, holderName, initialBalance);

        System.out.print("\nEnter amount to deposit: ");
        double depAmount = input.nextDouble();
        account.deposite(depAmount);

        System.out.print("\nEnter amount to withdraw: ");
        double witAmount = input.nextDouble();
        account.withdraw(witAmount);

        account.displayAccount();
    }
}

