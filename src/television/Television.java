package television;

public class Television {
    private boolean isOn;
    private int channel;

    public boolean isOn(){
        return isOn;
    }
    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;

    }

    public int getChannel(){ return channel; }

    public void nextChannel() {
        if (isOn) {
            if (channel >= 0 && channel < 100) channel++;
        }

    }

    public void previousChannel() {
        if (isOn)
            if (channel > 0)channel --;
    }

    public void setChannel(int channel) {
        if (channel >= 0 && channel <=100 )
            this.channel = channel;
    }
}
