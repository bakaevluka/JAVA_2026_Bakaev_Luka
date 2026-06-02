/**
 * Демонстрация: final-класс нельзя расширить (нельзя создать подкласс)
 */

// final-класс - от него НЕЛЬЗЯ наследоваться
final class FinalClass {
    private String name = "FinalClass";

    public String getName() {
        return name;
    }

    public void showMessage() {
        System.out.println("Это метод final-класса");
    }
}

// ❌ ОШИБКА: нельзя создать подкласс от final-класса
// class SubClass extends FinalClass {
//     // Невозможно! Компилятор выдаст ошибку
// }

// Обычный класс - от него МОЖНО наследоваться
class RegularClass {
    private String value = "RegularClass";

    public String getValue() {
        return value;
    }

    public void display() {
        System.out.println("Это метод обычного класса");
    }
}

// ✅ РАБОТАЕТ: наследование от обычного класса
class ExtendedClass extends RegularClass {
    public void extraMethod() {
        System.out.println("Дополнительный метод подкласса");
    }
}

/**
 * Пример полезного использования final-класса
 * String - классический пример final-класса в Java
 */
final class ImmutablePoint {
    private final int x;
    private final int y;

    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}

// ❌ НЕЛЬЗЯ: String - final-класс
// class MyString extends String { }  // Ошибка!

class FinalClassExample {
    public static void main(String[] args) {

        System.out.println("========== final-класс нельзя расширить ==========\n");

        // Работа с final-классом возможна (создание объектов, вызов методов)
        FinalClass finalObj = new FinalClass();
        System.out.println("finalObj.getName() = " + finalObj.getName());
        finalObj.showMessage();

        System.out.println("\n========== Обычный класс можно расширить ==========");
        ExtendedClass extended = new ExtendedClass();
        extended.display();      // унаследованный метод
        extended.extraMethod();  // свой метод

        System.out.println("\n========== ImmutablePoint (final-класс) ==========");
        ImmutablePoint p1 = new ImmutablePoint(10, 20);
        ImmutablePoint p2 = new ImmutablePoint(30, 40);
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        // p1.x = 15;  // ❌ НЕЛЬЗЯ: поля final

        System.out.println("\n========== Ошибки компиляции ==========");
        System.out.println("1. Попытка наследоваться от final-класса:");
        System.out.println("   class SubClass extends FinalClass { }");
        System.out.println("   → 'Cannot inherit from final 'FinalClass''\n");

        System.out.println("2. Попытка переопределить final-метод:");
        System.out.println("   public void finalMethod() { }");
        System.out.println("   → 'finalMethod()' cannot override 'finalMethod()'");
        System.out.println("     overridden method is final");
    }
}