/**
 * Перечисление с инициализацией элементов
 */
enum Planet {
    // Элементы перечисления с параметрами конструктора
    MERCURY(3.30e23, 2.44e6),
    VENUS(4.87e24, 6.05e6),
    EARTH(5.97e24, 6.38e6),
    MARS(6.42e23, 3.40e6),
    JUPITER(1.90e27, 6.99e7),
    SATURN(5.68e26, 5.82e7),
    URANUS(8.68e25, 2.54e7),
    NEPTUNE(1.02e26, 2.46e7);

    // Поля
    private final double mass;      // масса в кг
    private final double radius;    // радиус в метрах

    // Конструктор (всегда private)
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    // Геттеры
    public double getMass() { return mass; }
    public double getRadius() { return radius; }

    // Метод для вычисления гравитации
    public double surfaceGravity() {
        double G = 6.67430e-11;  // гравитационная постоянная
        return G * mass / (radius * radius);
    }

    public double surfaceWeight(double weightOnEarth) {
        // Вес на этой планете относительно Земли
        return weightOnEarth * surfaceGravity() / EARTH.surfaceGravity();
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("========== Инициализация элементов перечисления ==========\n");

        for (Planet p : Planet.values()) {
            System.out.printf("%s: масса = %.2e кг, радиус = %.2e м, гравитация = %.2f м/с²%n",
                    p, p.getMass(), p.getRadius(), p.surfaceGravity());
        }

        System.out.println("\n========== Вес 100 кг на разных планетах ==========");
        for (Planet p : Planet.values()) {
            System.out.printf("Вес на %s: %.2f кг%n", p, p.surfaceWeight(100));
        }
    }
}