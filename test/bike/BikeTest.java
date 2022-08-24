package bike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {
    private Bike bike;

    @BeforeEach
    public void setUp(){
        bike = new Bike();
    }

    @Test
    public void bikeCanBeTurnOnTest(){
        Bike bike = new Bike();
        assertFalse(bike.isOn());

        bike.turnOn();
        assertTrue(bike.isOn());
    }

    @Test
    public void bikeCanBeTurnOffTest(){
        bike.turnOn();
        assertTrue(bike.isOn());

        bike.turnOff();
        assertFalse(bike.isOn());
    }

    @Test
    public void bikeCanBeAcceleratedOnGearOneTest(){
        bike.turnOn();

        assertEquals(0, bike.getSpeed());
        assertEquals(1, bike.getGear());

    bike.increaseSpeed();
    bike.increaseSpeed();
    bike.increaseSpeed();
    bike.increaseSpeed();
    bike.increaseSpeed();
        assertEquals(5, bike.getSpeed());
    }
    @Test
    public void bikeCanNotAccelerateWhenBikeIsOffTest(){
        assertFalse(bike.isOn());
        assertEquals(0, bike.getSpeed());
        bike.increaseSpeed();
        assertEquals(0, bike.getSpeed());
    }

    @Test
    public void bikeCanChangeFromGearOneToGearTwoAutomaticallyTest(){
        bike.turnOn();
        for (int i = 0; i < 20; i++){
            bike.increaseSpeed();
        }
        assertEquals(20, bike.getSpeed());
        assertEquals(1, bike.getGear());
        bike.increaseSpeed();
        assertEquals(2, bike.getGear());
        assertEquals(21, bike.getSpeed());
    }

@Test
    public void bikeCanAccelerateOnGearTwoTest(){
        bike.turnOn();
        for (int i = 0; i < 21; i++){
            bike.increaseSpeed();
        }
        assertEquals(2, bike.getGear());
        assertEquals(21, bike.getSpeed());

        bike.increaseSpeed();
        assertEquals(23, bike.getSpeed());
        assertEquals(2, bike.getGear());
    }

    @Test
    public void bikeCanChangeFromGearTwoToGearThreeTest(){
        bike.turnOn();
        for (int i = 0; i < 25; i++) {
            bike.increaseSpeed();
        }
        assertEquals(29, bike.getSpeed());
        assertEquals(2, bike.getGear());
        bike.increaseSpeed();
        assertEquals(31, bike.getSpeed());
        assertEquals(3, bike.getGear());
    }

    @Test
    public void bikeCanChangeFromGearThreeToFourTest(){
        bike.turnOn();
        for (int i = 0; i < 29; i++) {
            bike.increaseSpeed();
        }
        assertEquals(40, bike.getSpeed());
        assertEquals(3, bike.getGear());
        bike.increaseSpeed();
        assertEquals(43, bike.getSpeed());
        assertEquals(4, bike.getGear());
    }
}
