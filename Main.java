import java.io.*;

/**
 * Объяснение: зачем нужны Reader и Writer, если есть InputStream и OutputStream
 */
class ReaderWriterExample {
    public static void main(String[] args) {

        System.out.println("========== ПОЧЕМУ НУЖНЫ READER И WRITER? ==========\n");

        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│ InputStream/OutputStream  → работают с БАЙТАМИ (byte)           │");
        System.out.println("│ Reader/Writer              → работают с СИМВОЛАМИ (char)        │");
        System.out.println("└─────────────────────────────────────────────────────────────────┘\n");

        // Проблема: байтовые потоки не правильно обрабатывают символы Unicode

        String unicodeText = "Привет, мир! こんにちは 🌍";

        System.out.println("Исходный текст: " + unicodeText);
        System.out.println("Длина текста: " + unicodeText.length() + " символов\n");

        // ===== ПРОБЛЕМА С БАЙТОВЫМИ ПОТОКАМИ =====
        System.out.println("--- ПРОБЛЕМА: байтовые потоки (InputStream/OutputStream) ---");

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(baos, "UTF-8")) {

            // Записываем как байты
            byte[] bytes = unicodeText.getBytes("UTF-8");
            System.out.println("В UTF-8 байтов: " + bytes.length + " (больше, чем символов!)");
            System.out.println("Байты: " + java.util.Arrays.toString(bytes));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ===== РЕШЕНИЕ: СИМВОЛЬНЫЕ ПОТОКИ =====
        System.out.println("\n--- РЕШЕНИЕ: символьные потоки (Reader/Writer) ---");

        try (StringReader reader = new StringReader(unicodeText);
             StringWriter writer = new StringWriter()) {

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
            System.out.println("Прочитано и записано: " + writer.toString());
            System.out.println("Корректно обработаны все символы, включая эмодзи!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ===== СРАВНЕНИЕ =====
        System.out.println("\n========== СРАВНЕНИЕ ПОТОКОВ ==========");
        System.out.println("┌─────────────────┬─────────────────────┬─────────────────────┐");
        System.out.println("│ Характеристика  │ Байтовые потоки     │ Символьные потоки   │");
        System.out.println("├─────────────────┼─────────────────────┼─────────────────────┤");
        System.out.println("│ Базовые классы  │ InputStream/        │ Reader/Writer       │");
        System.out.println("│                 │ OutputStream        │                     │");
        System.out.println("│ Единица данных  │ Байт (8 бит)        │ Символ (16 бит)     │");
        System.out.println("│ Поддержка       │ Проблемы с Unicode  │ Полная поддержка    │");
        System.out.println("│ Unicode         │ (эмодзи, кириллица) │ Unicode             │");
        System.out.println("│ Когда           │ Изображения, аудио, │ Текстовые файлы,    │");
        System.out.println("│ использовать    │ бинарные файлы      │ строки, документы   │");
        System.out.println("└─────────────────┴─────────────────────┴─────────────────────┘");

        System.out.println("\n========== ВЫВОД ==========");
        System.out.println("✅ Reader/Writer нужны для КОРРЕКТНОЙ работы с текстом");
        System.out.println("✅ Они автоматически обрабатывают кодировки");
        System.out.println("✅ Работают с символами, а не с байтами");
        System.out.println("✅ Поддерживают все символы Unicode (включая эмодзи)");
    }
}