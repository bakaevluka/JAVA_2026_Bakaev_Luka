/**
 * Вопрос: какая область видимости у интерфейса, объявленного следующим образом?
 *         protected interface Interface { ... }
 *
 * Ответ: НЕВОЗМОЖНО! protected НЕЛЬЗЯ использовать для интерфейсов верхнего уровня.
 *         Компилятор выдаст ошибку: "Modifier 'protected' not allowed here"
 *
 *         protected можно использовать ТОЛЬКО для:
 *         - внутренних интерфейсов (вложенных в класс)
 *         - методов
 *         - полей
 */

package practice3;

// ❌ РАСКОММЕНТИРОВАТЬ НЕЛЬЗЯ - БУДЕТ ОШИБКА!
// protected interface MyInterface {  // ОШИБКА КОМПИЛЯЦИИ!
//     void doSomething();
// }

/**
 * ПРАВИЛЬНОЕ использование protected - только для внутренних интерфейсов
 */
class OuterClass {

    // ✅ protected можно использовать для ВНУТРЕННЕГО интерфейса
    protected interface InnerInterface {
        void doSomething();
    }

    class InnerClass implements InnerInterface {
        public void doSomething() {
            System.out.println("Внутренний protected интерфейс работает");
        }
    }

    public void test() {
        InnerClass inner = new InnerClass();
        inner.doSomething();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.test();
        System.out.println("✅ protected можно использовать ТОЛЬКО для вложенных интерфейсов");
        System.out.println("❌ Для top-level интерфейсов protected НЕЛЬЗЯ");
    }
}