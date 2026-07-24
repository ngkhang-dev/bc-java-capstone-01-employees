package model;

public class Company {

//    Properties

    private String name;
    private String taxCode;
    private double revenueOfMonth;

//    Constructor

    public Company() {
    }

    public Company(String name, double revenueOfMonth, String taxCode) {
        this.name = name;
        this.revenueOfMonth = revenueOfMonth;
        this.taxCode = taxCode;
    }

//    Methods

    public double totalProfit (double totalSalaryOfEmployees) {
        return revenueOfMonth - totalSalaryOfEmployees;
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

    public double getRevenueOfMonth() {
        return revenueOfMonth;
    }

    public void setRevenueOfMonth(double revenueOfMonth) {
        this.revenueOfMonth = revenueOfMonth;
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
