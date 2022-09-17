package myBank;

//import java.util.Objects;

public class Account {
    private String pin;
    private String number;
    private String name;
    private int balance;

    public Account(){};
    public Account(String accountNumber, String accountName, String accountPin){
        pin = accountPin;
        number = accountNumber;
        name = accountName;
    }
    public int getBalance(String pin){
        if(!pin.equals(this.pin)) throw new InvalidPinException("Invalid PIN");
        return balance;
    }

    public void deposit(int amount) {
        boolean isValidAmount = isValidAmount(amount);
        if (!isValidAmount) throw new InvalidAmountException("Cannot deposit negative amount");
        balance = getBalance(pin) + amount;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }


    public void withdraw(int amount, String pin){
        boolean amountIsValid = balance >= amount && amount > 0;
        if (amount > balance) throw new InsufficientFundException("You cannot Withdraw above your balance");
        if (!amountIsValid) throw new InvalidAmountException("Cannot withdraw negative amount");
        else if (!isCorrect(pin)) throw new InvalidPinException("Invalid PIN");
        if(isCorrect(pin) && amountIsValid){
            balance -= amount;
        }
    }

    private static boolean isValidAmount(int amount) {
        return amount > 0;
    }

    private boolean isCorrect(String pin){
        if (!pin.equals(this.pin)) throw new InvalidPinException("Invalid PIN");
        return true;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
