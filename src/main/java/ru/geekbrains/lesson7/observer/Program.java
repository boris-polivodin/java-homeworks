package ru.geekbrains.lesson7.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Program {

    /**
     *  TODO: Доработать приложение, которое разрабатывалось на семинаре, поработать с шаблоном проектирования Observer,
     *  добавить новый тип соискателя.
     *  Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     *  Только после этого вы можете усложнить ваше приложение (при желании), например, добавить тип вакансии (enum),
     *  учитывать тип вакансии при отправке предложения соискателю.
     * @param args
     */
    static Random random = new Random();

    public static void main(String[] args) {
        Publisher jobAgency = new JobAgency();
        CompanyActions google = new Company("Google", jobAgency, 120000);
        CompanyActions yandex = new Company("Yandex", jobAgency, 95000);
        CompanyActions geekBrains = new Company("GeekBrains", jobAgency, 98000);

        google.setVacancies(getVacancies(google, 3));
        yandex.setVacancies(getVacancies(yandex, 4));
        geekBrains.setVacancies(getVacancies(geekBrains, 5));

        System.out.println("Вакансии компаний до: ");
        displayVacancies(google);
        displayVacancies(yandex);
        displayVacancies(geekBrains);

        Student student1 = new Student("Студент #1", new ArrayList<>(Arrays.asList(VacancyType.manager, VacancyType.worker, VacancyType.sysadmin)));
        Manager manager1 = new Manager("Менеджер #1", new ArrayList<>(List.of(VacancyType.manager)));
        Master master1 = new Master("Мастер #1", new ArrayList<>(Arrays.asList(VacancyType.engineer, VacancyType.programmist, VacancyType.sysadmin)));
        Master master2 = new Master("Мастер #2", new ArrayList<>(Arrays.asList(VacancyType.engineer, VacancyType.programmist)));

        jobAgency.registerObserver(student1);
        jobAgency.registerObserver(master1);
        jobAgency.registerObserver(master2);
        jobAgency.registerObserver(manager1);

        google.needEmployee();
        yandex.needEmployee();
        geekBrains.needEmployee();

        System.out.println("Вакансии компаний после: ");
        displayVacancies(google);
        displayVacancies(yandex);
        displayVacancies(geekBrains);

        System.out.println("Клиенты агентства после: ");
        System.out.println(Arrays.deepToString(jobAgency.getObserversList().toArray(new Observer[0])));

    }

    static ArrayList<Vacancy> getVacancies(CompanyActions company, int count) {
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            vacancies.add(generateVacancy(company));
        }
        return vacancies;
    }

    static Vacancy generateVacancy(CompanyActions company) {
        int typeIndex = random.nextInt(VacancyType.values().length);
        return generateVacancy(VacancyType.values()[typeIndex], company, random.nextInt(company.getMaxSalary()));
    }

    static Vacancy generateVacancy(VacancyType vacancyType, CompanyActions company, int salary) {
        return switch (vacancyType) {
            case sysadmin -> new Vacancy(vacancyType, company, "Системный администратор", "Поддержка корпоративной сети", salary);
            case engineer -> new Vacancy(vacancyType, company, "Инженер-программист", "Начальник отдела разработки ПО", salary);
            case worker -> new Vacancy(vacancyType, company, "Рабочий", "Рабочий на склад", salary);
            case programmist -> new Vacancy(vacancyType, company, "Программист", "Написание программ на языке С++", salary);
            case manager -> new Vacancy(vacancyType, company, "Менеджер", "Менеджер отдела продаж", salary);
        };
    }

    static void displayVacancies(CompanyActions company) {
        System.out.println(company.getCompanyName());
        System.out.println(Arrays.deepToString(company.getVacanciesList().toArray(new Vacancy[0])));
    }
}
