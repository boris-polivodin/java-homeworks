package ru.geekbrains.lesson4;

import java.util.ArrayList;

/*
 *  a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
    b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
    поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
    c. Для хранения фруктов внутри коробки можно использовать ArrayList;
    d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
    вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
    e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
    подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
    Можно сравнивать коробки с яблоками и апельсинами;
    f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
    Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
    Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
    g. Не забываем про метод добавления фрукта в коробку.
 */
public class Lesson4 {
    
    public void launchLesson4() {
        
        Box<Apple> appleBox1 = fillAppleBox();
        Box<Apple> appleBox2 = fillAppleBox();

        appleBox2.add(new Apple());
        System.out.println("Коробки с яблоками равны: " + appleBox1.compare(appleBox2));

        Box<Orange> orangeBox1 = fillOrangeBox();
        Box<Orange> orangeBox2 = fillOrangeBox();

        System.out.println("Коробки с апельсинами равны: " + orangeBox1.compare(orangeBox2));

        if (orangeBox1.transfer(orangeBox2)) {
            System.out.println("Количество апельсинов в коробке после пересыпания: " + orangeBox2.getFruits().size());
        } else System.out.println("Коробка пустая");

        if (orangeBox1.transfer(orangeBox2)) {
            System.out.println("Количество апельсинов в коробке после пересыпания: " + orangeBox2.getFruits().size());
        } else System.out.println("Коробка пустая");
        
        // orangeBox1.add(new Orange());
        // orangeBox1.add(new Orange());
        System.out.println("Вес первой коробки с апельсинами после добавления: " + orangeBox1.getWeight());
        System.out.println("Вес второй коробки с апельсинами: " + orangeBox2.getWeight());

        appleBox1.remove();
        appleBox1.remove();
        appleBox1.remove();
        appleBox1.remove();
        appleBox1.remove();
        appleBox1.remove();
        appleBox1.remove();
        System.out.println("Коробки с яблоками и апельсинами равны: " + appleBox1.compare(orangeBox1));

        if (appleBox1.remove()) {
            System.out.println("Взяли еще одно яблоко");
        } else System.out.println("Коробка пустая");

        if (appleBox1.remove()) {
            System.out.println("Взяли еще одно яблоко");
        } else System.out.println("Коробка пустая");

        if (appleBox1.remove()) {
            System.out.println("Взяли еще одно яблоко");
        } else System.out.println("Коробка пустая");

        if (appleBox1.remove()) {
            System.out.println("Взяли еще одно яблоко");
        } else System.out.println("Коробка пустая");

        System.out.println("Пустые коробки равны: " + appleBox1.compare(orangeBox1));

    }

    private Box<Apple> fillAppleBox() {

        ArrayList<Apple> apples = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            apples.add(new Apple());
        }

        return new Box<Apple>(apples);

    }

    private Box<Orange> fillOrangeBox() {

        ArrayList<Orange> oranges = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            oranges.add(new Orange());
        }

        return new Box<Orange>(oranges);

    }
}
