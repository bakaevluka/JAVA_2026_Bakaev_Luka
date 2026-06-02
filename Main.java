class DecodeExample {
    public static void main(String[] args) {

        System.out.println("========== decode() примеры ==========");

        // десятичное число (обычное)
        Integer dec1 = Integer.decode("123");
        System.out.println("decode(\"123\") = " + dec1);  // 123

        // десятичное число со знаком +
        Integer dec2 = Integer.decode("+456");
        System.out.println("decode(\"+456\") = " + dec2);  // 456

        // десятичное число со знаком -
        Integer dec3 = Integer.decode("-789");
        System.out.println("decode(\"-789\") = " + dec3);  // -789

        // восьмеричное число (начинается с 0)
        Integer oct1 = Integer.decode("012");
        System.out.println("decode(\"012\") = " + oct1);   // 10 (8+2)

        Integer oct2 = Integer.decode("077");
        System.out.println("decode(\"077\") = " + oct2);   // 63 (7*8+7)

        // шестнадцатеричное число (начинается с 0x или 0X)
        Integer hex1 = Integer.decode("0xFF");
        System.out.println("decode(\"0xFF\") = " + hex1);   // 255

        Integer hex2 = Integer.decode("0X10");
        System.out.println("decode(\"0X10\") = " + hex2);   // 16

        Integer hex3 = Integer.decode("#1A");
        System.out.println("decode(\"#1A\") = " + hex3);    // 26

        Integer hex4 = Integer.decode("-0x0A");
        System.out.println("decode(\"-0x0A\") = " + hex4);  // -10

        // decode для других типов
        Long longVal = Long.decode("0x7FFFFFFFFFFFFFFF");
        System.out.println("Long.decode(\"0x7FFFFFFFFFFFFFFF\") = " + longVal);

        Byte byteVal = Byte.decode("0x7F");
        System.out.println("Byte.decode(\"0x7F\") = " + byteVal);


        Short shortVal = Short.decode("0x7FFF");  // 32767 - максимальное значение Short
        System.out.println("Short.decode(\"0x7FFF\") = " + shortVal);

        // или другое допустимое значение
        Short shortVal2 = Short.decode("0x10");   // 16
        System.out.println("Short.decode(\"0x10\") = " + shortVal2);

        Short shortVal3 = Short.decode("-0x8000"); // -32768 - минимальное значение Short
        System.out.println("Short.decode(\"-0x8000\") = " + shortVal3);

        // ошибка при неправильном формате
        try {
            Integer invalid = Integer.decode("12A");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат числа");
        }

        System.out.println("\n========== Диапазоны значений ==========");
        System.out.println("Byte: от -128 до 127");
        System.out.println("Short: от -32768 до 32767");
        System.out.println("Integer: от -2147483648 до 2147483647");
        System.out.println("Long: от -9223372036854775808 до 9223372036854775807");
    }
}