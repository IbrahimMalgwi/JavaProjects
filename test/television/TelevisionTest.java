package television;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelevisionTest {
    private Television samsung;

    @BeforeEach
    @DisplayName("Start each test with a new television instance ")
    public void setUp(){
        samsung = new Television();
    }

    @Test
    @DisplayName("Test that television can be turn on")
    public void turnOnTelevisionTest(){
//        Given that I have a television
//        When I turn it on
//        Check that it is on
        samsung.turnOn();
        assertTrue(samsung.isOn());
    }

    @Test
    @DisplayName("Test that television can be turn off test")
    public void turnOffTelevisionTest(){
//        Given that I have a television
//        When I turn it off
//        Check that it is off
        samsung.turnOff();
        assertFalse(samsung.isOn());
    }

    @Test
    @DisplayName("Test that television can change channel")
    public void televisionCanChangeChanelTest(){
//        Given that I have a television
//        When I change Channel
//        Check that chanel changed
        samsung.turnOn();
        samsung.nextChannel();
        assertEquals(1, samsung.getChannel());
    }

    @Test
    @DisplayName("Test that television can only change chanel when turn on")
    public void channelCanChangeOnlyWhenTurnOn(){
//        Given that I have a television
//        When I change Channel
//        Check it is on first before changing the channel
        samsung.nextChannel();
        assertEquals(0, samsung.getChannel());

        samsung.turnOn();
        samsung.nextChannel();
        samsung.nextChannel();
        samsung.nextChannel();
        assertEquals(3, samsung.getChannel());
    }

    @Test
    @DisplayName("Test that television has 0 to 100 channel range")
    public void channelRange0to100Test(){
//        Given that I have a television
//        When I change channel above 100
//        Check that channel remains 100
        samsung.turnOn();
        assertTrue(samsung.isOn());
        assertEquals(0, samsung.getChannel());

        for (int i = 0; i <99 ; i++) {
            samsung.nextChannel();
        }
        assertEquals(99, samsung.getChannel());
        samsung.nextChannel();
        samsung.nextChannel();
        assertEquals(100, samsung.getChannel());
    }

    @Test
    @DisplayName("Test that television can go back to previous channel")
    public void televisionCanChangeFromCurrentToPreviousChannelTest(){
//        Given that I have a television
//        When I change channel from current to previous
//        Check that channel has changed
        samsung.turnOn();
        assertTrue(samsung.isOn());
        for (int i = 0; i <30 ; i++) {
            samsung.nextChannel();
        }
        assertEquals(30, samsung.getChannel());
        samsung.previousChannel();
        assertEquals(29, samsung.getChannel());
    }

    @Test
    @DisplayName("Test that television can only go to previous channel when is on")
    public void televisionCanOnlyGoToPreviousChannelWhenTurnOnTest(){
//        Given that I have a television
//        When I go to previous channel
//        Check that only when is on before channel can change
        samsung.nextChannel();
        samsung.nextChannel();
        samsung.nextChannel();
        assertEquals(0, samsung.getChannel());

        samsung.turnOn();
        samsung.nextChannel();
        samsung.nextChannel();
        assertEquals(2, samsung.getChannel());

        samsung.previousChannel();
        assertEquals(1, samsung.getChannel());
    }

    @Test
    @DisplayName("Test that channel cannot go bellow 0")
    public void televisionChannelCannotGoBelow0Test(){
//        Given that I have a television
//        When I change channel bellow 0
//        Check that channel remains on 0
        samsung.turnOn();
        assertTrue(samsung.isOn());

        samsung.nextChannel();
        samsung.nextChannel();
        assertEquals(2, samsung.getChannel());

        samsung.previousChannel();
        assertEquals(1, samsung.getChannel());

        samsung.previousChannel();
        assertEquals(0, samsung.getChannel());

        samsung.previousChannel();
        assertEquals(0, samsung.getChannel());
    }

    @Test
    @DisplayName("Test that television channel can be set")
    public void setChannelTest(){
//        Given that I have a television
//        When I set channel
//        Check that channel is set
        samsung.turnOn();
        assertTrue(samsung.isOn());

        for (int i = 0; i < 100; i++){
            samsung.nextChannel();
        }
        assertEquals(100, samsung.getChannel());

        samsung.setChannel(20);
        assertEquals(20, samsung.getChannel());
    }

    @Test
    @DisplayName("Test that channel can only be set between 0 to 100")
    public void setChannelFrom0To100Test(){
//        Given that I have a television
//        When is set channel above 100
//        Check that channel is between 0 and 100
        samsung.turnOn();
        assertTrue(samsung.isOn());

        samsung.setChannel(101);
        assertEquals(0, samsung.getChannel());

    }




}