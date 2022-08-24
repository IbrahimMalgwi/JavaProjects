package unicornwimps.store;

import com.uncornWimps.store.StoreCustomer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {
    private StoreCustomer jennifer;
    private StoreCustomer lekan;
    private StoreCustomer kelechi;

    @BeforeEach
    public void setUp(){
        jennifer = new StoreCustomer();
        jennifer.setAccountNumber(1);
        jennifer.setBalance(1000);
        jennifer.setCreditLimit(5000);
        jennifer.setTotalCreditsApplied(3000);
        jennifer.setTotalItemsCharged(4000);

        lekan = new StoreCustomer(2, 5000, 7000, 0, 10000);
        kelechi = new StoreCustomer(3, 500, 1500, 300, 200);
    }

    @Test
    public void calculateBalance(){
        jennifer.calculateBalance();
        assertEquals(2000, jennifer.getBalance());
    }

    @Test
    public void calculateBalanceWithNegativeBalance(){
        jennifer.setBalance(-1000);
        jennifer.calculateBalance();
        assertEquals(0, jennifer.getBalance());
    }

    @Test
    public void checkCreditLimitExceeded(){
        jennifer.calculateBalance();
        boolean exceeded = jennifer.isCreditLimitExceeded();
        assertFalse(exceeded);
    }

    @Test
    public void checkCreditLimitExceededWithHighItemCharges(){
        jennifer.setTotalItemsCharged(15000);
        jennifer.calculateBalance();
        assertEquals(13000, jennifer.getBalance());
        boolean exceeded = jennifer.isCreditLimitExceeded();
        assertTrue(exceeded);
    }

    @Test
    public void main(){
        StoreCustomer[] customers = {jennifer, lekan, kelechi};
        for(int i = 0; i < customers.length; i++){
            StoreCustomer customer = customers[i];
            customer.calculateBalance();
            if(customer.isCreditLimitExceeded()){
                System.out.println("Account Number: " + customer.getAccountNumber());
                System.out.println("Credit limit exceeded");
                System.out.println();
            }
        }
    }
}
