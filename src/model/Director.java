package model;

public class Director extends Employee {

//    Properties

    private static final double DEFAULT_DAILY_WAGE = 300;
    private double sharePercent;

//    Constructor

    public Director() {
        super();
    }

    public Director(String id, String fullName, String phoneNumber, double workingDays, double sharePercent) {
        super(id, fullName, phoneNumber, workingDays, Director.DEFAULT_DAILY_WAGE);

        setSharePercent(sharePercent);
    }

//    Methods

    public double calculateIncome(double companyProfit) {
        return calculateMonthlySalary() + (sharePercent / 100) * companyProfit;
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
        return "DIRECTOR";
    }

    //    Getter and Setter

    public double getSharePercent() {
        return sharePercent;
    }

    public void setSharePercent(double sharePercent) {
        if (sharePercent < 0 || sharePercent > 100) {
            throw new IllegalArgumentException("Phần trăm cổ phần phải nằm trong khoảng từ 0 - 100");
        }

        this.sharePercent = sharePercent;
    }
}
