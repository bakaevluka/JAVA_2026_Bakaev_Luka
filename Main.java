/**
 * Демонстрация доступа внешнего класса к полям и методам внутреннего класса
 */
class OuterClass2 {

    // Внутренний класс с разными модификаторами доступа
    public class PublicInner {
        private int privateField = 1;
        int defaultField = 2;
        protected int protectedField = 3;
        public int publicField = 4;

        private void privateMethod() {
            System.out.println("  PublicInner.privateMethod()");
        }

        public void publicMethod() {
            System.out.println("  PublicInner.publicMethod()");
        }
    }

    // Внутренний класс с private модификатором
    private class PrivateInner {
        public int innerField = 100;

        public void innerMethod() {
            System.out.println("PrivateInner.innerMethod()");
        }
    }

    // Демонстрация доступа внешнего класса к внутреннему
    public void demonstrateAccessToInner() {
        System.out.println("\n=== Доступ внешнего класса к PublicInner ===");

        PublicInner publicInner = new PublicInner();

        // Внешний класс имеет доступ ко ВСЕМ полям внутреннего класса
        System.out.println("publicInner.privateField = " + publicInner.privateField);
        System.out.println("publicInner.defaultField = " + publicInner.defaultField);
        System.out.println("publicInner.protectedField = " + publicInner.protectedField);
        System.out.println("publicInner.publicField = " + publicInner.publicField);

        publicInner.privateMethod();
        publicInner.publicMethod();

        System.out.println("\n=== Доступ внешнего класса к PrivateInner ===");
        PrivateInner privateInner = new PrivateInner();
        System.out.println("privateInner.innerField = " + privateInner.innerField);
        privateInner.innerMethod();
    }

    // Метод, возвращающий private внутренний класс
    public PrivateInner getPrivateInner() {
        return new PrivateInner();
    }
}

/**
 * Класс для демонстрации доступа извне
 */
class AccessFromOutside {
    public static void main(String[] args) {
        OuterClass2 outer = new OuterClass2();

        System.out.println("========== ДОСТУП ВНЕШНЕГО КЛАССА К ВНУТРЕННЕМУ ==========");
        System.out.println("\n✅ Внешний класс имеет доступ ко ВСЕМ полям и методам");
        System.out.println("   своих внутренних классов, независимо от модификаторов!\n");

        outer.demonstrateAccessToInner();

        System.out.println("\n========== ДОСТУП ИЗВНЕ ==========");

        // Доступ к public внутреннему классу
        System.out.println("\n--- Доступ к PublicInner извне ---");
        OuterClass2.PublicInner publicInner = outer.new PublicInner();

        // ❌ private поле НЕ доступно извне
        // System.out.println(publicInner.privateField); // ОШИБКА!

        // ❌ default поле НЕ доступно (если из другого пакета)
        // System.out.println(publicInner.defaultField);

        // ✅ public поле доступно
        System.out.println("publicInner.publicField = " + publicInner.publicField);

        // ✅ public метод доступен
        publicInner.publicMethod();

        // ❌ private метод НЕ доступен извне
        // publicInner.privateMethod(); // ОШИБКА!

        // Доступ к private внутреннему классу извне невозможен
        System.out.println("\n--- Доступ к PrivateInner извне ---");
        // OuterClass2.PrivateInner privateInner = outer.new PrivateInner(); // ❌ ОШИБКА!

        // Но можно получить через метод внешнего класса
        Object privateInner = outer.getPrivateInner();
        System.out.println("PrivateInner получен через метод: " + privateInner.getClass().getSimpleName());
    }
}