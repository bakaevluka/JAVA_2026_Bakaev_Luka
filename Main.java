// Интерфейс A с default методом
interface A {
    default void print() {
        System.out.println("A.print() - метод из интерфейса A");
    }
}

// Интерфейс B с ТАКИМ ЖЕ default методом
interface B {
    default void print() {
        System.out.println("B.print() - метод из интерфейса B");
    }
}

/**
 * Класс, реализующий оба интерфейса
 * ВОЗНИКАЕТ КОНФЛИКТ! Компилятор не знает, какой метод использовать
 */
class MyClass implements A, B {

    // ❌ Если не переопределить print() - будет ОШИБКА КОМПИЛЯЦИИ!
    // "MyClass inherits unrelated defaults for print() from types A and B"

    // ✅ РЕШЕНИЕ: переопределить конфликтующий метод
    @Override
    public void print() {
        System.out.println("MyClass.print() - переопределенный метод");
        // Можно явно вызвать нужный метод из интерфейса
    }

    // Можно также вызвать конкретный метод интерфейса
    public void callAPrint() {
        A.super.print();  // вызов метода из интерфейса A
    }

    public void callBPrint() {
        B.super.print();  // вызов метода из интерфейса B
    }
}

/**
 * Пример с более сложной иерархией
 */
interface Drawable {
    default void draw() {
        System.out.println("Рисуем фигуру");
    }
}

interface Colorable {
    default void draw() {
        System.out.println("Рисуем цветную фигуру");
    }
}

interface Shape extends Drawable, Colorable {
    // Интерфейс тоже должен разрешить конфликт!
    @Override
    default void draw() {
        // Можно выбрать один из методов
        Drawable.super.draw();  // выбираем метод из Drawable
        System.out.println("Shape: рисуем фигуру");
    }
}

class Circle implements Shape {
    // Можно использовать метод из Shape (уже разрешен конфликт)
    // Или переопределить снова
    @Override
    public void draw() {
        System.out.println("Circle: рисуем круг");
    }
}

/**
 * Альтернативное решение: класс сам решает конфликт
 */
interface Printer {
    default void print(String text) {
        System.out.println("Printer: " + text);
    }
}

interface Scanner {
    default void print(String text) {
        System.out.println("Scanner: " + text);
    }
}

class MultiFunctionDevice implements Printer, Scanner {

    // Решение 1: полностью переопределить метод
    @Override
    public void print(String text) {
        System.out.println("МФУ: " + text);
    }

    // Решение 2: вызвать нужный метод из интерфейса
    public void printFromPrinter(String text) {
        Printer.super.print(text);
    }

    public void printFromScanner(String text) {
        Scanner.super.print(text);
    }
}

/**
 * Демонстрация
 */
class MultipleInheritanceConflictExample {
    public static void main(String[] args) {

        System.out.println("========== КОНФЛИКТ DEFAULT МЕТОДОВ ==========\n");

        System.out.println("Проблема: Класс реализует два интерфейса с одинаковыми default методами");
        System.out.println("Решение: Класс должен переопределить конфликтующий метод\n");

        MyClass obj = new MyClass();
        obj.print();              // вызывает переопределенный метод
        obj.callAPrint();        // вызывает метод из интерфейса A
        obj.callBPrint();        // вызывает метод из интерфейса B

        System.out.println("\n========== РАЗРЕШЕНИЕ КОНФЛИКТА В ИНТЕРФЕЙСЕ ==========");

        Circle circle = new Circle();
        circle.draw();  // вызывает метод из Circle

        Shape shape = new Shape() { };  // анонимный класс
        shape.draw();   // вызывает метод из Shape (где конфликт уже разрешен)

        System.out.println("\n========== ВАРИАНТЫ РЕШЕНИЯ ==========");
        System.out.println("1. Переопределить метод в классе (обязательно)");
        System.out.println("2. Использовать A.super.methodName() для вызова конкретной реализации");
        System.out.println("3. Разрешить конфликт в интерфейсе-наследнике");

        System.out.println("\n========== СПОСОБЫ ВЫЗОВА ==========");
        MultiFunctionDevice mfd = new MultiFunctionDevice();
        mfd.print("Документ");              // свой метод
        mfd.printFromPrinter("Документ");   // метод из Printer
        mfd.printFromScanner("Документ");   // метод из Scanner
    }
}