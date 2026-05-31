class TypePromotionExample {
    public static void main(String[] args) {

        // 1. byte + int = int
        byte b = 10;
        int i = 20;
        int result1 = b + i;
        System.out.println("byte (10) + int (20) = " + result1);
        // Объяснение: byte (8 бит) автоматически расширяется до int (32 бита)
        // Результат: int (больший тип)
        // 2. int + long = long
        int x = 100;
        long y = 200L;
        long result2 = x + y;
        System.out.println("int (100) + long (200) = " + result2);
        // Объяснение: int (32 бита) расширяется до long (64 бита)
        // Результат: long (больший тип)

        // 3. long + float = float
        long l = 1000L;
        float f = 3.14f;
        float result3 = l + f;
        System.out.println("long (1000) + float (3.14) = " + result3); // 1003.14
        // Объяснение: long (64 бита, целочисленный) расширяется до float (32 бита, дробный)
        // float может представить больший диапазон значений, чем long
        // Результат: float (несмотря на меньший размер, дробный тип считается "больше")

        // 4. int + float = float
        int a = 42;
        float result4 = a + 2.5f;
        System.out.println("int (42) + float (2.5) = " + result4); // 44.5
        // Объяснение: int расширяется до float
        // Результат: float (дробный тип имеет приоритет над целочисленным)

        // 5. float + double = double
        float fl = 1.5f;
        double d = 2.5;
        double result5 = fl + d;
        System.out.println("float (1.5) + double (2.5) = " + result5); // 4.0
        // Объяснение: float (32 бита) расширяется до double (64 бита)
        // Результат: double (больший и более точный дробный тип)

        // 6. byte + byte = int (особенность Java!)
        byte b1 = 50;
        byte b2 = 50;
        int result6 = b1 + b2;
        System.out.println("byte (50) + byte (50) = " + result6); // 100
        // Объяснение: Java автоматически расширяет byte до int перед операцией
        // Это сделано для предотвращения переполнения (byte имеет диапазон -128..127)
        // Результат: int, НЕ byte!

        // 7. char + int = int
        char ch = 'A'; // код 65
        int num = 1;
        int result7 = ch + num;
        System.out.println("char ('A'=65) + int (1) = " + result7); // 66
        // Объяснение: char расширяется до int (берется его Unicode-код)
        // Результат: int

        // 8. short + short = int
        short s1 = 10000;
        short s2 = 20000;
        int result8 = s1 + s2;
        System.out.println("short (10000) + short (20000) = " + result8); // 30000
        // Объяснение: short расширяется до int перед сложением
        // Результат: int

        // 9. byte + char = int
        byte bt = 10;
        char cr = 'B'; // код 66
        int result9 = bt + cr;
        System.out.println("byte (10) + char ('B'=66) = " + result9); // 76
        // Объяснение: оба типа расширяются до int
        // Результат: int
    }
}