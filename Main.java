class VarargsOverloadExample {

    // 1. Метод для суммирования целых чисел
    public int sum(int... numbers) {
        System.out.print("sum(int... numbers) -> ");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // 2. Перегрузка: метод для суммирования чисел с плавающей точкой
    public double sum(double... numbers) {
        System.out.print("sum(double... numbers) -> ");
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    // 3. Перегрузка: метод для конкатенации строк
    public String sum(String... strings) {
        System.out.print("sum(String... strings) -> ");
        StringBuilder result = new StringBuilder();
        for (String s : strings) {
            result.append(s);
        }
        return result.toString();
    }

    // 4. Перегрузка: метод с умножением (изменено название, чтобы избежать конфликта)
    public int sumWithMultiplier(int multiplier, int... numbers) {
        System.out.print("sumWithMultiplier(int multiplier, int... numbers) -> ");
        int sum = 0;
        for (int num : numbers) {
            sum += num * multiplier;
        }
        return sum;
    }

    // 5. Перегрузка: метод с разными типами параметров + varargs
    public void print(String prefix, Object... items) {
        System.out.print("print(String prefix, Object... items) -> ");
        System.out.print(prefix + ": ");
        for (Object item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // 6. Перегрузка: только varargs
    public void print(Object... items) {
        System.out.print("print(Object... items) -> ");
        for (Object item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Демонстрация работы
    public static void main(String[] args) {
        VarargsOverloadExample obj = new VarargsOverloadExample();

        System.out.println("========== ПЕРЕГРУЗКА VARARGS ==========\n");

        System.out.println("1. " + obj.sum(1, 2, 3, 4, 5));
        System.out.println("2. " + obj.sum(1.5, 2.5, 3.5));
        System.out.println("3. " + obj.sum("Привет", ", ", "Мир", "!"));
        System.out.println("4. " + obj.sumWithMultiplier(10, 1, 2, 3));  // 10*1 + 10*2 + 10*3 = 60
        System.out.print("5. ");
        obj.print("Результат", 1, 2, 3, "четыре", 5.5);
        System.out.print("6. ");
        obj.print(1, 2, 3, "разные", 4.5, "типы");
    }
}