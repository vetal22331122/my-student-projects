package testing;

public class Manager implements Employee {
    private int monthSalary;

    public Manager(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    @Override
    public int getMonthSalary() {
        return this.monthSalary;
    }
}
