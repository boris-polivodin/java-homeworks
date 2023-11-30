package ru.geekbrains.lesson3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Freelancer extends Employee {

    private Double hoursWorked;


    public Freelancer(String name, String surName, BigDecimal salary, int age) {
        this(name, surName, salary, 0d, age);
    }

    public Freelancer(String name, String surName, BigDecimal salary, Double hoursWorked, int age) {
        super(name, surName, salary, age);
        this.hoursWorked = hoursWorked;
    }

    @Override
    protected BigDecimal calculateSalary() {
        return salary.multiply(new BigDecimal(hoursWorked));
    }

    @Override
    public String toString() {
        return String.format("%s %s.  Возраст: %d лет. Фрилансер. Среднемесячная зарплата (почасовая): %s (руб.) за %.1f отработанных часов по ставке %s (руб.)."
                            , surName, name, age, calculateSalary().setScale(2, RoundingMode.HALF_UP).toString(), hoursWorked, salary.setScale(0, RoundingMode.HALF_UP).toString());
    }

    @Override
    public int compareTo(Employee o) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    
    
}
