/**
 * Демонстрация Text Blocks (три двойные кавычки) - Java 15+
 *
 * Три двойные кавычки """ используются для создания многострочных строк
 * без необходимости экранирования и конкатенации.
 */
class TextBlocksExample {
    public static void main(String[] args) {

        System.out.println("========== ЧТО ТАКОЕ TEXT BLOCKS? ==========");
        System.out.println("Text Blocks - это многострочные строки, начинающиеся и заканчивающиеся \"\"\"");
        System.out.println("Позволяют писать строки с переносами без \\n и конкатенации\n");

        System.out.println("========== БЕЗ TEXT BLOCKS (старый способ) ==========");

        String oldHtml = "<html>\n" +
                "    <body>\n" +
                "        <h1>Заголовок</h1>\n" +
                "        <p>Текст</p>\n" +
                "    </body>\n" +
                "</html>";
        System.out.println(oldHtml);

        System.out.println("\n========== С TEXT BLOCKS (новый способ) ==========");

        String newHtml = """
                         <html>
                             <body>
                                 <h1>Заголовок</h1>
                                 <p>Текст</p>
                             </body>
                         </html>
                         """;
        System.out.println(newHtml);

        System.out.println("\n========== SQL ЗАПРОСЫ ==========");

        String sql = """
                     SELECT id, name, email, created_at
                     FROM users
                     WHERE status = 'active'
                       AND created_at > '2024-01-01'
                     ORDER BY created_at DESC
                     """;
        System.out.println(sql);

        System.out.println("\n========== JSON ФОРМАТ ==========");

        String json = """
                       {
                           "name": "Иван",
                           "age": 30,
                           "city": "Москва",
                           "hobbies": ["чтение", "спорт", "музыка"]
                       }
                       """;
        System.out.println(json);

        System.out.println("\n========== ИСПОЛЬЗОВАНИЕ ВНУТРИ СТРОК ==========");

        String text = """
                       Это пример с вложенными кавычками: "Привет, мир!"
                       А так же с апострофом: 'Java'
                       И даже с обратной косой чертой: \\
                       """;
        System.out.println(text);

        System.out.println("\n========== ФОРМАТИРОВАНИЕ С STRING.FORMATTED ==========");

        String name = "Анна";
        int age = 25;

        String message = """
                         Привет, %s!
                         Тебе %d лет.
                         Добро пожаловать в программу.
                         """.formatted(name, age);
        System.out.println(message);

        System.out.println("\n========== ОСОБЕННОСТИ ОТСТУПОВ ==========");

        // Отступы автоматически удаляются
        String withIndent = """
                            1. Первая строка
                            2. Вторая строка
                            3. Третья строка
                            """;
        System.out.println("С автоматическим удалением отступов:");
        System.out.println(withIndent);

        // Сохранение отступов
        String preserveIndent = """
                            1. Начало с отступом
                                2. Двойной отступ
                            3. Возврат к одному отступу
                            """.indent(4);
        System.out.println("С сохранением отступов:");
        System.out.println(preserveIndent);

        System.out.println("\n========== КОГДА НУЖНЫ ТРИ КАВЫЧКИ ==========");
        System.out.println("1. HTML/XML код");
        System.out.println("2. SQL запросы");
        System.out.println("3. JSON данные");
        System.out.println("4. Многострочные сообщения");
        System.out.println("5. Регулярные выражения");
        System.out.println("6. Шаблоны писем");

        System.out.println("\n========== ВАЖНЫЕ ПРАВИЛА ==========");
        System.out.println("1. Текст блока начинается с новой строки после \"\"\"");
        System.out.println("2. Закрывающая \"\"\" должна быть на отдельной строке");
        System.out.println("3. Отступы вычисляются по закрывающей \"\"\"");
        System.out.println("4. Не нужно экранировать \" и \\n");
        System.out.println("5. Доступны с Java 15 (Java 13/14 как preview)");
    }
}