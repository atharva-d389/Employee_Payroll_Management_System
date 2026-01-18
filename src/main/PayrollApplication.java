package main;

import java.util.Scanner;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class PayrollApplication {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== EMPLOYEE PAYROLL SYSTEM ===");
            System.out.println("1. Register Employee");
            System.out.println("2. Update Employee Details");
            System.out.println("3. Calculate Salary");
            System.out.println("4. Generate Payslip");
            System.out.println("5. Display Employee");
            System.out.println("6. Display All Employees");
            System.out.println("7. Remove Employee");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    service.registerEmployee();
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    service.modifyEmployeeDetails(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    service.calculateSalary(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    service.generatePaySlip(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Employee ID: ");
                    service.displayEmployee(sc.nextInt());
                    break;

                case 6:
                    service.displayAllEmployees();
                    break;

                case 7:
                    System.out.print("Enter Employee ID: ");
                    service.removeEmployee(sc.nextInt());
                    break;

                case 8:
                    System.out.println("Thank you! Exiting system.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
