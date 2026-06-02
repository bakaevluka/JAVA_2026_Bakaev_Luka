/**
 * Демонстрация 10 методов классов StringBuilder и StringBuffer
 * StringBuilder и StringBuffer - изменяемые строки
 * StringBuffer - потокобезопасный (синхронизированный), медленнее
 * StringBuilder - не потокобезопасный, быстрее
 */
class StringBuilderBufferExample {
    public static void main(String[] args) {

        System.out.println("========== StringBuilder (быстрый, не потокобезопасный) ==========");
        StringBuilder sb = new StringBuilder("Hello");

        System.out.println("\n========== 1. append() - добавляет в конец ==========");
        sb.append(" World");
        System.out.println("append(\" World\"): " + sb);
        // append() - добавляет строку, число, символ и т.д. в конец

        System.out.println("\n========== 2. insert() - вставляет по индексу ==========");
        sb.insert(5, " Beautiful");
        System.out.println("insert(5, \" Beautiful\"): " + sb);
        // insert(offset, value) - вставляет значение в указанную позицию

        System.out.println("\n========== 3. delete() - удаляет символы ==========");
        sb.delete(5, 15);
        System.out.println("delete(5, 15): " + sb);
        // delete(start, end) - удаляет символы от start до end-1

        System.out.println("\n========== 4. deleteCharAt() - удаляет символ по индексу ==========");
        sb.deleteCharAt(5);
        System.out.println("deleteCharAt(5): " + sb);
        // deleteCharAt(index) - удаляет один символ по индексу

        System.out.println("\n========== 5. replace() - заменяет часть строки ==========");
        sb.replace(6, 11, "Java");
        System.out.println("replace(6, 11, \"Java\"): " + sb);
        // replace(start, end, str) - заменяет часть строки

        System.out.println("\n========== 6. reverse() - переворачивает строку ==========");
        sb.reverse();
        System.out.println("reverse(): " + sb);
        sb.reverse(); // возвращаем обратно
        System.out.println("reverse() обратно: " + sb);
        // reverse() - переворачивает последовательность символов

        System.out.println("\n========== 7. length() и capacity() - длина и емкость ==========");
        System.out.println("length(): " + sb.length());      // текущая длина
        System.out.println("capacity(): " + sb.capacity());  // выделенная память

        System.out.println("\n========== 8. setLength() - устанавливает длину ==========");
        sb.setLength(5);
        System.out.println("setLength(5): " + sb);
        sb.setLength(10);
        System.out.println("setLength(10) (с null-символами): '" + sb + "'");
        sb.setLength(0); // очистка
        System.out.println("setLength(0) для очистки: '" + sb + "'");
        // setLength() - обрезает или дополняет строку нулевыми символами

        System.out.println("\n========== 9. charAt() и setCharAt() - доступ к символам ==========");
        sb = new StringBuilder("Java Programming");
        System.out.println("Исходная: " + sb);
        System.out.println("charAt(0): " + sb.charAt(0));
        sb.setCharAt(0, 'j');
        System.out.println("setCharAt(0, 'j'): " + sb);
        // charAt() - получает символ, setCharAt() - изменяет символ

        System.out.println("\n========== 10. substring() - извлекает подстроку ==========");
        String sub = sb.substring(5, 16);
        System.out.println("substring(5, 16): " + sub);
        // substring() - возвращает String, не изменяя StringBuilder

        System.out.println("\n========== ДОПОЛНИТЕЛЬНЫЕ МЕТОДЫ ==========");

        System.out.println("\n--- indexOf() и lastIndexOf() ---");
        sb = new StringBuilder("Hello Hello World");
        System.out.println("Строка: " + sb);
        System.out.println("indexOf(\"Hello\"): " + sb.indexOf("Hello"));
        System.out.println("lastIndexOf(\"Hello\"): " + sb.lastIndexOf("Hello"));

        System.out.println("\n--- ensureCapacity() - гарантирует емкость ---");
        sb = new StringBuilder();
        System.out.println("Начальная capacity: " + sb.capacity());
        sb.ensureCapacity(100);
        System.out.println("После ensureCapacity(100): " + sb.capacity());

        System.out.println("\n--- trimToSize() - уменьшает capacity до length() ---");
        sb = new StringBuilder(100);
        sb.append("Short text");
        System.out.println("До trimToSize(): capacity = " + sb.capacity() + ", length = " + sb.length());
        sb.trimToSize();
        System.out.println("После trimToSize(): capacity = " + sb.capacity() + ", length = " + sb.length());

        System.out.println("\n========== StringBuffer (потокобезопасный, но медленнее) ==========");

        StringBuffer buffer = new StringBuffer("Start");
        buffer.append(" End");
        buffer.insert(5, " Middle");
        buffer.delete(5, 12);
        buffer.reverse();
        System.out.println("StringBuffer операции: " + buffer);

        System.out.println("\n========== СРАВНЕНИЕ ==========");
        System.out.println("StringBuilder - быстрее, НЕ потокобезопасный (для однопоточных приложений)");
        System.out.println("StringBuffer - медленнее, потокобезопасный (для многопоточных приложений)");
        System.out.println("У них одинаковые методы, отличаются только синхронизацией");
    }
}