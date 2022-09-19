package creditCardValidator;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        startApp();
    }

    public static void startApp(){
        String menu = """
                CREDIT CARD VALIDITY CHECKER
                1. Enter Credit Card Number
                2. ENd
                """;
        String userInput = input(menu);
        switch (userInput){
            case "1" -> validityCheck();
            case "2" -> exit(2);
        }
    }

    private static void display(String prompt){
        System.out.println(prompt);
    }

    private static String input(String prompt){
        display(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static void validityCheck(){
        String cardNumber = input("Enter Your Credit Card number to check");
        try {
            if (CreditCard.isValidCreditCard(cardNumber)) System.out.println("Is valid");

        } catch (InvalidCreditCardNumberException | CreditCardLengthException exception){
            System.out.println(exception.getMessage());
        }
        startApp();
    }
}
