package myBank;

import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;

public class Main {
    private static Bank malgwiBank = new Bank();

    public static void main(String[] args) {
        startBank();
    }

    private static void startBank(){
        String mainMenu = """
                Welcome to Malgwi Bank
                1 -> Create Account
                2 -> Deposit
                3 -> Withdraw
                4 -> Transfer
                5 -> checkBalance
                6 -> Exit
                """;
        String userInput = input(mainMenu);
        switch (userInput){
            case "1" -> createAccount();
            case "2" -> deposit();
            case "3" -> withdraw();
            case "4" -> transfer();
            case "5" -> checkBalance();
            case "6" -> exit(6);
        }
    }

    private static void createAccount() {
        String accountName = input("Enter your account name");
        String pin = input("Enter your desired pin");
        malgwiBank.createAccountFor(accountName, pin);
        display(String.format("Account created for %s%n", accountName));
        startBank();
    }

    private static void deposit() {
        String accountNumber = input("Enter your account number");
        int amount = inputInt("Enter amount");
        try {
            malgwiBank.deposit(amount, accountNumber);
            display(String.format("Your have successfully deposited %d", amount));
        }
        catch (InvalidAmountException ex){
            display(ex.getMessage());
            deposit();
        }
        startBank();
    }

    private static void withdraw() {
        int amount = inputInt("Enter Amount to withdraw: ");
        String accountNumber = input("Enter Your Account Number");
        String pin = input("Enter Your Pin: ");
        try {
            malgwiBank.withdraw(amount, accountNumber, pin);
            display(String.format("You have successfully withdrawn %d", amount));
        }catch (InvalidAmountException | InsufficientFundException ex) {
            display(ex.getMessage());
            withdraw();
        }
        startBank();
    }

    private static void transfer(){
        String senderAccount = input("Enter account to transfer from: ");
        String receiverAccount = input(" Enter account to receive payment: ");
        int amount = inputInt("Enter amount to transfer: ");
        String pin = input("Enter Your Pin: ");
        malgwiBank.transfer(senderAccount, receiverAccount, amount, pin);
        display(String.format("You have successfully transferred %d to account %s", amount, receiverAccount));
        startBank();
    }

    private static void checkBalance(){
        String accountNumber = input("Enter your account number: ");
        String pin = input("Enter Your PIN");
        try {
            var balance = malgwiBank.findAccount(accountNumber).getBalance(pin);
            display(String.format("Your balance is %d", balance));
        } catch (InvalidPinException ex){
            display(ex.getMessage());
        }
        startBank();
    }

    private static int inputInt(String prompt) {
        display(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String input(String prompt){
        display(prompt);
        Scanner scanner = new Scanner(System.in);
        return  scanner.nextLine();
    }

    private static void display(String prompt){
        System.out.println(prompt);
    }
}
