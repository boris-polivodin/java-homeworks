package ru.geekbrains.exeptions;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Введите данные ФИО датарождения номертелефона пол в произвольном порядке, разделенные пробелом");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("surname", "");
        map.put("firstName", "");
        map.put("secondName", "");
        map.put("birthday", "");
        map.put("telephone", "");
        map.put("sex", "");

        Parser.parsing(map, line);


        try {
            FileProcessor.writeFile(map);
            System.out.println("Записан файл " + map.get("surname") + ".txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
