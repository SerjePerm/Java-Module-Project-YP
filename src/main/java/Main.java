import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Создаём сканер
        int peopleCount = peopleCountInput(scanner); //Запрашиваем кол-во человек
        Calculator calculator = new Calculator(); //Создаём калькулятор
        productInputCycle(scanner, calculator); //Добавление товаров в калькулятор
        calculator.calcResult(peopleCount); //Считаем, выводим счёт + результат
        scanner.close(); //Закрываем сканер
    }

    //Бесконечный цикл запроса кол-во человек
    public static int peopleCountInput(Scanner scanner) {
        int result;
        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт? Введите значение > 1");
            String peopleCount = scanner.nextLine();
            if (!peopleCount.chars().allMatch(Character::isDigit)) { //проверка содержит ли строка символы кроме цифр 0-9
                System.out.println("Необходимо ввести целое положительное число > 1");
                continue;
            }
            result = Integer.parseInt(peopleCount);
            if (result == 1)
                System.out.println("В этом случае нет смысла ничего считать и делить. Введите значение > 1");
            else if (result < 1)
                System.out.println("Количество человек меньше 1. Это некорректное значение для подсчёта. Введите значение > 1");
            else break; //result > 1
        }
        System.out.println("Количество человек = " + result);
        return result;
    }

    //Бесконечный цикл запроса действия (добавить товар или выйти)
    public static void productInputCycle(Scanner scanner, Calculator calculator) {
        while (true) {
            productAddInput(scanner, calculator);
            System.out.println("Добавить ещё один товар? Если да - введите любой символ, если нет - введите \"Завершить\"");
            String userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("завершить")) break;
        }
    }

    //Бесконечный цикл запроса товара
    public static void productAddInput(Scanner scanner, Calculator calculator) {
        while (true) {
            System.out.println("-----------------------");
            System.out.println("Введите название товара");
            String productName = scanner.nextLine();
            System.out.println("Введите стоимость товара (например 10.45 или 11.40)");
            String productPrice = scanner.nextLine();
            if (productName.isEmpty())
                System.out.println("Вы ввели пустое название товара, необходимо ввести название");
            else if (!isFloat(productPrice))
                System.out.println("Вы ввели неправильное значение стоимости");
            else if (Float.parseFloat(productPrice) <= 0)
                System.out.println("Вы ввели значение стоимости меньше или равное 0, необходимо ввести значение > 0");
            else {//Если прошли все проверки - создаём и добавляем товар
                Product product = new Product(productName, Float.parseFloat(productPrice));
                calculator.addProduct(product);
                System.out.println("-----------------------");
                break;
            }
        }
    }

    //Проверяем строку на возможность преобразования в Float
    public static boolean isFloat(String str) {
        float floatValue;
        try {
            floatValue = Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            //DO SOME
        }
        return false;
    }
}