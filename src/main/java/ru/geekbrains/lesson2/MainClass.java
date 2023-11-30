package ru.geekbrains.lesson2;

import java.util.ArrayList;

/*
 * ЗАДАНИЕ

    1. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, 
        а кот пытается покушать 15-20).
    2. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). 
        Если коту удалось покушать (хватило еды), сытость = true. Считаем, что если коту мало еды в тарелке, 
        то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
    3. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки 
        и потом вывести информацию о сытости котов в консоль.
    4. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.

 */
public class MainClass {
    public static void launchLesson2(String[] args) {
        Cat cat1 = new Cat("Barsik", 15);
        Cat cat2 = new Cat("Marsik", 10);
        Cat cat3 = new Cat("Perchik", 17);
        Cat cat4 = new Cat("Ponchik", 25);
        Cat cat5 = new Cat("Persik", 18);

        Plate plate = new Plate(65);
        plate.info();

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);
  
        for (Cat cat : cats) {
            cat.eat();
            cat.setSatiety(plate.setFood(plate.getFood() - cat.getAppetite()));
            System.out.println(cat.catInfo());
        }
        
    }
}
