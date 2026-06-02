/**
 * Демонстрация правил использования try-catch-finally
 */
class TryFinallyRulesExample {

    public static void main(String[] args) {

        System.out.println("========== ПРАВИЛА ИСПОЛЬЗОВАНИЯ TRY-CATCH-FINALLY ==========\n");

        // ========== ПРАКТИКА #1 ==========
        System.out.println("--- ПРАКТИКА #1: try без catch и finally ---");
        System.out.println("❌ НЕЛЬЗЯ! Будет ошибка компиляции");
        System.out.println("   try { ... }  // ОШИБКА!");
        System.out.println("   Причина: try должен сопровождаться либо catch, либо finally\n");

        /*
        // ❌ ТАК НЕЛЬЗЯ - ошибка компиляции
        try {
            int x = 10;
        }
        */

        // ========== ПРАКТИКА #2 ==========
        System.out.println("--- ПРАКТИКА #2: try только с finally ---");
        System.out.println("✅ МОЖНО! Такая конструкция допустима");

        try {
            System.out.println("   try-блок: попытка выполнить код");
            int x = 10 / 2;
            System.out.println("   Результат: " + x);
        } finally {
            System.out.println("   finally-блок: выполнится ВСЕГДА (даже если нет исключения)");
        }

        // Пример с исключением, но без catch
        System.out.println("\n   --- Пример с исключением (но без catch) ---");
        try {
            System.out.println("   try-блок: попытка деления на ноль");
            int y = 10 / 0;  // исключение
            System.out.println("   Эта строка не выполнится");
        } finally {
            System.out.println("   finally-блок: выполнится ДО аварийной остановки!");
        }
        // Исключение не перехвачено -> программа аварийно завершится
        // Но finally выполнится перед этим!

        // ========== ПРАКТИКА #3 ==========
        System.out.println("\n--- ПРАКТИКА #3: try с двумя finally ---");
        System.out.println("❌ НЕЛЬЗЯ! Будет ошибка компиляции");
        System.out.println("   try { ... } finally { ... } finally { ... }  // ОШИБКА!");
        System.out.println("   Причина: может быть только один блок finally\n");

        /*
        // ❌ ТАК НЕЛЬЗЯ - ошибка компиляции
        try {
            int x = 10;
        } finally {
            System.out.println("Первый finally");
        } finally {
            System.out.println("Второй finally");  // ОШИБКА!
        }
        */

        System.out.println("\n========== ВСЕ ВОЗМОЖНЫЕ КОНСТРУКЦИИ ==========");
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│ 1. ✅ try-catch                                               │");
        System.out.println("│ 2. ✅ try-catch-finally                                       │");
        System.out.println("│ 3. ✅ try-finally (без catch)                                 │");
        System.out.println("│ 4. ❌ try (без catch и finally) - ОШИБКА                       │");
        System.out.println("│ 5. ❌ try с двумя finally - ОШИБКА                            │");
        System.out.println("│ 6. ❌ try-catch-catch-finally-finally - ОШИБКА                │");
        System.out.println("└─────────────────────────────────────────────────────────────────┘");

        System.out.println("\n========== ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ ==========");

        // Пример 1: try-catch-finally
        System.out.println("\n--- 1. try-catch-finally (полная конструкция) ---");
        try {
            System.out.println("   try: деление 10/0");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("   catch: перехвачено исключение: " + e.getMessage());
        } finally {
            System.out.println("   finally: выполнится всегда");
        }

        // Пример 2: try-catch (без finally)
        System.out.println("\n--- 2. try-catch (без finally) ---");
        try {
            System.out.println("   try: без исключения");
            String s = "OK";
        } catch (Exception e) {
            System.out.println("   catch: не выполнится");
        }
        System.out.println("   finally нет, но код продолжается");

        // Пример 3: try-finally с return
        System.out.println("\n--- 3. try-finally с return (finally выполнится даже после return) ---");
        System.out.println("   Результат: " + testFinallyWithReturn());

        System.out.println("\n========== ВАЖНЫЕ ФАКТЫ О FINALLY ==========");
        System.out.println("• finally выполняется ВСЕГДА, даже если:");
        System.out.println("  - в try или catch есть return");
        System.out.println("  - в try или catch есть throw");
        System.out.println("  - произошло исключение");
        System.out.println("• finally выполняется ДО того, как исключение уйдет наверх");
        System.out.println("• finally нужен для освобождения ресурсов (закрытие файлов, соединений)");
    }

    // Демонстрация: finally выполняется даже после return
    public static int testFinallyWithReturn() {
        try {
            System.out.println("      try: выполняется return 1");
            return 1;
        } finally {
            System.out.println("      finally: выполняется ДАЖЕ после return!");
        }
    }
}