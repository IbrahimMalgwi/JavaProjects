package bike;

public class Bike {
    private boolean isOn;
    private int speed;
    private int gear ;
     public boolean isOn() {
        return isOn;
    }
    public void turnOn() {
         isOn = true;
         gear = 1;
    }

    public void turnOff() {
         isOn = false;
         gear = 0;
         speed = 0;
    }

    public int getSpeed() {
         return  speed;
    }

    public int getGear() {
        return gear;
    }

    public void increaseSpeed() {
         if (isOn) accelerate();

    }
    private void accelerate(){
         if (gear == 4){
             speed +=4;
         }
         if (gear == 3) increaseSpeedOnGearThree();
         if (gear == 2) increaseSpeedOnGearTwo();
         if (gear == 1) increaseSpeedOnGearOne();
    }

    private void increaseSpeedOnGearThree() {
        speed +=3;
        if (speed >= 41) gear++;
    }

    private void increaseSpeedOnGearTwo() {
        speed +=2;
        if (speed >= 31) gear++;
    }

    private void increaseSpeedOnGearOne() {
        speed ++;
        if (speed > 20) gear ++;
    }
}
