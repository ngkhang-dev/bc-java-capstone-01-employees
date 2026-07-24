package model;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

//    Properties

    private List<Staff> managedStaff;


//    Constructor

    public Manager() {
        this.managedStaff = new ArrayList<Staff>();
    }

    public Manager(String id, String fullName, String phoneNumber, double workingDays) {
        super(id, fullName, phoneNumber, workingDays, 200);
        this.managedStaff = new ArrayList<Staff>();
    }

    //    Methods

//    Override Methods

    @Override
    public double calculateMonthlySalary() {
        return dailySalary * workingDays + 100 * managedStaff.size();
    }

//    Getter and Setter

    public int getCountManagedStaff() {
        return managedStaff.size();
    }

    public List<Staff> getManagedStaff() {
        return managedStaff;
    }

    public void setManagedStaff(List<Staff> managedStaff) {
        this.managedStaff = managedStaff;
    }

    public void setManagedStaff(Staff staff) {
        this.managedStaff.add(staff);
    }
}
