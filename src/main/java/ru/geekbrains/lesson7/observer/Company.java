package ru.geekbrains.lesson7.observer;

import java.util.ArrayList;

public class Company implements CompanyActions{

    private String name;

    private Publisher jobAgency;

    private int maxSalary;

    private ArrayList<Vacancy> vacancies;

    @Override
    public void setVacancies(ArrayList<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    @Override
    public ArrayList<Vacancy> getVacanciesList() {
        return vacancies;
    }

    @Override
    public String getCompanyName() {
        return name;
    }

    @Override
    public int getMaxSalary() {
        return maxSalary;
    }

    public Company(String name, Publisher jobAgency, int maxSalary) {
        this.name = name;
        this.jobAgency = jobAgency;
        this.maxSalary = maxSalary;
    }

    @Override
    public void needEmployee(){
        for (int i = 0; i < vacancies.size(); i++)
            jobAgency.sendOffer(name, vacancies.get(i));

    }

}
