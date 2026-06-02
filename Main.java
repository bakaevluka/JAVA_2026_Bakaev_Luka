/**
 * Демонстрация:
 * 1. Перехваченное исключение - обработано в try-catch
 * 2. Неперехваченное исключение - приводит к аварийной остановке программы
 */
class CaughtVsUncaughtException {

    // ========== МЕТОД, ГЕНЕРИРУЮЩИЙ ПЕРЕХВАЧЕННОЕ ИСКЛЮЧЕНИЕ ==========
    public static void methodWithCaughtException() {
        System.out.println("  → Вход в methodWithCaughtException()");

        try {
            System.out.println("    Попытка: деление 10 / 0");
            int result = 10 / 0;  // генерирует ArithmeticException
            System.out.println("    Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("    ✅ Исключение ПЕРЕХВАЧЕНО в catch-блоке");
            System.out.println("    Ошибка: " + e.getMessage());
            System.out.println("    Программа продолжает работу");
        }

        System.out.println("  ← Выход из methodWithCaughtException()\n");
    }

    // ========== МЕТОД, ГЕНЕРИРУЮЩИЙ НЕПЕРЕХВАЧЕННОЕ ИСКЛЮЧЕНИЕ ==========
    public static void methodWithUncaughtException() {
        System.out.println("  → Вход в methodWithUncaughtException()");

        System.out.println("    Попытка: получить элемент массива с индексом 10");
        int[] arr = {1, 2, 3};
        int value = arr[10];  // ❌ ArrayIndexOutOfBoundsException - НЕТ try-catch!
        System.out.println("    Значение: " + value);

        System.out.println("  ← Выход из methodWithUncaughtException()"); // Этот код не выполнится
    }

    // ========== МЕТОД, КОТОРЫЙ ВЫЗЫВАЕТ ОБА ПРЕДЫДУЩИХ ==========
    public static void main(String[] args) {

        System.out.println("========== ПЕРЕХВАТ И АВАРИЙНАЯ ОСТАНОВКА ==========\n");

        System.out.println("--- ЧАСТЬ 1: Перехваченное исключение ---");
        System.out.println("(Программа продолжает работу после обработки)\n");

        methodWithCaughtException();

        System.out.println("--- ЧАСТЬ 2: Неперехваченное исключение ---");
        System.out.println("(Программа аварийно завершится)\n");

        methodWithUncaughtException();  // ❌ Здесь произойдет аварийная остановка

        // Этот код НЕ ВЫПОЛНИТСЯ из-за аварийной остановки выше
        System.out.println("Это сообщение не будет выведено!");
    }
}