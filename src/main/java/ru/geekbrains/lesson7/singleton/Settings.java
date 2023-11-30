package ru.geekbrains.lesson7.singleton;

public class Settings {

    private static Settings instance;

    public static Settings getInstance(){
        if (instance == null)
        {
            instance = new Settings();

            //TODO: Инициализация полей объекта, подгрузим настройки из конфигурационного файла

        }

        return instance;

    }

    private Settings(){

    }

    private String param1;
    private int param2;
    private boolean param3;

    public String getParam1() {
        return param1;
    }

    public int getParam2() {
        return param2;
    }

    public boolean isParam3() {
        return param3;
    }
}
