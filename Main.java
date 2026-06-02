/**
 * Рефакторинг кода с использованием this()
 * this() - вызов другого конструктора того же класса
 */
class A {
    int a;
    int b;
    int c;
    int z;

    // Базовый конструктор (с минимальным количеством параметров)
    public A() {
        this(0, 0, 0);  // вызов конструктора с тремя параметрами
        System.out.println("A() -> вызван конструктор без параметров");
    }

    // Конструктор с одним параметром
    public A(int a) {
        this(a, 0, 0);  // вызов конструктора с тремя параметрами
        System.out.println("A(int a) -> вызван конструктор с a=" + a);
    }

    // Конструктор с двумя параметрами
    public A(int a, int b) {
        this(a, b, 0);  // вызов конструктора с тремя параметрами
        System.out.println("A(int a, int b) -> вызван конструктор с a=" + a + ", b=" + b);
    }

    // Конструктор с тремя параметрами (главный конструктор)
    public A(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.z = 1;  // общая инициализация для всех конструкторов
        System.out.println("A(int a, int b, int c) -> a=" + a + ", b=" + b + ", c=" + c + ", z=" + z);
    }

    public void print() {
        System.out.println("  a=" + a + ", b=" + b + ", c=" + c + ", z=" + z);
    }
}

/**
 * Альтернативный вариант с цепочкой this()
 */
class B {
    int a;
    int b;
    int c;
    int z;

    // Цепочка: A() -> A(int) -> A(int,int) -> A(int,int,int)

    public B() {
        this(0);  // вызов конструктора с одним параметром
        System.out.println("B()");
    }

    public B(int a) {
        this(a, 0);  // вызов конструктора с двумя параметрами
        System.out.println("B(int a)");
    }

    public B(int a, int b) {
        this(a, b, 0);  // вызов конструктора с тремя параметрами
        System.out.println("B(int a, int b)");
    }

    public B(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.z = 1;
        System.out.println("B(int a, int b, int c) - главный конструктор");
    }

    public void print() {
        System.out.println("  a=" + a + ", b=" + b + ", c=" + c + ", z=" + z);
    }
}

class ThisExample {
    public static void main(String[] args) {

        System.out.println("========== this() - вызов конструктора из конструктора ==========\n");

        System.out.println("--- Создание A() ---");
        A obj1 = new A();
        obj1.print();

        System.out.println("\n--- Создание A(10) ---");
        A obj2 = new A(10);
        obj2.print();

        System.out.println("\n--- Создание A(10, 20) ---");
        A obj3 = new A(10, 20);
        obj3.print();

        System.out.println("\n--- Создание A(10, 20, 30) ---");
        A obj4 = new A(10, 20, 30);
        obj4.print();

        System.out.println("\n========== Цепочка вызовов this() ==========");
        System.out.println("--- Создание B() ---");
        B objB1 = new B();
        objB1.print();
    }
}