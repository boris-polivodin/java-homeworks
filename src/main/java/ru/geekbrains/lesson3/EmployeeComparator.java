package ru.geekbrains.lesson3;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    TypeSorting typeSorting;
    String fieldSorting;

    public EmployeeComparator(TypeSorting typeSorting, String fieldSorting) {
        this.typeSorting = typeSorting;
        this.fieldSorting = fieldSorting;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        if (fieldSorting.equals("surName")) {
            return sortingSurNames(o1, o2);
        } else if (fieldSorting.equals("salary")) {
            return sortingSalary(o1, o2);
        } else if (fieldSorting.equals("age")) {
            return sortingAge(o1, o2);
        } else {
            return o1.compareTo(o2);
        }
    }

    private int sortingSurNames(Employee o1, Employee o2) {
        int result;
        if (typeSorting.equals(TypeSorting.INCREASE)) {
            result =  o1.surName.compareTo(o2.surName);
            if (result == 0) {
               result =  o1.name.compareTo(o2.name); 
            }
        } else {
            result = o2.surName.compareTo(o1.surName);
            if (result == 0) {
                result = o2.name.compareTo(o1.name);
            }
        }
        return result;   
    }

    private int sortingSalary(Employee o1, Employee o2) {
        if (typeSorting.equals(TypeSorting.INCREASE)) {
            return o1.calculateSalary().compareTo(o2.calculateSalary());
        } else {
            return o2.calculateSalary().compareTo(o1.calculateSalary());
        }   
    }

    private int sortingAge(Employee o1, Employee o2) {
        if (typeSorting.equals(TypeSorting.INCREASE)) {
            return Integer.compare(o1.age, o2.age);
        } else {
            return Integer.compare(o2.age, o1.age);
        }   
    }
    
}
