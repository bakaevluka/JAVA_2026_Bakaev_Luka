class NarrowingExample {
    public static void main(String[] args) {
        // int -> byte
        int bigInt = 300;
        byte smallByte = (byte) bigInt;
        System.out.println("300 в byte: " + smallByte); // 44 (из-за переполнения)

        // double -> int
        double pi = 3.14159;
        int intPart = (int) pi;
        System.out.println("3.14159 в int: " + intPart); // 3 (дробная часть отброшена)

        // long -> short
        long largeLong = 100000L;
        short smallShort = (short) largeLong;
        System.out.println("100000 в short: " + smallShort); // -31072 (переполнение)

        // int -> char
        int code = 65;
        char symbol = (char) code;
        System.out.println("65 в char: " + symbol); // 'A'

        // double -> float (потеря точности)
        double precise = 1.23456789012345;
        float approx = (float) precise;
        System.out.println("double " + precise + " -> float " + approx);

        // char -> byte
        char letter = 'Я';
        byte byteFromChar = (byte) letter;
        System.out.println("'Я' в byte: " + byteFromChar); // отрицательное число
    }
}