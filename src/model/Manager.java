package model;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    //    Properties
    private static final double DEFAULT_DAILY_WAGE = 200;
    private static final double BONUS_PER_STAFF = 100;
    private List<Staff> managedStaffs;

//    Constructor

    public Manager() {
        super();
        this.managedStaffs = new ArrayList<Staff>();
    }

    public Manager(String id, String fullName, String phoneNumber, double workingDays) {
        super(id, fullName, phoneNumber, workingDays, Manager.DEFAULT_DAILY_WAGE);
        this.managedStaffs = new ArrayList<Staff>();
    }

//    Methods

    public void addStaff(Staff staff) {
        if (staff == null || managedStaffs.contains(staff)) {
            return;
        }

        Manager managerCurrent = staff.getManager();

        if (managerCurrent != null && managerCurrent != this) {
            managerCurrent.removeStaff(staff);
        }

        managedStaffs.add(staff);
        staff.setManager(this);
    }

    public void removeStaff(Staff staff) {
        if (managedStaffs.remove(staff)) {
            staff.setManager(null);
        }
    }

    public int getManagedStaffCount() {
        return managedStaffs.size();
    }

//    Override Methods

    @Override
    public double calculateMonthlySalary() {
        return dailyWage * workingDays + Manager.BONUS_PER_STAFF * managedStaffs.size();
    }

    @Override
    public String getExtraInfo() {
        return "";
    }

    @Override
    public String getRoleName() {
        return "MANAGER";
    }

//    Getter and Setter

    public List<Staff> getManagedStaff() {
        return managedStaffs;
    }

    public void setManagedStaff(List<Staff> managedStaff) {
        this.managedStaffs = managedStaff;
    }

    public void setManagedStaff(Staff staff) {
        this.managedStaffs.add(staff);
    }
}
