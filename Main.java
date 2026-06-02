/**
 * Демонстрация преобразований между String, StringBuilder, StringBuffer
 */
class StringConversionExample {
    public static void main(String[] args) {

        System.out.println("========== ПРЕОБРАЗОВАНИЯ МЕЖДУ String, StringBuilder, StringBuffer ==========\n");

        // ========== 1. String → StringBuilder ==========
        System.out.println("1. String → StringBuilder");
        String str = "Hello World";
        StringBuilder sb = new StringBuilder(str);
        System.out.println("   new StringBuilder(\"" + str + "\") = " + sb);
        System.out.println("   метод: new StringBuilder(String) или StringBuilder.append()\n");

        // ========== 2. String → StringBuffer ==========
        System.out.println("2. String → StringBuffer");
        StringBuffer sbf = new StringBuffer(str);
        System.out.println("   new StringBuffer(\"" + str + "\") = " + sbf);
        System.out.println("   метод: new StringBuffer(String) или StringBuffer.append()\n");

        // ========== 3. StringBuilder → String ==========
        System.out.println("3. StringBuilder → String");
        sb = new StringBuilder("Java Programming");
        String strFromSb = sb.toString();
        System.out.println("   sb.toString() = \"" + strFromSb + "\"");
        System.out.println("   метод: toString()\n");

        // ========== 4. StringBuffer → String ==========
        System.out.println("4. StringBuffer → String");
        sbf = new StringBuffer("Java Programming");
        String strFromSbf = sbf.toString();
        System.out.println("   sbf.toString() = \"" + strFromSbf + "\"");
        System.out.println("   метод: toString()\n");

        // ========== 5. StringBuilder → StringBuffer ==========
        System.out.println("5. StringBuilder → StringBuffer");
        sb = new StringBuilder("Convert to StringBuffer");
        StringBuffer sbf2 = new StringBuffer(sb.toString());
        System.out.println("   new StringBuffer(sb.toString()) = \"" + sbf2 + "\"");
        System.out.println("   метод: new StringBuffer(StringBuilder.toString())\n");

        // ========== 6. StringBuffer → StringBuilder ==========
        System.out.println("6. StringBuffer → StringBuilder");
        sbf = new StringBuffer("Convert to StringBuilder");
        StringBuilder sb2 = new StringBuilder(sbf.toString());
        System.out.println("   new StringBuilder(sbf.toString()) = \"" + sb2 + "\"");
        System.out.println("   метод: new StringBuilder(StringBuffer.toString())\n");

        // ========== 7. Через метод append() ==========
        System.out.println("7. Преобразование через append()");

        // String → StringBuilder
        StringBuilder sb3 = new StringBuilder().append("String to StringBuilder");
        System.out.println("   new StringBuilder().append(\"String\") = " + sb3);

        // StringBuilder → StringBuffer
        StringBuffer sbf3 = new StringBuffer().append(sb3);
        System.out.println("   new StringBuffer().append(StringBuilder) = " + sbf3);

        // ========== ТАБЛИЦА ПРЕОБРАЗОВАНИЙ ==========
        System.out.println("\n========== ТАБЛИЦА ПРЕОБРАЗОВАНИЙ ==========");
        System.out.println("┌───────────────────┬─────────────────────────────────────────────────┐");
        System.out.println("│ Из → В            │ Способ преобразования                          │");
        System.out.println("├───────────────────┼─────────────────────────────────────────────────┤");
        System.out.println("│ String → StringBuilder │ new StringBuilder(str)                    │");
        System.out.println("│ String → StringBuffer  │ new StringBuffer(str)                     │");
        System.out.println("│ StringBuilder → String │ sb.toString()                             │");
        System.out.println("│ StringBuffer → String  │ sbf.toString()                            │");
        System.out.println("│ StringBuilder → StringBuffer │ new StringBuffer(sb.toString())    │");
        System.out.println("│ StringBuffer → StringBuilder │ new StringBuilder(sbf.toString())  │");
        System.out.println("└───────────────────┴─────────────────────────────────────────────────┘");

        // ========== ДЕМОНСТРАЦИЯ ВСЕХ ПРЕОБРАЗОВАНИЙ В ЦИКЛЕ ==========
        System.out.println("\n========== ПОЛНЫЙ ПРИМЕР ==========");

        // Исходная строка
        String original = "Java 21";
        System.out.println("Исходная строка: \"" + original + "\"\n");

        // String → StringBuilder → String
        StringBuilder sb4 = new StringBuilder(original);
        String str1 = sb4.toString();
        System.out.println("String → StringBuilder → String: " + str1);

        // String → StringBuffer → String
        StringBuffer sbf4 = new StringBuffer(original);
        String str2 = sbf4.toString();
        System.out.println("String → StringBuffer → String: " + str2);

        // String → StringBuilder → StringBuffer → String
        StringBuilder sb5 = new StringBuilder(original);
        StringBuffer sbf5 = new StringBuffer(sb5.toString());
        String str3 = sbf5.toString();
        System.out.println("String → StringBuilder → StringBuffer → String: " + str3);

        // ========== ПРАКТИЧЕСКОЕ ПРИМЕНЕНИЕ ==========
        System.out.println("\n========== ПРАКТИЧЕСКОЕ ПРИМЕНЕНИЕ ==========");

        // Когда использовать преобразования
        System.out.println("\n1. String → StringBuilder (для многократных изменений):");
        String text = "Start";
        StringBuilder builder = new StringBuilder(text);
        for (int i = 0; i < 5; i++) {
            builder.append(" ").append(i);
        }
        System.out.println("   Результат: " + builder);

        System.out.println("\n2. StringBuilder → String (для финального результата):");
        String result = builder.toString();
        System.out.println("   Финальная строка: \"" + result + "\"");

        System.out.println("\n3. Сравнение производительности:");
        long start, end;

        // String конкатенация (медленно)
        String s = "";
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            s += "a";
        }
        end = System.nanoTime();
        System.out.println("   String конкатенация: " + (end - start) / 1_000_000 + " ms");

        // StringBuilder (быстро)
        StringBuilder sb6 = new StringBuilder();
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            sb6.append("a");
        }
        end = System.nanoTime();
        System.out.println("   StringBuilder.append: " + (end - start) / 1_000_000 + " ms");
    }
}