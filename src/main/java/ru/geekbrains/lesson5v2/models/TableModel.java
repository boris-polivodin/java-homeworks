package ru.geekbrains.lesson5v2.models;

import ru.geekbrains.lesson5v2.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class TableModel implements Model {


    private Collection<Table> tables;

    /**
     * Получить все столки
     *
     */
    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    @Override
    public Optional<Collection<Table>> loadOptionalTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return  Optional.of(tables);
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate Дата бронирования
     * @param tableNo         номер столика
     * @param name            Имя
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
//        for (Table table : loadTables()) {
//            if (table.getNo() == tableNo) {
//                Reservation reservation = new Reservation(reservationDate, name);
//                table.getReservations().add(reservation);
//                return reservation.getId();
//            }
//        }
//        throw new RuntimeException("Некорректный номер столика.");

        Optional<Table> table = loadTables().stream().filter(t -> t.getNo() == tableNo).findFirst();
        if (table.isPresent()){
            Reservation reservation = new Reservation(reservationDate, name);
            table.get().getReservations().add(reservation);
            return reservation.getId();
        }
        throw new RuntimeException("Некорректный номер столика");
    }

//    //**
//     * TODO: Разработать самостоятельно
//     * Изменить бронь столика
//     * @param oldReservation номер старого резерва (для снятия)
//     * @param reservationDate дата резерва столика
//     * @param tableNo номер столика
//     * @param name Имя
//    */
    @Override
    public boolean deleteReservationTable(int oldReservation, int tableNo) {
        for (Table table: loadTables()) {
            if (table.getNo() == tableNo) {
                Collection<Reservation> reservations = table.getReservations();
                for (Reservation reservation : reservations) {
                    if (reservation.getId() == oldReservation) {
                        return reservations.remove(reservation);
                    }
                }
            }
        }
        return false;
    }


    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
//        if (deleteReservationTable(idReservation, tableNo)) {
//            return reservationTable(reservationDate, tableNo, name);
//        }
//        return -2;

        for (Table table: tables) {
            Optional<Reservation> reservation = table.getReservations().stream().filter(r -> r.getId() == oldReservation).findFirst();
            if (reservation.isPresent())
            {
                table.getReservations().remove(reservation.get());
                return reservationTable(reservationDate, tableNo, name);
            }
        }
        throw new RuntimeException("Некорректный номер брони");
    }

}
