class InstanceofExample {

    // базовый класс
    static class Animal {
        String name = "Животное";
    }

    // подкласс - наследует Animal
    static class Dog extends Animal {
        String breed = "Собака";
    }

    // другой подкласс
    static class Cat extends Animal {
        String type = "Кошка";
    }

    public static void main(String[] args) {

        System.out.println("========== 1. Базовое использование instanceof ==========");

        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        // объект является экземпляром своего класса
        System.out.println("animal instanceof Animal: " + (animal instanceof Animal));
        System.out.println("dog instanceof Dog: " + (dog instanceof Dog));
        System.out.println("cat instanceof Cat: " + (cat instanceof Cat));

        // объект подкласса является экземпляром родительского класса
        System.out.println("dog instanceof Animal: " + (dog instanceof Animal));
        System.out.println("cat instanceof Animal: " + (cat instanceof Animal));

        // объект родительского класса НЕ является экземпляром подкласса
        System.out.println("animal instanceof Dog: " + (animal instanceof Dog));
        System.out.println("animal instanceof Cat: " + (animal instanceof Cat));

        // ПРОВЕРКА НА НЕСОВМЕСТИМЫЕ ТИПЫ - используем Object для обхода
        System.out.println("\n--- Проверка несовместимых типов ---");
        System.out.println("dog instanceof Cat: " + ((Object)dog instanceof Cat));
        System.out.println("cat instanceof Dog: " + ((Object)cat instanceof Dog));

        System.out.println("\n========== 2. instanceof с null-объектом ==========");

        Animal nullAnimal = null;

        // instanceof с null ВСЕГДА возвращает false
        System.out.println("null instanceof Animal: " + (nullAnimal instanceof Animal));
        System.out.println("null instanceof Dog: " + (nullAnimal instanceof Dog));
        System.out.println("null instanceof Cat: " + (nullAnimal instanceof Cat));
        // для проверки с несвязанным типом используем Object
        System.out.println("null instanceof String: " + ((Object)nullAnimal instanceof String));

        System.out.println("\n========== 3. instanceof с массивами ==========");

        String[] stringArray = new String[5];
        int[] intArray = new int[3];

        System.out.println("stringArray instanceof Object: " + (stringArray instanceof Object));
        System.out.println("stringArray instanceof String[]: " + (stringArray instanceof String[]));
        System.out.println("intArray instanceof int[]: " + (intArray instanceof int[]));
        System.out.println("intArray instanceof Object: " + (intArray instanceof Object));

        System.out.println("\n========== 4. instanceof с интерфейсами ==========");

        String text = "Hello Java";
        System.out.println("text instanceof String: " + (text instanceof String));
        System.out.println("text instanceof CharSequence: " + (text instanceof CharSequence));
        System.out.println("text instanceof Comparable: " + (text instanceof Comparable));

        System.out.println("\n========== 5. Безопасное приведение типов ==========");

        Animal myPet = new Dog();

        // сначала проверяем, потом приводим
        if (myPet instanceof Dog) {
            Dog myDog = (Dog) myPet;
            System.out.println("myPet является Dog: " + myDog.breed);
        } else {
            System.out.println("myPet не является Dog");
        }

        if (myPet instanceof Cat) {
            System.out.println("Это не выведется");
        } else {
            System.out.println("myPet не является Cat (это Dog)");
        }

        System.out.println("\n========== 6. Pattern Matching (Java 16+, пропускаем если старая версия) ==========");

        Object obj = "Привет, Лука!";

        // старый способ (работает везде)
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("Длина строки: " + str.length());
        }
    }
}