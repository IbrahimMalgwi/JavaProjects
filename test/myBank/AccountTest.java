package myBank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account judithAccount;

    @BeforeEach
    public void setUp(){
        judithAccount = new Account("1", "Judith Hyelsinta", "1212");
    }

    @Test
    public void accountCanBeCreatedWithZeroBalanceTest(){
        //given that account exist
        //check that account exists
        //Check that balance is zero
        assertNotNull(judithAccount);
        assertEquals(0, judithAccount.getBalance("1212"));
    }

    @Test
    public void depositMoney_balanceIncreasesTest(){
        //given that I have account and balance is zero;
        //when I deposit 200
        //check that balance is 200
        assertEquals(0, judithAccount.getBalance("1212"));
        judithAccount.deposit(200);
        int myBalance = judithAccount.getBalance("1212");
        assertEquals(200, myBalance);
    }

    @Test
    public void cannotDepositNegativeAmount(){
        //given that I have an account
        //when I try to deposit negative amount -2500
        //check that balance is zero;
        assertEquals(0, judithAccount.getBalance("1212"));
        assertThrows(InvalidAmountException.class, ()-> judithAccount.deposit(-2500));
    }

    @Test
    public void depositNegativeDepositThrowsExceptionTest(){
        assertThrows(InvalidAmountException.class, ()-> judithAccount.deposit(-2500));
    }

    @Test
    @DisplayName("Getting balance with valid pin returns ")
    public void getBalanceWithPin_returnsBalanceTest(){
        //given I have money in my account
        //when I check my balance with wrong pin
        //balance is zer0
        judithAccount.deposit(2000);
        int myBalance = judithAccount.getBalance("1212");
        assertEquals(2000, myBalance);
    }

    @Test
    @DisplayName("Getting balance with invalid pin returns ")
    public void getBalanceWithWrongPin_returnsZeroTestTwice(){
        //given I have money in my account
        //when I check my balance with wrong pin
        //balance is zero
        assertThrows(InvalidPinException.class, ()-> judithAccount.getBalance("2222"));
    }

    @Test
    public void withdrawRightPinWorksTest(){
        //given that I have account
        //given when I try to withdraw 2000 with 1234 as pin
        //check that current balance is 3000
        judithAccount.deposit(5_000);
        assertEquals(5_000, judithAccount.getBalance("1212"));
        judithAccount.withdraw(2_000, "1212");
    }

    @Test
    public void withdrawWithNegativeAmountThrowExceptionTest(){
        assertThrows(InvalidAmountException.class, ()-> judithAccount.withdraw(-10_200, "1212"));
    }

    @Test
    @DisplayName("Withdraw amount that is greater than the balance in your account")
    public void withdrawAmountThatIsGreaterThanBalance(){
        //given you have account
        //given you have money input the correct pin
        //given you have money above balance
        int myBal = judithAccount.getBalance("1212");
        assertEquals(0, myBal);
        judithAccount.deposit(12_000);
        assertEquals(12_000, judithAccount.getBalance("1212"));
        judithAccount.withdraw(10_000, "1212");
        assertEquals(2000, judithAccount.getBalance("1212"));
    }

    @Test
    public void withdrawWrongPinDoesNotWork(){
        judithAccount.deposit(5_000);
        assertThrows(InvalidPinException.class, ()-> judithAccount.withdraw(2_000, "2333"));
    }

    @Test
    @DisplayName("If pin is correct and amount exceeds balance, withdraw does not work")
    public void withdrawWithRightPinAndHighAmountDoesNotWorkTest(){
        judithAccount.deposit(5_000);
        judithAccount.withdraw(5000, "1212");
        assertEquals(0, judithAccount.getBalance("1212"));
    }

    @Test
    public void getBackBalanceIfUserWantToWithdrawAmountAboveBalance(){
        judithAccount.deposit(5_000);
        assertThrows(InsufficientFundException.class, ()-> judithAccount.withdraw(6_000, "1212"));
    }
}