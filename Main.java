 /**
 *  Вопрос: какая область видимости у интерфейса, объявленного следующим образом?
 *         interface Interface { ... }
 *
 * Ответ: Модификатор доступа - default (package-private)
 *         Интерфейс доступен ТОЛЬКО внутри своего пакета.
 *         В другом пакете этот интерфейс НЕ ВИДЕН.
 */

package practice1;

// default интерфейс (без модификатора)
interface MyInterface {
    void doSomething();
}

// Класс в ТОМ ЖЕ пакете может реализовать интерфейс
class MyClass implements MyInterface {
    public void doSomething() {
        System.out.println("Работает - доступ есть");
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.doSomething();
        System.out.println("✅ Интерфейс доступен внутри своего пакета");
    }
}

// Если создать класс в ДРУГОМ ПАКЕТЕ, то интерфейс НЕ БУДЕТ ВИДЕН
// package package2;
// class OtherClass implements MyInterface { }  // ❌ ОШИБКА!