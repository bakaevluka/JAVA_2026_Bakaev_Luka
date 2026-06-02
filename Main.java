/**
 * Демонстрация спецификаторов доступа для внутренних классов
 */
class OuterClass {

    private String privateField = "private поле";
    String defaultField = "default поле";
    protected String protectedField = "protected поле";
    public String publicField = "public поле";

    // 1. public внутренний класс - доступен везде
    public class PublicInner {
        public void display() {
            System.out.println("PublicInner - доступен везде");
        }
    }

    // 2. private внутренний класс - доступен только внутри OuterClass
    private class PrivateInner {
        public void display() {
            System.out.println("PrivateInner - доступен только в OuterClass");
        }
    }

    // 3. protected внутренний класс - доступен в пакете + подклассах
    protected class ProtectedInner {
        public void display() {
            System.out.println("ProtectedInner - доступен в пакете и подклассах");
        }
    }

    // 4. default (package-private) внутренний класс - доступен только в пакете
    class DefaultInner {
        public void display() {
            System.out.println("DefaultInner - доступен только в пакете");
        }
    }

    // Демонстрация доступа из внешнего класса
    public void demonstrateAccessFromOuter() {
        System.out.println("\n=== Доступ из внешнего класса ===");

        // Внешний класс имеет доступ ко всем внутренним классам
        PublicInner pi = new PublicInner();
        PrivateInner pri = new PrivateInner();
        ProtectedInner proi = new ProtectedInner();
        DefaultInner di = new DefaultInner();

        pi.display();
        pri.display();
        proi.display();
        di.display();
    }

    // Создание и возврат private внутреннего класса (фабричный метод)
    public PrivateInner getPrivateInner() {
        return new PrivateInner();
    }
}

/**
 * Класс в том же пакете
 */
class SamePackageClass {
    public void testAccess() {
        OuterClass outer = new OuterClass();

        System.out.println("\n=== Доступ из класса в том же пакете ===");

        // ✅ public - доступен
        OuterClass.PublicInner publicInner = outer.new PublicInner();
        publicInner.display();

        // ✅ protected - доступен (тот же пакет)
        OuterClass.ProtectedInner protectedInner = outer.new ProtectedInner();
        protectedInner.display();

        // ✅ default - доступен (тот же пакет)
        OuterClass.DefaultInner defaultInner = outer.new DefaultInner();
        defaultInner.display();

        // ❌ private - НЕ доступен
        // OuterClass.PrivateInner privateInner = outer.new PrivateInner(); // ОШИБКА!
    }
}

/**
 * Подкласс в другом пакете
 */
// Предполагается, что этот класс в другом пакете
// package anotherpackage;
class SubClassInOtherPackage extends OuterClass {
    public void testAccess() {
        OuterClass outer = new OuterClass();

        System.out.println("\n=== Доступ из подкласса в другом пакете ===");

        // ✅ public - доступен
        OuterClass.PublicInner publicInner = outer.new PublicInner();
        publicInner.display();

        // ✅ protected - доступен (через наследование)
        // Для protected нужно использовать ссылку на подкласс или специальный синтаксис
        SubClassInOtherPackage sub = new SubClassInOtherPackage();
        ProtectedInner protectedInner = sub.new ProtectedInner();
        protectedInner.display();

        // ❌ default - НЕ доступен (другой пакет)
        // OuterClass.DefaultInner defaultInner = outer.new DefaultInner(); // ОШИБКА!

        // ❌ private - НЕ доступен
        // OuterClass.PrivateInner privateInner = outer.new PrivateInner(); // ОШИБКА!
    }
}

/**
 * Класс в другом пакете (не подкласс)
 */
// package anotherpackage;
class OtherPackageClass {
    public void testAccess() {
        OuterClass outer = new OuterClass();

        System.out.println("\n=== Доступ из другого пакета (не подкласс) ===");

        // ✅ public - доступен
        OuterClass.PublicInner publicInner = outer.new PublicInner();
        publicInner.display();

        // ❌ protected - НЕ доступен (другой пакет, не подкласс)
        // OuterClass.ProtectedInner protectedInner = outer.new ProtectedInner(); // ОШИБКА!

        // ❌ default - НЕ доступен
        // OuterClass.DefaultInner defaultInner = outer.new DefaultInner(); // ОШИБКА!

        // ❌ private - НЕ доступен
        // OuterClass.PrivateInner privateInner = outer.new PrivateInner(); // ОШИБКА!
    }
}

class AccessModifiersForInnerClasses {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();

        System.out.println("========== СПЕЦИФИКАТОРЫ ДОСТУПА ДЛЯ ВНУТРЕННИХ КЛАССОВ ==========");

        // Демонстрация из внешнего класса
        outer.demonstrateAccessFromOuter();

        // Демонстрация из того же пакета
        SamePackageClass samePkg = new SamePackageClass();
        samePkg.testAccess();

        System.out.println("\n========== ТАБЛИЦА ДОСТУПНОСТИ ==========");
        System.out.println("┌─────────────────┬────────────┬──────────────┬─────────────────┬──────────────┐");
        System.out.println("│ Модификатор     │ Тот же     │ Тот же       │ Подкласс        │ Другой       │");
        System.out.println("│                 │ класс      │ пакет        │ (др. пакет)     │ пакет        │");
        System.out.println("├─────────────────┼────────────┼──────────────┼─────────────────┼──────────────┤");
        System.out.println("│ public          │ ✅         │ ✅           │ ✅              │ ✅          │");
        System.out.println("│ protected       │ ✅         │ ✅           │ ✅              │ ❌          │");
        System.out.println("│ default (нет)   │ ✅         │ ✅           │ ❌              │ ❌          │");
        System.out.println("│ private         │ ✅         │ ❌           │ ❌              │ ❌          │");
        System.out.println("└─────────────────┴────────────┴──────────────┴─────────────────┴──────────────┘");
    }
}