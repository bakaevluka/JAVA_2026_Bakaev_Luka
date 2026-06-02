import java.util.Formatter;
import java.util.Date;

/**
 * Демонстрация пяти спецификаторов форматирования:
 * %d - целые числа, %f - числа с плавающей точкой, %s - строки, %b - булевы значения, %n - новая строка
 */
class FormatterExample {
    public static void main(String[] args) {

        System.out.println("========== СПЕЦИФИКАТОРЫ ФОРМАТИРОВАНИЯ ==========\n");

        // Способ 1: System.out.printf()
        System.out.println("--- Использование System.out.printf() ---");
        System.out.printf("1. %d - целое число: %d%n", 42, 42);
        System.out.printf("2. %f - число с плавающей точкой: %.2f%n", 3.14159, 3.14159);
        System.out.printf("3. %s - строка: %s%n", "Привет", "Привет");
        System.out.printf("4. %b - булево значение: %b%n", true, true);
        System.out.printf("5. %n - символ новой строки%n");

        // Способ 2: String.format()
        System.out.println("\n--- Использование String.format() ---");
        String formatted = String.format("Число: %d, Строка: %s, Дробное: %.2f", 100, "Java", 99.99);
        System.out.println(formatted);

        // Способ 3: Форматтер с числами
        System.out.println("\n--- Форматирование чисел ---");
        int intValue = 12345;
        double doubleValue = 1234.56789;

        System.out.printf("Целое число: %d%n", intValue);
        System.out.printf("Целое с пробелами (10 позиций): %10d%n", intValue);
        System.out.printf("Целое с нулями: %010d%n", intValue);
        System.out.printf("Дробное число: %f%n", doubleValue);
        System.out.printf("Дробное с 2 знаками: %.2f%n", doubleValue);
        System.out.printf("Дробное в экспоненциальной форме: %e%n", doubleValue);

        // Способ 4: Форматтер с разными типами
        System.out.println("\n--- Форматирование разных типов ---");
        String name = "Лука";
        int age = 20;
        double height = 183.2;
        boolean isStudent = true;

        String info = String.format("Имя: %s, Возраст: %d лет, Рост: %.1f см, Студент: %b",
                name, age, height, isStudent);
        System.out.println(info);

        // Способ 5: Использование Formatter класса
        System.out.println("\n--- Использование класса Formatter ---");
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("Сумма: %d + %d = %d", 10, 20, 30);
        System.out.println(sb.toString());
        formatter.close();

        // Способ 6: Много аргументов
        System.out.println("\n--- Несколько аргументов ---");
        System.out.printf("Имя: %s | Возраст: %d | Оценка: %.1f | Сдал: %b%n",
                "Анна", 19, 4.8, true);

        // Способ 7: Индексы аргументов
        System.out.println("\n--- Индексация аргументов (2$ - второй аргумент) ---");
        System.out.printf("%2$s учит %1$s%n", "Java", "Лука");
        // Выведет: "Лука учит Java"

        System.out.printf("%1$d + %1$d = %2$d%n", 5, 10);
        // Выведет: "5 + 5 = 10"

        System.out.println("\n========== ТАБЛИЦА ИСПОЛЬЗОВАННЫХ СПЕЦИФИКАТОРОВ ==========");
        System.out.println("┌────────┬────────────────────────────────────────────────┐");
        System.out.println("│ %d     │ Целое десятичное число                         │");
        System.out.println("│ %f     │ Число с плавающей точкой                       │");
        System.out.println("│ %s     │ Строка                                         │");
        System.out.println("│ %b     │ Булево значение (true/false)                   │");
        System.out.println("│ %n     │ Символ новой строки (перенос)                  │");
        System.out.println("└────────┴────────────────────────────────────────────────┘");
    }
}