package employee;

public class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary; //base salary per week

    //six-argument constructor
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary){
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

        // If baseSalary is invalid throw exception
        if (baseSalary < 0.0){
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }
        this.baseSalary = baseSalary;
    }

    //setting baseSalary and have it throw exception for invalid value
    public void setBaseSalary(double baseSalary){
        if (baseSalary < 0.0){
            throw new IllegalArgumentException("Base salary must be >= 0");
        }
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    // Calculate earnings
    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }

    // Return String representation of BasePlusCommissionEmployee object
    @Override
    public String toString(){
        return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
    }
}
