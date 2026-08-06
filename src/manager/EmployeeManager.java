package manager;

import model.*;
import util.InputHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {

    private Company company;
    private final List<Employee> employees;

    public EmployeeManager() {
        this.company = new Company();
        this.employees = new ArrayList<>(initialData());
    }

    /**
     * Initial data
     */
    private List<Employee> initialData() {
        Director director1 = new Director("DIRECTOR-001", "Director 1", "0987654321", 20, 10);
        Director director2 = new Director("DIRECTOR-002", "Director 2", "0987603321", 19, 12);

        Manager manager1 = new Manager("MANAGER-001", "Manager 1", "0987654321", 20);
        Staff staff1 = new Staff("STAFF-001", "Staff 1", "0977654321", 21, manager1);
        Staff staff2 = new Staff("STAFF-002", "Staff 2", "0978585466", 21, manager1);
        manager1.setManagedStaff(staff1, staff2);

        Manager manager2 = new Manager("MANAGER-002", "Manager 2", "0988654921", 18);
        Staff staff3 = new Staff("STAFF-003", "Staff 3", "0908754021", 20, manager2);
        manager2.addStaff(staff3);

        Staff staff4 = new Staff("STAFF-004", "Staff 4", "0907444021", 0, null);

        return Arrays.asList(director1, director2, manager1, manager2, staff1, staff2, staff3, staff4);
    }

    public void enterInfoCompany() {
        company.setName(InputHelper.readLine("Enter company name", "Name"));
        company.setTaxCode(InputHelper.readLine("Enter company tax code", "\\d{10,13}", "Tax Code must be 10 to 13 " +
                "digits"));
        company.setMonthlyRevenue(InputHelper.readDouble("Enter monthly revenue", "Monthly Revenue"));
        company.showInfo();
    }

    /**
     * Assign a staff to a manager
     */
    public void assignEmployeeToDeptManager() {
        Manager manager = null;
        Staff staff = null;

        String managerId = InputHelper.readLine("Enter manager ID", "ID");

        for (Employee employee : employees) {
            if (employee instanceof Manager && employee.getId().equals(managerId)) {
                manager = (Manager) employee;
                break;
            }
        }

        if (manager == null) {
            System.out.println("Invalid manager ID. Return to main menu.");
            return;
        }

        String staffId = InputHelper.readLine("Enter staff ID", "ID");

        for (Employee employee : employees) {
            if (employee instanceof Staff && employee.getId().equals(staffId)) {
                staff = (Staff) employee;
                break;
            }
        }

        if (staff == null) {
            System.out.println("Invalid staff ID. Return to main menu.");
            return;
        }

        manager.setManagedStaff(staff);
        staff.setManager(manager);
    }

    /**
     * Print information of all employees
     */
    public void getInfoOfAllEmployees() {
        for (Employee employee : employees) {
            employee.showInfo();
            System.out.println("|");
        }
    }

    /**
     * Get the total salary of all employees in the company
     */
    public double getAllSalaryOfCompany() {
        double totalSalary = 0;

        for (Employee employee : employees) {
            totalSalary += employee.calculateMonthlySalary();
        }

        return totalSalary;
    }

    /**
     * Find the staffs with the highest salary
     */
    public void findTopSalaryStaff() {
        ArrayList<Staff> topSalaryStaffs = new ArrayList<>();
        double maxSalary = 0;

        for (Employee employee : employees) {
            if (employee instanceof Staff) {
                if (employee.calculateMonthlySalary() > maxSalary) {
                    maxSalary = employee.calculateMonthlySalary();
                    topSalaryStaffs.clear();
                    topSalaryStaffs.add((Staff) employee);
                } else if (employee.calculateMonthlySalary() == maxSalary) {
                    topSalaryStaffs.add((Staff) employee);
                }
            }
        }

        if (topSalaryStaffs.size() != 0) {
            System.out.println("The staffs with the highest salary are:");
            System.out.printf("|%-14s|%-25s|%-12s|%-14s|%-13s|%-13s|%-25s|\n",
                    "ID", "Full Name", "Role", "Phone Number", "Working Days", "Daily Wage", "Manager");
            for (Staff staff : topSalaryStaffs) {
                staff.showExtraInfo();
            }

        } else {
            System.out.println("No staff has the highest salary.");
        }
    }

    /**
     * Find the managers with the most staff members managed
     */
    public void findManagerWithMostStaff() {
        ArrayList<Manager> managerWithMostStaffs = new ArrayList<>();
        int maxStaffCount = 0;

        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                Manager manager = (Manager) employee;
                int staffCount = manager.getManagedStaffCount();

                if (staffCount > maxStaffCount) {
                    maxStaffCount = staffCount;
                    managerWithMostStaffs.clear();
                    managerWithMostStaffs.add(manager);
                } else if (staffCount == maxStaffCount) {
                    managerWithMostStaffs.add(manager);
                }
            }
        }

        if (managerWithMostStaffs.size() != 0) {
            System.out.println("The managers with the most staff are: ");
            System.out.printf("|%-14s|%-25s|%-12s|%-14s|%-13s|%-13s|%-12s|\n",
                    "ID", "Full Name", "Role", "Phone Number", "Working Days", "Daily Wage", "No. of staff");
            for (Manager manager : managerWithMostStaffs) {
                manager.showExtraInfo();
            }
        } else {
            System.out.println("No manager has the most staff.");
        }
    }

    /**
     * Sort employees
     */
    public void sortEmployees(Comparator<Employee> comparator) {
        ArrayList<Employee> sortedList = new ArrayList<>(employees);

        sortedList.stream().sorted(comparator).forEach(employee -> {
            employee.showInfo();
            System.out.println();
        });
    }

    /**
     * Find the directors with the most share percent (%)
     */
    public void findDirectorWithMostSharePercent() {
        ArrayList<Director> directorWithMostSharePercents = new ArrayList<>();
        double maxSharePercent = 0;

        for (Employee employee : employees) {
            if (employee instanceof Director) {
                Director director = (Director) employee;
                double sharePercent = director.getSharePercent();
                if (sharePercent > maxSharePercent) {
                    maxSharePercent = sharePercent;
                    directorWithMostSharePercents.clear();
                    directorWithMostSharePercents.add(director);
                } else if (sharePercent == maxSharePercent) {
                    directorWithMostSharePercents.add(director);
                }
            }
        }

        if (directorWithMostSharePercents.size() != 0) {
            System.out.println("The directors with the most share percent are: ");
            System.out.printf("|%-14s|%-25s|%-12s|%-14s|%-13s|%-13s|%-12s|\n",
                    "ID", "Full Name", "Role", "Phone Number", "Working Days", "Daily Wage", "Share Percent (%)");
            for (Director director : directorWithMostSharePercents) {
                director.showExtraInfo();
            }
        } else {
            System.out.println("No director has the most share percent.");
        }
    }

    /**
     * Print the income of all directors
     */
    public void printIncomeOfDeptDirector() {
        double companyProfit = company.calculateCompanyProfit(getAllSalaryOfCompany());
        for (Employee employee : employees) {
            if (employee instanceof Director) {
                Director director = (Director) employee;
                System.out.printf("|%-14s|%-25s|%-14s|%-13.1f|%-13.2f|%-17.2f|%-12.2f|\n",
                        director.getId(), director.getFullName(), director.getPhoneNumber(),
                        director.getWorkingDays(), director.getDailyWage(), director.getSharePercent(),
                        director.calculateIncome(companyProfit));
            }
        }
    }

    /**
     * Print extra information of employees of a certain role
     */
    public void printExtraInformationOfEmployees() {
        String role = InputHelper.readLine("Enter role [STAFF|MANAGER|DIRECTOR]", "(STAFF|MANAGER|DIRECTOR)",
                "Role must be one of: STAFF, MANAGER, DIRECTOR");

        if (role.equals("STAFF")) {
            System.out.printf("|%-14s|%-25s|%-12s|%-14s|%-13s|%-13s|%-25s|\n",
                    "ID", "Full Name", "Role", "Phone Number", "Working Days", "Daily Wage", "Manager");
            _getEmployeesByType(Staff.class).forEach(Employee::showExtraInfo);
        } else if (role.equals("MANAGER")) {
            System.out.printf("|%-14s|%-25s|%-12s|%-14s|%-13s|%-13s|%-12s|\n",
                    "ID", "Full Name", "Role", "Phone Number", "Working Days", "Daily Wage", "No. of staff");
            _getEmployeesByType(Manager.class).forEach(Employee::showExtraInfo);
        } else {
            System.out.printf("|%-14s|%-25s|%-12s|%-14s|%-13s|%-13s|%-12s|\n",
                    "ID", "Full Name", "Role", "Phone Number", "Working Days", "Daily Wage", "Share Percent (%)");
            _getEmployeesByType(Director.class).forEach(Employee::showExtraInfo);
        }
    }

    private <T extends Employee> List<T> _getEmployeesByType(Class<T> type) {
        return employees.parallelStream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());
    }
}
