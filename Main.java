/**
 * Демонстрация вложения класса в интерфейс
 */

// Интерфейс может содержать вложенный класс
interface Calculator {

    // Константа интерфейса
    double PI = 3.14159;

    // Абстрактный метод интерфейса
    double calculate(double a, double b);

    /**
     * Вложенный класс внутри интерфейса
     * (по умолчанию является public static)
     */
    class BasicCalculator {

        public double add(double a, double b) {
            return a + b;
        }

        public double subtract(double a, double b) {
            return a - b;
        }

        public double multiply(double a, double b) {
            return a * b;
        }

        public double divide(double a, double b) {
            if (b != 0) {
                return a / b;
            }
            throw new ArithmeticException("Деление на ноль");
        }

        public void showPi() {
            System.out.println("Значение PI из интерфейса: " + PI);
        }
    }

    // Вложенный класс с утилитными методами
    class Utils {
        public static void log(String message) {
            System.out.println("[LOG] " + message);
        }

        public boolean isPositive(double value) {
            return value > 0;
        }

        public double round(double value, int decimals) {
            double factor = Math.pow(10, decimals);
            return Math.round(value * factor) / factor;
        }
    }
}

/**
 * Интерфейс с вложенным классом-билдером
 */
interface MessageBuilder {

    // Вложенный класс для создания сообщений
    class Builder {
        private String header;
        private String body;
        private String footer;

        public Builder setHeader(String header) {
            this.header = header;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setFooter(String footer) {
            this.footer = footer;
            return this;
        }

        public String build() {
            StringBuilder sb = new StringBuilder();
            if (header != null) sb.append(header).append("\n");
            if (body != null) sb.append(body).append("\n");
            if (footer != null) sb.append(footer).append("\n");
            return sb.toString().trim();
        }
    }
}

/**
 * Интерфейс с вложенным классом-исключением
 */
interface DataValidator {

    // Вложенный класс-исключение
    class ValidationException extends Exception {
        private final int errorCode;

        public ValidationException(String message, int errorCode) {
            super(message);
            this.errorCode = errorCode;
        }

        public int getErrorCode() {
            return errorCode;
        }
    }

    void validate(String data) throws ValidationException;
}

/**
 * Демонстрация работы
 */
class NestedClassInInterfaceExample {

    public static void main(String[] args) {

        System.out.println("========== 1. Вложенный класс в интерфейсе Calculator ==========\n");

        // Создание экземпляра вложенного класса
        // Синтаксис: Интерфейс.ВложенныйКласс объект = new Интерфейс.ВложенныйКласс()
        Calculator.BasicCalculator calc = new Calculator.BasicCalculator();

        System.out.println("10 + 5 = " + calc.add(10, 5));
        System.out.println("10 - 5 = " + calc.subtract(10, 5));
        System.out.println("10 * 5 = " + calc.multiply(10, 5));
        System.out.println("10 / 5 = " + calc.divide(10, 5));
        calc.showPi();

        System.out.println("\n========== 2. Вложенный класс Utils ==========");

        Calculator.Utils utils = new Calculator.Utils();
        Calculator.Utils.log("Программа запущена");
        System.out.println("isPositive(-5) = " + utils.isPositive(-5));
        System.out.println("round(3.14159, 2) = " + utils.round(3.14159, 2));

        System.out.println("\n========== 3. Вложенный класс Builder в интерфейсе ==========");

        MessageBuilder.Builder builder = new MessageBuilder.Builder();
        String message = builder
                .setHeader("=== СООБЩЕНИЕ ===")
                .setBody("Текст сообщения")
                .setFooter("=== КОНЕЦ ===")
                .build();

        System.out.println("Построенное сообщение:");
        System.out.println(message);

        System.out.println("\n========== 4. Вложенный класс-исключение ==========");

        DataValidator validator = new DataValidator() {
            @Override
            public void validate(String data) throws ValidationException {
                if (data == null || data.isEmpty()) {
                    throw new ValidationException("Данные не могут быть пустыми", 1001);
                }
                if (data.length() < 3) {
                    throw new ValidationException("Данные слишком короткие", 1002);
                }
                System.out.println("Данные валидны: " + data);
            }
        };

        try {
            validator.validate("Hello");
            validator.validate("");
        } catch (DataValidator.ValidationException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
            System.out.println("Код ошибки: " + e.getErrorCode());
        }

        System.out.println("\n========== 5. Различные способы вызова ==========");

        // Способ 1: Прямое создание
        Calculator.BasicCalculator calc1 = new Calculator.BasicCalculator();

        // Способ 2: Через переменную интерфейса (невозможно, так как класс статический)
        // Calculator calc2 = new Calculator.BasicCalculator(); // ❌ ОШИБКА!

        // Способ 3: Статический импорт (только для статических методов)
        Calculator.BasicCalculator calc3 = new Calculator.BasicCalculator();

        System.out.println("Способ 1: " + calc1.add(5, 3));
        System.out.println("Способ 3: " + calc3.add(5, 3));

        System.out.println("\n========== ВАЖНЫЕ ЗАМЕЧАНИЯ ==========");
        System.out.println("1. Вложенный класс в интерфейсе неявно является public static");
        System.out.println("2. Создается через new Интерфейс.Класс()");
        System.out.println("3. Может иметь свои поля, методы, конструкторы");
        System.out.println("4. Может быть объявлен с модификаторами public, private, protected");
        System.out.println("5. Имеет доступ к статическим константам интерфейса");
    }
}