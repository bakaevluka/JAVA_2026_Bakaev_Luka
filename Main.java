class SwitchWithoutBreakExample {
    public static void main(String[] args) {

        System.out.println("========== Пример без break ==========");

        for (int value = 1; value <= 4; value++) {
            int i = 0;
            switch(value) {
                case 1:
                    i = 1;
                    break;  // есть break
                case 2:
                    i = 2;
                    // break ОТСУТСТВУЕТ! проваливается в case 3
                case 3:
                    i = 3;
                    break;  // break здесь
                default:
                    i = 4;
                    break;
            }
            System.out.println("value = " + value + " → i = " + i);
        }

        System.out.println("\n========== Детальный разбор ==========");

        // Разбор для value = 2
        System.out.println("При value = 2:");
        System.out.println("1. Входим в case 2: i = 2");
        System.out.println("2. Отсутствует break → проваливаемся в case 3");
        System.out.println("3. Выполняется case 3: i = 3");
        System.out.println("4. Встречаем break → выходим из switch");
        System.out.println("5. Итог: i = 3\n");

        // Демонстрация fallthrough (проваливания)
        System.out.println("========== Использование fallthrough намеренно ==========");

        int month = 2;
        String season;
        switch(month) {
            case 12:
            case 1:
            case 2:
                season = "Зима";
                break;
            case 3:
            case 4:
            case 5:
                season = "Весна";
                break;
            case 6:
            case 7:
            case 8:
                season = "Лето";
                break;
            case 9:
            case 10:
            case 11:
                season = "Осень";
                break;
            default:
                season = "Неверный месяц";
        }
        System.out.println("Месяц " + month + " → " + season);

        System.out.println("\n========== Еще пример с break ==========");

        int day = 3;
        String dayType;
        switch(day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                dayType = "Будний день";
                break;
            case 6:
            case 7:
                dayType = "Выходной";
                break;
            default:
                dayType = "Неверный день";
        }
        System.out.println("День " + day + " → " + dayType);
    }
}