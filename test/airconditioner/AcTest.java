package airconditioner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcTest {
    private Ac samsung;

    @BeforeEach
    public void setUp(){
        samsung = new Ac();
    }

    @Test
    public void acCanBeTurnOnTest(){
        samsung.tunOn();
        assertTrue(samsung.isOn());
    }

    @Test
    public void acCanBeTurnOff(){
        samsung.turnOff();
        assertFalse(samsung.isOn());
    }

    @Test
    public void temperatureCanOnlyIncreaseWhenAcIsOnTest(){
        samsung.increaseTemperature();
        assertEquals(0, samsung.getTemperature());
    }

    @Test
    public void initialTemperatureIs16Test(){
        samsung.tunOn();
        samsung.getTemperature();
        assertEquals(16, samsung.getTemperature());
    }


    @Test
    public void temperatureCanIncreaseTest(){
        samsung.tunOn();
        samsung.increaseTemperature();
        samsung.increaseTemperature();
        assertEquals(18, samsung.getTemperature());
    }
    @Test
    public void temperatureCannotBeAbove32Test(){
        samsung.tunOn();
        for (int i = 0; i < 15 ; i++) {
            samsung.increaseTemperature();
        }
        assertEquals(31, samsung.getTemperature());

        samsung.increaseTemperature();
        assertEquals(32, samsung.getTemperature());

        samsung.increaseTemperature();
        samsung.increaseTemperature();
        assertEquals(32, samsung.getTemperature());
    }

    @Test
    public void temperatureCanBeReducedTest(){
        samsung.tunOn();
        for (int i = 0; i < 14; i++){
            samsung.increaseTemperature();
        }
        assertEquals(30, samsung.getTemperature());

        samsung.decreaseTemperature();
        assertEquals(29, samsung.getTemperature());
    }

    @Test
    public void temperatureCanNotGoBellow16Test(){
        samsung.tunOn();
        samsung.increaseTemperature();
        assertEquals(17, samsung.getTemperature());

        samsung.decreaseTemperature();
        samsung.decreaseTemperature();
        assertEquals(16, samsung.getTemperature());
    }

}