import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Демонстрация пяти спецификаторов для форматирования времени и даты
 * %tH - час (00-23), %tM - минуты, %tS - секунды, %tY - год (4 цифры), %tB - полное название месяца
 */
class DateTimeFormatExample {
    public static void main(String[] args) {

        System.out.println("========== ФОРМАТИРОВАНИЕ ДАТЫ И ВРЕМЕНИ ==========\n");

        // Текущая дата и время
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();

        System.out.println("--- 1. %tH - час (00-23) ---");
        System.out.printf("Текущий час (24-часовой формат): %tH%n", now);
        System.out.printf("Час: %tH%n", calendar);

        System.out.println("\n--- 2. %tM - минуты (00-59) ---");
        System.out.printf("Текущие минуты: %tM%n", now);
        System.out.printf("Минуты: %tM%n", calendar);

        System.out.println("\n--- 3. %tS - секунды (00-59) ---");
        System.out.printf("Текущие секунды: %tS%n", now);
        System.out.printf("Секунды: %tS%n", calendar);

        System.out.println("\n--- 4. %tY - год (4-значный формат) ---");
        System.out.printf("Текущий год: %tY%n", now);
        System.out.printf("Год: %tY%n", calendar);

        System.out.println("\n--- 5. %tB - полное название месяца ---");
        System.out.printf("Текущий месяц: %tB%n", now);
        System.out.printf("Месяц: %tB%n", calendar);

        System.out.println("\n========== КОМБИНИРОВАНИЕ СПЕЦИФИКАТОРОВ ==========");

        // Полная дата и время
        System.out.printf("Полная дата: %tA, %tB %td, %tY%n", now, now, now, now);
        System.out.printf("Время: %tH:%tM:%tS%n", now, now, now);
        System.out.printf("Дата и время: %tY-%tm-%td %tH:%tM:%tS%n", now, now, now, now, now, now);

        System.out.println("\n========== ИСПОЛЬЗОВАНИЕ ОДНОГО АРГУМЕНТА С ИНДЕКСАМИ ==========");

        // Использование индекса 1$ для одного аргумента
        System.out.printf("Сегодня: %1$tA, %1$tB %1$td, %1$tY%n", now);
        System.out.printf("Сейчас: %1$tH:%1$tM:%1$tS%n", now);

        System.out.println("\n========== ДРУГИЕ СПЕЦИФИКАТОРЫ ДАТЫ ==========");

        System.out.printf("%tA - полное название дня недели: %tA%n", now, now);
        System.out.printf("%ta - сокращенное название дня: %ta%n", now, now);
        System.out.printf("%tB - полное название месяца: %tB%n", now, now);
        System.out.printf("%tb - сокращенное название месяца: %tb%n", now, now);
        System.out.printf("%td - день месяца (01-31): %td%n", now, now);
        System.out.printf("%te - день месяца без нуля (1-31): %te%n", now, now);
        System.out.printf("%tY - год (4 цифры): %tY%n", now, now);
        System.out.printf("%ty - год (2 цифры): %ty%n", now, now);
        System.out.printf("%tH - час (00-23): %tH%n", now, now);
        System.out.printf("%tI - час (01-12): %tI%n", now, now);
        System.out.printf("%tM - минуты: %tM%n", now, now);
        System.out.printf("%tS - секунды: %tS%n", now, now);
        System.out.printf("%tL - миллисекунды: %tL%n", now, now);
        System.out.printf("%tp - AM/PM: %tp%n", now, now);

        System.out.println("\n========== СОЗДАНИЕ ЗАДАННОЙ ДАТЫ ==========");

        // Создание конкретной даты
        Calendar specificDate = new GregorianCalendar(2025, Calendar.DECEMBER, 25, 15, 30, 45);

        System.out.printf("Заданная дата: %tA, %tB %td, %tY%n", specificDate, specificDate, specificDate, specificDate);
        System.out.printf("Заданное время: %tH:%tM:%tS%n", specificDate, specificDate, specificDate);

        System.out.println("\n========== ФОРМАТИРОВАНИЕ ЧЕРЕЗ STRING.FORMAT() ==========");

        String dateStr = String.format("Сегодня: %tY-%tm-%td", now, now, now);
        String timeStr = String.format("Время: %tH:%tM:%tS", now, now, now);
        System.out.println(dateStr);
        System.out.println(timeStr);

        System.out.println("\n========== ТАБЛИЦА ИСПОЛЬЗОВАННЫХ СПЕЦИФИКАТОРОВ ==========");
        System.out.println("┌────────┬────────────────────────────────────────────────┐");
        System.out.println("│ %tH    │ Час (00–23)                                    │");
        System.out.println("│ %tM    │ Минуты как десятичное целое (00–59)           │");
        System.out.println("│ %tS    │ Секунды как десятичное целое (00–59)          │");
        System.out.println("│ %tY    │ Год в четырехзначном формате                  │");
        System.out.println("│ %tB    │ Полное название месяца (январь, февраль...)   │");
        System.out.println("└────────┴────────────────────────────────────────────────┘");

        System.out.println("\n========== АЛЬТЕРНАТИВНЫЙ СПОСОБ (Java 8+) ==========");

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm:ss");
        System.out.println("LocalDateTime: " + ldt.format(dtf));
    }
}