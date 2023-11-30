package ru.geekbrains.lesson5.presenters;

import ru.geekbrains.lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    /**
     * Отображение списка столиков в приложении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер бронирования
     */
    void showReservationTableResult(int tableNo, int reservationNo);


    /**
     * Отобразить результат отмены бронирования столика
     * @param result результат отмены бронирования
     */
    void showDeleteReservationTableResult(int tableNo, boolean result);

    /**
     * Добавить наблюдателя за представлением
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    void reservationTable(Date orderDate, int tableNo, String name);

    /**
     * Действие клиента (пользователь нажал на кнопку отмены бронирования), отмена бронирование столика
     * @param idReservation номер бронирования
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    void deleteReservationTable(int idReservation, int tableNo);
    void changeReservationTable(int idReservation, Date orderDate, int tableNo, String name);

}
