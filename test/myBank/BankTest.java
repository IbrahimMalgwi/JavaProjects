package myBank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank wemaBank;
    private Account account;
    @BeforeEach
    public void setUp(){
        wemaBank = new Bank();
    }
    @Test
    public void bankExistTest(){

        assertNotEquals(null, wemaBank);
        assertNotNull(wemaBank);
    }

    @Test
    public void accountCanBeCreatedTest(){

        wemaBank.createAccountFor("Banke Celina Owolabi", "2727");
        assertEquals(1, wemaBank.getNumberOfCustomers());
    }

    @Test
    public void create_findAccountByAccountNumberTest(){
        wemaBank.createAccountFor("Banke Celina Owolabi", "2727");
        assertEquals(1, wemaBank.getNumberOfCustomers());

        account = wemaBank.findAccount("1");
        assertEquals("Banke Celina Owolabi", account.getName());

    }

    @Test
    public  void customerCanDepositInHerAccountTest(){
        wemaBank.createAccountFor("Bank Celina Owoloba", "2727");
        wemaBank.deposit(2_000, "1");

        Account bankeAccount = wemaBank.findAccount("1");
        assertEquals(2_000, bankeAccount.getBalance("2727"));
    }

    @Test
    public void withdrawPositiveAmountFromAccount(){
        wemaBank.createAccountFor("Bank Celina Owoloba", "2727");
        wemaBank.deposit(2_000, "1");

        Account bankeAccount = wemaBank.withdraw(1000, "1", "2727");
        assertEquals(1000, bankeAccount.getBalance("2727"));
    }
    @Test
    public void withdrawNegativeAmountFromAccount(){
        wemaBank.createAccountFor("Bank Celina Owoloba", "2727");
        wemaBank.deposit(2_000, "1");

        Account bankeAccount = wemaBank.withdraw(-1000, "1", "2727");
        assertEquals(2000, bankeAccount.getBalance("2727"));
    }

    @Test
    public void bankCanTransfer(){
//       We have a bank
//       We have two accounts
        wemaBank.createAccountFor("Hadiza Roll-on", "needle");
        wemaBank.createAccountFor("Hopeson Roll-on", "thread");
//        account 1 has money
        wemaBank.deposit(5000, "1");
        assertEquals(5000, wemaBank.findAccount("1").getBalance("needle"));

//        When you transfer x from account1 to account2
        wemaBank.transfer("1", "2", 4900, "needle");
//        Check account 1 has been debited x and account 2 credited with x
        assertEquals(100, wemaBank.findAccount("1").getBalance("needle"));
        assertEquals(4900, wemaBank.findAccount("2").getBalance("thread"));



    }



}