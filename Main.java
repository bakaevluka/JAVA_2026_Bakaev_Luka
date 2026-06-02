import java.util.ArrayList;
import java.util.List;

class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

class StringBox extends Box<String> {
    // конкретный подкласс
}

class Main {
    public static void main(String[] args) {

        System.out.println("========== instanceof с generic-классами ==========\n");

        Box<String> stringBox = new Box<>();
        Box<Integer> integerBox = new Box<>();
        Box rawBox = new Box();  // raw type

        // ✅ РАБОТАЕТ: проверка на raw type
        System.out.println("stringBox instanceof Box: " + (stringBox instanceof Box));
        System.out.println("integerBox instanceof Box: " + (integerBox instanceof Box));

        // НЕ РАБОТАЕТ: нельзя проверять конкретный generic-тип
        // System.out.println(stringBox instanceof Box<String>);  // ОШИБКА компиляции!
        // System.out.println(integerBox instanceof Box<Integer>); // ОШИБКА компиляции!

        // ✅ РАБОТАЕТ: проверка на подкласс с конкретным типом
        StringBox sb = new StringBox();
        System.out.println("sb instanceof StringBox: " + (sb instanceof StringBox));
        System.out.println("sb instanceof Box: " + (sb instanceof Box));

        System.out.println("\n========== instanceof с wildcard ==========\n");

        // ✅ РАБОТАЕТ: через wildcard
        System.out.println("stringBox instanceof Box<?>: " + (stringBox instanceof Box<?>));
        System.out.println("integerBox instanceof Box<?>: " + (integerBox instanceof Box<?>));

        System.out.println("\n========== instanceof с коллекциями ==========\n");

        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        // ✅ РАБОТАЕТ: raw type
        System.out.println("stringList instanceof List: " + (stringList instanceof List));

        // НЕ РАБОТАЕТ: конкретный generic-тип
        // System.out.println(stringList instanceof List<String>); // ОШИБКА!

        // ✅ РАБОТАЕТ: wildcard
        System.out.println("stringList instanceof List<?>: " + (stringList instanceof List<?>));
    }
}