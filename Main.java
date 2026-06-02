/**
 * ПРАКТИКА #1
 *
 * ЗАДАНИЕ: Что произойдет при выполнении данного кода?
 *
 * public class App {
 *     final static int START_COUNTER;
 *     static {
 *         START_COUNTER = Integer.parseInt("Y-");
 *     }
 *     public static void main(String[] args) {
 *         System.out.println("Hello");
 *     }
 * }
 *
 * ОТВЕТ: Программа выбросит NumberFormatException и НЕ выведет "Hello"
 * ПОЧЕМУ: Строка "Y-" не может быть преобразована в число
 */

/**
 * ИСПРАВЛЕНИЕ 1: Использовать корректное число
 */
class FixedApp1 {
    final static int START_COUNTER;
    static {
        START_COUNTER = Integer.parseInt("100");  // ✅ корректное число
    }
    public static void main(String[] args) {
        System.out.println("Hello, START_COUNTER = " + START_COUNTER);
    }
}

/**
 * ИСПРАВЛЕНИЕ 2: Обработать исключение в статическом блоке
 */
class FixedApp2 {
    final static int START_COUNTER;
    static {
        int temp = 0;
        try {
            temp = Integer.parseInt("Y-");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Некорректное значение, установлено значение по умолчанию 0");
            temp = 0;
        }
        START_COUNTER = temp;
    }
    public static void main(String[] args) {
        System.out.println("Hello, START_COUNTER = " + START_COUNTER);
    }
}

/**
 * ИСПРАВЛЕНИЕ 3: Использовать значение по умолчанию без parseInt
 */
class FixedApp3 {
    final static int START_COUNTER = 0;  // ✅ просто присвоить значение
    public static void main(String[] args) {
        System.out.println("Hello, START_COUNTER = " + START_COUNTER);
    }
}

/**
 * Демонстрация работы исправленных версий
 */
class App {
    public static void main(String[] args) {

        System.out.println("========== ЧТО НЕ ТАК В ИСХОДНОМ КОДЕ? ==========\n");
        System.out.println("Проблема: Integer.parseInt(\"Y-\")");
        System.out.println("  - Метод parseInt() ожидает строку, содержащую число");
        System.out.println("  - Строка \"Y-\" содержит буквы и знак минуса в неверном месте");
        System.out.println("  - Это вызывает NumberFormatException\n");

        System.out.println("========== ПОСЛЕДОВАТЕЛЬНОСТЬ ВЫПОЛНЕНИЯ ==========\n");
        System.out.println("1. Загрузка класса App");
        System.out.println("2. Выполнение статического блока static { }");
        System.out.println("3. Вызов Integer.parseInt(\"Y-\") → ❌ NumberFormatException");
        System.out.println("4. Исключение прерывает загрузку класса");
        System.out.println("5. Метод main() НЕ вызывается");
        System.out.println("6. Программа завершается с ошибкой\n");

        System.out.println("========== РЕЗУЛЬТАТ РАБОТЫ ИСПРАВЛЕННЫХ ВЕРСИЙ ==========\n");

        System.out.println("--- Исправление 1: корректное число ---");
        FixedApp1.main(args);

        System.out.println("\n--- Исправление 2: обработка исключения ---");
        FixedApp2.main(args);

        System.out.println("\n--- Исправление 3: значение по умолчанию ---");
        FixedApp3.main(args);

        System.out.println("\n========== КАКИЕ ОШИБКИ БЫЛИ ИСПРАВЛЕНЫ? ==========");
        System.out.println("┌────────────────────────────────────────────────────────────────┐");
        System.out.println("│ Ошибка                    │ Исправление                        │");
        System.out.println("├───────────────────────────┼────────────────────────────────────┤");
        System.out.println("│ Integer.parseInt(\"Y-\")    │ Integer.parseInt(\"100\")        │");
        System.out.println("│ - строка не число         │ - корректное число                 │");
        System.out.println("├───────────────────────────┼────────────────────────────────────┤");
        System.out.println("│ Нет обработки исключения  │ try-catch для NumberFormatException│");
        System.out.println("│ - программа падает        │ - установка значения по умолчанию  │");
        System.out.println("├───────────────────────────┼────────────────────────────────────┤");
        System.out.println("│ Сложная инициализация     │ START_COUNTER = 0                  │");
        System.out.println("│ - parseInt() не нужен     │ - простое присвоение               │");
        System.out.println("└───────────────────────────┴────────────────────────────────────┘");

        System.out.println("\n========== ВЫВОД ==========");
        System.out.println("✅ Программа теперь работает корректно");
        System.out.println("✅ Исключение обработано или устранено");
        System.out.println("✅ Выводится сообщение 'Hello'");
    }
}