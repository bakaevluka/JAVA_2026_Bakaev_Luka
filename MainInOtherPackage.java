package package2;

import package1.MyClass;

public class MainInOtherPackage {
    public static void main(String[] args) {
        MyClass myObj = new MyClass();

        System.out.println("========== ДОСТУП ИЗ ДРУГОГО ПАКЕТА (НЕ ПОДКЛАСС) ==========");
        System.out.println("publicField = " + myObj.publicField);
        myObj.publicMethod();

        System.out.println("\n========== ДОСТУП ЧЕРЕЗ ПОДКЛАСС ==========");
        SubClass sub = new SubClass();
        sub.tryToAccess();
    }
}