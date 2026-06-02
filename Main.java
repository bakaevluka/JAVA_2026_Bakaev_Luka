import java.io.*;
import java.util.Arrays;

/**
 * Демонстрация работы метода read() класса InputStream
 */
class InputStreamExample {
    public static void main(String[] args) {

        System.out.println("========== МЕТОД read() КЛАССА InputStream ==========\n");

        // Создаем массив байтов для демонстрации
        byte[] data = {65, 66, 67, 68, 69, 10, 70, 71, 72};  // A, B, C, D, E, \n, F, G, H

        System.out.println("Исходные данные: " + Arrays.toString(data));
        System.out.println("Как текст: " + new String(data));

        // Используем ByteArrayInputStream (подкласс InputStream)
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data)) {

            // 1. read() - читает один байт
            System.out.println("\n--- 1. int read() - читает один байт ---");
            int firstByte = bais.read();
            System.out.println("Прочитанный байт: " + firstByte + " -> символ: " + (char) firstByte);

            int secondByte = bais.read();
            System.out.println("Прочитанный байт: " + secondByte + " -> символ: " + (char) secondByte);

            // 2. read(byte[] buffer) - читает в массив
            System.out.println("\n--- 2. int read(byte[] buffer) - читает в массив ---");
            bais.reset(); // возвращаемся в начало
            byte[] buffer1 = new byte[5];
            int bytesRead = bais.read(buffer1);
            System.out.println("Прочитано байт: " + bytesRead);
            System.out.println("Содержимое буфера: " + Arrays.toString(buffer1));
            System.out.println("Как текст: " + new String(buffer1));

            // 3. read(byte[] buffer, int offset, int length) - читает с указанием позиции
            System.out.println("\n--- 3. read(byte[] buffer, int offset, int length) ---");
            bais.reset();
            byte[] buffer2 = new byte[10];
            int bytesRead2 = bais.read(buffer2, 2, 5);
            System.out.println("Прочитано байт: " + bytesRead2);
            System.out.println("Буфер (с offset 2): " + Arrays.toString(buffer2));
            System.out.println("Как текст: '" + new String(buffer2) + "'");

            // 4. Чтение всех байтов до конца
            System.out.println("\n--- 4. Чтение всех байтов до конца ---");
            bais.reset();
            byte[] allBytes = bais.readAllBytes();  // Java 9+
            System.out.println("Все байты: " + Arrays.toString(allBytes));
            System.out.println("Как текст: " + new String(allBytes));

            // 5. available() - сколько байтов доступно 
            System.out.println("\n--- 5. available() - доступные байты ---");
            bais.reset();  // ✅ ВАЖНО: сбрасываем поток в начало
            System.out.println("Доступно байт (после reset): " + bais.available());

            // Демонстрация уменьшения available после чтения
            System.out.println("\n   Демонстрация изменения available после чтения:");
            System.out.println("   Доступно до чтения: " + bais.available());
            bais.read();  // читаем 1 байт
            System.out.println("   Доступно после чтения 1 байта: " + bais.available());
            bais.read(new byte[3]);  // читаем 3 байта
            System.out.println("   Доступно после чтения 3 байтов: " + bais.available());

            // 6. skip() - пропуск байтов
            System.out.println("\n--- 6. skip() - пропуск байтов ---");
            bais.reset();
            System.out.println("   Доступно до skip: " + bais.available());
            System.out.println("   Пропускаем 3 байта");
            bais.skip(3);
            int byteAfterSkip = bais.read();
            System.out.println("   Байт после пропуска: " + byteAfterSkip + " -> символ: " + (char) byteAfterSkip);
            System.out.println("   Доступно после skip: " + bais.available());

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}