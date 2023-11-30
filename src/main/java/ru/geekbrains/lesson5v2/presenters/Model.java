package ru.geekbrains.lesson5v2.presenters;

import ru.geekbrains.lesson5v2.models.Table;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public interface Model {

    Collection<Table> loadTables();

    Optional<Collection<Table>> loadOptionalTables();

    int reservationTable(Date reservationDate, int tableNo, String name);

    boolean deleteReservationTable(int idReservation, int tableNo);
    int changeReservationTable(int idReservation, Date reservationDate, int tableNo, String name);

}
