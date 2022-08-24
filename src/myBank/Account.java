package myBank;

import java.util.Objects;

public class Account {

    private int balance;
    private String number;
    private String name;
    private String pin;
    private int withdraw;
    private int transfer;


    public Account(String accountNumber, String accountName, String accountPin) {
        pin = accountPin;
        number = accountNumber;
        name = accountName;
    }

    public int getBalance(String pin) {
        if (isCorrectPin(pin)) return balance;
        return 0;
    }

    public void deposit(int amount) {
        boolean isValidAMount = amount > 0;
        if (isValidAMount) balance = getBalance("1234") + amount;
    }

    public void withdraw(int amount, String pin) {
        if(pin.equals(this.pin)) {
            this.balance = getBalance(pin) - amount;
        }
        else
           getBalance("1234");
//        return balance;
    }

    boolean isCorrectPin(String pin){
        return pin.equals(this.pin);
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
