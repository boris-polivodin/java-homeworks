package ru.geekbrains.lesson1;

import java.math.BigDecimal;
import java.util.ArrayList;

public final class App {
    private App() {
    }

    public static void launchLesson1(String[] args) {

        Product milkBottle1 = new MilkBottle();
        Product milkBottle5 = new MilkBottle(1d, 2.5);
        Product milkBottle4 = new MilkBottle("Молоко неизвестного происхождения", 1.5, 3.2);
        Product milkBottle2 = new MilkBottle("Молоко без цены", "ГринАгро", 2d, 3.5);
        Product milkBottle3 = new MilkBottle("Молоко натуральное", "Деревенское", new BigDecimal(100), 1d, 4d);

        MilkBottle milkBottle = (MilkBottle) milkBottle5;
        milkBottle.setName("Молоко");
        milkBottle.setBrand("Родимая сторонка");
        milkBottle.setPrice(new BigDecimal(119.99));
        
        ArrayList<Product> products = new ArrayList<>();
        products.add(milkBottle1);
        products.add(milkBottle2);
        products.add(milkBottle3);
        products.add(milkBottle4);
        products.add(milkBottle5);

        Product blackTea = new Tea(250d, 90, Colors.BLACK);
        blackTea.setName("Чай черный индийский");
        blackTea.setBrand("India");
        blackTea.setPrice(new BigDecimal(89.99));

        Product greenTea = new Tea(200d, 95, Colors.GREEN);
        greenTea.setName("Чай зеленый китайcкий");
        greenTea.setBrand("China");
        greenTea.setPrice(new BigDecimal(99.99));

        products.add(blackTea);
        products.add(greenTea);
        

        VendingMachine vendingMachine = new VendingMachine(products);

        Product product = vendingMachine.getProduct(milkBottle.getName(), milkBottle.getBrand(), milkBottle.getPrice(), milkBottle.getVolume(), milkBottle.getFat(), 0, null);
        if (product == null) {
            System.out.println("Нет такого товара.");
        } else {
            System.out.println("Вы купили: " + product);
        }

        Product product2 = vendingMachine.getProduct("Чай зеленый китайcкий", "", new BigDecimal(0), 200d, 0d, 95, Colors.GREEN);
        if (product2 == null) {
            System.out.println("Нет такого товара.");
        } else {
            System.out.println("Вы купили: " + product2);
        }
    }


}
