package hotelManagementSystem;

public class UnicornHotel {
    private static String [] rooms;

    public UnicornHotel (int numberOfRooms){
        this.rooms = new String[numberOfRooms];
    }

    public String bookRoom(String name) throws IllegalAccessException{
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i] == null){
                rooms[i] = name;
                break;
            }
        }
        return "Room booked Successfully!";
    }

    public String getRoomGuest(int roomNumber)throws  IllegalAccessException{
        return rooms[roomNumber - 1];
    }

    public String[] getRooms() {
        return rooms;
    }

    public static boolean checkOut(int roomNumber) {
        boolean result = false;
        rooms[roomNumber -1] = null;
        if (rooms [roomNumber - 1] == null) {
            result = true;
        }
        return result;
    }
}
