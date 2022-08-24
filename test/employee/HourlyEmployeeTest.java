package employee;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {
    public static void main(String[] args) {
        HourlyEmployee employee = new HourlyEmployee("Ibrahim", "Malgwi", "222-22-2222", 100, 20);

        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %s%n", "Hours is", employee.getHours());
        System.out.printf("%s %,.2f%n", "Wage is", employee.getWage());

        System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", employee);
    }

}