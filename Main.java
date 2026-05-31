class StringConcatExample {
    public static void main(String[] args) {
        String str = "Результат: ";

        // String + базовый тип
        int number = 42;
        String result1 = str + number;
        System.out.println(result1); // "Результат: 42"

        // String + другой String
        String name = "Лука";
        String result2 = "Привет, " + name + "!";
        System.out.println(result2); // "Привет, Лука!"

        // String + объект
        Object obj = new Object();
        String result3 = "Объект: " + obj;
        System.out.println(result3);

        // Смешанные операции
        int a = 10;
        int b = 20;
        String result4 = "Сумма: " + a + b;   // Сначала конкатенация!
        System.out.println(result4); // "Сумма: 1020"

        String result5 = "Сумма: " + (a + b); // Сначала сложение!
        System.out.println(result5); // "Сумма: 30"

        // boolean со String
        boolean flag = true;
        System.out.println("Флаг: " + flag); // "Флаг: true"

        // char со String
        char symbol = '$';
        System.out.println("Символ: " + symbol); // "Символ: $"
    }
}