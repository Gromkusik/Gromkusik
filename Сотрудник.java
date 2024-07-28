public class Сотрудник {
    //№1*******************************************************************************************************
    //1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    //Конструктор класса должен заполнять эти поля при создании объекта.
    //Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    private String fio;
    private String job;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Сотрудник(String fio, String job, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.job = job;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void info() {
        System.out.println("Сотрудник: \t" + fio + "\nДолжность: \t" + job + "\nEmail: \t\t" + email + "\nТелефон: \t" + phone + "\nЗарплата: \t" + salary + "\nВозраст: \t" + age);
    }
}