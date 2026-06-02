class SwitchTypesExample {

    // enum для демонстрации
    enum Day { MONDAY, TUESDAY, WEDNESDAY }

    public static void main(String[] args) {

        System.out.println("========== 1. switch с byte ==========");
        byte byteValue = 1;
        switch(byteValue) {
            case 1:
                System.out.println("byte = 1");
                break;
            case 2:
                System.out.println("byte = 2");
                break;
            default:
                System.out.println("byte другое");
        }

        System.out.println("\n========== 2. switch с short ==========");
        short shortValue = 100;
        switch(shortValue) {
            case 100:
                System.out.println("short = 100");
                break;
            default:
                System.out.println("short другое");
        }

        System.out.println("\n========== 3. switch с int ==========");
        int intValue = 42;
        switch(intValue) {
            case 42:
                System.out.println("int = 42");
                break;
            default:
                System.out.println("int другое");
        }

        System.out.println("\n========== 4. switch с char ==========");
        char charValue = 'A';
        switch(charValue) {
            case 'A':
                System.out.println("char = A");
                break;
            case 'B':
                System.out.println("char = B");
                break;
            default:
                System.out.println("char другое");
        }

        System.out.println("\n========== 5. switch с String ==========");
        String stringValue = "Привет";
        switch(stringValue) {
            case "Привет":
                System.out.println("String = Привет");
                break;
            case "Пока":
                System.out.println("String = Пока");
                break;
            default:
                System.out.println("String другое");
        }

        System.out.println("\n========== 6. switch с enum ==========");
        Day day = Day.MONDAY;
        switch(day) {
            case MONDAY:
                System.out.println("Сегодня понедельник");
                break;
            case TUESDAY:
                System.out.println("Сегодня вторник");
                break;
            default:
                System.out.println("Другой день");
        }
    }
}