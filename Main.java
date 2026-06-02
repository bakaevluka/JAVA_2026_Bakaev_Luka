interface Vehicle {

    // Абстрактный метод (должен быть реализован в классе)
    void move();

    // Default метод (неабстрактный) - имеет реализацию по умолчанию
    default void honk() {
        System.out.println("Vehicle: Бип-бип!");
    }

    // Static метод - принадлежит интерфейсу
    static void description() {
        System.out.println("Vehicle interface - represents any vehicle");
    }
}

/**
 * Класс, реализующий интерфейс Vehicle
 */
class Car implements Vehicle {

    // Обязательно реализуем абстрактный метод
    @Override
    public void move() {
        System.out.println("Car: Едет по дороге");
    }

    // Опционально переопределяем default метод
    @Override
    public void honk() {
        System.out.println("Car: Бип-бип! Машина сигналит");
    }
}

/**
 * Другой класс, который НЕ переопределяет default метод
 */
class Bicycle implements Vehicle {

    @Override
    public void move() {
        System.out.println("Bicycle: Едет по велодорожке");
    }

    // НЕ переопределяем honk() - используется реализация по умолчанию
}

/**
 * Демонстрация всех способов вызова
 */
class DefaultStaticMethodsExample {
    public static void main(String[] args) {

        System.out.println("========== ВЫЗОВ STATIC МЕТОДА ==========");
        // Static метод вызывается через имя интерфейса
        Vehicle.description();

        System.out.println("\n========== ВЫЗОВ МЕТОДОВ ЧЕРЕЗ ОБЪЕКТ CAR ==========");
        Car car = new Car();
        car.move();      // переопределенный абстрактный метод
        car.honk();      // переопределенный default метод

        System.out.println("\n========== ВЫЗОВ МЕТОДОВ ЧЕРЕЗ ОБЪЕКТ BICYCLE ==========");
        Bicycle bike = new Bicycle();
        bike.move();     // переопределенный абстрактный метод
        bike.honk();     // default метод (НЕ переопределен - используется реализация из интерфейса)

        System.out.println("\n========== ВЫЗОВ ЧЕРЕЗ ССЫЛКУ ТИПА ИНТЕРФЕЙСА ==========");
        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Bicycle();

        vehicle1.move();
        vehicle1.honk();

        vehicle2.move();
        vehicle2.honk();

        System.out.println("\n========== СПОСОБЫ ВЫЗОВА ==========");
        System.out.println("1. Static метод: Vehicle.description()");
        System.out.println("2. Абстрактный метод: объект.move()");
        System.out.println("3. Default метод: объект.honk() (может быть переопределен)");
    }
}