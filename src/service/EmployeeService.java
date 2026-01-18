package service;

public interface EmployeeService {

    void registerEmployee();
    void modifyEmployeeDetails(int employeeId);
    void calculateSalary(int employeeId);
    void generatePaySlip(int employeeId);
    void displayEmployee(int employeeId);
    void displayAllEmployees();
    void removeEmployee(int employeeId);
}
