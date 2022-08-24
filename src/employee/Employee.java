package employee;

public abstract class Employee {
    //Instance variables
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    //All arguments constructor
    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    //Get method for the super class
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    //Override method to string to allow for the string output of the class objects
    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s", "Employee", firstName, lastName, "social security number", socialSecurityNumber);
    }

    public abstract double earnings();
}
