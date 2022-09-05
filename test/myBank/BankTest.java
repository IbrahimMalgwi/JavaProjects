package myBank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank malgwiBank;
    private Account account;
    @BeforeEach
    public void setUp(){
        malgwiBank = new Bank();
    }
    @Test
    public void bankExistTest(){
        assertNotEquals(null, malgwiBank);
        assertNotNull(malgwiBank);
    }

    @Test
    public void accountCanBeCreatedTest(){
        malgwiBank.createAccountFor("Banke Celina Owolabi", "2727");
        assertEquals(1, malgwiBank.getNumberOfCustomers());
    }

    @Test
    public void create_findAccountByAccountNumberTest(){
        malgwiBank.createAccountFor("Banke Celina Owolabi", "2727");
        assertEquals(1, malgwiBank.getNumberOfCustomers());

        account = malgwiBank.findAccount("1");
        assertEquals("Banke Celina Owolabi", account.getName());
    }

    @Test
    public  void customerCanDepositInAccountTest(){
        malgwiBank.createAccountFor("Bank Celina Owoloba", "2727");
        malgwiBank.deposit(2_000, "1");

        Account bankeAccount = malgwiBank.findAccount("1");
        assertEquals(2_000, bankeAccount.getBalance("2727"));
    }

    @Test
    public void withdrawPositiveAmountFromAccount(){
        malgwiBank.createAccountFor("Bank Celina Owoloba", "2727");
        malgwiBank.deposit(2_000, "1");

        Account bankeAccount = malgwiBank.withdraw(1000, "1", "2727");
        assertEquals(1000, bankeAccount.getBalance("2727"));
    }
    @Test
    public void withdrawNegativeAmountFromAccount(){
        malgwiBank.createAccountFor("Bank Celina Owoloba", "2727");
        malgwiBank.deposit(2_000, "1");

        Account bankeAccount = malgwiBank.withdraw(-1000, "1", "2727");
        assertEquals(2000, bankeAccount.getBalance("2727"));
    }

    @Test
    public void bankCanTransfer(){
//       We have a bank
//       We have two accounts
        malgwiBank.createAccountFor("Hadiza Roll-on", "needle");
        malgwiBank.createAccountFor("Hopeson Roll-on", "thread");
//        account 1 has money
        malgwiBank.deposit(5000, "1");
        assertEquals(5000, malgwiBank.findAccount("1").getBalance("needle"));

//        When you transfer x from account1 to account2
        malgwiBank.transfer("1", "2", 4900, "needle");
//        Check account 1 has been debited x and account 2 credited with x
        assertEquals(100, malgwiBank.findAccount("1").getBalance("needle"));
        assertEquals(4900, malgwiBank.findAccount("2").getBalance("thread"));



    }



}