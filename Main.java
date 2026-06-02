/**
* Вопрос: какая область видимости у интерфейса, объявленного следующим образом?
 *         private interface Interface { ... }
 *
 * Ответ: НЕВОЗМОЖНО! private НЕЛЬЗЯ использовать для интерфейсов верхнего уровня.
 *         Компилятор выдаст ошибку: "Modifier 'private' not allowed here"
 *
 *         private можно использовать ТОЛЬКО для:
 *         - внутренних интерфейсов (вложенных в класс)
 *         - методов
 *         - полей
 */

package practice4;

// ❌ РАСКОММЕНТИРОВАТЬ НЕЛЬЗЯ - БУДЕТ ОШИБКА!
// private interface MyInterface {  // ОШИБКА КОМПИЛЯЦИИ!
//     void doSomething();
// }

/**
 * ПРАВИЛЬНОЕ использование private - только для внутренних интерфейсов
 */
class OuterClass {

    // ✅ private можно использовать для ВНУТРЕННЕГО интерфейса
    private interface InnerInterface {
        void doSomething();
    }

    // Реализация private интерфейса внутри внешнего класса
    private class InnerImpl implements InnerInterface {
        public void doSomething() {
            System.out.println("Внутренний private интерфейс работает");
        }
    }

    public void test() {
        InnerImpl impl = new InnerImpl();
        impl.doSomething();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.test();
        System.out.println("✅ private можно использовать ТОЛЬКО для вложенных интерфейсов");
        System.out.println("❌ Для top-level интерфейсов private НЕЛЬЗЯ");
    }
}