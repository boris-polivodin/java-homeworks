package ru.geekbrains.lesson7.builder;

public class Program {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder("AAA");
        String str = stringBuilder
                .append("BBB")
                .append("CCC")
                .replace(1, 3, "DDD")
                .delete(1, 5)
                .toString();

        Order order = new OrderBuilder()
                .setProductId(12343)
                .setProductName("Name #1")
                .setQnt(2)
                .setClientName("Client #1")
                .build();


    }

}
