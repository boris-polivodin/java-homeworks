package ru.geekbrains.lesson7.observer;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JobAgency implements Publisher {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void sendOffer(String companyName, Vacancy vacancy) {
        List<Observer> observersOnDelete = new ArrayList<>();
        for (Observer observer : observers) {
            Optional<VacancyType> vacancyType = observer.getVacancyTypeList().stream().filter(r -> r == vacancy.getVacancyType()).findFirst();
            if (vacancyType.isPresent()) {
                if (observer.receiveOffer(companyName, vacancy)) {
                    vacancy.getCompany().getVacanciesList().remove(vacancy);
                    observersOnDelete.add(observer);
                    break;
                }
            }
        }
        for (Observer observer : observersOnDelete) {
            observers.remove(observer);
        }
    }

    @Override
    public List<Observer> getObserversList() {
        return observers;
    }
}
