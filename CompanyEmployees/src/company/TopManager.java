package company;

public class TopManager implements Employee {
    private double fixedSalary;
    private Company company;
    private boolean isEmployed;

    public TopManager (double fixedSalary) {
        this.isEmployed = false;
        this.fixedSalary = fixedSalary;
    }

    public Company getCompany() {
        return this.company;
    }


    @Override
    public double getMonthSalary() {
        if (this.getCompany().getIncome() > 1000000) {
            return Company.formatSalary(this.fixedSalary * 2.5);
        }
        return Company.formatSalary(this.fixedSalary);
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
