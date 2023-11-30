package ru.geekbrains.lesson5.presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);

    void onDeleteReservationTable(int idReservation, int tableNo);
    void onChangeReservationTable(int idReservation, Date orderDate, int tableNo, String name);

}
