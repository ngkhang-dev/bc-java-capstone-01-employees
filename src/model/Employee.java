package model;

public abstract class Employee {

//    Properties

    protected String id;
    protected String fullName;
    protected String phoneNumber;
    protected double workingDays;
    protected double dailySalary;

//    Constructor

    public Employee() {
    }

    public Employee(String id, String fullName, String phoneNumber, double workingDays, double dailySalary) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.workingDays = workingDays;
        this.dailySalary = dailySalary;
    }

//    Methods

    // TODO: Implement showInfo() method


//    Abstract Methods

    public abstract double calculateMonthlySalary();

//    Getter and Setter

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

    public double getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(double dailySalary) {
        if (dailySalary < 0) {
            throw new IllegalArgumentException("Số tiền lương không được âm");
        }
        this.dailySalary = dailySalary;
    }
}
