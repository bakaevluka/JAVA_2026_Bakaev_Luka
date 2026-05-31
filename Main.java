import java.util.Scanner;

/**
 * Программа для приветствия пользователя.
 * Демонстрирует использование документационных комментариев Javadoc.
 *
 * <p>Программа запрашивает имя пользователя и выводит персонализированное
 * приветствие в консоль.
 *
 * @author Лука
 * @version 1.0
 * @since 2026-05-31
 * @see java.util.Scanner
 */
class JavadocExample {

    /**
     * Главный метод программы.
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки (не используются)
     * @throws IllegalStateException если возникает ошибка ввода-вывода
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();

        System.out.println("Привет, " + name + "!");

        scanner.close();
    }
}