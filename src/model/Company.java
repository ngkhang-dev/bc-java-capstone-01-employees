package model;

public class Company {

//    Properties

    private String name;
    private String taxCode;
    private double monthlyRevenue;

//    Constructor

    public Company() {
    }

    public Company(String name, double monthlyRevenue, String taxCode) {
        this.name = name;
        this.monthlyRevenue = monthlyRevenue;
        this.taxCode = taxCode;
    }

//    Methods

    public double calculateCompanyProfit(double totalSalaryOfEmployees) {
        return monthlyRevenue - totalSalaryOfEmployees;
    }

//    Override Methods

//    Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên công ty không bỏ trống");
        }

        this.name = name;
    }

    public double getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(double monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        if (taxCode == null || taxCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã số thuế không bỏ trống");
        }

        if (!taxCode.matches("\\d{10,13}")) {
            throw new IllegalArgumentException("Mã số thuế không hợp lệ");
        }

        this.taxCode = taxCode;
    }
}
