package ru.geekbrains.lesson3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lesson3 {

    static String[] names = {"Иван", "Семен", "Дмитрий", "Алексей", "Александр", "Антон", "Николай"
                            , "Сергей", "Федор", "Илья", "Виктор", "Андрей"};
    static String[] surNames = {"Иванов", "Смирнов", "Кузнецов", "Васильев", "Петров", "Соколов", "Михайлов"
                            , "Новиков", "Фёдоров", "Морозов", "Волков", "Лебедев", "Хохлов", "Яковлев", "Захаров"};
    
    static Random rnd = new Random();

    private static Worker generateWorker() {
        return new Worker(names[rnd.nextInt(names.length)]
                            , surNames[rnd.nextInt(surNames.length)]
                            , new BigDecimal(rnd.nextDouble(50000, 150000))
                            , rnd.nextInt(18, 65));
    }

    private static Freelancer generateFreelancer() {
        return new Freelancer(names[rnd.nextInt(names.length)]
                            , surNames[rnd.nextInt(surNames.length)]
                            , new BigDecimal(rnd.nextDouble(2000, 3000))
                            , rnd.nextDouble(100d)
                            , rnd.nextInt(18, 65));
    }

    private static ArrayList<Employee> generateEmployees(int length) {
     
        ArrayList<Employee> employees = new ArrayList<>(length);
        for (int index = 0; index < length; index++) {
            int switcher = rnd.nextInt(2);
            switch (switcher) {
                case 0:
                    employees.add(index, generateWorker());
                    break;
                case 1:
                    employees.add(index, generateFreelancer());
                    break;
                default:
                    break;
            }
        }

        return employees;
    }

    public static void launchLesson3(String[] args) {

        ArrayList<Employee> employees = generateEmployees(10);

        Employee[] arrEmployees = employees.toArray(new Employee[0]);

        Arrays.sort(arrEmployees, new EmployeeComparator(TypeSorting.DECREASE, "surName"));

        for (Employee employee : arrEmployees) {
            System.out.println(employee);
        }

        System.out.println();

        Arrays.sort(arrEmployees, new EmployeeComparator(TypeSorting.INCREASE, "salary"));

        for (Employee employee : arrEmployees) {
            System.out.println(employee);
        }

        System.out.println();

        Arrays.sort(arrEmployees, new EmployeeComparator(TypeSorting.DECREASE, "age"));

        for (Employee employee : arrEmployees) {
            System.out.println(employee);
        }
        

    }
}
