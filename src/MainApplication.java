import manager.EmployeeManager;
import model.Company;
import ui.Menu;

public class MainApplication {

    public static void main(String[] args) {
        Menu menu = new Menu("Employee Management System");

        menu.addOption("Enter information of company");
        menu.addOption("Print information of employees in the company");

        int choice;
        EmployeeManager hrManager = new EmployeeManager();

        menu.printGreeting();

        do {
            menu.printMenu();
            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter information of company");
                    // TODO: Implement company input
                    break;
                case 2:
                    System.out.println("\nPrint information of employees in the company");
                    System.out.printf("|%-14s|%-25s|%-12s|%-14s|%-13s|%-13s|\n", "ID", "Full Name","Role", "Phone Number", "Working Days", "Daily Wage");
                    hrManager.getInfoOfAllEmployees();
                    break;
                case 0:
                    System.out.println("Quit");
                    break;
            }

        } while (choice != 0);

    }

}
