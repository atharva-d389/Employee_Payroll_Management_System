package service;

public class PayrollImpl implements PayrollService{

	@Override
	public double calculatehra(double basicSalary) {
		
		return basicSalary*0.20;
	}

	@Override
	public double calculatepf(double basicSalary) {

		return basicSalary*0.12;
	}

	@Override
	public double calculateda(double basicSalary) {
		
		return basicSalary*0.10;
	}

	@Override
	public double calculatetax(double basicSalary) {
		// TODO Auto-generated method stub
		return basicSalary*0.5;
	}

	@Override
	public double calculateNetSalary(double basicSalary) {
		double hra = calculatehra(basicSalary);
        double da = calculateda(basicSalary);
        double pf = calculatepf(basicSalary);
        double tax = calculatetax(basicSalary);

        return basicSalary + hra + da - pf - tax;
	}

}
