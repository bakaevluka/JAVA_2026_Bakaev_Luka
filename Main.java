/**
 * Демонстрация трех вариантов использования ключевого слова super
 */
class Parent {
    protected String name = "Родитель";
    protected int value = 100;

    // Конструктор без параметров
    Parent() {
        System.out.println("Parent() - конструктор без параметров");
    }

    // Конструктор с параметром
    Parent(String name) {
        this.name = name;
        System.out.println("Parent(String name) - конструктор с параметром: " + name);
    }

    // Метод для демонстрации
    void display() {
        System.out.println("Parent.display(): name = " + name + ", value = " + value);
    }

    void someMethod() {
        System.out.println("Parent.someMethod() - метод суперкласса");
    }
}

class Child extends Parent {
    private String name = "Ребенок";
    private int value = 200;

    // 1. Использование super() - вызов конструктора суперкласса
    Child() {
        super();  // вызывает Parent()
        System.out.println("Child() - конструктор без параметров");
    }

    Child(String name) {
        super(name);  // вызывает Parent(String name)
        System.out.println("Child(String name) - конструктор с параметром: " + name);
    }

    Child(String name, int value) {
        super(name);  // вызов конструктора суперкласса
        this.value = value;
        System.out.println("Child(String name, int value) - name=" + name + ", value=" + value);
    }

    void demonstrateSuper() {
        System.out.println("\n========== Демонстрация super ==========");

        // 2. super.поле - доступ к полю суперкласса
        System.out.println("this.name = " + this.name);    // "Ребенок"
        System.out.println("super.name = " + super.name);  // "Родитель" (или переданное значение)

        System.out.println("this.value = " + this.value);  // 200
        System.out.println("super.value = " + super.value); // 100

        // 3. super.метод() - доступ к методу суперкласса
        System.out.println("\n--- Вызов метода через this ---");
        this.display();

        System.out.println("\n--- Вызов метода через super ---");
        super.display();

        System.out.println("\n--- Вызов otherMethod ---");
        super.someMethod();
    }

    @Override
    void display() {
        System.out.println("Child.display(): this.name = " + this.name + ", super.name = " + super.name);
    }
}

class SuperExample {
    public static void main(String[] args) {

        System.out.println("========== 1. super() - вызов конструктора суперкласса ==========\n");

        System.out.println("--- Создание Child() ---");
        Child child1 = new Child();

        System.out.println("\n--- Создание Child(\"Новое имя\") ---");
        Child child2 = new Child("Новое имя");

        System.out.println("\n--- Создание Child(\"Имя\", 500) ---");
        Child child3 = new Child("Имя", 500);

        System.out.println("\n========== 2. super.поле - доступ к полю суперкласса ==========");
        child1.demonstrateSuper();

        System.out.println("\n========== 3. super.метод() - доступ к методу суперкласса ==========");
        child3.demonstrateSuper();
    }
}