/**
 * Перегруженные методы - одинаковое имя, разные параметры
 */
class Calculator {

    // Перегрузка: разные типы параметров
    public int add(int a, int b) {
        System.out.print("add(int, int) -> ");
        return a + b;
    }

    public double add(double a, double b) {
        System.out.print("add(double, double) -> ");
        return a + b;
    }

    // Перегрузка: разное количество параметров
    public int add(int a, int b, int c) {
        System.out.print("add(int, int, int) -> ");
        return a + b + c;
    }

    // Перегрузка: разный порядок параметров
    public String add(String a, int b) {
        System.out.print("add(String, int) -> ");
        return a + b;
    }

    public String add(int a, String b) {
        System.out.print("add(int, String) -> ");
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("========== ПЕРЕГРУЖЕННЫЕ МЕТОДЫ ==========\n");
        System.out.println(calc.add(5, 10));
        System.out.println(calc.add(2.5, 3.7));
        System.out.println(calc.add(1, 2, 3));
        System.out.println(calc.add("Результат: ", 42));
        System.out.println(calc.add(100, " рублей"));
    }
}