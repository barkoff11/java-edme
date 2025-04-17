import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите действие: ");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Ответ: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.exit(1);
        }
    }

    public static String calc(String input) throws Exception {
        input = input.replaceAll("([+\\-*/])", " $1 ").trim();
        String[] parts = input.split("\\s+");

        if (parts.length == 1 && parts[0].matches("\\d+")) {
            throw new Exception("throws Exception //т.к. строка не является математической операцией");
        }
        if (parts.length != 3) {
            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        int a, b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("throws Exception //т.к. калькулятор работает только с целыми числами");
        }
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("throws Exception //т.к. числа должны быть от 1 до 10 включительно");
        }

        String operator = parts[1];
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
                if (b == 0) throw new ArithmeticException("На ноль делить нельзя");
                result = a / b;
                break;
            default:
                throw new Exception("throws Exception //т.к. строка не является математической операцией");
        }

        return String.valueOf(result);
    }
}
