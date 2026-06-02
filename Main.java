class A {

    // ПЕРВЫЙ ЛОГИЧЕСКИЙ БЛОК
    {
        System.out.println("1. Нестатический блок (первый) → id = " + this.id + " (еще не инициализировано, значение по умолчанию)");
    }

    // СТАТИЧЕСКИЙ БЛОК
    static {
        System.out.println("1. Статический блок (выполняется при загрузке класса)");
    }

    // ПОЛЕ id с инициализацией
    private int id = 1;
    {
        System.out.println("2. Инициализация поля id = " + id);
    }

    // ВТОРОЙ ЛОГИЧЕСКИЙ БЛОК
    {
        System.out.println("3. Нестатический блок (второй) → id = " + id + " (после инициализации поля)");
    }

    // КОНСТРУКТОР
    public A(int id) {
        this.id = id;
        System.out.println("4. Конструктор → id = " + this.id + " (перезаписывает значение)");
    }

    public static void main(String[] args) {
        System.out.println("=== Создаем первый объект ===");
        new A(100);

        System.out.println("\n=== Создаем второй объект ===");
        new A(200);
    }
}