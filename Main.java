/**
 * Пример собственного класса исключения
 * По договоренности название должно заканчиваться на "Exception"
 */
class InvalidAgeException extends Exception {

    // 1. Конструктор без параметров
    public InvalidAgeException() {
        super("Недопустимый возраст");
    }

    // 2. Конструктор с сообщением (наиболее часто используемый)
    public InvalidAgeException(String message) {
        super(message);
    }

    // 3. Конструктор с сообщением и причиной (cause)
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    // Дополнительный: конструктор только с причиной
    public InvalidAgeException(Throwable cause) {
        super(cause);
    }
}

/**
 * Еще один пример - исключение для банковских операций
 */
class InsufficientFundsException extends Exception {

    private double amount;  // дополнительное поле для хранения недостающей суммы

    public InsufficientFundsException() {
        super("Недостаточно средств");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException(String message, double amount) {
        super(message);
        this.amount = amount;
    }

    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientFundsException(Throwable cause) {
        super(cause);
    }

    public double getAmount() {
        return amount;
    }
}

/**
 * Пример проверяемого исключения для валидации email
 */
class InvalidEmailException extends Exception {

    private String invalidEmail;

    public InvalidEmailException() {
        super("Некорректный email адрес");
    }

    public InvalidEmailException(String message) {
        super(message);
    }

    public InvalidEmailException(String message, String invalidEmail) {
        super(message);
        this.invalidEmail = invalidEmail;
    }

    public InvalidEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEmailException(Throwable cause) {
        super(cause);
    }

    public String getInvalidEmail() {
        return invalidEmail;
    }
}

/**
 * Демонстрация использования собственных исключений
 */
class CustomExceptionExample {

    // Метод, выбрасывающий InvalidAgeException
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Возраст не может быть отрицательным: " + age);
        }
        if (age > 150) {
            throw new InvalidAgeException("Возраст не может превышать 150 лет: " + age);
        }
        System.out.println("Возраст " + age + " корректен");
    }

    // Метод, выбрасывающий InsufficientFundsException
    public static void withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double needed = amount - balance;
            throw new InsufficientFundsException("Недостаточно средств. Не хватает: " + needed, needed);
        }
        System.out.println("Снято: " + amount + ", остаток: " + (balance - amount));
    }

    // Метод, выбрасывающий InvalidEmailException
    public static void validateEmail(String email) throws InvalidEmailException {
        if (email == null || email.isEmpty()) {
            throw new InvalidEmailException("Email не может быть пустым");
        }
        if (!email.contains("@")) {
            throw new InvalidEmailException("Email должен содержать символ @", email);
        }
        if (email.indexOf('@') == 0) {
            throw new InvalidEmailException("Email не может начинаться с @", email);
        }
        System.out.println("Email " + email + " корректен");
    }

    public static void main(String[] args) {

        System.out.println("========== СОБСТВЕННЫЕ ИСКЛЮЧЕНИЯ ==========\n");

        // ===== Демонстрация InvalidAgeException =====
        System.out.println("--- 1. InvalidAgeException ---");

        int[] ages = {25, -5, 200};

        for (int age : ages) {
            try {
                System.out.print("Проверка возраста " + age + ": ");
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Исключение: " + e.getMessage());
            }
        }

        // ===== Демонстрация InsufficientFundsException =====
        System.out.println("\n--- 2. InsufficientFundsException ---");

        double balance = 1000;
        double[] withdrawals = {500, 1500, 300};

        for (double amount : withdrawals) {
            try {
                System.out.print("Снятие " + amount + " руб. со счета " + balance + " руб.: ");
                withdraw(balance, amount);
                balance -= amount;  // обновляем баланс только при успешном снятии
            } catch (InsufficientFundsException e) {
                System.out.println("Исключение: " + e.getMessage());
                System.out.println("   Недостающая сумма: " + e.getAmount() + " руб.");
            }
        }

        // ===== Демонстрация InvalidEmailException =====
        System.out.println("\n--- 3. InvalidEmailException ---");

        String[] emails = {"user@example.com", "", "usermail.com", "@example.com"};

        for (String email : emails) {
            try {
                System.out.print("Проверка email '" + email + "': ");
                validateEmail(email);
            } catch (InvalidEmailException e) {
                System.out.println("Исключение: " + e.getMessage());
                if (e.getInvalidEmail() != null) {
                    System.out.println("   Некорректный email: " + e.getInvalidEmail());
                }
            }
        }

        System.out.println("\n========== ОСНОВНЫЕ ПРАВИЛА ==========");
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│ 1. Класс исключения должен наследоваться от Exception           │");
        System.out.println("│ 2. Название должно заканчиваться на 'Exception'                 │");
        System.out.println("│ 3. Рекомендуется определять минимум 3 конструктора:             │");
        System.out.println("│    - без параметров                                             │");
        System.out.println("│    - с сообщением (String)                                      │");
        System.out.println("│    - с сообщением и причиной (String, Throwable)                │");
        System.out.println("│ 4. Можно добавлять свои поля (например, недостающую сумму)      │");
        System.out.println("└─────────────────────────────────────────────────────────────────┘");
    }
}