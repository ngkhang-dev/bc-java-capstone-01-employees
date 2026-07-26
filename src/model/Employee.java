package model;

public abstract class Employee {

    protected String id;
    protected String fullName;
    protected String phoneNumber;
    protected double workingDays;
    protected double dailyWage;

    public Employee() {
    }

    public Employee(String id, String fullName, String phoneNumber, double workingDays, double dailyWage) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.workingDays = workingDays;
        this.dailyWage = dailyWage;
    }

    public void showInfo() {
        System.out.printf("|%-14s|%-25s|%-12s|%-14s|%-13.1f|%-13.2f",
                id, fullName, getRoleName(), phoneNumber, workingDays, dailyWage);
    }

    public abstract void showExtraInfo();

    public abstract String getRoleName();

    public abstract double calculateMonthlySalary();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID không được bỏ trống");
        }

        // TODO: Validate ID must have format: ROLE-INDEX

        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.length() < 3) {
            throw new IllegalArgumentException("Tên không được bỏ trống hoặc quá ngắn");
        }

        // TODO: Validate full name must have 2 words

        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Số điện thoại không được bỏ trống");
        }

        if (!phoneNumber.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("Số điện thoại phải có độ dài từ 10 đến 11 số");
        }

        this.phoneNumber = phoneNumber;
    }

    public double getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(double workingDays) {
        if (workingDays < 0) {
            throw new IllegalArgumentException("Số ngày làm việc không được âm");
        }

        this.workingDays = workingDays;
    }

    public double getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(double dailyWage) {
        if (dailyWage < 0) {
            throw new IllegalArgumentException("Số tiền lương không được âm");
        }
        this.dailyWage = dailyWage;
    }
}
