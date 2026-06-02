
class A {

    // Статические поля класса
    public static int a = 1;
    public static int b = 2;  // инициализируем b значением 2

    /**
     * Статический метод printVars()
     * Выводит значения статических полей a и b
     */
    public static void printVars() {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    /**
     * Нестатический метод (для демонстрации, что статические методы
     * можно вызывать и из нестатических)
     */
    public void callPrintVarsFromNonStatic() {
        System.out.println("\n--- Вызов из нестатического метода ---");
        // Из нестатического метода можно вызвать статический
        printVars();           // вариант 1
        A.printVars();         // вариант 2
        this.printVars();      // вариант 3 (через this)
    }

    public static void main(String[] args) {

        System.out.println("========== ВСЕ ВАРИАНТЫ ВЫЗОВА СТАТИЧЕСКОГО МЕТОДА ==========\n");

        // ===== ВАРИАНТ 1: Прямой вызов из статического метода того же класса =====
        System.out.println(">>> ВАРИАНТ 1: Прямой вызов");
        System.out.println("Код: printVars();");
        printVars();

        // ===== ВАРИАНТ 2: Вызов через имя класса =====
        System.out.println("\n>>> ВАРИАНТ 2: Вызов через имя класса");
        System.out.println("Код: A.printVars();");
        A.printVars();

        // ===== ВАРИАНТ 3: Вызов через объект класса =====
        System.out.println("\n>>> ВАРИАНТ 3: Вызов через объект класса");
        System.out.println("Код: A obj = new A(); obj.printVars();");
        A obj = new A();
        obj.printVars();

        // ===== ВАРИАНТ 4: Вызов через null-ссылку =====
        System.out.println("\n>>> ВАРИАНТ 4: Вызов через null-ссылку");
        System.out.println("Код: A nullObj = null; nullObj.printVars();");
        A nullObj = null;
        nullObj.printVars();  // Работает! NullPointerException не возникает

        // ===== ВАРИАНТ 5: Вызов через this (внутри нестатического метода) =====
        System.out.println("\n>>> ВАРИАНТ 5: Вызов через this (из нестатического метода)");
        A test = new A();
        test.callPrintVarsFromNonStatic();

        // ===== ВАРИАНТ 6: Вызов через new A().printVars() =====
        System.out.println("\n>>> ВАРИАНТ 6: Вызов без сохранения ссылки");
        System.out.println("Код: new A().printVars();");
        new A().printVars();

        // ===== ВАРИАНТ 7: Вызов через приведение типа =====
        System.out.println("\n>>> ВАРИАНТ 7: Вызов через приведение типа");
        System.out.println("Код: ((A) null).printVars();");
        ((A) null).printVars();

        // ===== ВАРИАНТ 8: Вызов из другого класса =====
        System.out.println("\n>>> ВАРИАНТ 8: Вызов из другого класса");
        System.out.println("Код: B.callPrintVars();");
        B.callPrintVars();

        System.out.println("\n========== ВЫВОД ==========");
        System.out.println("Статический метод можно вызывать:");
        System.out.println("1. Прямо по имени (внутри того же класса)");
        System.out.println("2. Через имя класса (рекомендуемый способ)");
        System.out.println("3. Через объект класса (возможно, но не рекомендуется)");
        System.out.println("4. Даже через null-ссылку (компилятор заменяет на вызов через класс)");
    }
}

/**
 * Дополнительный класс для демонстрации вызова статического метода из другого класса
 */
class B {
    public static void callPrintVars() {
        System.out.println("Вызов из класса B:");
        A.printVars();
    }
}