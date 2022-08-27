package airconditioner;

public class Ac {
    private boolean isOn;
    private int temperature;

    public boolean isOn(){
        return isOn;
    }
    public void tunOn() {
        isOn = true;
        temperature = 16;
    }

    public void turnOff() {
        isOn = false;
    }

    public int getTemperature() {
        return temperature;
    }

    public void increaseTemperature() {
        if (isOn) {
            if(temperature >= 16 && temperature < 32) temperature++;
        }
    }

}
