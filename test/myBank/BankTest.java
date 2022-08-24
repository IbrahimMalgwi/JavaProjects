package myBank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank myBank;

    @BeforeEach
    public void startWithThis(){
        myBank = new Bank();
    }

    @Test
    public void bankExistsTest(){
        assertNotNull(myBank);
    }

    @Test
    public void accountCanBeCreated(){
        // When I create an account
        //Check that number of accounts created is 1
        myBank.createAccountFor("Ibrahim Gana Malgwi", "1234");
        assertEquals(1, myBank.getNumberOfCustomer());
    }

    @Test
    public void createAccount_findAccountByAccountNumber(){
        myBank.createAccountFor("Ibrahim Gana Malgwi", "1234");
        myBank.createAccountFor("Judith Ibrahim Malgwi", "2321");
        assertEquals(2, myBank.getNumberOfCustomer());

        Account account = myBank.findAccount("1");
        assertEquals("Ibrahim Gana Malgwi", account.getName());
    }

//    @Test
//    public void customerCanDepositInHisAccountTest(){
//        myBank.createAccountFor("Ibrahim Gana Malgwi", "1234");
//        myBank.deposit(2_000, "1");
//
//        Account bankeAccount = myBank.findAccount("1");
//        assertEquals(2_000, bankeAccount.getBalance("1234"));
//    }
//
//    @Test
//    public void customerCannotDepositNegativeAmountTest(){
//        //Given that I have an account
//        //When I deposit negative amount
//        //Check balance remain the same
//        myBank.createAccountFor("Ibbi", "1223");
//        assertEquals(1, myBank.getNumberOfCustomer());
//        Account account = myBank.findAccount("1");
//    }
//
//    @Test
//    public void customerCanWithdrawFromAccountTest(){
//        //Given I have an account with money
//        //When I withdraw from account
//        //Check that balance has change
//        myBank.createAccountFor("Ibrahim Gana Malgwi", "1234");
//        myBank.deposit(5_000, "1");
//        Account account = myBank.findAccount("1");
//        assertEquals(5_000, account.getBalance("1234"));
//        myBank.withdraw(2_000, "1234", "1");
//        assertEquals(3000, account.getBalance("1234"));
//    }

//    @Test
//    public void customerCannotWithdrawWithNegativeNumberTest(){
//        //Given that I have an account with money
//        //When I withdraw negative value
//        //Check balance remians the same
//        myBank.createAccountFor("Judith Ibrahim Malgwi", "1234");
//        myBank.deposit(7_000,"1");
//        Account account = myBank.findAccount("1");
//        assertEquals(7_000, account.getBalance("1234"));
//        myBank.withdraw(-3_500, "1234", "1");
//        assertEquals(7_000, account.getBalance("1234"));
//    }

//    @Test
//    public void customerCanTransferFromAccountTest(){
//        // Given that I have an account with money
//        // When I transfer from the account to another account
//        // Check balance of both accounts change
//        myBank.createAccountFor("Judith Ibrahim Malgwi", "2266");
//        myBank.createAccountFor("Joanna Ibrahim Malgwi", "5678");
//        myBank.createAccountFor("Patience Ibrahim Gana", "2244");
//        assertEquals(3, myBank.getNumberOfCustomer());
//        Account account = myBank.findAccount("1");
//        Account account1 = myBank.findAccount("2");
//        Account account2 = myBank.findAccount("3");
//
//        account.deposit(7_000);
//        assertEquals(7_000, account.getBalance("2266"));
////        myBank.deposit(1_000, "2");
////        assertEquals(1_000, account1.getBalance("5678"));
//
////        myBank.transfer(2_000, "2266", "1", "2");
////        assertEquals(5_000, account.getBalance("2266"));
////        assertEquals(7_000, account1.getBalance("5678"));
////
////        myBank.transfer(1_000, "5678", "2", "3");
////        assertEquals(1_000, account1.getBalance("5678"));
////        assertEquals(1_000, account2.getBalance("2244"));
//    }
//
//    @Test
//    public void customerCannotTransferNegativeAmountTest(){
//        //Given that I have an account with money
//        //When I transfer negative amount
//        //Check balance did not change for both account
//        myBank.createAccountFor("Hyelhirra", "2233");
//        myBank.createAccountFor("Hyelsinta", "2323");
//        assertEquals(2, myBank.getNumberOfCustomer());
//        Account account = myBank.findAccount("1");
//        Account account1 = myBank.findAccount("2");
//
//        myBank.deposit(7_000, "1");
//        assertEquals(7_000, account.getBalance("2233"));
//
//        myBank.transfer(-2_000, "2233", "1", "2");
//        assertEquals(7_000, account.getBalance("2233"));
//        assertEquals(0, account1.getBalance("2323"));
//    }
//
//    @Test
//    public void customerCannotTransferAboveTheAccountBalanceTest(){
//        //Given that i have an account with money
//        //When I transfer above the balance
//        //Check that balance did not change for both account
//        myBank.createAccountFor("Mama", "2341");
//        myBank.createAccountFor("Juju", "2213");
//        assertEquals(2, myBank.getNumberOfCustomer());
//        Account account = myBank.findAccount("1");
//        Account account1 = myBank.findAccount("2");
//
//        myBank.deposit(8_200, "1");
//        assertEquals(8_200, account.getBalance("2341"));
//
//        myBank.transfer(10_000, "2341", "1", "2");
//        assertEquals(8_200, account.getBalance("2341"));
//        assertEquals(0, account1.getBalance("2213"));
//    }
//
//    @Test
//    public void customerCannotTransferWithWrongPinTest(){
//        //Given that I have an account with money
//        // When I transfer with wrong pin
//        // Check that balance did not change for both account
//        myBank.createAccountFor("Hyelsinta", "2332");
//        myBank.createAccountFor("Hyelhirra", "3322");
//        assertEquals(2, myBank.getNumberOfCustomer());
//        Account account = myBank.findAccount("1");
//        Account account1 = myBank.findAccount("2");
//
//        myBank.deposit(5_570, "1");
//        assertEquals(5_570, account.getBalance("2332"));
//
//        myBank.transfer(2_350, "1234", "1", "2");
//        assertEquals(5_570, account.getBalance("2332"));
//        assertEquals(0, account1.getBalance("3322"));
//    }
//
//    @Test
//    public void customerCannotTransferToOwnAccountTest() throws IllegalAccessException{
//        //Given that I have an account
//        //When I transfer to own account
//        //Check that balance not change
//        myBank.createAccountFor("Juju Mana", "2423");
//        assertEquals(1, myBank.getNumberOfCustomer());
//        Account account = myBank.findAccount("1");
//
//        myBank.deposit(2_350, "1");
//        assertEquals(2_350, account.getBalance("2423"));
//
//        myBank.transfer(1_000, "1023", "1", "1");
//        assertEquals(2_350, account.getBalance("2423"));
//    }




}