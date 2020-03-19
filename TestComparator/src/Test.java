import testing.Controller;
import testing.Employee;
import testing.EmployeeComparator;
import testing.Manager;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Manager id1 = new Manager(100);
        Manager id2 = new Manager(130);
        Manager id3 = new Manager(140);
        Manager id4 = new Manager(130);
        Manager id5 = new Manager(150);
        Manager id6 = new Manager(170);
        Controller id7 = new Controller(784);
        Controller id8 = new Controller(7896);
        Controller id9 = new Controller(786);
        Controller id10 = new Controller(784);
        Controller id11 = new Controller(787);
        Controller id12 = new Controller(1);

        ArrayList<Employee> shit = new ArrayList<>();
        shit.add(id1);
        shit.add(id2);
        shit.add(id3);
        shit.add(id4);
        shit.add(id5);
        shit.add(id6);
        shit.add(id7);
        shit.add(id8);
        shit.add(id9);
        shit.add(id10);
        shit.add(id11);
        shit.add(id12);

        for (Employee employee : shit) {
            System.out.println(employee.getMonthSalary());
        }

        EmployeeComparator shitCompare = new EmployeeComparator();
        shit.sort(shitCompare);
        System.out.println("=======================================================");

        for (Employee employee : shit) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("=======================================================");
        TreeSet<Employee> shitTree = new TreeSet<>();
        shitTree.addAll(shit);
        for (Employee employee : shitTree) {
            System.out.println(employee.getMonthSalary());
        }



    }
}
