package ru.geekbrains.lesson1;

import java.math.BigDecimal;

public class MilkBottle  extends Product {

    private Double volume;
    private Double fat;
    
    public Double getVolume() {
        return volume;
    }
    public void setVolume(Double volume) {
        this.volume = volume;
    }
    public Double getFat() {
        return fat;
    }
    public void setFat(Double fat) {
        this.fat = fat;
    }
    public MilkBottle(String name, String brand, BigDecimal price, Double volume, Double fat) {
        super(name, brand, price);
        this.volume = volume;
        this.fat = fat;
    }
    public MilkBottle(Double volume, Double fat) {
        super();
        this.volume = volume;
        this.fat = fat;
    }
    public MilkBottle(String name, Double volume, Double fat) {
        super(name);
        this.volume = volume;
        this.fat = fat;
    }
    public MilkBottle(String name, String brand, Double volume, Double fat) {
        super(name, brand);
        this.volume = volume;
        this.fat = fat;
    }

    public MilkBottle() {
        super();
        setDefaultValues();
    }

    @Override
    public String toString() {
        return String.format("name=%s, brand=%s, price=%.2f, volume=%.1f, fat=%.1f", name, brand, price, volume, fat);
    }

    private void setDefaultValues() {
        volume = 0d;
        fat = 0d;
    }
    
}
