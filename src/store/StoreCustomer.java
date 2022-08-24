package com.uncornWimps.store;

public class StoreCustomer {
    private int accountNumber;
    private int balance;
    private int totalItemsCharged;
    private int totalCreditsApplied;
    private int creditLimit;

    public StoreCustomer(){}

    public StoreCustomer(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public StoreCustomer(int accountNumber, int accountBalance, int totalItems, int totalCredits, int limit){
        this(accountNumber);
        balance = accountBalance;
        totalItemsCharged = totalItems;
        totalCreditsApplied = totalCredits;
        creditLimit = limit;
    }

    public int calculateBalance(){
        int balance = getBalance() + totalItemsCharged - totalCreditsApplied;
        setBalance(balance);
        return getBalance();
    }

    public boolean isCreditLimitExceeded(){
        boolean result = false;
        if(getBalance() > getCreditLimit()){
            result = true;
        }
        return result;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getTotalItemsCharged() {
        return totalItemsCharged;
    }

    public void setTotalItemsCharged(int totalItemsCharged) {
        this.totalItemsCharged = totalItemsCharged;
    }

    public int getTotalCreditsApplied() {
        return totalCreditsApplied;
    }

    public void setTotalCreditsApplied(int totalCreditsApplied) {
        this.totalCreditsApplied = totalCreditsApplied;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }
}
