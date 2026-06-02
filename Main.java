import java.util.StringJoiner;

/**
 * Демонстрация класса StringJoiner (Java 8+)
 */
class StringJoinerExample {
    public static void main(String[] args) {

        System.out.println("========== ОСНОВНОЕ ИСПОЛЬЗОВАНИЕ ==========");

        // Создание StringJoiner с разделителем
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("Яблоко");
        joiner1.add("Груша");
        joiner1.add("Банан");
        System.out.println("С разделителем \", \": " + joiner1);

        System.out.println("\n========== С ПРЕФИКСОМ И СУФФИКСОМ ==========");

        // StringJoiner с разделителем, префиксом и суффиксом
        StringJoiner joiner2 = new StringJoiner(", ", "[", "]");
        joiner2.add("Красный");
        joiner2.add("Синий");
        joiner2.add("Зеленый");
        System.out.println("С префиксом '[' и суффиксом ']': " + joiner2);

        System.out.println("\n========== ОБЪЕДИНЕНИЕ STRINGJOINER ==========");

        StringJoiner joiner3 = new StringJoiner(", ");
        joiner3.add("Один");
        joiner3.add("Два");

        StringJoiner joiner4 = new StringJoiner(", ");
        joiner4.add("Три");
        joiner4.add("Четыре");

        joiner3.merge(joiner4);
        System.out.println("После merge: " + joiner3);

        System.out.println("\n========== ПУСТОЙ STRINGJOINER ==========");

        StringJoiner empty = new StringJoiner(", ", "{", "}");
        System.out.println("Пустой StringJoiner: '" + empty + "'");
        System.out.println("toString() пустого: " + empty.toString());

        // С пустым значением по умолчанию
        StringJoiner emptyWithDefault = new StringJoiner(", ", "{", "}");
        emptyWithDefault.setEmptyValue("ПУСТО");
        System.out.println("С установленным emptyValue: " + emptyWithDefault);

        System.out.println("\n========== ПРИМЕРЫ ИСПОЛЬЗОВАНИЯ ==========");

        // Пример 1: Формирование списка email
        StringJoiner emails = new StringJoiner("; ");
        emails.add("user1@example.com");
        emails.add("user2@example.com");
        emails.add("user3@example.com");
        System.out.println("Список email: " + emails);

        // Пример 2: Формирование SQL запроса
        StringJoiner columns = new StringJoiner(", ", "SELECT ", " FROM users");
        columns.add("id");
        columns.add("name");
        columns.add("email");
        System.out.println("SQL запрос: " + columns);

        // Пример 3: Формирование пути
        StringJoiner path = new StringJoiner("/", "/", "");
        path.add("home");
        path.add("user");
        path.add("documents");
        System.out.println("Путь: " + path);

        // Пример 4: Сравнение с обычной конкатенацией
        System.out.println("\n========== СРАВНЕНИЕ С КОНКАТЕНАЦИЕЙ ==========");

        // Без StringJoiner (плохо)
        String[] fruits = {"Яблоко", "Груша", "Банан"};
        String result = "";
        for (int i = 0; i < fruits.length; i++) {
            result += fruits[i];
            if (i < fruits.length - 1) {
                result += ", ";
            }
        }
        System.out.println("Обычная конкатенация: " + result);

        // С StringJoiner (хорошо)
        StringJoiner good = new StringJoiner(", ");
        for (String fruit : fruits) {
            good.add(fruit);
        }
        System.out.println("StringJoiner: " + good);

        // С String.join() (альтернатива)
        String joined = String.join(", ", fruits);
        System.out.println("String.join(): " + joined);
    }
}