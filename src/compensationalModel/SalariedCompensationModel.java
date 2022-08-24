package compensationalModel;

public class SalariedCompensationModel implements CompensationModel{
    private double weeklySalary;

    public SalariedCompensationModel(double WeeklySalary){
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double earnings(){
        return weeklySalary;
    }

}
