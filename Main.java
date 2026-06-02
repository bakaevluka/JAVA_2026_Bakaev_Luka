class StringMethodsExample {
    public static void main(String[] args) {

        String str = "  Java Programming Language  ";
        String str2 = "java programming language";

        System.out.println("========== 1. length() - возвращает длину строки ==========");
        System.out.println("Длина строки \"" + str + "\" = " + str.length());
        // length() считает количество символов, включая пробелы

        System.out.println("\n========== 2. charAt() - возвращает символ по индексу ==========");
        System.out.println("Символ на индексе 0: '" + str.charAt(0) + "'");
        System.out.println("Символ на индексе 5: '" + str.charAt(5) + "'");
        // Индексация начинается с 0

        System.out.println("\n========== 3. substring() - извлекает подстроку ==========");
        System.out.println("substring(2, 6): \"" + str.substring(2, 6) + "\"");
        System.out.println("substring(5): \"" + str.substring(5) + "\"");
        // substring(start, end) - end не включается

        System.out.println("\n========== 4. trim() - удаляет пробелы в начале и конце ==========");
        System.out.println("До trim(): \"" + str + "\"");
        System.out.println("После trim(): \"" + str.trim() + "\"");
        // trim() удаляет только пробелы, табуляции, переводы строк в начале и конце

        System.out.println("\n========== 5. toLowerCase() и toUpperCase() - изменение регистра ==========");
        System.out.println("toLowerCase(): " + str.toLowerCase());
        System.out.println("toUpperCase(): " + str.toUpperCase());
        // Возвращают новую строку в нижнем/верхнем регистре

        System.out.println("\n========== 6. equals() и equalsIgnoreCase() - сравнение строк ==========");
        System.out.println("str.equals(str2): " + str.trim().equals(str2));
        System.out.println("str.equalsIgnoreCase(str2): " + str.trim().equalsIgnoreCase(str2));
        // equals() - учитывает регистр, equalsIgnoreCase() - не учитывает

        System.out.println("\n========== 7. contains() - проверяет наличие подстроки ==========");
        System.out.println("Содержит \"Java\": " + str.contains("Java"));
        System.out.println("Содержит \"Python\": " + str.contains("Python"));
        // contains() возвращает true, если подстрока найдена

        System.out.println("\n========== 8. replace() - заменяет символы или подстроки ==========");
        System.out.println("replace('a', 'o'): " + str.replace('a', 'o'));
        System.out.println("replace(\"Java\", \"Python\"): " + str.replace("Java", "Python"));
        // replace() заменяет все вхождения

        System.out.println("\n========== 9. split() - разбивает строку на массив ==========");
        String[] words = str.trim().split(" ");
        System.out.println("Разбиение по пробелу:");
        for (String word : words) {
            System.out.println("  - " + word);
        }
        // split() возвращает массив строк, разделенных по заданному шаблону

        System.out.println("\n========== 10. indexOf() и lastIndexOf() - поиск индекса ==========");
        System.out.println("Первый 'a': " + str.indexOf('a'));
        System.out.println("Последний 'a': " + str.lastIndexOf('a'));
        System.out.println("Первый 'Java': " + str.indexOf("Java"));
        // indexOf() - первый индекс, lastIndexOf() - последний. Если нет - возвращает -1

        System.out.println("\n========== ДОПОЛНИТЕЛЬНЫЕ МЕТОДЫ ==========");

        System.out.println("\n--- isEmpty() и isBlank() ---");
        String empty = "";
        String blank = "   ";
        System.out.println("isEmpty() для \"\": " + empty.isEmpty());    // true
        System.out.println("isEmpty() для \"   \": " + blank.isEmpty()); // false
        System.out.println("isBlank() для \"   \": " + blank.isBlank()); // true (Java 11+)

        System.out.println("\n--- startsWith() и endsWith() ---");
        System.out.println("startsWith(\"Java\"): " + str.trim().startsWith("Java"));
        System.out.println("endsWith(\"ge\"): " + str.trim().endsWith("ge"));

        System.out.println("\n--- repeat() ---");
        System.out.println("\"Hi\".repeat(3): " + "Hi ".repeat(3));  // Java 11+

        System.out.println("\n--- join() ---");
        String joined = String.join("-", "2024", "12", "25");
        System.out.println("String.join(\"-\", \"2024\", \"12\", \"25\"): " + joined);
    }
}