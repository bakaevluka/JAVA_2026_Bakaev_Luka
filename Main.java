import java.util.ArrayList;
import java.util.HashMap;

class TypeInferenceExample {
    public static void main(String[] args) {
        // Базовые типы
        var number = 42;        // int
        var pi = 3.14159;       // double
        var letter = 'A';       // char
        var name = "Лука";      // String
        var flag = true;        // boolean

        System.out.println("number: " + number);
        System.out.println("pi: " + pi);

        // Коллекции
        var list = new ArrayList<String>();  // ArrayList<String>
        list.add("Java");
        list.add("Python");

        var map = new HashMap<Integer, String>(); // HashMap<Integer, String>
        map.put(1, "один");

        // Циклы
        for (var item : list) {  // String item
            System.out.println(item);
        }

        // var НЕЛЬЗЯ использовать для:
        // var x; - обязательна инициализация
        // var nullVar = null; - тип не определен
        // var[] array; - для массивов

        // var с анонимными классами
        var obj = new Object() {
            String message = "Hello";
        };
        System.out.println(obj.message);
    }
}