class BooleanCreationExample {
    public static void main(String[] args) {

        System.out.println("========== Все способы создания Boolean ==========");

        // 1. valueOf(boolean) - статический метод
        Boolean b1 = Boolean.valueOf(true);
        Boolean b2 = Boolean.valueOf(false);
        System.out.println("1. Boolean.valueOf(true) = " + b1);
        System.out.println("   Boolean.valueOf(false) = " + b2);

        // 2. valueOf(String) - строка сравнивается с "true" (без учета регистра)
        Boolean b3 = Boolean.valueOf("true");
        Boolean b4 = Boolean.valueOf("TRUE");
        Boolean b5 = Boolean.valueOf("True");
        Boolean b6 = Boolean.valueOf("false");
        Boolean b7 = Boolean.valueOf("FALSE");
        Boolean b8 = Boolean.valueOf("any other string");
        System.out.println("2. Boolean.valueOf(\"true\") = " + b3);
        System.out.println("   Boolean.valueOf(\"TRUE\") = " + b4);
        System.out.println("   Boolean.valueOf(\"True\") = " + b5);
        System.out.println("   Boolean.valueOf(\"false\") = " + b6);
        System.out.println("   Boolean.valueOf(\"FALSE\") = " + b7);
        System.out.println("   Boolean.valueOf(\"any\") = " + b8);  // false

        // 3. parseBoolean(String) - возвращает примитив boolean
        boolean primitive = Boolean.parseBoolean("true");
        Boolean b9 = Boolean.valueOf(primitive);
        System.out.println("3. Boolean.parseBoolean(\"true\") = " + primitive);
        System.out.println("   затем Boolean.valueOf() = " + b9);

        // 4. Автоупаковка (boxing)
        Boolean b10 = true;   // автоматически Boolean.valueOf(true)
        Boolean b11 = false;
        System.out.println("4. Автоупаковка: Boolean b10 = true -> " + b10);

        // 5. Константы Boolean.TRUE и Boolean.FALSE (кешированные экземпляры)
        Boolean b12 = Boolean.TRUE;
        Boolean b13 = Boolean.FALSE;
        System.out.println("5. Boolean.TRUE = " + b12);
        System.out.println("   Boolean.FALSE = " + b13);

        // 6. getBoolean(String) - читает системное свойство
        System.setProperty("my.property", "true");
        Boolean b14 = Boolean.getBoolean("my.property");
        System.out.println("6. Boolean.getBoolean(\"my.property\") = " + b14);

        System.out.println("\n========== Демонстрация кеширования ==========");
        // valueOf использует кешированные экземпляры TRUE и FALSE
        Boolean x1 = Boolean.valueOf(true);
        Boolean x2 = Boolean.valueOf(true);
        System.out.println("x1 == x2: " + (x1 == x2));  // true - один объект!

        Boolean y1 = true;  // автоупаковка использует valueOf
        Boolean y2 = true;
        System.out.println("y1 == y2: " + (y1 == y2));  // true - тоже кеш
    }
}