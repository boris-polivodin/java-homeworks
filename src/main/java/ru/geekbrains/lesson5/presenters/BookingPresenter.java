package ru.geekbrains.lesson5.presenters;

import ru.geekbrains.lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    private Collection<Table> loadTables(){
        return model.loadTables();
    }

    /**
     * Отобразить список столиков
     */
    public void updateUIShowTables(){
        view.showTables(loadTables());
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер бронирования
     */
    private void updateUIShowReservationTableResult(int tableNo, int reservationNo){
        view.showReservationTableResult(tableNo, reservationNo);
    }

    /**
     * Отобразить результат отмены бронирования столика
     * @param result результат отмены бронирования
     */
    private void updateUIDeleteReservationTableResult(int tableNo, boolean result){
        view.showDeleteReservationTableResult(tableNo, result);
    }

    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationTableResult(tableNo, reservationNo);
        }
        catch (RuntimeException e){
            updateUIShowReservationTableResult(tableNo, -1);
        }

    }

    /**
     * Произошло событие, пользователь нажал на кнопку отмены бронирования столика
     * @param idReservation номер бронирования
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    @Override
    public void onDeleteReservationTable(int idReservation, int tableNo) {

            boolean result = model.deleteReservationTable(idReservation, tableNo);
            updateUIDeleteReservationTableResult(tableNo, result);
 
    }

    @Override
    public void onChangeReservationTable(int idReservation, Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.changeReservationTable(idReservation, orderDate, tableNo, name);
            updateUIShowReservationTableResult(tableNo, reservationNo);
        }
        catch (RuntimeException e){
            updateUIShowReservationTableResult(tableNo, -2);
        }
    }

}
