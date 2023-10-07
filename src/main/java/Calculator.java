public class Calculator {
    float summ = 0.0f;
    String cart = "Добавленные товары:";

    void addProduct(Product product) {
        cart += "\n" + product.name + " - " + String.format("%.2f", product.price);
        summ += Math.round(product.price * 100.0) / 100.0;
        System.out.println("Товар \"" + product.name + "\" на сумму " + String.format("%.2f", product.price) + " успешно добавлен.");
    }

    void calcResult(int peopleCount) {
        float result;
        result = summ / peopleCount;
        result = Math.round(result * 100.0f) / 100.0f;
        System.out.println("-------------------");
        System.out.println(cart);
        System.out.println("-------------------");
        System.out.println("Итого: " + String.format("%.2f", summ) + Formatter.getRubleForm(summ));
        System.out.println("Разделить на " + peopleCount + " чел.");
        System.out.println("Результат: " + String.format("%.2f", result) + Formatter.getRubleForm(result));
        System.out.println("(сколько должен заплатить каждый человек)");
    }
}
