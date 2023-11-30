package ru.geekbrains.lesson7.observer;

import java.util.ArrayList;

public interface CompanyActions {
    void needEmployee();
    ArrayList<Vacancy> getVacanciesList();
    String getCompanyName();
    int getMaxSalary();
    void setVacancies(ArrayList<Vacancy> vacancies);
}
