package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.presenters.BookingPresenter;
import ru.geekbrains.lesson5.presenters.Model;
import ru.geekbrains.lesson5.presenters.View;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void launchLesson5(String[] args) {
        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateUIShowTables();

        System.out.println();
        System.out.println("// Бронирование");
        view.reservationTable(new Date(), 1, "Станислав");
        view.reservationTable(new Date(), 2, "Станислав");
        view.reservationTable(new Date(), 3, "Станислав");

        System.out.println();
        System.out.println("// Отмена бронирования");
        view.deleteReservationTable(1001, 1);
        view.deleteReservationTable(1003, 4);
        view.deleteReservationTable(1003, 3);

        System.out.println();
        System.out.println("// Изменение бронирования 2 столика на другое время");
        view.changeReservationTable(1002, new Date(), 2, "Станислав");

        System.out.println();
        view.reservationTable(new Date(), 3, "Станислав");
        view.reservationTable(new Date(), 3, "Вася");

        System.out.println();
        System.out.println("// Результат");
        presenter.updateUIShowTables();
    }

}
