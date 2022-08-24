package myBank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account bankeAccount;
    @BeforeEach
    public void startWithThis(){
        bankeAccount = new Account("1", "Banke Celina", "1234");
    }

    @Test
    public void accountCanBeCreatedTest(){
        //given that account exists
        //check that account exists
        // Check that balance is zero
        assertNotNull(bankeAccount);
        assertEquals(0, bankeAccount.getBalance("1234"));
    }

    @Test
    public void depositMoney_balanceIncreasesTest(){
        //given that I have account and balance is Zero:
        // when I deposit 200
        // check that balance is 200
        assertEquals(0, bankeAccount.getBalance("1234"));
        bankeAccount.deposit(200);
        assertEquals(200, bankeAccount.getBalance("1234"));
    }

    @Test
    public void cannotDepositNegativeAmountTest(){
        //given I have an account and balance is Zero
        // when I try to deposit -2500
        // check that balance is Zero
        assertEquals(0, bankeAccount.getBalance("1234"));
        bankeAccount.deposit(-2500);
        assertEquals(0, bankeAccount.getBalance("1234"));
    }

    @Test
    @DisplayName("Getting balance with invalid pin return Zero")
    public void getBalanceWIthWrongPin_returnsZeroTest(){
        //given that I have money in my account
        // when I check balance
        // balance is Zero
        bankeAccount.deposit(2000);
        int myBalance = bankeAccount.getBalance("1223");
        assertEquals(0, myBalance);
    }

    @Test
    @DisplayName("Getting balance with valid pin return real balance")
    public void getBalanceWIthPinRightReturnsRealBalanceTest(){
        //given that I have money in my account
        // when I check balance
        // balance real balance
        bankeAccount.deposit(2000);
        int myBalance = bankeAccount.getBalance("1234");
        assertEquals(2000, myBalance);
    }

    @Test
    public void withdrawWithRightPinWorksTest() {
        //Given that I have account and balance is 5000
        // When I withdraw 2000 with 1234 as pin
        //Check that current balance is 3000
        bankeAccount.deposit(5000);
        bankeAccount.withdraw(2000, "1234");
        assertEquals(3000, bankeAccount.getBalance("1234"));
    }

    @Test
    public void withdrawWithWrongPinDoesNotWorkTest(){
        //given that I have an account with money
        // When I withdraw with wrong pin
        // balance should not change
        bankeAccount.deposit(5000);
        bankeAccount.withdraw(2000,"2727");
        assertEquals(5000, bankeAccount.getBalance("1234"));
    }

    @Test
    @DisplayName("If pin is correct and amount exceeds balance, Withdraw does not work")
    public void withdrawWithRightPinAndHighAmountDoesNotWork(){
        bankeAccount.deposit(5_000);
        bankeAccount.withdraw(10_000, "1234");
        assertEquals(5_000, bankeAccount.getBalance("1234"));
    }


}