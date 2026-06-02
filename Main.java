import java.util.Objects;

/**
 * Класс "Студент" с переопределенным методом equals()
 */
class Student {
    private final String studentId;  // уникальный идентификатор студента
    private String firstName;
    private String lastName;
    private int age;
    private String group;

    // Конструктор
    public Student(String studentId, String firstName, String lastName, int age, String group) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
    }

    // Геттеры
    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getGroup() { return group; }

    /**
     * Переопределение метода equals()
     * Сравнивает студентов по уникальному идентификатору (studentId)
     */
    @Override
    public boolean equals(Object obj) {
        // 1. Проверка: сравниваем объект с самим собой (рефлексивность)
        if (this == obj) {
            return true;
        }

        // 2. Проверка: если obj == null, возвращаем false
        if (obj == null) {
            return false;
        }

        // 3. Проверка: совпадают ли классы (для симметричности и безопасности)
        if (getClass() != obj.getClass()) {
            return false;
        }

        // 4. Приведение типа
        Student other = (Student) obj;

        // 5. Сравнение значимых полей
        // studentId уникален, поэтому сравниваем только его
        return Objects.equals(studentId, other.studentId);
    }

    /**
     * Всегда переопределяйте hashCode(), если переопределяете equals()
     */
    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return String.format("Student{id='%s', name='%s %s', age=%d, group='%s'}",
                studentId, firstName, lastName, age, group);
    }
}

/**
 * Другой класс, демонстрирующий сравнение по нескольким полям
 */
class Book {
    private final String isbn;      // уникальный ISBN
    private final String title;
    private final String author;
    private final int year;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    /**
     * Переопределение equals() с сравнением по всем значимым полям
     */
    @Override
    public boolean equals(Object obj) {
        // 1. Сравнение с самим собой
        if (this == obj) return true;

        // 2. Проверка на null
        if (obj == null) return false;

        // 3. Проверка типа
        if (getClass() != obj.getClass()) return false;

        // 4. Приведение
        Book other = (Book) obj;

        // 5. Сравнение всех полей
        return Objects.equals(isbn, other.isbn) &&
                Objects.equals(title, other.title) &&
                Objects.equals(author, other.author) &&
                year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, year);
    }

    @Override
    public String toString() {
        return String.format("Book{ISBN='%s', title='%s', author='%s', year=%d}",
                isbn, title, author, year);
    }
}

/**
 * Демонстрация работы equals()
 */
class EqualsExample {
    public static void main(String[] args) {

        System.out.println("========== ПЕРЕОПРЕДЕЛЕНИЕ equals() ==========\n");

        System.out.println("--- Пример 1: Сравнение студентов ---");

        Student s1 = new Student("S001", "Иван", "Петров", 20, "ИВТ-01");
        Student s2 = new Student("S001", "Иван", "Петров", 20, "ИВТ-01");
        Student s3 = new Student("S002", "Мария", "Иванова", 19, "ИВТ-01");
        Student s4 = new Student("S001", "Петр", "Сидоров", 21, "ИВТ-02"); // другой студент, но тот же ID

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);

        System.out.println("\nРезультаты сравнения:");
        System.out.println("s1.equals(s1) = " + s1.equals(s1));  // рефлексивность: true
        System.out.println("s1.equals(s2) = " + s1.equals(s2));  // true (одинаковый ID)
        System.out.println("s1.equals(s3) = " + s1.equals(s3));  // false (разные ID)
        System.out.println("s1.equals(s4) = " + s1.equals(s4));  // true (одинаковый ID, хотя имена разные!)
        System.out.println("s1.equals(null) = " + s1.equals(null)); // false

        System.out.println("\n--- Пример 2: Сравнение книг ---");

        Book b1 = new Book("978-5-699-12014-7", "Война и мир", "Лев Толстой", 1869);
        Book b2 = new Book("978-5-699-12014-7", "Война и мир", "Лев Толстой", 1869);
        Book b3 = new Book("978-5-699-12014-7", "Война и мир", "Л.Н. Толстой", 1869); // автор отличается

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);

        System.out.println("\nРезультаты сравнения:");
        System.out.println("b1.equals(b1) = " + b1.equals(b1));   // true
        System.out.println("b1.equals(b2) = " + b1.equals(b2));   // true (все поля совпадают)
        System.out.println("b1.equals(b3) = " + b1.equals(b3));   // false (разный автор)

        System.out.println("\n========== ДЕМОНСТРАЦИЯ СОГЛАШЕНИЙ ==========\n");

        System.out.println("1. РЕФЛЕКСИВНОСТЬ: объект равен самому себе");
        System.out.println("   s1.equals(s1) = " + s1.equals(s1) + " ✓\n");

        System.out.println("2. СИММЕТРИЧНОСТЬ: если x.equals(y)=true, то y.equals(x)=true");
        System.out.println("   s1.equals(s2) = " + s1.equals(s2));
        System.out.println("   s2.equals(s1) = " + s2.equals(s1) + " ✓\n");

        System.out.println("3. ТРАНЗИТИВНОСТЬ: если x=y и y=z, то x=z");
        Student x = new Student("S001", "A", "A", 20, "G1");
        Student y = new Student("S001", "B", "B", 21, "G2");
        Student z = new Student("S001", "C", "C", 22, "G3");
        System.out.println("   x.equals(y) = " + x.equals(y));
        System.out.println("   y.equals(z) = " + y.equals(z));
        System.out.println("   x.equals(z) = " + x.equals(z) + " ✓\n");

        System.out.println("4. ПОСТОЯНСТВО: многократный вызов дает тот же результат");
        System.out.println("   s1.equals(s2) (1-й раз) = " + s1.equals(s2));
        System.out.println("   s1.equals(s2) (2-й раз) = " + s1.equals(s2) + " ✓\n");

        System.out.println("5. СРАВНЕНИЕ С NULL: x.equals(null) = false");
        System.out.println("   s1.equals(null) = " + s1.equals(null) + " ✓");

        System.out.println("\n========== ВАЖНЫЕ ПРАВИЛА ==========");
        System.out.println("1. Всегда переопределяйте hashCode(), если переопределяете equals()");
        System.out.println("2. Используйте Objects.equals() для безопасного сравнения");
        System.out.println("3. Сравнивайте только значимые поля");
        System.out.println("4. Не сравнивайте поля, которые не влияют на идентичность объекта");
    }
}