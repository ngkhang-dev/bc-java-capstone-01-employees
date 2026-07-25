package model;

public class Staff extends Employee {

//    Properties

    private static final double DEFAULT_DAILY_WAGE = 100;
    private Manager manager;

//    Constructor

    public Staff() {
        super();
    }

    public Staff(String id, String fullName, String phoneNumber, double workingDays, double dailyWage) {
        super(id, fullName, phoneNumber, workingDays, dailyWage);
        this.manager = null;
    }

    public Staff(String id, String fullName, String phoneNumber, double workingDays, Manager manager) {
        super(id, fullName, phoneNumber, workingDays, Staff.DEFAULT_DAILY_WAGE);
        this.manager = manager;
    }

//    Methods

    public void removeManager() {
        this.manager = null;
    }

//    Override Methods

    @Override
    public double calculateMonthlySalary() {
        return dailyWage * workingDays;
    }

    @Override
    public String getExtraInfo() {
        return "";
    }

    @Override
    public String getRoleName() {
        return "STAFF";
    }

    //    Getter and Setter

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
