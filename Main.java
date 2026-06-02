/**
 * Пример перегрузки методов (overloading)
 */
class Calculator {

    // Перегрузка: методы с одинаковым именем, но разными параметрами

    public int sum(int a) {
        return a;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public String sum(String a, int b) {
        return a + b;
    }
}

/**
 * Базовый класс для демонстрации переопределения
 */
class Animal {

    protected String name = "Животное";

    // Метод, который будет переопределен
    public void makeSound() {
        System.out.println(name + " издает звук");
    }
}

/**
 * Подкласс Dog - переопределяет метод makeSound()
 */
class Dog extends Animal {

    public Dog() {
        name = "Собака";
    }

    @Override
    public void makeSound() {
        System.out.println(name + " гавкает: Гав-гав!");
    }
}

/**
 * Подкласс Cat - переопределяет метод makeSound()
 */
class Cat extends Animal {

    public Cat() {
        name = "Кошка";
    }

    @Override
    public void makeSound() {
        System.out.println(name + " мяукает: Мяу-мяу!");
    }
}

/**
 * Главный класс с демонстрацией
 */
class OverloadingOverrideExample {

    public static void main(String[] args) {

        System.out.println("========== ПЕРЕГРУЗКА (OVERLOADING) ==========\n");

        Calculator calc = new Calculator();

        System.out.println("sum(5) = " + calc.sum(5));
        System.out.println("sum(5, 10) = " + calc.sum(5, 10));
        System.out.println("sum(5, 10, 15) = " + calc.sum(5, 10, 15));
        System.out.println("sum(2.5, 3.7) = " + calc.sum(2.5, 3.7));
        System.out.println("sum(\"Число: \", 42) = " + calc.sum("Число: ", 42));

        System.out.println("\n========== ПЕРЕОПРЕДЕЛЕНИЕ (OVERRIDE) ==========\n");

        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        animal.makeSound();
        dog.makeSound();
        cat.makeSound();

        System.out.println("\n========== ПОЛИМОРФИЗМ ==========\n");

        Animal[] animals = {new Animal(), new Dog(), new Cat()};
        for (Animal a : animals) {
            a.makeSound();
        }
    }
}