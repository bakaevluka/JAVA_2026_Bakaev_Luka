class IntegerCacheExample {
    public static void main(String[] args) {

        System.out.println("========== Код для 128 (ВНЕ кеша) ==========");

        int i1 = 128;
        Integer a1 = i1;  // автоупаковка: создается НОВЫЙ объект Integer
        Integer b1 = i1;  // автоупаковка: создается ДРУГОЙ объект Integer

        System.out.println("a1==i1 " + (a1 == i1));      // true (unboxing a1, сравнение примитивов)
        System.out.println("b1==i1 " + (b1 == i1));      // true (unboxing b1, сравнение примитивов)
        System.out.println("a1==b1 " + (a1 == b1));      // false (разные объекты!)
        System.out.println("a1.equals(i1) -> " + a1.equals(i1));  // true (сравнение по значению)
        System.out.println("b1.equals(i1) -> " + b1.equals(i1));  // true
        System.out.println("a1.equals(b1) -> " + a1.equals(b1));  // true (значения равны)

        System.out.println("\n========== Код для 127 (ВНУТРИ кеша) ==========");

        int i2 = 127;
        Integer a2 = i2;  // автоупаковка: берется ИЗ КЕША
        Integer b2 = i2;  // автоупаковка: берется ТОТ ЖЕ объект из кеша

        System.out.println("a2==i2 " + (a2 == i2));      // true (unboxing)
        System.out.println("b2==i2 " + (b2 == i2));      // true (unboxing)
        System.out.println("a2==b2 " + (a2 == b2));      // true (один объект из кеша!)
        System.out.println("a2.equals(i2) -> " + a2.equals(i2));  // true
        System.out.println("b2.equals(i2) -> " + b2.equals(i2));  // true
        System.out.println("a2.equals(b2) -> " + a2.equals(b2));  // true
    }
}