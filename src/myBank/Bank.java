package myBank;

import java.util.Objects;

public class Bank {
    private int numberOfCustomer;
    private final Account[] accounts = new Account[10];
    public void createAccountFor(String accountName, String pin) {
        Account account = new Account((numberOfCustomer+1)+ "", accountName, pin);
        accounts[numberOfCustomer] = account;
        numberOfCustomer++;
    }
    public int getNumberOfCustomers() {
        return numberOfCustomer;
    }
    public Account findAccount(String accountNumber) {
        for(Account account : accounts){
            if(account.getNumber().equals(accountNumber))
                return account;
        }
        return null;
    }

    public void deposit(int amount, String accountNumber) {
        Account account =  findAccount(accountNumber);
        account.deposit(amount);
    }

    public Account withdraw(int amount, String accountNumber, String pin) {
        Account account = findAccount(accountNumber);
        account.getBalance(accountNumber);
        account.withdraw(amount, pin);
        return account;
    }

    public void transfer(String sender, String receiver, int amount, String pin) {
        Account senderAccount = findAccount(sender);
        Account receiverAccount = findAccount(receiver);

        senderAccount.withdraw(amount, pin);
        receiverAccount.deposit(amount);

    }
}
