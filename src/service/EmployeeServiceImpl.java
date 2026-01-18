package service;

import java.util.Scanner;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao ed = new EmployeeDaoImpl();
    private PayrollService payrollService = new PayrollImpl();
    private Scanner sc = new Scanner(System.in);

    
    @Override
    public void registerEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = sc.nextDouble();

        Employee emp = new Employee(id, name, department, designation, email, basicSalary);

        boolean result = false;
        try {
            result = ed.addEmployee(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result) {
            System.out.println("Employee registered successfully.");
        } else {
            System.out.println("Failed to register employee.");
        }
    }

   
    @Override
    public void modifyEmployeeDetails(int employeeId) {

        Employee emp = ed.getEmployeeById(employeeId);

        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }

        sc.nextLine();
        System.out.print("Enter New Name: ");
        emp.setName(sc.nextLine());

        System.out.print("Enter New Department: ");
        emp.setDepartment(sc.nextLine());

        System.out.print("Enter New Designation: ");
        emp.setDesignation(sc.nextLine());

        System.out.print("Enter New Email: ");
        emp.setEmail(sc.nextLine());

        boolean updated = ed.updateEmployee(emp);

        if (updated) {
            System.out.println("Employee details updated successfully.");
        } else {
            System.out.println("Update failed.");
        }
    }

    
    @Override
    public void calculateSalary(int employeeId) {

        Employee emp = ed.getEmployeeById(employeeId);

        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }

        double basic = emp.getBasicSalary();

        double hra = payrollService.calculatehra(basic);
        double da = payrollService.calculateda(basic);
        double pf = payrollService.calculatepf(basic);
        double tax = payrollService.calculatetax(basic);
        double netSalary = payrollService.calculateNetSalary(basic);

        emp.setHra(hra);
        emp.setDa(da);
        emp.setPf(pf);
        emp.setTax(tax);
        emp.setNetSalary(netSalary);

        boolean updated = ed.updateSalary(employeeId, netSalary);

        if (updated) {
            System.out.println("Salary calculated successfully.");
        } else {
            System.out.println("Salary update failed.");
        }
    }

    
    @Override
    public void generatePaySlip(int employeeId) {

        Employee emp = ed.getEmployeeById(employeeId);

        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("------ PAY SLIP ------");
        System.out.println("Employee ID   : " + emp.getEmployeeId());
        System.out.println("Name          : " + emp.getName());
        System.out.println("Designation   : " + emp.getDesignation());
        System.out.println("Basic Salary  : " + emp.getBasicSalary());
        System.out.println("HRA           : " + emp.getHra());
        System.out.println("DA            : " + emp.getDa());
        System.out.println("PF            : " + emp.getPf());
        System.out.println("Tax           : " + emp.getTax());
        System.out.println("Net Salary    : " + emp.getNetSalary());
    }

   
    @Override
    public void displayEmployee(int employeeId) {

        Employee emp = ed.getEmployeeById(employeeId);

        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found.");
        }
    }

    
    @Override
    public void displayAllEmployees() {

        Employee[] employees = ed.getAllEmployees();

        if (employees == null || employees.length == 0) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    
    @Override
    public void removeEmployee(int employeeId) {

        boolean deleted = ed.deleteEmployee(employeeId);

        if (deleted) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found or deletion failed.");
        }
    }
}
