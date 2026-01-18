package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Employee;
import util.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean addEmployee(Employee employee) {
		
		 String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql))
		{
			ps.setInt(1, employee.getEmployeeId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getDepartment());
            ps.setString(4, employee.getDesignation());
            ps.setString(5, employee.getEmail());
            ps.setDouble(6, employee.getBasicSalary());
            ps.setDouble(7, employee.getHra());
            ps.setDouble(8, employee.getDa());
            ps.setDouble(9, employee.getPf());
            ps.setDouble(10, employee.getTax());
            ps.setDouble(11, employee.getNetSalary());

            return ps.executeUpdate() > 0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		
		String sql = "UPDATE employee SET name=?, department=?, designation=?, email=? WHERE employeeId=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {
        	
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDepartment());
            ps.setString(3, employee.getDesignation());
            ps.setString(4, employee.getEmail());
            ps.setInt(5, employee.getEmployeeId());

            return ps.executeUpdate() > 0;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		return false;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		
		String sql = "Select * from employee where employeeId = ?";
		 try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, employeeId);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) 
	            {
	                Employee emp = new Employee();
	                emp.setEmployeeId(rs.getInt("employeeId"));
	                emp.setName(rs.getString("name"));
	                emp.setDepartment(rs.getString("department"));
	                emp.setDesignation(rs.getString("designation"));
	                emp.setEmail(rs.getString("email"));
	                emp.setBasicSalary(rs.getDouble("basicSalary"));
	                emp.setHra(rs.getDouble("hra"));
	                emp.setDa(rs.getDouble("da"));
	                emp.setPf(rs.getDouble("pf"));
	                emp.setTax(rs.getDouble("tax"));
	                emp.setNetSalary(rs.getDouble("netSalary"));
	                return emp;
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		return null;
	}

	@Override
	public Employee[] getAllEmployees() {

		 Employee[] employees = null;

	        try (Connection con = DBConnection.getConnection()) {
	           
	            String countSql = "SELECT COUNT(*) FROM employee";
	            
	            PreparedStatement countPs = con.prepareStatement(countSql);
	            ResultSet countRs = countPs.executeQuery();
	            countRs.next();
	            int count = countRs.getInt(1);

	            employees = new Employee[count];

	            String sql = "SELECT * FROM employee";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            int index = 0;
	            while (rs.next()) {
	                Employee emp = new Employee();
	                emp.setEmployeeId(rs.getInt("employeeId"));
	                emp.setName(rs.getString("name"));
	                emp.setDepartment(rs.getString("department"));
	                emp.setDesignation(rs.getString("designation"));
	                emp.setEmail(rs.getString("email"));
	                emp.setBasicSalary(rs.getDouble("basicSalary"));
	                emp.setHra(rs.getDouble("hra"));
	                emp.setDa(rs.getDouble("da"));
	                emp.setPf(rs.getDouble("pf"));
	                emp.setTax(rs.getDouble("tax"));
	                emp.setNetSalary(rs.getDouble("netSalary"));

	                employees[index++] = emp;
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return employees;
		
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		
		String sql = "DELETE FROM employee WHERE employeeId=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, employeeId);
            return ps.executeUpdate() > 0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean updateSalary(int employeeId, double netSalary) {
		
		String sql = "update employee set netSalary = ? where employeeId = ?";
		try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) 
		{
	            ps.setDouble(1, netSalary);
	            ps.setInt(2, employeeId);

	            return ps.executeUpdate() > 0;
	    } 
		catch (Exception e)
		{
	            e.printStackTrace();
	    }
	        return false;
	}

}
