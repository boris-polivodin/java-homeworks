package ru.geekbrains.lesson1;

import java.math.BigDecimal;

public class Product {
    
    protected String name;
    protected String brand;
    protected BigDecimal price;
    protected TypeOfPackage typeOfPackage;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setTypeOfPackage(TypeOfPackage typeOfPackage) {
        this.typeOfPackage = typeOfPackage;
    }
    public TypeOfPackage getTypeOfPackage() {
        return typeOfPackage;
    }

    public Product() {
        setDefaultValues();
    }
    public Product(String name) {
        setDefaultValues();
        this.name = name;
    }
    public Product(String name, String brand) {
        setDefaultValues();
        this.name = name;
        this.brand = brand;
    }
    public Product(String name, String brand, BigDecimal price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    private void setDefaultValues() {
        name = "product";
        brand = "brand";
        price = new BigDecimal(0);
    }
    
    @Override
    public String toString() {
        return "Product [name=" + name + ", brand=" + brand + ", price=" + price + "]";
    }

    
    
}
