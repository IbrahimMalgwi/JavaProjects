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
    public void accountCanBeCreatedTest(){
        //given that account exist
        //check that account exists
        //Check that balance is zero
        assertNotNull(bankeAccount);
        assertEquals(0, bankeAccount.getBalance("1212"));

    }

    @Test
    public void depositMoney_balanceIncreasesTest(){

        //given that i have account and balance is zero;
        //when i deposit 200
        //check that balance is 200

        assertEquals(0, bankeAccount.getBalance("1212"));
        bankeAccount.deposit(200);
        int myBalance = bankeAccount.getBalance("1212");
        assertEquals(200, myBalance);

    }

    @Test
    public void cannotDepositNegativeAmount(){
        //given that i have an account
        //when i try to deposit negative amount -2500
        //check that balance is zero;


        assertEquals(0, bankeAccount.getBalance("1212"));
        bankeAccount.deposit(-2500);
        assertEquals(0, bankeAccount.getBalance("1212"));
    }

    @Test
    public void depositNegativeDepositThrowsExceptionTest(){
        assertThrows(InvalidAmountException.class, ()->bankeAccount.deposit(-2500));
    }


    @Test
    @DisplayName("Getting balance with invalid pin returns ")
    public void getBalanceWithWrongPin_returnsZeroTest(){
        //given i have money in my account
        //when i check my balance with wrong pin
        //balance is zero

        bankeAccount.deposit(2000);
        int myBalance = bankeAccount.getBalance("1212");
        assertEquals(2000, myBalance);
    }

    @Test
    @DisplayName("Getting balance with invalid pin returns ")
    public void getBalanceWithWrongPin_returnsZeroTestTwice(){
        //given i have money in my account
        //when i check my balance with wrong pin
        //balance is zero

        bankeAccount.deposit(2000);
        int myBalance = bankeAccount.getBalance("1234");
        assertEquals(0, myBalance);
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
        bankeAccount.withdraw(-10_000, "1212");
        assertEquals(12000, bankeAccount.getBalance("1212"));
        bankeAccount.withdraw(10_000, "1212");
        assertEquals(2000, bankeAccount.getBalance("1212"));

    }


    @Test
    public void withdrawWrongPinDoesNotWork(){
        bankeAccount.deposit(5000);
        bankeAccount.withdraw(2000, "1223");
        assertEquals(5000, bankeAccount.getBalance("1212"));
    }
    @Test
    @DisplayName("If pin is correct ane amount exceeds balance, withdraw does not work")
    public void withdrawWithRightPinAndHighAmountDoesNotWorkTest(){
        bankeAccount.deposit(5_000);
        bankeAccount.withdraw(5000, "1212");
        assertEquals(0, bankeAccount.getBalance("1212"));

    }

    @Test
    public void getBackBalanceIfUserWantToWithdrawAmountAboveBalance(){
        bankeAccount.deposit(5_000);
        bankeAccount.withdraw(10_000, "1212");
        assertEquals(5000, bankeAccount.getBalance("1212"));
    }
    @Test
    public void withdrawRightPinWorksTest(){
        //given that i have account
        //given when i try to withdraw 2000 with 1234 as pin
        //check that current balance is 3000
    }

}