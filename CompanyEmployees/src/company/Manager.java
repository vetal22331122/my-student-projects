package company;

public class Manager implements Employee {
    private double fixedSalary;
    private Company company;
    private boolean isEmployed;

    public Manager (double fixedSalary) {
        this.isEmployed = false;
        this.fixedSalary = fixedSalary;
    }

    public Company getCompany() {
        return this.company;
    }



    @Override
    public double getMonthSalary() {
        return Company.formatSalary(fixedSalary + this.company.getIncome() * 0.05);
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public void setStatus(boolean status) {
        this.isEmployed = status;
    }
}
