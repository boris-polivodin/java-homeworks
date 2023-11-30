package ru.geekbrains.lesson1;

import java.math.BigDecimal;

public interface VendingAutomat {
    
    Product getProduct(String name, String brand, BigDecimal price, Double volume, Double fat, int temperature, Colors color);

}
