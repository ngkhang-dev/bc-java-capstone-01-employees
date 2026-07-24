package model;

public class Director extends Employee {

//    Properties

    private double stock;

//    Constructor

    public Director() {
    }

    public Director(String id, String fullName, String phoneNumber, double workingDays, double stock) {
        super(id, fullName, phoneNumber, workingDays, 300);
        this.stock = stock;
    }

//    Methods

    public double calculateTotalIncome(double revenueInMonthOfCompany, double totalSalaryOfEmployees) {
        return calculateMonthlySalary() + stock * (revenueInMonthOfCompany - totalSalaryOfEmployees);
    }


//    Override Methods

    @Override
    public double calculateMonthlySalary() {
        return dailySalary * workingDays;
    }

//    Getter and Setter

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        if (stock < 0 || stock > 100) {
            throw new IllegalArgumentException("Cổ phần phải nằm trong khoảng từ 0% - 100%");
        }
        this.stock = stock;
    }
}
