package package1;

public class MainInSamePackage {
    public static void main(String[] args) {
        System.out.println("========== ДЕМОНСТРАЦИЯ СПЕЦИФИКАТОРОВ ДОСТУПА ==========");

        MyClass myObj = new MyClass();
        myObj.showAccessFromInside();

        SamePackageClass samePkg = new SamePackageClass();
        samePkg.tryToAccess(myObj);

        System.out.println("\n--- Прямой доступ из main (тот же пакет) ---");
        System.out.println("defaultField = " + myObj.defaultField);
        System.out.println("protectedField = " + myObj.protectedField);
        System.out.println("publicField = " + myObj.publicField);
    }
}