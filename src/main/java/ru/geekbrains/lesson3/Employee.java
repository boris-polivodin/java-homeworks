package ru.geekbrains.lesson3;

import java.math.BigDecimal;

public abstract class Employee implements Comparable<Employee> {
    
    protected String name;
    protected String surName;
    protected BigDecimal salary;
    protected int age;

    public Employee(String name, String surName, BigDecimal salary) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
        this.age = 0;
    }

    public Employee(String name, String surName, BigDecimal salary, int age) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
        this.age = age;
    }


    protected abstract BigDecimal calculateSalary();
    
}
