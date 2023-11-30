package ru.geekbrains.lesson1;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VendingMachine implements VendingAutomat {
    
    private ArrayList<Product> products = new ArrayList<>();

    public VendingMachine(ArrayList<Product> products) {
        this.products = products;
    }

    public Milk SaleMilk(BigDecimal price, Double volume, Double fat) {

        for (Product product : products) {
            if (product instanceof Milk) {
                Milk milk = (Milk) product;
                if (milk.getPrice().doubleValue() == price.doubleValue()
                    && milk.getVolume().doubleValue() == volume.doubleValue()
                    && milk.getFat().doubleValue() == fat.doubleValue()) {

                        return milk;

                }
            }
        }
        return null;

    }

    public Product SaleTea(String name, Double volume, int temperature, Colors color) {

        for (Product product : products) {
            if (product instanceof Tea) {
                Tea tea = (Tea) product;
                if (tea.getName().equals(name) 
                    && tea.getVolume().doubleValue() == volume.doubleValue() 
                    && tea.getTemperature() == temperature
                    && tea.getColor() == color) {

                        return tea;
                    
                }
            }
        }

        return null;
    }

    @Override
    public Product getProduct(String name, String brand, BigDecimal price, Double volume, Double fat, int temperature,
            Colors color) {

        Product result;
        for (Product product : products) {
            if (product instanceof Milk) {

                result = SaleMilk(price, volume, fat);
                if (result != null) {
                    return result;
                }

            } else if (product instanceof Tea) {
                
                result = SaleTea(name, volume, temperature, color);
                if (result != null) {
                    return result;
                }

            }
        }

        return null;
    }





}
