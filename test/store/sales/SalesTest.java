package unicornwimps.store.sales;
import com.uncornWimps.store.sales.Item;
import com.uncornWimps.store.sales.SalesPerson;
import org.junit.jupiter.api.*;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class SalesTest {
    private SalesPerson john;
    private Item iPhone;
    private Item[] itemsSold = new Item[1];

    @BeforeEach
    public void setUp(){
        john = new SalesPerson();
        iPhone = new Item(1000);
        itemsSold[0] = iPhone;
        john.setSoldItems(itemsSold);
    }

    @Test
    public void addItem(){
//        assertNull(john.getSoldItems());
//        itemsSold[0] = iPhone;
//        john.setSoldItems(itemsSold);
        assertEquals(1, john.getSoldItems().length);

        Scanner input = new Scanner(System.in);
    }

    @Test
    public void calculateEarnings(){
        assertEquals(1, john.getSoldItems().length);
        Item itemSold = john.getSoldItems()[0];
        assertEquals(1000, itemSold.getValueSold());
        assertEquals(290, john.calculateEarnings());
    }

    @Test
    public void calculateEarningsWithMultipleItems(){
        assertEquals(1, john.getSoldItems().length);
        Item itemSold = john.getSoldItems()[0];
        assertEquals(1000, itemSold.getValueSold());

        Item samsung = new Item(2000);
        Item itel = new Item(200);
        Item dell = new Item(5000);
        Item hp = new Item(4500);

        Item[] itemsSold = {iPhone, samsung, itel, dell, hp};
        john.setSoldItems(itemsSold);
        assertEquals(5, john.getSoldItems().length);

        assertEquals(1343, john.calculateEarnings());
    }
}
