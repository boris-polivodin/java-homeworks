package ru.geekbrains.lesson5v2.presenters;

import ru.geekbrains.lesson5v2.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver{

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
     * @param orderDate
     * @param tableNo
     * @param name
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
     * @param idReservation
     * @param tableNo
     */
    @Override
    public void onDeleteReservationTable(int idReservation, int tableNo) {

        boolean result = model.deleteReservationTable(idReservation, tableNo);
        updateUIDeleteReservationTableResult(tableNo, result);

    }

    /**
     * @param idReservation
     * @param orderDate
     * @param tableNo
     * @param name
     */
    @Override
    public void onChangeReservationTable(int idReservation, Date orderDate, int tableNo, String name) {
//        try {
//            int reservationNo = model.changeReservationTable(idReservation, orderDate, tableNo, name);
//            updateUIShowReservationTableResult(tableNo, reservationNo);
//        }
//        catch (RuntimeException e){
//            updateUIShowReservationTableResult(tableNo, -2);
//        }

        int reservationNo = model.changeReservationTable(idReservation, orderDate, tableNo, name);
        // BookingPresenter сообщает View об успешном изменении бронирования столика
        printChangeReservationTableResult(reservationNo);
    }

    protected void printChangeReservationTableResult(int reservationNo){
        view.printReservationTableResult(reservationNo);
    }
}
