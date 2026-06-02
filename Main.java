/**
 * Демонстрация генерации и обработки различных исключений
 */
class ExceptionExamples {

    // ========== 1. ArithmeticException ==========
    public static void demonstrateArithmeticException() {
        System.out.println("\n========== 1. ArithmeticException ==========");
        System.out.println("Возникает при делении на ноль или других арифметических ошибках");

        try {
            int a = 10;
            int b = 0;
            System.out.println("Попытка: " + a + " / " + b);
            int result = a / b;  // ❌ Деление на ноль
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("✅ Перехвачено ArithmeticException: " + e.getMessage());
            System.out.println("   Решение: проверить делитель перед делением");
        }

        // Как избежать исключения
        int a = 10;
        int b = 0;
        if (b != 0) {
            int result = a / b;
            System.out.println("Результат с проверкой: " + result);
        } else {
            System.out.println("Безопасно: деление на ноль не выполнено");
        }
    }

    // ========== 2. ArrayIndexOutOfBoundsException ==========
    public static void demonstrateArrayIndexOutOfBoundsException() {
        System.out.println("\n========== 2. ArrayIndexOutOfBoundsException ==========");
        System.out.println("Возникает при обращении к индексу массива вне его границ");

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Массив длиной: " + arr.length);

        try {
            int index = 10;
            System.out.println("Попытка получить элемент с индексом: " + index);
            int value = arr[index];  // ❌ Индекс вне границ
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("✅ Перехвачено ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("   Решение: проверять индекс перед доступом");
        }

        // Как избежать исключения
        int index = 10;
        if (index >= 0 && index < arr.length) {
            int value = arr[index];
            System.out.println("Безопасное получение: " + value);
        } else {
            System.out.println("Безопасно: индекс " + index + " вне диапазона [0-" + (arr.length-1) + "]");
        }
    }

    // ========== 3. IllegalArgumentException ==========
    public static void demonstrateIllegalArgumentException() {
        System.out.println("\n========== 3. IllegalArgumentException ==========");
        System.out.println("Возникает при передаче некорректных аргументов в метод");

        // Метод, который проверяет аргументы
        class Person {
            private String name;
            private int age;

            public void setName(String name) {
                if (name == null || name.trim().isEmpty()) {
                    throw new IllegalArgumentException("Имя не может быть пустым или null");
                }
                this.name = name;
                System.out.println("Имя установлено: " + name);
            }

            public void setAge(int age) {
                if (age < 0 || age > 150) {
                    throw new IllegalArgumentException("Возраст должен быть от 0 до 150, получено: " + age);
                }
                this.age = age;
                System.out.println("Возраст установлен: " + age);
            }
        }

        Person person = new Person();

        // Попытка с корректными данными
        try {
            person.setName("Лука");
            person.setAge(20);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Попытка с некорректными данными
        try {
            person.setName("");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Перехвачено IllegalArgumentException: " + e.getMessage());
        }

        try {
            person.setAge(200);
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Перехвачено IllegalArgumentException: " + e.getMessage());
        }
    }

    // ========== 4. ClassCastException ==========
    public static void demonstrateClassCastException() {
        System.out.println("\n========== 4. ClassCastException ==========");
        System.out.println("Возникает при некорректном приведении типов");

        Object obj = "Это строка";
        System.out.println("Объект: " + obj + " (тип String)");

        try {
            System.out.println("Попытка привести String к Integer");
            Integer num = (Integer) obj;  // ❌ Нельзя привести String к Integer
            System.out.println("Результат: " + num);
        } catch (ClassCastException e) {
            System.out.println("✅ Перехвачено ClassCastException: " + e.getMessage());
            System.out.println("   Решение: использовать instanceof перед приведением");
        }

        // Как избежать исключения
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            System.out.println("Безопасное приведение: " + num);
        } else if (obj instanceof String) {
            System.out.println("Объект является String, а не Integer");
        }

        // Корректное приведение
        Object numObj = 42;
        if (numObj instanceof Integer) {
            Integer num = (Integer) numObj;
            System.out.println("Корректное приведение Integer: " + num);
        }
    }

    // ========== 5. NullPointerException ==========
    public static void demonstrateNullPointerException() {
        System.out.println("\n========== 5. NullPointerException ==========");
        System.out.println("Возникает при вызове метода на null-ссылке");

        String str = null;
        System.out.println("Строка: " + str);

        try {
            System.out.println("Попытка вызвать str.length()");
            int length = str.length();  // ❌ Вызов метода на null
            System.out.println("Длина строки: " + length);
        } catch (NullPointerException e) {
            System.out.println("✅ Перехвачено NullPointerException: " + e.getMessage());
            System.out.println("   Решение: проверять объект на null перед использованием");
        }

        // Как избежать исключения
        String safeStr = null;
        if (safeStr != null) {
            int length = safeStr.length();
            System.out.println("Безопасная длина: " + length);
        } else {
            System.out.println("Безопасно: строка равна null, метод не вызывается");
        }

        // Использование Optional (Java 8+)
        String optionalStr = null;
        int length = java.util.Optional.ofNullable(optionalStr)
                .map(String::length)
                .orElse(0);
        System.out.println("Через Optional: длина = " + length);
    }

    // ========== ДЕМОНСТРАЦИЯ ВСЕХ ИСКЛЮЧЕНИЙ ==========
    public static void main(String[] args) {

        System.out.println("========== ПРИМЕРЫ ИСКЛЮЧЕНИЙ И ИХ ОБРАБОТКА ==========");

        demonstrateArithmeticException();
        demonstrateArrayIndexOutOfBoundsException();
        demonstrateIllegalArgumentException();
        demonstrateClassCastException();
        demonstrateNullPointerException();

        System.out.println("\n========== ИТОГОВАЯ ТАБЛИЦА ==========");
        System.out.println("┌────────────────────────────────┬─────────────────────────────────────┐");
        System.out.println("│ Исключение                     │ Причина возникновения               │");
        System.out.println("├────────────────────────────────┼─────────────────────────────────────┤");
        System.out.println("│ ArithmeticException            │ Деление на ноль                     │");
        System.out.println("│ ArrayIndexOutOfBoundsException │ Выход за границы массива            │");
        System.out.println("│ IllegalArgumentException       │ Некорректные аргументы метода        │");
        System.out.println("│ ClassCastException             │ Некорректное приведение типов        │");
        System.out.println("│ NullPointerException           │ Вызов метода на null-ссылке          │");
        System.out.println("└────────────────────────────────┴─────────────────────────────────────┘");

        System.out.println("\n========== СПОСОБЫ ОБРАБОТКИ ==========");
        System.out.println("1. try-catch - перехват и обработка исключения");
        System.out.println("2. throws - передача исключения выше");
        System.out.println("3. Проверка условий - предотвращение исключения");
        System.out.println("4. Optional - безопасная работа с null (Java 8+)");
    }
}