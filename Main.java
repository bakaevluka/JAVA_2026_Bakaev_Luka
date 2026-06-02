import java.lang.annotation.*;
import java.lang.reflect.Method;

// 1. АННОТАЦИЯ @Override
// Назначение: Проверяет, что метод действительно переопределяет метод суперкласса.
// Если метод не переопределяет (опечатка, неправильные параметры), компилятор выдаст ошибку.

class Parent {
    public void sayHello() {
        System.out.println("Hello from Parent");
    }

    public void doSomething() {
        System.out.println("Parent doing something");
    }
}

class Child extends Parent {

    // ✅ ПРАВИЛЬНО: метод действительно переопределяет метод родителя
    @Override
    public void sayHello() {
        System.out.println("Hello from Child");
    }

    // ❌ Если раскомментировать - ОШИБКА! Нет такого метода в Parent
    // @Override
    // public void sayHelloo() {  // опечатка в названии
    //     System.out.println("This will cause error");
    // }

    // ❌ Если раскомментировать - ОШИБКА! Другие параметры
    // @Override
    // public void sayHello(String name) {  // другой параметр
    //     System.out.println("Hello " + name);
    // }
}

// 2. АННОТАЦИЯ @Deprecated
// Назначение: Помечает элемент (класс, метод, поле) как устаревший.
// Компилятор выдает предупреждение при использовании такого элемента.

class OldClass {

    @Deprecated
    public void oldMethod() {
        System.out.println("Этот метод устарел, используйте новый метод!");
    }

    public void newMethod() {
        System.out.println("Новый метод - используйте этот!");
    }

    @Deprecated
    public static final int OLD_CONSTANT = 100;
}

// 3. АННОТАЦИЯ @SuppressWarnings
// Назначение: Подавляет предупреждения компилятора.

class WarningSuppressor {

    @SuppressWarnings("unused")
    public void suppressUnusedWarning() {
        int unusedVariable = 10;  // без аннотации было бы предупреждение "never used"
        String anotherUnused = "test";
        System.out.println("Предупреждение о неиспользуемых переменных подавлено");
    }

    @SuppressWarnings({"unused", "deprecation"})
    public void suppressMultipleWarnings() {
        int x = 5;  // unused
        OldClass old = new OldClass();
        old.oldMethod();  // deprecation warning
        System.out.println("Несколько предупреждений подавлено");
    }

    @SuppressWarnings("all")
    public void suppressAllWarnings() {
        int a = 1;
        int b = 2;
        String s = "test";
        OldClass old = new OldClass();
        old.oldMethod();
        System.out.println("Все предупреждения подавлены");
    }
}

/**
 * ============================================================
 * СОЗДАНИЕ СОБСТВЕННОЙ АННОТАЦИИ
 * ============================================================
 */

// АННОТАЦИЯ @Target - указывает, где можно использовать нашу аннотацию
// ElementType.TYPE - для классов, интерфейсов, enum
// ElementType.METHOD - для методов
// ElementType.FIELD - для полей
// ElementType.PARAMETER - для параметров
// и другие

@Target(ElementType.TYPE)  // аннотацию можно применять только к классам/интерфейсам
@Retention(RetentionPolicy.RUNTIME)  // аннотация будет доступна во время выполнения
@interface BaseAction {
    int level();           // обязательный параметр
    String description() default "Нет описания";  // параметр со значением по умолчанию
}

// АННОТАЦИЯ для методов
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface ActionInfo {
    String name();
    int priority() default 1;
}

// АННОТАЦИЯ для полей
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantField {
    boolean required() default true;
}

// АННОТАЦИЯ с несколькими целями
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@interface Loggable {
    String value() default "";
}

// ИСПОЛЬЗОВАНИЕ созданных аннотаций
@BaseAction(level = 2, description = "Это основной класс приложения")
class MyApplication {

    @ImportantField(required = true)
    private String appName;

    @ActionInfo(name = "start", priority = 10)
    public void start() {
        System.out.println("Приложение запущено");
    }

    @ActionInfo(name = "stop")
    public void stop() {
        System.out.println("Приложение остановлено");
    }

    @Loggable("Загрузка данных")
    public void loadData() {
        System.out.println("Данные загружены");
    }
}

/**
 * ============================================================
 * ДОСТУП К АННОТАЦИЯМ ЧЕРЕЗ РЕФЛЕКСИЮ
 * ============================================================
 */

class AnnotationReflectionExample {

    public static void main(String[] args) {

        System.out.println("========== ДЕМОНСТРАЦИЯ ВСТРОЕННЫХ АННОТАЦИЙ ==========\n");

        // Демонстрация @Override
        Child child = new Child();
        child.sayHello();  // Вызов переопределенного метода

        // Демонстрация @Deprecated
        OldClass old = new OldClass();
        old.oldMethod();  // Вызов устаревшего метода - будет предупреждение
        old.newMethod();  // Новый метод
        System.out.println("OLD_CONSTANT = " + OldClass.OLD_CONSTANT);

        // Демонстрация @SuppressWarnings
        WarningSuppressor suppressor = new WarningSuppressor();
        suppressor.suppressUnusedWarning();
        suppressor.suppressMultipleWarnings();
        suppressor.suppressAllWarnings();

        System.out.println("\n========== ДОСТУП К СОБСТВЕННЫМ АННОТАЦИЯМ ==========\n");

        // Получаем аннотацию класса через рефлексию
        Class<?> clazz = MyApplication.class;

        if (clazz.isAnnotationPresent(BaseAction.class)) {
            BaseAction action = clazz.getAnnotation(BaseAction.class);
            System.out.println("Аннотация @BaseAction на классе " + clazz.getSimpleName());
            System.out.println("  level = " + action.level());
            System.out.println("  description = " + action.description());
        }

        System.out.println("\n--- Аннотации на методах ---");

        // Получаем аннотации методов
        Method[] methods = MyApplication.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ActionInfo.class)) {
                ActionInfo info = method.getAnnotation(ActionInfo.class);
                System.out.println("Метод: " + method.getName());
                System.out.println("  @ActionInfo(name = " + info.name() + ", priority = " + info.priority() + ")");
            }

            if (method.isAnnotationPresent(Loggable.class)) {
                Loggable loggable = method.getAnnotation(Loggable.class);
                System.out.println("  @Loggable(\"" + loggable.value() + "\")");
            }
        }

        System.out.println("\n========== СОЗДАНИЕ СОБСТВЕННОЙ АННОТАЦИИ ==========");
        System.out.println("Синтаксис:");
        System.out.println("  @Target(ElementType.TYPE)");
        System.out.println("  @Retention(RetentionPolicy.RUNTIME)");
        System.out.println("  public @interface MyAnnotation {");
        System.out.println("      int value();           // обязательный параметр");
        System.out.println("      String name() default \"\";  // параметр по умолчанию");
        System.out.println("  }");
        System.out.println("\nИспользование:");
        System.out.println("  @MyAnnotation(value = 10, name = \"Test\")");
        System.out.println("  public class MyClass { }");

        System.out.println("\n========== ЭТАПЫ СОЗДАНИЯ АННОТАЦИИ ==========");
        System.out.println("1. Объявить аннотацию через @interface");
        System.out.println("2. Указать @Target - где можно использовать");
        System.out.println("3. Указать @Retention - когда доступна (SOURCE, CLASS, RUNTIME)");
        System.out.println("4. Объявить методы-члены (параметры)");
        System.out.println("5. Использовать аннотацию в коде");
        System.out.println("6. Получить доступ через рефлексию (если RetentionPolicy.RUNTIME)");
    }
}