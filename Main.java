/**
 * Если переменная a и метод method() не определены в классе B,
 * а определены только в классе A, то:
 * - super.a обращается к полю из A
 * - super.method() вызывает метод из A
 */
class A {
    int a = 10;

    void method() {
        System.out.println("A.method(): a = " + a);
    }
}

class B extends A {
    // В классе B НЕТ переменной a и НЕТ метода method()
    // Они наследуются от A
}

class C extends B {
    int a = 100;  // переопределение (скрытие) поля a из A

    void method() {
        System.out.println("\n=== Вызов из C.method() ===");

        // super.a - обращается к полю из A (через цепочку B → A)
        System.out.println("super.a = " + super.a);  // 10 (из класса A)

        // super.method() - вызывает метод из A (через цепочку B → A)
        super.method();

        // this.a - обращается к полю из C
        System.out.println("this.a = " + this.a);    // 100 (из класса C)

        // Если бы a не было в C, this.a вернул бы значение из A
    }
}

class SuperCallExample {
    public static void main(String[] args) {
        System.out.println("========== super в цепочке наследования A → B → C ==========");
        System.out.println("Класс A: a = 10, method() выводит a");
        System.out.println("Класс B: пустой (наследует от A)");
        System.out.println("Класс C: a = 100, переопределяет method()\n");

        C obj = new C();
        obj.method();

        System.out.println("\n========== Важное замечание ==========");
        System.out.println("super в классе C обращается к полям и методам");
        System.out.println("ближайшего суперкласса, в котором они определены.");
        System.out.println("Если в B нет a и method(), super идет дальше — в A.");
    }
}