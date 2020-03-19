import company.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        //создаем компанию
        Company daewoo = new Company(10000001);
        //создаем список сотрудников для найма согласно условиям
        ArrayList<Employee> newEmployees = new ArrayList<>();
        for (int i = 1; i <= 180; i++) {
            if (i <= 10) {
                newEmployees.add(new TopManager(Math.floor(Math.random() * 30000 + 120000)));
            }
            if (i <= 80) {
                newEmployees.add(new Manager(Math.floor(Math.random() * 20000 + 70000)));
            }
            newEmployees.add(new Operator(Math.floor(Math.random() * 20000 + 30000)));
        }
        //нанимаем всех сотрудников из списка
        daewoo.hireAll(newEmployees);
        //10 самых высоких зарплат
        int j = 1;
        System.out.println("10 самых высоких зарплат:");
        for(Employee e : daewoo.getTopSalaryStaff(5)) {
            System.out.println(j + ". " + formatter.format(e.getMonthSalary()) + " руб.");
            j++;
        }
        System.out.println("==================================================================");
        //30 самых низких зарплат
        System.out.println("30 самых низких зарплат:");
        j = 1;
        for(Employee e : daewoo.getLowestSalaryStaff(5)) {
            System.out.println(j + ". " + formatter.format(e.getMonthSalary()) + " руб.");
            j++;
        }
        System.out.println("==================================================================");
        //увольняем 50% случайных сотрудников
        daewoo.fireFiftyPercent();
        System.out.println("==================================================================");
        //10 самых высоких зарплат после увольнения
        System.out.println("10 самых высоких зарплат после увольнения:");
        j = 1;
        for(Employee e : daewoo.getTopSalaryStaff(10)) {
            System.out.println(j + ". " + formatter.format(e.getMonthSalary()) + " руб.");
            j++;
        }
        System.out.println("==================================================================");
        //30 самых низких зарплат после увольнения
        System.out.println("30 самых низких зарплат после увольнения:");
        j = 1;
        for(Employee e : daewoo.getLowestSalaryStaff(30)) {
            System.out.println(j + ". " + formatter.format(e.getMonthSalary()) + " руб.");
            j++;
        }
    }
}

