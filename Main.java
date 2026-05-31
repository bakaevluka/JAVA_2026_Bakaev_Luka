public class Main {

    public static void main(String[] args) {

        Bird bird1 = new Bird();
        Bird bird2 = new Sparrow();

        bird1.fly();
        bird2.fly();
    }
}

class Bird {

    public void fly() {
        System.out.println("Птица летит");
    }
}

class Sparrow extends Bird {

    @Override
    public void fly() {
        System.out.println("Воробей летит");
    }
}