import java.util.Scanner;

class GreetingProgram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scan.next();

        System.out.println("Привет, " + name);

        scan.close();
    }
}