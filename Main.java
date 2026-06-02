/**
 * ОСНОВНЫЕ КЛАССЫ ИСКЛЮЧЕНИЙ В Java
 *
 * Throwable - корневой класс всех исключений и ошибок
 *   ├── Error - критические ошибки системы, которые НЕЛЬЗЯ обработать
 *   └── Exception - исключения, которые МОЖНО и НУЖНО обрабатывать
 *        └── RuntimeException - исключения времени выполнения (unchecked)
 */
class ExceptionHierarchyExplanation {
    public static void main(String[] args) {

        System.out.println("========== ИЕРАРХИЯ ИСКЛЮЧЕНИЙ ==========\n");

        System.out.println("1. Throwable");
        System.out.println("   └── Базовый класс для всех исключений и ошибок");
        System.out.println("   └── Содержит стек-трейс и сообщение об ошибке\n");

        System.out.println("2. Error (НЕЛЬЗЯ обработать)");
        System.out.println("   └── Критические ошибки системы/виртуальной машины");
        System.out.println("   └── Примеры: OutOfMemoryError, StackOverflowError");
        System.out.println("   └── Приложение не может их обработать\n");

        System.out.println("3. Exception (МОЖНО обработать)");
        System.out.println("   └── Исключительные ситуации в программе");
        System.out.println("   └── Делится на две группы:\n");

        System.out.println("   ┌─────────────────────────────────────────────────┐");
        System.out.println("   │ Checked Exceptions (проверяемые)               │");
        System.out.println("   ├─────────────────────────────────────────────────┤");
        System.out.println("   │ • Компилятор требует обработки (try-catch)     │");
        System.out.println("   │ • Примеры: IOException, SQLException           │");
        System.out.println("   │ • Обязательны к обработке                       │");
        System.out.println("   └─────────────────────────────────────────────────┘\n");

        System.out.println("   ┌─────────────────────────────────────────────────┐");
        System.out.println("   │ RuntimeException (unchecked)                   │");
        System.out.println("   ├─────────────────────────────────────────────────┤");
        System.out.println("   │ • Возникают во время выполнения                 │");
        System.out.println("   │ • Компилятор НЕ требует обработки              │");
        System.out.println("   │ • Примеры: NullPointerException,                │");
        System.out.println("   │   ArithmeticException, ArrayIndexOutOfBounds   │");
        System.out.println("   └─────────────────────────────────────────────────┘\n");

        System.out.println("========== ТАБЛИЦА КЛАССОВ ==========");
        System.out.println("┌─────────────────────┬─────────────────────────────────────────┐");
        System.out.println("│ Класс               │ Назначение                              │");
        System.out.println("├─────────────────────┼─────────────────────────────────────────┤");
        System.out.println("│ Throwable           │ Базовый класс для всех исключений       │");
        System.out.println("│ Error               │ Системные ошибки (не обрабатываются)    │");
        System.out.println("│ Exception           │ Обрабатываемые исключения               │");
        System.out.println("│ RuntimeException    │ Ошибки программирования (unchecked)     │");
        System.out.println("└─────────────────────┴─────────────────────────────────────────┘");
    }
}