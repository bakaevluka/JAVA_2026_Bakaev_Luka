/**
 * Демонстрация изменения спецификаторов доступа при наследовании
 */
class A {
    // Поля с разными модификаторами доступа
    int a1 = 1;           // default (package-private)
    public int a2 = 2;    // public
    protected int a3 = 3; // protected
    private int a4 = 4;   // private

    // Методы с разными модификаторами доступа
    void method1() {
        System.out.println("A.method1() - default");
    }

    public void method2() {
        System.out.println("A.method2() - public");
    }

    protected void method3() {
        System.out.println("A.method3() - protected");
    }

    private void method4() {
        System.out.println("A.method4() - private");
    }

    // Метод для демонстрации доступа внутри класса A
    public void showAccessFromA() {
        System.out.println("\n=== Доступ из класса A ===");
        System.out.println("a1 = " + a1 + " (default) - ✅ доступен");
        System.out.println("a2 = " + a2 + " (public) - ✅ доступен");
        System.out.println("a3 = " + a3 + " (protected) - ✅ доступен");
        System.out.println("a4 = " + a4 + " (private) - ✅ доступен");
        method1();  // ✅ доступен
        method2();  // ✅ доступен
        method3();  // ✅ доступен
        method4();  // ✅ доступен
    }
}

class B extends A {
    // B наследует A

    public void showAccessFromB() {
        System.out.println("\n=== Доступ из класса B (наследник A) ===");

        // Доступ к полям A из класса B
        // System.out.println("a1 = " + a1);  // ✅ доступен (тот же пакет)
        System.out.println("a1 = " + a1 + " (default) - ✅ доступен (тот же пакет)");
        System.out.println("a2 = " + a2 + " (public) - ✅ доступен");
        System.out.println("a3 = " + a3 + " (protected) - ✅ доступен");
        // System.out.println("a4 = " + a4);  // ❌ НЕ ДОСТУПЕН! private

        // Доступ к методам A из класса B
        method1();  // ✅ доступен (тот же пакет)
        method2();  // ✅ доступен (public)
        method3();  // ✅ доступен (protected)
        // method4();  // ❌ НЕ ДОСТУПЕН! private
    }

    // Переопределение метода с расширением доступа (можно только шире)
    @Override
    public void method1() {  // default -> public (расширение ✅)
        System.out.println("B.method1() - override (default -> public)");
    }

    @Override
    public void method2() {  // public -> public (то же ✅)
        System.out.println("B.method2() - override (public -> public)");
    }

    @Override
    protected void method3() {  // protected -> protected (то же ✅)
        System.out.println("B.method3() - override (protected -> protected)");
    }

    // Нельзя расширить доступ с private (private не виден)
    // @Override - нельзя переопределить private метод
}

class C extends B {
    // C наследует B (цепочка: A -> B -> C)

    public void showAccessFromC() {
        System.out.println("\n=== Доступ из класса C (наследник B) ===");

        // Все еще доступны поля из A (через цепочку наследования)
        System.out.println("a1 = " + a1 + " (default) - ✅ доступен (тот же пакет)");
        System.out.println("a2 = " + a2 + " (public) - ✅ доступен");
        System.out.println("a3 = " + a3 + " (protected) - ✅ доступен");
        // System.out.println("a4 = " + a4);  // ❌ НЕ ДОСТУПЕН! private остается private

        method1();  // ✅ доступен
        method2();  // ✅ доступен
        method3();  // ✅ доступен
    }

    @Override
    public void method1() {
        System.out.println("C.method1() - еще одно переопределение");
    }
}

/**
 * Класс в том же пакете (для проверки default доступа)
 */
class SamePackageClass {
    public void testAccess(A obj) {
        System.out.println("\n=== Доступ из другого класса в том же пакете ===");
        System.out.println("a1 = " + obj.a1 + " (default) - ✅ доступен (тот же пакет)");
        System.out.println("a2 = " + obj.a2 + " (public) - ✅ доступен");
        System.out.println("a3 = " + obj.a3 + " (protected) - ✅ доступен");
        // System.out.println("a4 = " + obj.a4);  // ❌ private - не доступен
    }
}

/**
 * Главный класс для демонстрации
 */
class InheritanceAccessExample {
    public static void main(String[] args) {

        System.out.println("========== НАСЛЕДОВАНИЕ И СПЕЦИФИКАТОРЫ ДОСТУПА ==========");

        A objA = new A();
        B objB = new B();
        C objC = new C();

        objA.showAccessFromA();
        objB.showAccessFromB();
        objC.showAccessFromC();

        // Проверка доступа из другого класса в том же пакете
        SamePackageClass test = new SamePackageClass();
        test.testAccess(objA);

        System.out.println("\n========== ПЕРЕОПРЕДЕЛЕНИЕ МЕТОДОВ ==========");
        objB.method1();
        objB.method2();
        objB.method3();

        System.out.println("\n========== ПОЛИМОРФИЗМ ==========");
        A ref = new B();
        ref.method1();  // вызовется B.method1()
        ref.method2();  // вызовется B.method2()
        ref.method3();  // вызовется B.method3()
        // ref.method4();  // ❌ НЕ ДОСТУПЕН!
    }
}