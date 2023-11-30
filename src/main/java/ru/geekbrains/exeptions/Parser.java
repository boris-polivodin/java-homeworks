package ru.geekbrains.exeptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class Parser {

    private static final int COUNT_WORDS = 6;

    static void parsing(LinkedHashMap<String, String> map, String line) {

        String[] arr = line.split(" ");
        if (arr.length != COUNT_WORDS) throw new MyArraySizeExeption(arr.length, COUNT_WORDS);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        boolean isExeption;
        boolean isTelephone;
        boolean isDate;
        boolean isName;
        boolean isGender;

        for (String item : arr) {

            isExeption = false;
            isTelephone = false;
            isDate = false;
            isName = false;
            isGender = false;

            try {
                Long.parseLong(item);
                isTelephone = true;
            } catch (NumberFormatException e) {
                System.out.printf("%s - не число\n", item);

                try {
                    LocalDate localDate = LocalDate.parse(item, formatter);
                    isDate = true;
                } catch (DateTimeParseException exception) {
                    System.out.printf("%s - не дата\n", item);
                    isExeption = true;
                } catch (IllegalArgumentException exception) {
                    System.out.printf("%s - не удалось конвертировать в дату\n", item);
                    isExeption = true;
                }
            }

            if (isExeption) {
                if (!Pattern.matches("[a-zA-Zа-яёА-ЯЁ]+", item)) {
                    throw new RuntimeException(String.format("Некорректный формат введенных данных - %s\n", item));
                }
                if (item.length() == 1 && (item.equals("f") || item.equals("m"))) {
                    isGender = true;
                } else {
                    isName = true;
                }
            }

            if (isDate && map.get("birthday").isEmpty()) {
                map.put("birthday", item);
            } else if (isGender && map.get("sex").isEmpty()) {
                map.put("sex", item);
            } else if (isName && map.get("surname").isEmpty()) {
                map.put("surname", item);
            } else if (isName && map.get("firstName").isEmpty()) {
                map.put("firstName", item);
            } else if (isName && map.get("secondName").isEmpty()) {
                map.put("secondName", item);
            } else if (isTelephone && map.get("telephone").isEmpty()) {
                map.put("telephone", item);
            } else {
                throw new RuntimeException(String.format("Некорректный формат введенных данных - %s\n", item));
            }
        }

    }
}

class MyArraySizeExeption extends RuntimeException {
    public MyArraySizeExeption(int validSize) {
        super(String.format("Количество данных должно быть равным %d.", validSize));
    }

    public MyArraySizeExeption(int size, int validSize) {
        super(String.format("Количество данных должно быть равным %d. Вы ввели %d", validSize, size));
    }
}



