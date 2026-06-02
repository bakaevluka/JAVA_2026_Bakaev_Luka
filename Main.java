class Parent {
    protected String name = "Родитель";
    protected int value = 10;

    Parent() {
        System.out.println("Конструктор Parent");
    }

    Parent(String name) {
        this.name = name;
        System.out.println("Конструктор Parent с параметром: " + name);
    }

    void show() {
        System.out.println("Parent.show(): name = " + name);
    }

    void printValue() {
        System.out.println("Parent.printValue(): value = " + value);
    }
}

class Child extends Parent {
    private String name = "Ребенок";  // скрывает поле name из Parent
    private int value = 20;            // скрывает поле value из Parent

    Child() {
        // super() - вызов конструктора родителя (должен быть первой строкой)
        super();  // вызывает Parent()
        System.out.println("Конструктор Child");
    }

    Child(String name, int value) {
        // super(name) - вызов конструктора родителя с параметром
        super(name);  // вызывает Parent(String name)
        this.value = value;
        System.out.println("Конструктор Child с параметрами");
    }

    void demonstrateThisAndSuper() {
        System.out.println("\n========== this vs super ==========");

        // this - обращение к полям/методам текущего класса
        System.out.println("this.name = " + this.name);     // "Ребенок"
        System.out.println("this.value = " + this.value);   // 20

        // super - обращение к полям/методам родительского класса
        System.out.println("super.name = " + super.name);   // "Родитель"
        System.out.println("super.value = " + super.value); // 10

        // this.show() - вызывает переопределенный метод в Child
        this.show();

        // super.show() - вызывает метод из Parent
        super.show();

        // super.printValue() - вызов метода родителя
        super.printValue();
    }

    @Override
    void show() {
        System.out.println("Child.show(): this.name = " + this.name + ", super.name = " + super.name);
    }

    void callParentMethod() {
        System.out.println("\n========== Вызов методов родителя ==========");
        // Вызов переопределенного метода из родителя
        super.printValue();

        // Нельзя вызвать private метод родителя из подкласса
        // super.privateMethod();  //  ОШИБКА!
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("========== Демонстрация this и super ==========");

        Child child1 = new Child();
        child1.demonstrateThisAndSuper();

        System.out.println("\n========== Конструктор с параметрами ==========");
        Child child2 = new Child("Новое имя", 99);
        child2.demonstrateThisAndSuper();

        child1.callParentMethod();
    }
}