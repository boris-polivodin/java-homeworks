package ru.geekbrains.lesson7.adapter;

public class Program {

    public static void main(String[] args) {
        MeteoStore meteoStore = new MeteoStore();
        MS200 ms200 = new MS200();
        meteoStore.save(ms200);
        ST500 st500 = new ST500();
        AdapterST500 adapterST500 = new AdapterST500(st500);
        meteoStore.save(adapterST500);
    }

}
