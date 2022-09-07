package fairTax;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FairTaxCalculatorTest {
        private FairTaxCalculator fairTaxCalculator;

        @BeforeEach
        void setUp(){
            fairTaxCalculator = new FairTaxCalculator();
        }

        @Test
        void testThatFairTaxCanBeCalculated(){
            //given
            Product product = new Product("milo", 100.00);
            //when
            double tax = fairTaxCalculator.calculateTax(product.getPrice());
            //assert
            assertEquals(23, tax);
        }
        @Test
        void testThatProductsTotalPriceCanBeCalculated(){
            //given
            fairTaxCalculator.setTotalPrice(100.00);
            //when
            double totalPrice = fairTaxCalculator.calculateTotalPrice(30.00);
            //assert
            assertEquals(130.00, totalPrice);
        }

    }


