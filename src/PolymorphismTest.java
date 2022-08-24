import employee.BasePlusCommissionEmployee;
import employee.CommissionEmployee;

public class PolymorphismTest {
    public static void main(String[] args) {
        CommissionEmployee commissionEmployee = new CommissionEmployee("Ibbi", "Gana", "222-222-222", 10_000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("james", "Jake", "111-111-111", 5_000, .04, 500);

        System.out.printf("%s %s:%n%n%s%n%n", "Call CommissionEmployee's toString with superclass reference ", "to superclass object", commissionEmployee.toString());

        System.out.printf("%s %s:%n%n%s%n%n", "Call basePlusCommissionEmployee's toString with superclass reference ", "to superclass object", basePlusCommissionEmployee.toString());

        CommissionEmployee commissionEmployee2 = basePlusCommissionEmployee;
        System.out.printf("%s %s:%n%n%s%n%n", "Call BasedPlusComissionEmployee's toString wuth superclass", "reference to subclass object", commissionEmployee2.toString());

    }
}
