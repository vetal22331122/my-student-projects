package company;

public class Operator implements Employee {
    private double fixedSalary;
    private Company company;
    private boolean isEmployed;

    public Operator (double fixedSalary) {
        this.isEmployed = false;
        this.fixedSalary = fixedSalary;
    }

    public Company getCompany() {
        return this.company;
    }

    @Override
    public double getMonthSalary() {
        return Company.formatSalary(this.fixedSalary);
    }

    @Override
    public void setCompany (Company company) {
        this.company = company;
    }

    @Override
    public void setStatus(boolean status) {
        this.isEmployed = status;
    }
}
