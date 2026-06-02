/**
 * Переопределение метода - метод подкласса заменяет метод суперкласса
 */
class Animal {

    public String makeSound() {
        return "Животное издает звук";
    }

    // Метод, который будет переопределен
    public Animal getSelf() {
        System.out.println("Animal.getSelf()");
        return this;
    }
}

class Dog extends Animal {

    @Override
    public String makeSound() {
        return "Собака гавкает: Гав-гав!";
    }

    @Override
    public Dog getSelf() {  // ковариантный возвращаемый тип (Dog вместо Animal)
        System.out.println("Dog.getSelf()");
        return this;
    }
}

class Cat extends Animal {

    @Override
    public String makeSound() {
        return "Кошка мяукает: Мяу-мяу!";
    }
}

/**
 * ❌ НЕПРАВИЛЬНО: если не совпадает тип возвращаемого значения
 * (раскомментируйте, чтобы увидеть ошибку)
 */
/*
class WrongDog extends Animal {
    @Override
    public int makeSound() {  // ❌ ОШИБКА! String != int
        return 0;
    }
}
*/

class OverrideExample {
    public static void main(String[] args) {

        System.out.println("========== ПЕРЕОПРЕДЕЛЕННЫЕ МЕТОДЫ ==========\n");

        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        System.out.println("animal.makeSound(): " + animal.makeSound());
        System.out.println("dog.makeSound(): " + dog.makeSound());
        System.out.println("cat.makeSound(): " + cat.makeSound());

        System.out.println("\n========== ПОЛИМОРФИЗМ ==========");

        // Динамическое связывание - выбор метода по типу ОБЪЕКТА, а не ссылки
        Animal[] animals = {new Animal(), new Dog(), new Cat()};

        for (Animal a : animals) {
            System.out.println(a.makeSound());
        }

        System.out.println("\n========== КОВАРИАНТНЫЙ ВОЗВРАЩАЕМЫЙ ТИП ==========");

        Animal ref = new Dog();
        Dog dogRef = dog.getSelf();     // возвращает Dog
        Animal animalRef = ref.getSelf(); // возвращает Dog (но ссылка Animal)

        System.out.println("dog.getSelf() возвращает: " + dogRef.getClass().getSimpleName());
        System.out.println("ref.getSelf() возвращает: " + animalRef.getClass().getSimpleName());
    }
}
