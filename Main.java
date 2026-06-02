/**
 * Демонстрация доступа внутреннего класса к полям и методам внешнего класса
 */
class Outer {
    // Поля с разными модификаторами доступа
    private int privateVar = 10;
    int defaultVar = 20;
    protected int protectedVar = 30;
    public int publicVar = 40;

    private static int staticPrivateVar = 100;
    public static int staticPublicVar = 200;

    // Приватный метод
    private void privateMethod() {
        System.out.println("Вызван privateMethod() внешнего класса");
    }

    // Публичный метод
    public void publicMethod() {
        System.out.println("Вызван publicMethod() внешнего класса");
    }

    /**
     * Внутренний класс (нестатический)
     * Имеет доступ ко ВСЕМ полям и методам внешнего класса,
     * НЕЗАВИСИМО от их модификаторов доступа!
     */
    class Inner {

        public void accessOuterMembers() {
            System.out.println("\n=== Доступ внутреннего класса к полям внешнего ===");

            // ✅ Доступ к private полю внешнего класса
            System.out.println("privateVar = " + privateVar);

            // ✅ Доступ к default полю
            System.out.println("defaultVar = " + defaultVar);

            // ✅ Доступ к protected полю
            System.out.println("protectedVar = " + protectedVar);

            // ✅ Доступ к public полю
            System.out.println("publicVar = " + publicVar);

            // ✅ Доступ к статическим полям
            System.out.println("staticPrivateVar = " + staticPrivateVar);
            System.out.println("staticPublicVar = " + staticPublicVar);

            // ✅ Доступ к private методу
            privateMethod();

            // ✅ Доступ к public методу
            publicMethod();
        }

        // Внутренний класс может иметь свои поля
        private int innerPrivateVar = 999;

        public void showInnerOwnField() {
            System.out.println("innerPrivateVar = " + innerPrivateVar);
        }
    }

    // Метод для демонстрации создания внутреннего класса
    public void createInner() {
        Inner inner = new Inner();
        inner.accessOuterMembers();
    }
}

class InnerClassAccessExample {
    public static void main(String[] args) {
        Outer outer = new Outer();

        System.out.println("========== ДОСТУП ВНУТРЕННЕГО КЛАССА К ВНЕШНЕМУ ==========");
        System.out.println("\n✅ Внутренний класс имеет доступ к ЛЮБЫМ полям и методам");
        System.out.println("   внешнего класса, независимо от модификаторов доступа!");

        // Способ 1: через метод внешнего класса
        outer.createInner();

        // Способ 2: создание внутреннего класса извне
        System.out.println("\n=== Создание внутреннего класса извне ===");
        Outer.Inner inner = outer.new Inner();
        inner.accessOuterMembers();
        inner.showInnerOwnField();
    }
}