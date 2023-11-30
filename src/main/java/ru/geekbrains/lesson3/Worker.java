package ru.geekbrains.lesson3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Worker extends Employee{

    public Worker(String name, String surName, BigDecimal salary, int age) {
        super(name, surName, salary, age);
    }

    @Override
    protected BigDecimal calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s. Возраст: %d лет. Рабочий. Среднемесячная зарплата (фиксированная): %s (руб.)"
                            , surName, name, age, calculateSalary().setScale(2, RoundingMode.HALF_UP).toString());
    }

    @Override
    public int compareTo(Employee o) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    
    
}
