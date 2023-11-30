package ru.geekbrains.lesson2;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    
    public int getAppetite() {
        return appetite;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat() {
        
    }

    public String catInfo() {
        return String.format(satiety == true ? "Котик %s сытый" : "Котик %s голодный", name);
    }
}
