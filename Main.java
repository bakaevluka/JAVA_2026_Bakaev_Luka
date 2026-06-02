import java.util.ArrayList;
import java.util.List;

class Animal {
    private String name;
    Animal(String name) { this.name = name; }
    public String getName() { return name; }
    public String toString() { return name; }
}

class Dog extends Animal {
    Dog(String name) { super(name); }
    public void bark() { System.out.println(getName() + " гавкает!"); }
}

class Cat extends Animal {
    Cat(String name) { super(name); }
    public void meow() { System.out.println(getName() + " мяукает!"); }
}

class Main {

    // ===== <? extends T> - Producer Extends =====
    // Позволяет ЧИТАТЬ объекты как тип T (или его подтипы)
    // НЕЛЬЗЯ добавлять элементы (кроме null)

    public static void printAnimals(List<? extends Animal> animals) {
        System.out.println("=== Список животных ===");
        for (Animal a : animals) {
            System.out.println("  - " + a.getName());
        }
        // animals.add(new Animal("Новое"));  //  ОШИБКА! нельзя добавить
        // animals.add(new Dog("Шарик"));    //  ОШИБКА! нельзя добавить
    }

    // ===== <? super T> - Consumer Super =====
    // Позволяет ДОБАВЛЯТЬ объекты типа T (или его подтипы)
    // При чтении гарантирован только тип Object

    public static void addDogs(List<? super Dog> dogs) {
        System.out.println("\n=== Добавляем собак ===");
        dogs.add(new Dog("Бобик"));
        dogs.add(new Dog("Шарик"));
        // dogs.add(new Animal("Животное")); // ОШИБКА! нельзя добавить Animal
        // Object obj = dogs.get(0);  // можно прочитать только как Object
    }

    // ===== PECS правило =====
    // Producer Extends - Consumer Super

    public static void main(String[] args) {

        System.out.println("========== <? extends T> - Чтение ==========\n");

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Рекс"));
        dogs.add(new Dog("Джек"));

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Мурка"));
        cats.add(new Cat("Барсик"));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Леопольд"));

        // Можно передавать List<Dog>, List<Cat>, List<Animal>
        printAnimals(dogs);
        printAnimals(cats);
        printAnimals(animals);

        System.out.println("\n========== <? super T> - Запись ==========\n");

        List<Animal> animalList = new ArrayList<>();
        addDogs(animalList);
        System.out.println("Список животных после добавления:");
        for (Animal a : animalList) {
            System.out.println("  - " + a.getName());
        }

        // <? super Dog> позволяет также List<Animal> и List<Object>
        List<Object> objectList = new ArrayList<>();
        addDogs(objectList);
        System.out.println("\nСписок Object после добавления:");
        for (Object o : objectList) {
            System.out.println("  - " + o);
        }

        System.out.println("\n========== PECS правило ==========");
        System.out.println("Producer (поставщик) -> используйте <? extends T> (читаем)");
        System.out.println("Consumer (потребитель) -> используйте <? super T> (пишем)");
    }
}