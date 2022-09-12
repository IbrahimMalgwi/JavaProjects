package myBank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account bankeAccount;

    @BeforeEach
    public void setUp(){
        bankeAccount = new Account("1", "Banke Celina", "1212");
    }

    @Test
    public void accountCanBeCreatedWIthZeroBalanceTest(){
        //given that account exist
        //check that account exists
        //Check that balance is zero
        assertNotNull(bankeAccount);
        assertEquals(0, bankeAccount.getBalance("1212"));
    }

    @Test
    public void depositMoney_balanceIncreasesTest(){
        //given that I have account and balance is zero;
        //when I deposit 200
        //check that balance is 200

        assertEquals(0, bankeAccount.getBalance("1212"));
        bankeAccount.deposit(200);
        int myBalance = bankeAccount.getBalance("1212");
        assertEquals(200, myBalance);
    }

    @Test
    public void cannotDepositNegativeAmount(){
        //given that I have an account
        //when I try to deposit negative amount -2500
        //check that balance is zero;
        assertEquals(0, bankeAccount.getBalance("1212"));
        assertThrows(InvalidAmountException.class, ()->bankeAccount.deposit(-2500));
    }

    @Test
    public void depositNegativeDepositThrowsExceptionTest(){
        assertThrows(InvalidAmountException.class, ()->bankeAccount.deposit(-2500));
    }

    @Test
    @DisplayName("Getting balance with valid pin returns ")
    public void getBalanceWithPin_returnsBalanceTest(){
        //given I have money in my account
        //when I check my balance with wrong pin
        //balance is zer0
        bankeAccount.deposit(2000);
        int myBalance = bankeAccount.getBalance("1212");
        assertEquals(2000, myBalance);
    }

    @Test
    @DisplayName("Getting balance with invalid pin returns ")
    public void getBalanceWithWrongPin_returnsZeroTestTwice(){
        //given I have money in my account
        //when I check my balance with wrong pin
        //balance is zero
        assertThrows(InvalidPinException.class, ()->bankeAccount.getBalance("2222"));
    }

    @Test
    public void withdrawRightPinWorksTest(){
        //given that I have account
        //given when I try to withdraw 2000 with 1234 as pin
        //check that current balance is 3000
        bankeAccount.deposit(5_000);
        assertEquals(5_000, bankeAccount.getBalance("1212"));
        bankeAccount.withdraw(2_000, "1212");
    }

    @Test
    public void withdrawWithNegativeAmountThrowExceptionTest(){
        assertThrows(InvalidAmountException.class, ()->bankeAccount.withdraw(-10_200, "1212"));
    }

    @Test
    @DisplayName("Withdraw amount that is greater than the balance in your account")
    public void withdrawAmountThatIsGreaterThanBalance(){
        //given you have account
        //given you have money input the correct pin
        //given you have money above balance
        int myBal = bankeAccount.getBalance("1212");
        assertEquals(0, myBal);
        bankeAccount.deposit(12_000);
        assertEquals(12_000, bankeAccount.getBalance("1212"));
        bankeAccount.withdraw(10_000, "1212");
        assertEquals(2000, bankeAccount.getBalance("1212"));
    }

    @Test
    public void withdrawWrongPinDoesNotWork(){
        bankeAccount.deposit(5_000);
        assertThrows(InvalidPinException.class, ()-> bankeAccount.withdraw(2_000, "2333"));
    }

    @Test
    @DisplayName("If pin is correct and amount exceeds balance, withdraw does not work")
    public void withdrawWithRightPinAndHighAmountDoesNotWorkTest(){
        bankeAccount.deposit(5_000);
        bankeAccount.withdraw(5000, "1212");
        assertEquals(0, bankeAccount.getBalance("1212"));
    }

    @Test
    public void getBackBalanceIfUserWantToWithdrawAmountAboveBalance(){
        bankeAccount.deposit(5_000);
        assertThrows(InsufficientFundException.class, ()-> bankeAccount.withdraw(6_000, "1212"));
    }
}