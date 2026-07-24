package model;

public class Staff extends Employee {

//    Properties
    private Manager manager; // TODO: Q: Storge manager object or string ID?

//    Constructor

    public Staff() {
    }

    public Staff(String id, String fullName, String phoneNumber, double workingDays, Manager manager) {
        super(id, fullName, phoneNumber, workingDays, 100);
        this.manager = manager;
    }

//    Methods


//    Override Methods

    @Override
    public double calculateMonthlySalary() {
        return dailySalary * workingDays;
    }


//    Getter and Setter

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
