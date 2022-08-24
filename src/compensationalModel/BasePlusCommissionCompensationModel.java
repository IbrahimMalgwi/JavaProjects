package compensationalModel;

public class BasePlusCommissionCompensationModel implements CompensationModel{
    private double baseSalary;
    private double grossSales;
    private double commissionRate;

    public BasePlusCommissionCompensationModel(double baseSalary, double grossSales, double commissionRate){
        this.baseSalary = baseSalary;
        this.grossSales = grossSales;
        this. commissionRate = commissionRate;
    }

    @Override
    public double earnings(){
        return baseSalary + grossSales * commissionRate;
    }
}
