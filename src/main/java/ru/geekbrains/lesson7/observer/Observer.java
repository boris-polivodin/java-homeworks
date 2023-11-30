package ru.geekbrains.lesson7.observer;

import java.util.ArrayList;

public interface Observer {

    boolean receiveOffer(String nameCompany, Vacancy vacancy);
    ArrayList<VacancyType> getVacancyTypeList();

}
