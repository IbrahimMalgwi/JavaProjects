package hotelManagementSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnicornHotelTest {
    UnicornHotel unicornHotel;

    @BeforeEach
    void startALlTestWith() {
        unicornHotel = new UnicornHotel(5);
    }

    @Test
    void testThatHotelExists() {
        assertNotNull(unicornHotel);
    }

    @Test
    void testThatHotelHasRooms_AndTheyAreEmpty() {
        String[] rooms = unicornHotel.getRooms();
        assertNotNull(rooms);
        for (String room : rooms) {
            assertNull(room);
        }
    }

    @Test
    void testThatRoomCanBeBooked() {
        String name = "Segun";
        try {
            String result = unicornHotel.bookRoom(name);
            assertNotNull(result);
            assertEquals(name, unicornHotel.getRoomGuest(1));
            String name2 = "Lekan";
            unicornHotel.bookRoom(name2);
            assertEquals(name2, unicornHotel.getRoomGuest(2));
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        String name2 = "Perry";
        try {
            unicornHotel.bookRoom(name2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testThatGuestCanCheckOut() throws IllegalAccessException {
        assertTrue(UnicornHotel.checkOut(1));
//        try {
//            System.out.println(unicornHotel.getRoomGuest(1));
//        } catch (IllegalAccessException e){
//            System.out.println(e.getMessage());
//        }
        unicornHotel.bookRoom("Perry");
        assertEquals("Perry", unicornHotel.getRoomGuest(1));
    }
}