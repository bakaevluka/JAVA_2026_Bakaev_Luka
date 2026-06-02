class BreakContinueExample {
    public static void main(String[] args) {

        System.out.println("========== 1. break в цикле while ==========");
        // break - полностью выходит из цикла
        int i = 1;
        while(i <= 10) {
            if(i == 5) {
                System.out.println("break при i = " + i + " → выход из цикла");
                break;  // выход из цикла при i == 5
            }
            System.out.println("i = " + i);
            i++;
        }

        System.out.println("\n========== 2. continue в цикле while ==========");
        // continue - пропускает текущую итерацию, переходит к следующей
        int j = 0;
        while(j < 10) {
            j++;
            if(j % 2 == 0) {
                continue;  // пропускаем четные числа
            }
            System.out.println("Нечетное число: " + j);
        }

        System.out.println("\n========== 3. break в цикле do-while ==========");
        int k = 1;
        do {
            if(k == 3) {
                System.out.println("break при k = " + k);
                break;
            }
            System.out.println("k = " + k);
            k++;
        } while(k <= 5);

        System.out.println("\n========== 4. continue в цикле do-while ==========");
        int m = 0;
        do {
            m++;
            if(m == 5) {
                continue;  // пропускаем 5
            }
            System.out.println("m = " + m);
        } while(m < 8);

        System.out.println("\n========== 5. break в цикле for ==========");
        for(int n = 1; n <= 10; n++) {
            if(n > 7) {
                System.out.println("break при n = " + n);
                break;
            }
            System.out.println("n = " + n);
        }

        System.out.println("\n========== 6. continue в цикле for ==========");
        for(int n = 1; n <= 10; n++) {
            if(n % 3 == 0) {
                System.out.println("continue для n = " + n + " (пропускаем)");
                continue;
            }
            System.out.println("n = " + n);
        }

        System.out.println("\n========== 7. break в бесконечном цикле ==========");
        int counter = 0;
        while(true) {
            counter++;
            System.out.println("Итерация " + counter);
            if(counter >= 5) {
                System.out.println("Выход из бесконечного цикла через break");
                break;
            }
        }

        System.out.println("\n========== 8. continue + break вместе ==========");
        for(int num = 1; num <= 20; num++) {
            if(num < 10) {
                continue;  // пропускаем числа меньше 10
            }
            if(num > 15) {
                System.out.println("break при num = " + num);
                break;     // выходим при числе больше 15
            }
            System.out.println("num = " + num);
        }
    }
}