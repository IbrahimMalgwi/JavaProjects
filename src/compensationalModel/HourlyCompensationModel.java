package compensationalModel;

public class HourlyCompensationModel implements CompensationModel{
    private double wages;
    private double hours;

    public HourlyCompensationModel(double wages, double hours){
        this.wages = wages;
        this.hours = hours;
    }

    @Override
    public double earnings(){
        if (hours <= 40){
            return wages * 40;
        } else {
            return wages * 40 + (hours - 40) * 1.5;
        }
    }
}
