package testing;

public class Controller implements Employee {
    private int monthSalary;

    public Controller(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    @Override
    public int getMonthSalary() {
        return this.monthSalary;
    }
}
