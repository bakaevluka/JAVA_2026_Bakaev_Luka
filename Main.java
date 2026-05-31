 class TypesExample {
    // Члены класса (автоматически получают нулевые значения)
    byte byteDefault;
    short shortDefault;
    int intDefault;
    long longDefault;
    float floatDefault;
    double doubleDefault;
    char charDefault;
    boolean booleanDefault;

    public static void main(String[] args) {
        // Локальные переменные (должны быть инициализированы)
        byte byteVar = 127;
        short shortVar = 32767;
        int intVar = 2_000_000_000;
        long longVar = 9_223_372_036_854_775_807L;
        float floatVar = 3.14f;
        double doubleVar = 3.141592653589793;
        char charVar = 'A';
        boolean booleanVar = true;

        // Вывод значений
        System.out.println("byte: " + byteVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);
        System.out.println("char: " + charVar);
        System.out.println("boolean: " + booleanVar);

        // Демонстрация нулевых значений для членов класса
        TypesExample example = new TypesExample();
        System.out.println("\nНулевые значения членов класса:");
        System.out.println("byte: " + example.byteDefault);
        System.out.println("short: " + example.shortDefault);
        System.out.println("int: " + example.intDefault);
        System.out.println("long: " + example.longDefault);
        System.out.println("float: " + example.floatDefault);
        System.out.println("double: " + example.doubleDefault);
        System.out.println("char: [" + example.charDefault + "] (код 0)");
        System.out.println("boolean: " + example.booleanDefault);
    }
}