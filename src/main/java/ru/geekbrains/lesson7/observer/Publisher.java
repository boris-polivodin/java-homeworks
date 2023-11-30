package ru.geekbrains.lesson7.observer;

import java.util.List;

public interface Publisher {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    void sendOffer(String companyName, Vacancy vacancy);

    List<Observer> getObserversList();

}
