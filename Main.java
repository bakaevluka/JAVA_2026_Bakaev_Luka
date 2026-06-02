/**
 * Перечисление уровней логирования с дополнительными методами
 */
enum LogLevel {
    // Элементы перечисления с инициализацией
    DEBUG(1, "Отладка", ConsoleColor.CYAN),
    INFO(2, "Информация", ConsoleColor.GREEN),
    WARNING(3, "Предупреждение", ConsoleColor.YELLOW),
    ERROR(4, "Ошибка", ConsoleColor.RED),
    FATAL(5, "Фатальная ошибка", ConsoleColor.RED_BRIGHT);

    // Поля
    private final int level;
    private final String description;
    private final ConsoleColor color;

    // Конструктор
    LogLevel(int level, String description, ConsoleColor color) {
        this.level = level;
        this.description = description;
        this.color = color;
    }

    // Геттеры
    public int getLevel() { return level; }
    public String getDescription() { return description; }
    public ConsoleColor getColor() { return color; }

    // Дополнительные методы
    public boolean isHigherThan(LogLevel other) {
        return this.level > other.level;
    }

    public boolean isLowerThan(LogLevel other) {
        return this.level < other.level;
    }

    public void print(String message) {
        System.out.println(color.getCode() + "[" + description + "] " + message + ConsoleColor.RESET);
    }

    // Статический метод для получения по строке
    public static LogLevel fromString(String text) {
        for (LogLevel level : LogLevel.values()) {
            if (level.name().equalsIgnoreCase(text)) {
                return level;
            }
        }
        return INFO; // значение по умолчанию
    }
}

/**
 * Вспомогательный класс для цветов консоли
 */
enum ConsoleColor {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    CYAN("\u001B[36m"),
    RED_BRIGHT("\u001B[91m");

    private final String code;

    ConsoleColor(String code) {
        this.code = code;
    }

    public String getCode() { return code; }
}

/**
 * Перечисление для времен года
 */
enum Season {
    // Элементы перечисления с инициализацией
    SPRING("Весна", "Тепло, цветут цветы", 15),
    SUMMER("Лето", "Жарко, можно купаться", 25),
    AUTUMN("Осень", "Прохладно, листопад", 10),
    WINTER("Зима", "Холодно, снег", -5);

    private final String russianName;
    private final String description;
    private final double averageTemp;

    Season(String russianName, String description, double averageTemp) {
        this.russianName = russianName;
        this.description = description;
        this.averageTemp = averageTemp;
    }

    public String getRussianName() { return russianName; }
    public String getDescription() { return description; }
    public double getAverageTemp() { return averageTemp; }

    // Дополнительный метод: следующий сезон
    public Season next() {
        Season[] seasons = values();
        return seasons[(this.ordinal() + 1) % seasons.length];
    }

    // Дополнительный метод: предыдущий сезон
    public Season prev() {
        Season[] seasons = values();
        return seasons[(this.ordinal() - 1 + seasons.length) % seasons.length];
    }

    // Дополнительный метод: информация о сезоне
    public void printInfo() {
        System.out.printf("%s (%s): %s, средняя температура: %.1f°C%n",
                russianName, name(), description, averageTemp);
    }
}

/**
 * Главный класс для демонстрации
 */
class EnumExample {
    public static void main(String[] args) {

        System.out.println("========== LogLevel (с цветами) ==========\n");

        LogLevel.DEBUG.print("Переменная x = 10");
        LogLevel.INFO.print("Приложение запущено");
        LogLevel.WARNING.print("Низкая память");
        LogLevel.ERROR.print("Не удалось открыть файл");
        LogLevel.FATAL.print("Критическая ошибка");

        System.out.println("\n========== Сравнение уровней логирования ==========");

        LogLevel current = LogLevel.WARNING;
        System.out.println("Текущий уровень: " + current.getDescription());
        System.out.println("ERROR выше WARNING? " + LogLevel.ERROR.isHigherThan(current));
        System.out.println("INFO ниже WARNING? " + LogLevel.INFO.isLowerThan(current));

        System.out.println("\n========== Season ==========\n");

        for (Season s : Season.values()) {
            s.printInfo();
        }

        System.out.println("\n========== Навигация по сезонам ==========");
        Season summer = Season.SUMMER;
        System.out.println("Текущий: " + summer.getRussianName());
        System.out.println("Следующий: " + summer.next().getRussianName());
        System.out.println("Предыдущий: " + summer.prev().getRussianName());

        System.out.println("\n========== Использование в switch ==========");
        Season currentSeason = Season.WINTER;

        switch (currentSeason) {
            case SPRING:
                System.out.println("Пора сажать растения!");
                break;
            case SUMMER:
                System.out.println("Пора в отпуск!");
                break;
            case AUTUMN:
                System.out.println("Пора собирать урожай!");
                break;
            case WINTER:
                System.out.println("Пора отдыхать у камина!");
                break;
        }

        System.out.println("\n========== Статический метод fromString() ==========");
        LogLevel level = LogLevel.fromString("ERROR");
        level.print("Получен через fromString");
    }
}