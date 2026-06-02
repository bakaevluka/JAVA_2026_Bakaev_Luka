class A {
    public void printNum(Integer i) {
        System.out.println("  → Выбран метод printNum(Integer): значение = " + i);
    }
    public void printNum(int i) {
        System.out.println("  → Выбран метод printNum(int): значение = " + i);
    }
    public void printNum(Float f) {
        System.out.println("  → Выбран метод printNum(Float): значение = " + f);
    }
    public void printNum(Number n) {
        System.out.println("  → Выбран метод printNum(Number): значение = " + n);
    }
}

class Main {
    public static void main(String[] args) {
        A a = new A();
        Number[] num = {new Integer(1), 11, 1.11f, 11.11 };

        System.out.println("========== (1) цикл for ==========");
        System.out.println("Тип переменной n в цикле: Number");
        for (Number n : num) {
            System.out.print("n = " + n + " (реальный тип: " + n.getClass().getSimpleName() + ") → ");
            a.printNum(n);
        }

        System.out.println("\n========== (2) прямые вызовы ==========");
        System.out.println("new Integer(1) → тип Integer → ");
        a.printNum(new Integer(1));

        System.out.println("11 → тип int → ");
        a.printNum(11);

        System.out.println("1.11f → тип float (автоупаковка в Float) → ");
        a.printNum(1.11f);

        System.out.println("11.11 → тип double → ");
        a.printNum(11.11);
    }
}