 * Вопрос: какая область видимости у интерфейса, объявленного следующим образом?
 *         public interface Interface { ... }
 *
 * Ответ: Модификатор доступа - public
 *         Интерфейс доступен ВЕЗДЕ (из любого пакета).
 *         Любой класс в любом пакете может реализовать этот интерфейс.
 */

package practice2;

// public интерфейс - доступен везде
public interface MyInterface {
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

// Класс в ДРУГОМ ПАКЕТЕ ТОЖЕ может реализовать интерфейс
// package practice2_other;
// import practice2.MyInterface;
//
// class OtherClass implements MyInterface {
//     public void doSomething() {
//         System.out.println("Работает в другом пакете");
//     }
// }  // ✅ РАБОТАЕТ!