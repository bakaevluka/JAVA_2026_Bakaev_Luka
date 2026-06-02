package package2;

import package1.MyClass;

public class SubClass extends MyClass {

    public void tryToAccess() {
        System.out.println("\n--- Доступ из ПОДКЛАССА в другом пакете (package2) ---");

        System.out.println("protectedField = " + protectedField);
        System.out.println("publicField = " + publicField);

        protectedMethod();
        publicMethod();
    }
}