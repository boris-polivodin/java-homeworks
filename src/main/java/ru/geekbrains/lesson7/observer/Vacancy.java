package ru.geekbrains.lesson7.observer;

public class Vacancy {

    private VacancyType vacancyType;
    private CompanyActions company;
    private String name;
    private String description;
    private int salary;

    public VacancyType getVacancyType() {
        return vacancyType;
    }

    public CompanyActions getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Vacancy(VacancyType vacancyType, CompanyActions company, String name, String description, int salary) {
        this.vacancyType = vacancyType;
        this.company = company;
        this.name = name;
        this.description = description;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "type=" + vacancyType +
                ", company=" + company.getCompanyName() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                "\n";
    }
}
