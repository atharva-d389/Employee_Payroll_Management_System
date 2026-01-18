package service;

public interface PayrollService {

	
	double calculatehra(double basicSalary);
	double calculatepf(double basicSalary);
	double calculateda(double basicSalary);
	double calculatetax(double basicSalary);
	double calculateNetSalary(double basicSalary);
}
