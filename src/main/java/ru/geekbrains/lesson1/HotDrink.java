package ru.geekbrains.lesson1;

import java.math.BigDecimal;

public class HotDrink extends Product {
    
    protected Double volume;

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public HotDrink(String name, String brand, BigDecimal price, Double volume) {
        super(name, brand, price);
        this.volume = volume;
    }

    public HotDrink(Double volume) {
        super();
        this.volume = volume;
    }

    public HotDrink(String name, Double volume) {
        super(name);
        this.volume = volume;
    }

    public HotDrink(String name, String brand, Double volume) {
        super(name, brand);
        this.volume = volume;
    }

    

}
