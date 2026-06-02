/**
 * Демонстрация: статические методы НЕ поддерживают полиморфизм
 */
class A {
    // Статический метод
    public static void method() {
        System.out.println("A.method() - статический метод суперкласса");
    }

    // Нестатический метод (для сравнения)
    public void nonStaticMethod() {
        System.out.println("A.nonStaticMethod() - нестатический метод");
    }
}

class B extends A {
    // Это НЕ переопределение! Это сокрытие (hiding) статического метода
    public static void method() {
        System.out.println("B.method() - статический метод подкласса");
    }

    // Переопределение нестатического метода (работает)
    @Override
    public void nonStaticMethod() {
        System.out.println("B.nonStaticMethod() - переопределенный метод");
    }
}

class StaticPolymorphismExample {
    public static void main(String[] args) {

        System.out.println("========== СТАТИЧЕСКИЕ vs НЕСТАТИЧЕСКИЕ МЕТОДЫ ==========\n");

        // Прямые вызовы через классы
        System.out.println("--- Прямые вызовы ---");
        A.method();      // A.method()
        B.method();      // B.method()

        System.out.println("\n--- Полиморфный вызов (ссылка типа A, объект типа B) ---");
        A ref = new B();

        // Статический метод: вызывается метод КЛАССА ссылки (A), а не объекта (B)
        ref.method();    // Выводит: A.method()

        // Нестатический метод: вызывается метод ОБЪЕКТА (B) - полиморфизм работает
        ref.nonStaticMethod();  // Выводит: B.nonStaticMethod()

        System.out.println("\n========== ПОЧЕМУ ТАК ПРОИСХОДИТ? ==========\n");

        System.out.println("1. Статические методы связываются на ЭТАПЕ КОМПИЛЯЦИИ");
        System.out.println("   → Компилятор смотрит на ТИП ССЫЛКИ (A), а не на тип объекта");
        System.out.println("   → ref.method() заменяется на A.method()\n");

        System.out.println("2. Нестатические методы связываются на ЭТАПЕ ВЫПОЛНЕНИЯ");
        System.out.println("   → JVM смотрит на реальный ТИП ОБЪЕКТА (B)");
        System.out.println("   → Вызывается переопределенный метод\n");

        System.out.println("3. Ключевое слово @Override НЕ РАБОТАЕТ для static методов");
        System.out.println("   → Если попытаться использовать @Override, будет ошибка компиляции");
    }
}