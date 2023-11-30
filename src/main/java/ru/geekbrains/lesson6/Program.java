package ru.geekbrains.lesson6;

public class Program {
    public static void main(String[] args) {
        System.out.println("Введите заказ:");
        Order order = new Order("", "", 0, 0);

        Prompt prompt = new Prompt();
        order.setClientName(prompt.promptValue("Client name: "));
        order.setProduct(prompt.promptValue("Product: "));
        order.setQnt(Integer.parseInt(prompt.promptValue("Quantity: ")));
        order.setPrice(Integer.parseInt(prompt.promptValue("Price: ")));


        SaveToFile saver = new SaveToFile(order, "order.json");
        saver.saveToJson();
    }
}
