package ru.geekbrains.lesson5v2;

import ru.geekbrains.lesson5v2.models.TableModel;
import ru.geekbrains.lesson5v2.presenters.BookingPresenter;
import ru.geekbrains.lesson5v2.presenters.Model;
import ru.geekbrains.lesson5v2.presenters.View;
import ru.geekbrains.lesson5v2.views.BookingView;

import java.util.Date;

public class Program {

    public static void launchLesson5v2() {
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
