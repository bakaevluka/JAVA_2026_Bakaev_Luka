class NullPointerExceptionExample {
    public static void main(String[] args) {

        System.out.println("========== NullPointerException при unboxing ==========");

        // null - это допустимое значение для ссылочного типа (объекта)
        Integer nullInteger = null;

        // ПРИМЕР 1: Автораспаковка null -> примитив
        try {
            int value = nullInteger;  // unboxing: nullInteger.intValue()
            System.out.println("Это не выведется");
        } catch (NullPointerException e) {
            System.out.println("Ошибка! int value = nullInteger; -> NullPointerException");
            System.out.println("Причина: попытка вызвать метод intValue() на null");
        }

        // ПРИМЕР 2: Арифметическая операция с null-объектом
        try {
            Integer a = null;
            Integer b = 10;
            Integer result = a + b;  // сначала unboxing a и b, потом операция
            System.out.println("Это не выведется");
        } catch (NullPointerException e) {
            System.out.println("Ошибка! a + b где a = null -> NullPointerException");
        }

        // ПРИМЕР 3: Сравнение с null-объектом
        try {
            Integer x = null;
            int y = 5;
            boolean compare = x > y;  // unboxing x
            System.out.println("Это не выведется");
        } catch (NullPointerException e) {
            System.out.println("Ошибка! x > y где x = null -> NullPointerException");
        }

        // ПРИМЕР 4: Передача null в метод, ожидающий примитив
        try {
            printInt(nullInteger);  // unboxing при передаче
        } catch (NullPointerException e) {
            System.out.println("Ошибка! Передача null в метод с параметром int");
        }

        System.out.println("\n========== Безопасный код ==========");

        // ПРАВИЛЬНО: проверка на null перед unboxing
        Integer safeInteger = null;
        if (safeInteger != null) {
            int value = safeInteger;  // безопасно
            System.out.println("Значение: " + value);
        } else {
            System.out.println("safeInteger = null, unboxing не выполняется");
        }

        // использование Optional (Java 8+)
        Integer optionalInteger = null;
        int defaultValue = 0;
        int result = (optionalInteger != null) ? optionalInteger : defaultValue;
        System.out.println("Безопасное получение значения: " + result);
    }

    public static void printInt(int value) {
        System.out.println("Значение: " + value);
    }
}