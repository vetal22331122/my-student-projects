package company;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.*;

public class Company {
    private final double income;
    private static ArrayList<Employee> employeesList = new ArrayList<>();

    public Company(double income) {
        this.income = income;
    }

    public void hire (Employee employee) {
        employee.setCompany(this);
        employee.setStatus(true);
        employeesList.add(employee);
    }

    public void hireAll (ArrayList<Employee> list) {
        for (Employee employee : list) {
            employee.setStatus(true);
            employee.setCompany(this);
        }
        employeesList.addAll(list);
        System.out.println("Нанято " + list.size() + " сотрудников");
        System.out.println("==================================================");
    }

    public void fire (Employee employee) {
        employee.setCompany(null);
        employee.setStatus(false);
        employeesList.remove(employee);
    }

    protected double getIncome() {
        return this.income;
    }

    protected ArrayList<Employee> getEmployeesList () {
        return employeesList;
    }

    public List<Employee> getLowestSalaryStaff (int count) {
        TreeSet<Employee> lowestTree = new TreeSet<>(new EmployeeComparator());
        lowestTree.addAll(employeesList);
        return new ArrayList<>(lowestTree).subList(0, count);
    }

    public List<Employee> getTopSalaryStaff (int count) {
        Collections.sort(employeesList, new EmployeeComparator());
        Collections.reverse(employeesList);
        return employeesList.subList(0, count);
    }

    public void fireFiftyPercent () {
        int halfOriginalEmployeesCount = employeesList.size()/2;
        int firePersonId;
        for (int i = 0; i < halfOriginalEmployeesCount; i++) {
            firePersonId = (int) (Math.random()*employeesList.size());
            fire(employeesList.get(firePersonId));
        }
        System.out.println("Уволено " + halfOriginalEmployeesCount + " сотрудников");
    }

    //метод для округления зарплат вниз до десятков
    protected static double formatSalary (double salaryToFormat) {
        return new BigDecimal(salaryToFormat).setScale(-1, RoundingMode.DOWN).doubleValue();
    }
}
