class A {

    public final int a;  // константа, нужно инициализировать

    // СПОСОБ 1: Инициализация при объявлении
    // public final int a = 100;

    // СПОСОБ 2: Инициализация в блоке инициализации
    // {
    //     a = 100;
    // }

    // СПОСОБ 3: Инициализация в конструкторе
    public A() {
        a = 100;  // константе присваивается значение 100
    }

    // СПОСОБ 4: Инициализация через параметр конструктора
    public A(int value) {
        a = value;  // константе присваивается переданное значение
    }

    public static void main(String[] args) {
        System.out.println("========== Инициализация final поля ==========\n");

        // Использование конструктора без параметров
        A obj1 = new A();
        System.out.println("new A() → a = " + obj1.a);

        // Использование конструктора с параметром
        A obj2 = new A(555);
        System.out.println("new A(555) → a = " + obj2.a);

        A obj3 = new A(999);
        System.out.println("new A(999) → a = " + obj3.a);

        // Демонстрация того, что изменить final поле нельзя
        // obj1.a = 200;  // ❌ ОШИБКА компиляции: cannot assign a value to final variable

        System.out.println("\n========== ВЫВОД ==========");
        System.out.println("final-поле a может быть инициализировано:");
        System.out.println("1. При объявлении: public final int a = 10;");
        System.out.println("2. В блоке инициализации: { a = 10; }");
        System.out.println("3. В конструкторе: public A() { a = 10; }");
        System.out.println("4. Через параметр конструктора: public A(int val) { a = val; }");
    }
}