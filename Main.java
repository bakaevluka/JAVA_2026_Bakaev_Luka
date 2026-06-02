class TernaryExample {
    public static void main(String[] args) {

        System.out.println("========== Преобразование if-else в тернарный оператор ==========");

        // Тестируем для разных значений a
        for (int a = 0; a <= 3; a++) {

            // Исходная конструкция if-else
            int i1;
            if (a == 1) {
                i1 = 1;
            } else if (a == 2) {
                i1 = 2;
            } else {
                i1 = 3;
            }

            // Та же логика через тернарный оператор
            int i2 = (a == 1) ? 1 : (a == 2) ? 2 : 3;

            System.out.println("a = " + a + " → i = " + i1 + " (тернарный: " + i2 + ")");
        }

        System.out.println("\n========== Разбор конструкции ==========");
        System.out.println("int i = (a == 1) ? 1 : (a == 2) ? 2 : 3;");
        System.out.println();
        System.out.println("Если a == 1, то i = 1");
        System.out.println("Иначе если a == 2, то i = 2");
        System.out.println("Иначе i = 3");

        System.out.println("\n========== Варианты записи ==========");

        int a = 1;

        // Вариант 1: без скобок (работает, но менее читаемо)
        int result1 = a == 1 ? 1 : a == 2 ? 2 : 3;
        System.out.println("Без скобок: " + result1);

        // Вариант 2: со скобками (рекомендуется для читаемости)
        int result2 = (a == 1) ? 1 : (a == 2) ? 2 : 3;
        System.out.println("Со скобками: " + result2);

        // Вариант 3: полные скобки для вложенного тернарника
        int result3 = (a == 1) ? 1 : ((a == 2) ? 2 : 3);
        System.out.println("Полные скобки: " + result3);
    }
}