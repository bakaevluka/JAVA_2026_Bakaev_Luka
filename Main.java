import java.io.*;

/**
 * Демонстрация работы метода write() класса OutputStream
 */
class OutputStreamExample {
    public static void main(String[] args) {

        System.out.println("========== МЕТОД write() КЛАССА OutputStream ==========\n");

        // Используем ByteArrayOutputStream (подкласс OutputStream)
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            // 1. write(int) - записывает один байт
            System.out.println("--- 1. void write(int b) - запись одного байта ---");
            baos.write(65);  // 'A'
            baos.write(66);  // 'B'
            baos.write(67);  // 'C'
            System.out.println("После записи 3 байт: " + baos.toString());

            // 2. write(byte[] buffer) - запись массива байтов
            System.out.println("\n--- 2. void write(byte[] buffer) - запись массива ---");
            byte[] data = {68, 69, 70};  // D, E, F
            baos.write(data);
            System.out.println("После записи массива: " + baos.toString());

            // 3. write(byte[] buffer, int offset, int length) - запись части массива
            System.out.println("\n--- 3. void write(byte[] buffer, int offset, int length) ---");
            byte[] moreData = {71, 72, 73, 74, 75};  // G, H, I, J, K
            baos.write(moreData, 1, 3);  // H, I, J
            System.out.println("После записи части массива: " + baos.toString());

            // 4. Запись строки в байтах
            System.out.println("\n--- 4. Запись строки ---");
            String text = " Привет, мир!";
            baos.write(text.getBytes());
            System.out.println("После записи строки: " + baos.toString());

            // 5. Получение результата
            System.out.println("\n--- 5. Получение результата ---");
            byte[] result = baos.toByteArray();
            System.out.println("Байтовый массив: " + java.util.Arrays.toString(result));
            System.out.println("Как строка: " + baos.toString());

            // 6. flush() - принудительная запись (для буферизированных потоков)
            System.out.println("\n--- 6. flush() - принудительная запись ---");
            baos.flush();  // для ByteArrayOutputStream не обязателен, но для других потоков важен
            System.out.println("flush() вызван, данные записаны");

            // 7. close() - закрытие потока
            System.out.println("\n--- 7. close() - закрытие потока ---");
            baos.close();
            System.out.println("Поток закрыт");

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Пример записи в файл
        System.out.println("\n========== ЗАПИСЬ В ФАЙЛ ==========");

        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            fos.write(72);  // 'H'
            fos.write(101); // 'e'
            fos.write(108); // 'l'
            fos.write(108); // 'l'
            fos.write(111); // 'o'
            fos.write(10);  // '\n'
            fos.write("World!".getBytes());

            System.out.println("Данные записаны в файл output.txt");

        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}