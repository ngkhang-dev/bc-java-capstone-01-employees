package manager;

import model.Director;
import model.Employee;
import model.Manager;
import model.Staff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeManager {

    private List<Employee> employees;

    public EmployeeManager() {
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

    /**
     * Print information of all employees
     */
    public void getInfoOfAllEmployees() {
        for (Employee employee : employees) {
            employee.showInfo();
            System.out.println("|");
        }
    }
}
