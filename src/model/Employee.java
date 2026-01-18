package model;

public class Employee {

	private int employeeId;
	private String name;
	private String department;
	private String designation;
	private String email;
	private double basicSalary;
	private double pf;
	private double hra;
	private double da;
	private double tax;
	private double netSalary;
	
	public Employee()
	{
		
	}
	
	public Employee(int employeeId, String name, String department,
            String designation, String email, double basicSalary) {
this.employeeId = employeeId;
this.name = name;
this.department = department;
this.designation = designation;
this.email = email;
this.basicSalary = basicSalary;
}
	
	public Employee(int employeeId, String name, String department, String designation, String email,
			double basicSalary, double pf, double hra, double da, double tax, double netSalary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.email = email;
		this.basicSalary = basicSalary;
		this.pf = pf;
		this.hra = hra;
		this.da = da;
		this.tax = tax;
		this.netSalary = netSalary;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getPf() {
		return pf;
	}
	public void setPf(double pf) {
		this.pf = pf;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getDa() {
		return da;
	}
	public void setDa(double da) {
		this.da = da;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", department=" + department + ", designation="
				+ designation + ", email=" + email + ", basicSalary=" + basicSalary + ", pf=" + pf + ", hra=" + hra
				+ ", da=" + da + ", tax=" + tax + ", netSalary=" + netSalary + "]";
	}
	
	
}
