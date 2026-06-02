import java.io.*;

/**
 * Демонстрация интерфейса AutoCloseable и try-with-resources
 */
class AutoCloseableExample {

    // Собственный класс, реализующий AutoCloseable
    static class CustomResource implements AutoCloseable {
        private String name;

        public CustomResource(String name) {
            this.name = name;
            System.out.println("Ресурс '" + name + "' создан");
        }

        public void doWork() {
            System.out.println("Ресурс '" + name + "' выполняет работу");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Ресурс '" + name + "' закрыт (AutoCloseable)");
        }
    }

    // Класс для демонстрации важности закрытия ресурсов
    static class DatabaseConnection implements AutoCloseable {
        private String connectionId;

        public DatabaseConnection(String id) {
            this.connectionId = id;
            System.out.println("  🔌 Соединение " + connectionId + " открыто");
        }

        public void query(String sql) {
            System.out.println("  📊 Выполнен запрос: " + sql);
        }

        @Override
        public void close() {
            System.out.println("  🔒 Соединение " + connectionId + " закрыто");
        }
    }

    public static void main(String[] args) {

        System.out.println("========== ИНТЕРФЕЙС AutoCloseable ==========\n");

        System.out.println("Что такое AutoCloseable?");
        System.out.println("  • Интерфейс, гарантирующий закрытие ресурса");
        System.out.println("  • Содержит один метод: void close() throws Exception");
        System.out.println("  • Позволяет использовать try-with-resources\n");

        // ===== 1. try-with-resources (автоматическое закрытие) =====
        System.out.println("--- 1. try-with-resources (автоматическое закрытие) ---");

        try (CustomResource resource = new CustomResource("Ресурс1")) {
            resource.doWork();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // ===== 2. Несколько ресурсов в try-with-resources =====
        System.out.println("\n--- 2. Несколько ресурсов в try-with-resources ---");

        try (CustomResource r1 = new CustomResource("РесурсA");
             CustomResource r2 = new CustomResource("РесурсB");
             CustomResource r3 = new CustomResource("РесурсC")) {

            r1.doWork();
            r2.doWork();
            r3.doWork();

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // ===== 3. ПРОБЛЕМА: без AutoCloseable (ресурс не закрывается) =====
        System.out.println("\n--- 3. ПРОБЛЕМА: без AutoCloseable ---");

        class BadResource {
            public BadResource() {
                System.out.println("  ❌ Ресурс создан (но не будет закрыт)");
            }
            public void use() {
                System.out.println("  ❌ Ресурс используется");
            }
        }

        BadResource bad = new BadResource();
        bad.use();
        System.out.println("  ❌ Ресурс НЕ закрыт! (потенциальная утечка)");

        // ===== 4. Пример с файлом =====
        System.out.println("\n--- 4. Реальный пример: работа с файлом ---");

        try (FileWriter fw = new FileWriter("test.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("Пример использования try-with-resources");
            System.out.println("  ✅ Данные записаны в файл");

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        // fw и bw автоматически закрыты

        // ===== 5. Демонстрация важности закрытия ресурсов =====
        System.out.println("\n--- 5. Почему важно закрывать ресурсы ---");

        System.out.println("Проблемы при НЕзакрытии ресурсов:");
        System.out.println("  • Утечка памяти");
        System.out.println("  • Исчерпание файловых дескрипторов");
        System.out.println("  • Блокировка файлов");
        System.out.println("  • Превышение лимита соединений с БД");

        System.out.println("\n--- Демонстрация с БД (симуляция) ---");

        // Правильно: с try-with-resources
        try (DatabaseConnection conn = new DatabaseConnection("DB-001")) {
            conn.query("SELECT * FROM users");
        }

        // Неправильно: без закрытия
        System.out.println("\n  ❌ Плохая практика:");
        DatabaseConnection badConn = new DatabaseConnection("DB-002");
        badConn.query("SELECT * FROM products");
        // conn НЕ закрыт! Утечка ресурса!

        System.out.println("\n========== КЛЮЧЕВЫЕ МОМЕНТЫ ==========");
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│ 1. AutoCloseable позволяет использовать try-with-resources      │");
        System.out.println("│ 2. close() вызывается АВТОМАТИЧЕСКИ после try-блока             │");
        System.out.println("│ 3. Даже если произошло исключение, close() будет вызван         │");
        System.out.println("│ 4. Ресурсы закрываются в обратном порядке создания              │");
        System.out.println("│ 5. Closeable extends AutoCloseable (для обратной совместимости) │");
        System.out.println("└─────────────────────────────────────────────────────────────────┘");
    }
}