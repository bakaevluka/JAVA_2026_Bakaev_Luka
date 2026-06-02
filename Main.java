/**
 * Демонстрация: final-метод нельзя переопределить в подклассе
 */
class Parent {

    // Обычный метод - можно переопределить
    public void regularMethod() {
        System.out.println("Parent.regularMethod() - обычный метод");
    }

    // final-метод - НЕЛЬЗЯ переопределить
    public final void finalMethod() {
        System.out.println("Parent.finalMethod() - final метод, нельзя переопределить");
    }

    // final-метод с private - фактически не наследуется
    private final void privateFinalMethod() {
        System.out.println("Parent.privateFinalMethod() - private final");
    }

    public void callPrivateFinalMethod() {
        privateFinalMethod();  // можно вызвать внутри класса
    }
}

class Child extends Parent {

    // ✅ РАБОТАЕТ: переопределение обычного метода
    @Override
    public void regularMethod() {
        System.out.println("Child.regularMethod() - переопределенный метод");
    }

    // ❌ ОШИБКА: нельзя переопределить final-метод
    // @Override
    // public void finalMethod() {
    //     System.out.println("Попытка переопределить final-метод");
    // }

    // Это не переопределение, а новый метод (не связано с Parent.privateFinalMethod)
    // private final void privateFinalMethod() { }  // Это новый метод класса Child
}

class FinalMethodExample {
    public static void main(String[] args) {
        System.out.println("========== final-метод нельзя переопределить ==========\n");

        Parent parent = new Parent();
        Child child = new Child();

        System.out.println("--- Вызов методов Parent ---");
        parent.regularMethod();
        parent.finalMethod();

        System.out.println("\n--- Вызов методов Child ---");
        child.regularMethod();   // переопределенный метод
        child.finalMethod();     // вызывается метод из Parent (не переопределен)

        System.out.println("\n========== Попытка переопределения final-метода ==========");
        System.out.println("Если раскомментировать метод finalMethod() в Child,");
        System.out.println("компилятор выдаст ошибку:");
        System.out.println("'finalMethod()' cannot override 'finalMethod()' in 'Parent'");
        System.out.println("overridden method is final");
    }
}