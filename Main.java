/**
 * Демонстрация:
 * 1. Несколько исключений обрабатываются одинаково
 * 2. Исключения с иерархией (Ex1 <|-- Ex2 <|-- Ex3)
 * 3. Multi-catch с оператором |
 */
class MultipleCatchExample {

    // ========== СОЗДАНИЕ ИЕРАРХИИ ИСКЛЮЧЕНИЙ ==========
    static class Ex1 extends Exception {
        public Ex1(String msg) { super(msg); }
    }

    static class Ex2 extends Ex1 {
        public Ex2(String msg) { super(msg); }
    }

    static class Ex3 extends Ex2 {
        public Ex3(String msg) { super(msg); }
    }

    // ========== 1. НЕСКОЛЬКО ИСКЛЮЧЕНИЙ С ИДЕНТИЧНОЙ ОБРАБОТКОЙ ==========
    public static void identicalHandling() {
        System.out.println("\n--- 1. Одинаковая обработка разных исключений ---");

        String[] testCases = {"null", "empty", "valid"};

        for (String test : testCases) {
            try {
                System.out.print("  Тест '" + test + "': ");

                if (test.equals("null")) {
                    String str = null;
                    str.length();  // NullPointerException
                } else if (test.equals("empty")) {
                    int[] arr = new int[0];
                    arr[0] = 1;    // ArrayIndexOutOfBoundsException
                } else {
                    System.out.println("Успех!");
                }

            } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                // Мульти-catch: оба исключения обрабатываются одинаково
                System.out.println("Перехвачено: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }
        }
    }

    // ========== 2. ИЕРАРХИЯ ИСКЛЮЧЕНИЙ - порядок catch-блоков ==========
    public static void hierarchyHandling() {
        System.out.println("\n--- 2. Иерархия исключений (Ex3 ← Ex2 ← Ex1) ---");
        System.out.println("Важно! Порядок catch-блоков: от более специфичных к более общим");

        String[] testCases = {"ex1", "ex2", "ex3"};

        for (String test : testCases) {
            try {
                System.out.print("  Тест '" + test + "': ");

                if (test.equals("ex1")) {
                    throw new Ex1("Исключение Ex1");
                } else if (test.equals("ex2")) {
                    throw new Ex2("Исключение Ex2");
                } else {
                    throw new Ex3("Исключение Ex3");
                }

            } catch (Ex3 e) {
                // Самый специфичный (подкласс)
                System.out.println("  catch Ex3: " + e.getMessage());
            } catch (Ex2 e) {
                // Более общий
                System.out.println("  catch Ex2: " + e.getMessage());
            } catch (Ex1 e) {
                // Самый общий (суперкласс) - должен быть последним
                System.out.println("  catch Ex1: " + e.getMessage());
            }
        }

        // ❌ НЕПРАВИЛЬНЫЙ ПОРЯДОК (раскомментировать для демонстрации ошибки)
        System.out.println("\n  ❌ Неправильный порядок catch-блоков приведет к ошибке компиляции:");
        System.out.println("     catch (Ex1 e) { }  // Должен быть после Ex2 и Ex3");
        System.out.println("     catch (Ex2 e) { }  // Ошибка: exception Ex2 has already been caught");
    }

    // ========== 3. МУЛЬТИ-CATCH НЕ РАБОТАЕТ С ИЕРАРХИЕЙ ==========
    public static void multiCatchWithHierarchy() {
        System.out.println("\n--- 3. Multi-catch НЕ работает с иерархическими исключениями ---");

        // ❌ ТАК НЕЛЬЗЯ - будет ошибка компиляции
        System.out.println("  ❌ Ошибка компиляции при таком multi-catch:");
        System.out.println("     catch (Ex2 | Ex3 e) { }");
        System.out.println("     Потому что Ex3 extends Ex2 (иерархическая связь)\n");

        // ✅ ПРАВИЛЬНО - исключения из разных веток иерархии
        System.out.println("  ✅ Правильно - исключения из разных иерархий:");
        System.out.println("     catch (NullPointerException | IllegalArgumentException e) { }");

        try {
            // Генерируем разные исключения
            if (Math.random() > 0.5) {
                throw new NullPointerException("NPE");
            } else {
                throw new IllegalArgumentException("IAE");
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            // ✅ Эти исключения не связаны иерархией
            System.out.println("     Перехвачено multi-catch: " + e.getClass().getSimpleName());
        }
    }

    // ========== 4. ВЛОЖЕННЫЕ TRY-CATCH ==========
    public static void nestedTryCatch() {
        System.out.println("\n--- 4. Вложенные try-catch блоки ---");

        try {
            System.out.println("  Внешний try-блок");

            try {
                System.out.println("    Внутренний try-блок");
                int result = 10 / 0;  // ArithmeticException
                System.out.println("    Результат: " + result);
            } catch (ArithmeticException e) {
                System.out.println("    ✅ Внутренний catch перехватил: " + e.getClass().getSimpleName());
                // Внутренний catch обработал исключение
            }

            System.out.println("  Внешний try-блок продолжает работу");

        } catch (Exception e) {
            System.out.println("  Внешний catch (не выполнится, т.к. исключение уже обработано)");
        }

        System.out.println("  Программа продолжается после вложенных блоков");
    }

    // ========== 5. ИСКЛЮЧЕНИЕ НЕ ОБРАБОТАНО ВО ВНУТРЕННЕМ TRY ==========
    public static void nestedTryWithUncaught() {
        System.out.println("\n--- 5. Исключение НЕ обработано во внутреннем try ---");

        try {
            System.out.println("  Внешний try-блок");

            try {
                System.out.println("    Внутренний try-блок");
                int[] arr = new int[1];
                arr[10] = 100;  // ArrayIndexOutOfBoundsException
                System.out.println("    Эта строка не выполнится");
            } catch (ArithmeticException e) {
                // Этот catch не ловит ArrayIndexOutOfBoundsException
                System.out.println("    Внутренний catch (не сработает)");
            }

            System.out.println("  Эта строка не выполнится - исключение передано во внешний try");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  ✅ Внешний catch перехватил: " + e.getClass().getSimpleName());
        }
    }

    // ========== ГЛАВНЫЙ МЕТОД ==========
    public static void main(String[] args) {

        System.out.println("========== НЕСКОЛЬКО CATCH-БЛОКОВ И ИЕРАРХИЯ ==========");

        identicalHandling();
        hierarchyHandling();
        multiCatchWithHierarchy();
        nestedTryCatch();
        nestedTryWithUncaught();

        System.out.println("\n========== ПРАВИЛА ==========");
        System.out.println("┌────────────────────────────────────────────────────────────────┐");
        System.out.println("│ 1. catch-блоки идут от более специфичных к более общим         │");
        System.out.println("│ 2. Multi-catch (|) НЕ работает с иерархическими исключениями   │");
        System.out.println("│ 3. Обработка исключения происходит в ПЕРВОМ подходящем catch   │");
        System.out.println("│ 4. Вложенные try-catch позволяют обрабатывать исключения       │");
        System.out.println("│    на разных уровнях                                           │");
        System.out.println("│ 5. Если исключение не обработано во внутреннем try, оно        │");
        System.out.println("│    передается во внешний                                       │");
        System.out.println("└────────────────────────────────────────────────────────────────┘");
    }
}