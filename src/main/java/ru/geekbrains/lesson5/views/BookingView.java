package ru.geekbrains.lesson5.views;

import ru.geekbrains.lesson5.models.Reservation;
import ru.geekbrains.lesson5.models.Table;
import ru.geekbrains.lesson5.presenters.View;
import ru.geekbrains.lesson5.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Отобразить столики на экране приложения
     *
     * @param tables коллекция столиков
     */
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
            Collection<Reservation> reservations = table.getReservations();
            for (Reservation reservation : reservations) {
                System.out.println("  " + reservation);
            }
        }
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер бронирования
     */
    @Override
    public void showReservationTableResult(int tableNo, int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик %d успешно забронирован. Номер вашей брони: #%d\n", tableNo, reservationNo);
        }
        else {
            System.out.println("Не удалось забронировать столик, повторите попытку позже.");
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void reservationTable(Date orderDate, int tableNo, String name){
        if (observer != null)
            observer.onReservationTable(orderDate, tableNo, name);

    }

    /**
     * TODO: Доработать в рамках домашней работы
     * Действие клиента, отмена бронирования столика
     * @param oldReservation идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void deleteReservationTable(int oldReservation, int tableNo){
        if (observer != null)
            observer.onDeleteReservationTable(oldReservation,  tableNo);
    }

    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        if (observer != null)
            observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }

    @Override
     public void showDeleteReservationTableResult(int tableNo, boolean result) {
        if (result) {
            System.out.printf("Бронирование столика %d успешно отменено.\n", tableNo);
        } else {
            System.out.printf("Не удалось отменть бронирование столика %d, проверьте корректность вводимых данных.\n", tableNo);
        }
    }


}
