package ru.geekbrains.lesson1;

import java.math.BigDecimal;

public class Tea extends HotDrink{

    private int temperature;
    private Colors color;

    
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }


    public Tea(Double volume) {
        super(volume);
    }

    public Tea(String name, String brand, BigDecimal price, Double volume, int temperature, Colors color, TypeOfPackage typeOfPackage) {
        super(name, brand, price, volume, typeOfPackage);
        this.temperature = temperature;
        this.color = color;
    }
    public Tea(String name, String brand, BigDecimal price, Double volume, int temperature, Colors color) {
        super(name, brand, price, volume);
        this.temperature = temperature;
        this.color = color;
    }


    public Tea(Double volume, int temperature, Colors color) {
        super(volume);
        this.temperature = temperature;
        this.color = color;
    }


    public Tea(String name, Double volume, int temperature, Colors color) {
        super(name, volume);
        this.temperature = temperature;
        this.color = color;
    }


    public Tea(String name, String brand, Double volume, int temperature, Colors color) {
        super(name, brand, volume);
        this.temperature = temperature;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("name=%s, brand=%s, color=%s, price=%.2f, volume=%.1f, temperature=%d, package=%s", name, brand, color, price, volume, temperature, typeOfPackage);
    }

    
    
    
}

