package ru.geekbrains.lesson7.singleton;

public class Program {

    public static void main(String[] args) {

        //Settings settings1 = new Settings();
        //Settings settings2 = new Settings();

        Settings settings3 = Settings.getInstance();
        Settings settings4 = Settings.getInstance();


    }

}
