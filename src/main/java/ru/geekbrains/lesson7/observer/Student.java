package ru.geekbrains.lesson7.observer;

import java.util.ArrayList;

public class Student implements Observer{

    private String name;
    private int salary = 2000;

    private ArrayList<VacancyType> vacancyTypes;

    public Student(String name, ArrayList<VacancyType> vacancyTypes) {
        this.name = name;
        this.vacancyTypes = vacancyTypes;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean receiveOffer(String nameCompany, Vacancy vacancy) {
        int offerSalary = vacancy.getSalary();
        if (this.salary <= offerSalary) {
            System.out.printf("Студент %s: Мне нужна эта работа! (компания: %s; вакансия: %s; заработная плата: %d)\n",
                    name, nameCompany, vacancy.getName(), offerSalary);
            this.salary = offerSalary;
            return true;
        }
        else {
            System.out.printf("Студент %s: Я найду работу получше! (компания: %s; вакансия: %s; заработная плата: %d)\n",
                    name, nameCompany, vacancy.getName(), offerSalary);
            return false;
        }
    }

    @Override
    public ArrayList<VacancyType> getVacancyTypeList() {
        return vacancyTypes;
    }
}
