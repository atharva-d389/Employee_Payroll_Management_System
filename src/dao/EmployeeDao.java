package dao;

import model.Employee;

public interface EmployeeDao {

    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    Employee getEmployeeById(int employeeId);
    Employee[] getAllEmployees();
    boolean deleteEmployee(int employeeId);
    boolean updateSalary(int employeeId, double netSalary);
}
