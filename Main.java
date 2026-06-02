/**
 * Демонстрация использования final в catch-блоке
 */
class FinalInCatchExample {

    public static void main(String[] args) {

        System.out.println("========== final в catch-блоке ==========\n");

        // final в catch - параметр исключения нельзя изменить
        try {
            int result = 10 / 0;
        } catch (final ArithmeticException e) {
            System.out.println("✅ Исключение перехвачено с final параметром");
            System.out.println("   e.getMessage(): " + e.getMessage());

            // ❌ НЕЛЬЗЯ - параметр с final нельзя изменить
            // e = new ArithmeticException("Новое сообщение");  // Ошибка компиляции!

            // ✅ МОЖНО - использовать методы объекта
            e.printStackTrace();
            System.out.println("   Класс: " + e.getClass().getSimpleName());
        }

        System.out.println("\n--- Зачем нужен final в catch? ---");
        System.out.println("1. Гарантирует, что ссылка на исключение не изменится");
        System.out.println("2. Показывает намерение разработчика");
        System.out.println("3. Позволяет использовать в лямбда-выражениях");

        System.out.println("\n--- Пример с лямбдой (Java 8+) ---");

        try {
            throw new RuntimeException("Тестовое исключение");
        } catch (final RuntimeException e) {
            // final позволяет использовать e в лямбде
            Runnable r = () -> System.out.println("  Ошибка в лямбде: " + e.getMessage());
            r.run();
        }

        System.out.println("\n--- Сравнение с обычным catch ---");

        // Без final - можно переопределить ссылку
        try {
            int[] arr = {1, 2, 3};
            int x = arr[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  Обычный catch (без final): " + e.getMessage());
            // Можно изменить ссылку (но не рекомендуется)
            e = new ArrayIndexOutOfBoundsException("Новое сообщение");
            System.out.println("  После изменения: " + e.getMessage());
        }

        System.out.println("\n========== ВЫВОД ==========");
        System.out.println("final в catch-блоке делает параметр неизменяемым");
        System.out.println("Использование final - хорошая практика, особенно при работе с лямбдами");
    }
}