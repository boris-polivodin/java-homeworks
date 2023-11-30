package ru.geekbrains.lesson6;

import java.util.Scanner;

public class Prompt {

    private final Scanner in = new Scanner(System.in);

    public String promptValue(String message) {
        System.out.print(message);
        return in.nextLine();
    }

}
