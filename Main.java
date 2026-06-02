class InfiniteLoopsExample {
    public static void main(String[] args) {

        System.out.println("========== Бесконечный цикл while ==========");
        System.out.println("Вариант 1: условие всегда true");
        /*
        int i = 0;
        while(true) {
            System.out.println("Бесконечный цикл: " + i++);
        }
        */

        System.out.println("Вариант 2: условие никогда не станет false");
        /*
        int i = 1;
        while(i > 0) {
            System.out.println("i = " + i);
            i++;  // i всегда увеличивается, никогда не станет <= 0
        }
        */

        System.out.println("Вариант 3: условие не меняется");
        /*
        int i = 5;
        while(i != 0) {
            System.out.println("i = " + i);
            // нет изменения i, условие всегда true
        }
        */

        System.out.println("\n========== Бесконечный цикл do-while ==========");
        System.out.println("Вариант 1: условие всегда true");
        /*
        int j = 0;
        do {
            System.out.println("Бесконечный цикл: " + j++);
        } while(true);
        */

        System.out.println("Вариант 2: условие никогда не станет false");
        /*
        int j = 1;
        do {
            System.out.println("j = " + j);
            j++;
        } while(j > 0);  // j всегда положительное
        */

        System.out.println("\n========== Самые простые примеры ==========");
        System.out.println("while(true) { }");
        System.out.println("do { } while(true);");
        System.out.println("while(1 == 1) { }");
        System.out.println("do { } while(1 == 1);");

        System.out.println("\n========== Демонстрация (без реального выполнения) ==========");
        System.out.println("Чтобы остановить бесконечный цикл, используют break:");

        // Пример с безопасным выходом
        int counter = 0;
        while(true) {
            System.out.println("Итерация " + counter);
            counter++;
            if(counter >= 5) {
                System.out.println("Выход из цикла через break");
                break;  // выход из бесконечного цикла
            }
        }

        counter = 0;
        do {
            System.out.println("do-while итерация " + counter);
            counter++;
            if(counter >= 5) {
                System.out.println("Выход из do-while через break");
                break;
            }
        } while(true);
    }
}