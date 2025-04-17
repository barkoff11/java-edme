import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите действие: ");
        String input = scanner.nextLine().trim();

        try {
            // Добавим пробелы вокруг операторов для универсального парсинга
            input = input.replaceAll("([+\\-*/])", " $1 ");
            String[] parts = input.trim().split("\\s+");

            // Проверка: ровно 3 элемента
            if (parts.length != 3) {
                throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

            int a = Integer.parseInt(parts[0]);
            String operator = parts[1];
            int b = Integer.parseInt(parts[2]);

            // Проверка диапазона
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new Exception("throws Exception //т.к. числа должны быть от 1 до 10 включительно");
            }

            int result;

            switch (operator) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b == 0) throw new ArithmeticException("Zero");
                    result = a / b;
                    break;
                default:
                    throw new Exception("throws Exception //т.к. строка не является математической операцией");
            }

            System.out.println("Ответ: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.exit(1);
        }
    }
}
