class ArrayAssignmentExample {
    public static void main(String[] args) {

        System.out.println("========== Результат выполнения кода ==========");

        int a1[] = {1, 2, 3, 4, 5};
        int a2[] = {6, 7, 8, 9, 10};

        System.out.print("Исходный a1: ");
        for (int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("Исходный a2: ");
        for (int i : a2) {
            System.out.print(i + " ");
        }
        System.out.println();

        a1 = a2;  // операция присваивания

        System.out.println("\nПосле выполнения a1 = a2:");
        System.out.print("a1 теперь указывает на: ");
        for (int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("a2 указывает на: ");
        for (int i : a2) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\n========== Объяснение ==========");
        System.out.println("1. a1 и a2 - это ссылки на массивы в памяти");
        System.out.println("2. a1 = a2 - копирует ссылку, а не массив");
        System.out.println("3. После присваивания a1 указывает на тот же массив, что и a2");
        System.out.println("4. Исходный массив {1,2,3,4,5} теряет ссылку и становится доступен для GC");

        // Демонстрация, что теперь a1 и a2 ссылаются на один и тот же массив
        System.out.println("\n========== Доказательство ==========");
        a2[0] = 100;  // меняем элемент через a2
        System.out.println("После изменения a2[0] = 100:");
        System.out.print("a1: ");
        for (int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Проверка ссылок
        System.out.println("\na1 == a2: " + (a1 == a2));  // true - одна и та же ссылка
    }
}