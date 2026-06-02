import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Демонстрация чтения данных из текстового файла с помощью Scanner
 */
class ScannerFileExample {

    public static void main(String[] args) {

        System.out.println("========== ЧТЕНИЕ ФАЙЛА С ПОМОЩЬЮ SCANNER ==========\n");

        // Сначала создадим файл для чтения
        createSampleFile();

        // ===== 1. БАЗОВОЕ ЧТЕНИЕ ФАЙЛА =====
        System.out.println("--- 1. Базовое чтение файла ---");
        readFileBasic();

        // ===== 2. ЧТЕНИЕ С РАЗДЕЛИТЕЛЯМИ =====
        System.out.println("\n--- 2. Чтение с кастомным разделителем ---");
        readFileWithDelimiter();

        // ===== 3. ЧТЕНИЕ ЧИСЕЛ ИЗ ФАЙЛА =====
        System.out.println("\n--- 3. Чтение чисел из файла ---");
        readNumbersFromFile();

        // ===== 4. ЧТЕНИЕ ПО СТРОКАМ =====
        System.out.println("\n--- 4. Чтение файла по строкам ---");
        readFileLineByLine();

        // ===== 5. ЧТЕНИЕ ВСЕГО ФАЙЛА СРАЗУ =====
        System.out.println("\n--- 5. Чтение всего файла ---");
        readWholeFile();

        // ===== 6. ЧТЕНИЕ С ИСПОЛЬЗОВАНИЕМ КОДИРОВКИ =====
        System.out.println("\n--- 6. Чтение с указанием кодировки ---");
        readFileWithEncoding();

        // ===== 7. ОБРАБОТКА ИСКЛЮЧЕНИЙ =====
        System.out.println("\n--- 7. Обработка ошибок при чтении файла ---");
        readFileWithErrorHandling();
    }

    // Создание примера файла для чтения
    private static void createSampleFile() {
        try (PrintWriter writer = new PrintWriter("sample.txt")) {
            writer.println("Иван Петров 25");
            writer.println("Мария Иванова 30");
            writer.println("Алексей Сидоров 28");
            writer.println("Елена Козлова 22");
            writer.println("Дмитрий Николаев 35");

            writer.println("\n--- Числа для примера ---");
            writer.println("10 20 30 40 50");
            writer.println("2.5 4.7 8.1 9.3");

            System.out.println("Файл 'sample.txt' создан\n");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    // 1. Базовое чтение файла
    private static void readFileBasic() {
        File file = new File("sample.txt");

        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Содержимое файла (по словам):");
            while (scanner.hasNext()) {
                String word = scanner.next();
                System.out.print(word + " ");
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    // 2. Чтение с кастомным разделителем
    private static void readFileWithDelimiter() {
        File file = new File("sample.txt");

        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("[ ,;\\n]+");

            System.out.println("Чтение с разделителем:");
            while (scanner.hasNext()) {
                System.out.print("[" + scanner.next() + "] ");
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    // 3. Чтение чисел из файла
    private static void readNumbersFromFile() {
        File file = new File("sample.txt");

        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Чтение целых чисел (nextInt):");
            int sumInt = 0;
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                sumInt += num;
                System.out.println("  int: " + num);
            }
            System.out.println("  Сумма целых чисел: " + sumInt);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }

        // Отдельный Scanner для double
        try (Scanner scanner2 = new Scanner(file)) {
            System.out.println("\nЧтение дробных чисел (nextDouble):");
            double sumDouble = 0;
            while (scanner2.hasNextDouble()) {
                double num = scanner2.nextDouble();
                sumDouble += num;
                System.out.println("  double: " + num);
            }
            System.out.println("  Сумма дробных чисел: " + sumDouble);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    // 4. Чтение по строкам
    private static void readFileLineByLine() {
        File file = new File("sample.txt");

        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Чтение файла по строкам:");
            int lineNum = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.printf("  %d: %s%n", lineNum++, line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    // 5. Чтение всего файла целиком
    private static void readWholeFile() {
        File file = new File("sample.txt");

        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\\A");

            if (scanner.hasNext()) {
                String content = scanner.next();
                System.out.println("Весь файл целиком:");
                System.out.println("----------------------------------------");
                System.out.println(content);
                System.out.println("----------------------------------------");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    // 6. Чтение с указанием кодировки
    private static void readFileWithEncoding() {
        // Создадим файл в UTF-8
        try (PrintWriter writer = new PrintWriter("utf8.txt", "UTF-8")) {
            writer.println("Привет мир! (UTF-8 файл)");
            writer.println("Hello world!");
            writer.println("こんにちは");
        } catch (Exception e) {
            System.out.println("Ошибка при создании UTF-8 файла: " + e.getMessage());
        }

        // Чтение с указанием кодировки
        try (Scanner scanner = new Scanner(new File("utf8.txt"), "UTF-8")) {
            System.out.println("Файл в кодировке UTF-8:");
            while (scanner.hasNextLine()) {
                System.out.println("  " + scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Неподдерживаемая кодировка: " + e.getMessage());
        }
    }

    // 7. Обработка ошибок
    private static void readFileWithErrorHandling() {
        String[] filesToTry = {"nonexistent.txt", "sample.txt"};

        for (String filename : filesToTry) {
            try (Scanner scanner = new Scanner(new File(filename))) {
                System.out.println("Файл '" + filename + "' найден. Первая строка:");
                if (scanner.hasNextLine()) {
                    System.out.println("    " + scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл '" + filename + "' не найден!");
            }
        }
    }
}