package package1;

public class SamePackageClass {

    public void tryToAccess(MyClass obj) {
        System.out.println("\n--- Доступ из класса в ТОМ ЖЕ пакете (package1) ---");

        System.out.println("defaultField = " + obj.defaultField);
        System.out.println("protectedField = " + obj.protectedField);
        System.out.println("publicField = " + obj.publicField);

        obj.defaultMethod();
        obj.protectedMethod();
        obj.publicMethod();
    }
}