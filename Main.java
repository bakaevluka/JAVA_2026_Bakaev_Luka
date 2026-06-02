/**
 * Демонстрация того, как @Override помогает найти ошибки
 */
class Parent {

    public void processData() {
        System.out.println("Parent.processData()");
    }

    public void save() {
        System.out.println("Parent.save()");
    }

    public String getName() {
        return "Parent";
    }

    public int calculate(int x) {
        return x * 2;
    }
}

class Child extends Parent {

    // ✅ ПРАВИЛЬНО: @Override показывает, что метод переопределен
    @Override
    public void processData() {
        System.out.println("Child.processData()");
    }

    // ❌ ОШИБКА 1: опечатка в имени метода (savee вместо save)
    // @Override
    // public void savee() {  // Компилятор выдаст ошибку!
    //     System.out.println("Child.save()");
    // }

    // ❌ ОШИБКА 2: неправильные параметры
    // @Override
    // public void processData(String x) {  // Компилятор выдаст ошибку!
    //     System.out.println("Child.processData(String)");
    // }

    // ❌ ОШИБКА 3: неправильный возвращаемый тип
    // @Override
    // public int getName() {  // Компилятор выдаст ошибку!
    //     return 100;
    // }

    // ❌ ОШИБКА 4: более строгий модификатор доступа
    // @Override
    // protected void processData() {  // Компилятор выдаст ошибку!
    //     System.out.println("Child.processData()");
    // }
}

/**
 * Пример реальной ошибки, которую находит @Override
 */
class Version1 {
    public void updateUser(String name, int age) {
        System.out.println("Обновление пользователя: " + name + ", " + age);
    }
}

class Version2 extends Version1 {

    // Разработчик хотел переопределить метод updateUser,
    // но ошибся в названии параметра (age -> userAge)
    // и порядке параметров

    // БЕЗ @Override - код скомпилируется, но будет работать НЕПРАВИЛЬНО!
    public void updateUser(String name, int userAge) {
        System.out.println("ДРУГОЙ метод: " + name + ", " + userAge);
    }

    // С @Override - компилятор покажет ошибку,
    // потому что метод с такими параметрами не существует в суперклассе
    /*
    @Override
    public void updateUser(String name, int userAge) {
        System.out.println("Это НЕ переопределение!");
    }
    */
}

class OverrideAnnotationExample {
    public static void main(String[] args) {

        System.out.println("========== @Override помогает найти ошибки ==========\n");

        System.out.println("Ошибки, которые обнаруживает @Override:");
        System.out.println("1. Опечатка в имени метода");
        System.out.println("2. Неправильные параметры (тип, количество, порядок)");
        System.out.println("3. Неправильный возвращаемый тип");
        System.out.println("4. Более строгий модификатор доступа");
        System.out.println("5. Метод не существует в суперклассе\n");

        // Пример скрытой ошибки без @Override
        System.out.println("=== Пример ошибки без @Override ===");
        Version2 v2 = new Version2();

        // Ожидается вызов переопределенного метода
        // Но на самом деле вызывается метод с другим параметром (userAge)
        v2.updateUser("Иван", 25);

        System.out.println("\n⚠️  ПРОБЛЕМА: Код скомпилировался, но метод updateUser()");
        System.out.println("не переопределил родительский метод, а создал НОВЫЙ метод!");
        System.out.println("Это может привести к логическим ошибкам в программе.\n");

        System.out.println("=== Как @Override помогает ===");
        System.out.println("Если бы разработчик использовал @Override,");
        System.out.println("компилятор сразу показал бы ошибку.");

        System.out.println("\n✅ ВЫВОД: Всегда используйте @Override!");
        System.out.println("Это защищает от ошибок и делает код понятнее.");
    }
}