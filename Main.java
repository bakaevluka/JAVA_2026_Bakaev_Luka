import java.io.*;

/**
 * Демонстрация метода flush()
 *
 * flush() - принудительно записывает данные из буфера в выходной поток
 * Буфер - временное хранилище данных для оптимизации ввода/вывода
 */
class FlushExample {
    public static void main(String[] args) {

        System.out.println("========== ЧТО ТАКОЕ FLUSH()? ==========");
        System.out.println("flush() - принудительно очищает буфер и записывает данные в выходной поток");
        System.out.println("Без flush() данные могут остаться в буфере и не записаться сразу\n");

        System.out.println("========== ПРИМЕР БЕЗ FLUSH() ==========");

        // Пример с PrintWriter (буферизированный вывод)
        try {
            PrintWriter writer = new PrintWriter(System.out);
            writer.print("Это сообщение");
            writer.print(" может остаться в буфере");
            System.out.println("\n(Данные еще не выведены - они в буфере)");
            // writer.flush(); - раскомментируйте, чтобы увидеть разницу
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n========== ПРИМЕР С FLUSH() ==========");

        try {
            PrintWriter writer = new PrintWriter(System.out);
            writer.print("Это сообщение");
            writer.print(" выведено сразу после flush()");
            writer.flush();  // принудительная запись
            System.out.println("\n✅ flush() вызван - данные записаны");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n========== РЕАЛЬНЫЙ ПРИМЕР (файловый ввод/вывод) ==========");

        // Демонстрация на файле
        String fileName = "test_flush.txt";

        // Без flush() - запись в файл может не произойти до закрытия
        try (FileOutputStream fos = new FileOutputStream(fileName);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             PrintWriter writer = new PrintWriter(bos)) {

            writer.println("Строка 1 - это сообщение в буфере");
            writer.println("Строка 2 - еще одно сообщение");
            System.out.println("Данные записаны в буфер, но не в файл");

            // writer.flush(); // если раскомментировать, данные запишутся сразу
            System.out.println("Файл может быть пустым или неполным");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // С flush()
        try (FileOutputStream fos = new FileOutputStream(fileName, true);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             PrintWriter writer = new PrintWriter(bos)) {

            writer.println("Строка 3 - данные с flush()");
            writer.flush();  // принудительная запись в файл
            System.out.println("✅ flush() вызван - данные записаны в файл");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n========== КОГДА НУЖЕН FLUSH()? ==========");
        System.out.println("1. При работе с сетевыми сокетами - отправить данные сразу");
        System.out.println("2. При записи в файл - гарантировать сохранение данных");
        System.out.println("3. При интерактивном взаимодействии с пользователем");
        System.out.println("4. При логировании - записать критическую информацию немедленно");
        System.out.println("5. При отладке - увидеть вывод сразу");

        System.out.println("\n========== ВАЖНЫЕ ЗАМЕЧАНИЯ ==========");
        System.out.println("• System.out автоматически сбрасывает буфер при \\n");
        System.out.println("• close() автоматически вызывает flush()");
        System.out.println("• Частый вызов flush() снижает производительность");
        System.out.println("• Буферизация нужна для оптимизации, flush - для контроля");
    }
}