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

    private static void checkBalance(){
        String accountName = input("Enter your account name");
        String pin = input("Enter Your PIN");
        display(String.format("Balance is %s", malgwiBank.findAccount(accountName).getBalance(pin)));
        startBank();
    }
    private static void createAccount() {
        String accountName = input("Enter your account name");
        String pin = input("Enter your desired pin");
        malgwiBank.createAccountFor(accountName, pin);
        display(String.format("Account created for %s", accountName));
        startBank();
    }

    private static void transfer(){}

    private static void withdraw() {
    }

    private static void deposit() {
        String accountNumber = input("Enter your account number");
        int amount = inputInt("Enter amount");
        try {
            malgwiBank.deposit(amount, accountNumber);
        }
        catch (InvalidAmountException ex){
            display(ex.getMessage());
            deposit();
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
