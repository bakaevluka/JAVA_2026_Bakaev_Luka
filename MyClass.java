package package1;

public class MyClass {

    private int privateField = 1;
    int defaultField = 2;
    protected int protectedField = 3;
    public int publicField = 4;

    private void privateMethod() {
        System.out.println("  → privateMethod: доступен только внутри MyClass");
    }

    void defaultMethod() {
        System.out.println("  → defaultMethod: доступен в пакете package1");
    }

    protected void protectedMethod() {
        System.out.println("  → protectedMethod: доступен в package1 + подклассах");
    }

    public void publicMethod() {
        System.out.println("  → publicMethod: доступен всем");
    }

    public void showAccessFromInside() {
        System.out.println("\n--- Доступ изнутри MyClass ---");
        System.out.println("privateField = " + privateField);
        System.out.println("defaultField = " + defaultField);
        System.out.println("protectedField = " + protectedField);
        System.out.println("publicField = " + publicField);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }
}