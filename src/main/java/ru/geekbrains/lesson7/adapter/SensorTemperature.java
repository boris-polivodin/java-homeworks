package ru.geekbrains.lesson7.adapter;

public interface SensorTemperature {

    int getIdentifier(); // Уникальный идентификатор датчика

    double temperature(); // Средняя температура

}
