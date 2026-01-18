package model;

public class Payroll {

    private double basicSalary;
    private double hra;
    private double da;
    private double pf;
    private double tax;
    private double netSalary;

    
    public Payroll() {
    }


    public Payroll(double basicSalary) {
        this.basicSalary = basicSalary;
    }

  
    public Payroll(double basicSalary, double hra, double da,
                   double pf, double tax, double netSalary) {
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.pf = pf;
        this.tax = tax;
        this.netSalary = netSalary;
    }


    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
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

    public double getPf() {
        return pf;
    }

    public void setPf(double pf) {
        this.pf = pf;
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
        return "Payroll [Basic Salary=" + basicSalary +
               ", HRA=" + hra +
               ", DA=" + da +
               ", PF=" + pf +
               ", Tax=" + tax +
               ", Net Salary=" + netSalary + "]";
    }
}
