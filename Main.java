import java.util.Arrays;

class ArraysExample {
    public static void main(String[] args) {

        System.out.println("========== 1. toString() - преобразование массива в строку ==========");
        int[] numbers = {5, 2, 8, 1, 9, 3};
        String str = Arrays.toString(numbers);
        System.out.println("Arrays.toString(numbers) = " + str);

        // для многомерных массивов используется deepToString()
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println("Arrays.deepToString(matrix) = " + Arrays.deepToString(matrix));

        System.out.println("\n========== 2. sort() - сортировка массива ==========");
        int[] toSort = {5, 2, 8, 1, 9, 3};
        System.out.println("До сортировки: " + Arrays.toString(toSort));
        Arrays.sort(toSort);
        System.out.println("После сортировки: " + Arrays.toString(toSort));

        // сортировка части массива
        int[] partialSort = {5, 2, 8, 1, 9, 3};
        Arrays.sort(partialSort, 1, 4);  // сортируем индексы 1,2,3
        System.out.println("Сортировка с 1 по 4 индекс: " + Arrays.toString(partialSort));

        System.out.println("\n========== 3. binarySearch() - бинарный поиск ==========");
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = Arrays.binarySearch(sortedArray, 7);
        System.out.println("Массив: " + Arrays.toString(sortedArray));
        System.out.println("Поиск числа 7: индекс = " + index);

        // поиск несуществующего элемента
        int notFound = Arrays.binarySearch(sortedArray, 15);
        System.out.println("Поиск числа 15: индекс = " + notFound);  // отрицательное значение

        System.out.println("\n========== 4. equals() - сравнение массивов ==========");
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {1, 2, 3, 4, 6};

        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("arr3: " + Arrays.toString(arr3));
        System.out.println("Arrays.equals(arr1, arr2) = " + Arrays.equals(arr1, arr2));  // true
        System.out.println("Arrays.equals(arr1, arr3) = " + Arrays.equals(arr1, arr3));  // false

        // для многомерных массивов
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        System.out.println("Arrays.deepEquals(matrix1, matrix2) = " + Arrays.deepEquals(matrix1, matrix2));

        System.out.println("\n========== 5. compare() - лексикографическое сравнение (Java 9+) ==========");
        int[] cmp1 = {1, 2, 3};
        int[] cmp2 = {1, 2, 3};
        int[] cmp3 = {1, 2, 4};
        int[] cmp4 = {1, 2};

        System.out.println("cmp1: " + Arrays.toString(cmp1));
        System.out.println("cmp2: " + Arrays.toString(cmp2));
        System.out.println("cmp3: " + Arrays.toString(cmp3));
        System.out.println("cmp4: " + Arrays.toString(cmp4));
        System.out.println("Arrays.compare(cmp1, cmp2) = " + Arrays.compare(cmp1, cmp2));  // 0 (равны)
        System.out.println("Arrays.compare(cmp1, cmp3) = " + Arrays.compare(cmp1, cmp3));  // -1 (cmp1 < cmp3)
        System.out.println("Arrays.compare(cmp3, cmp1) = " + Arrays.compare(cmp3, cmp1));  // 1 (cmp3 > cmp1)
        System.out.println("Arrays.compare(cmp1, cmp4) = " + Arrays.compare(cmp1, cmp4));  // 1 (cmp1 длиннее)

        System.out.println("\n========== Дополнительные методы ==========");

        // fill() - заполнение массива
        int[] filled = new int[5];
        Arrays.fill(filled, 42);
        System.out.println("Arrays.fill(массив, 42): " + Arrays.toString(filled));

        // copyOf() - копирование массива
        int[] original = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(original, 3);
        System.out.println("copyOf(original, 3): " + Arrays.toString(copy));

        // copyOfRange() - копирование диапазона
        int[] range = Arrays.copyOfRange(original, 1, 4);
        System.out.println("copyOfRange(original, 1, 4): " + Arrays.toString(range));
    }
}