package bsuir.laba5;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;


public class FacultyManager {
    private static SessionFactory sessionFactory = null;
    private static Scanner scanner = null;
    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        scanner = new Scanner(System.in);


        int choice = 0;
        while(choice != 5) {
            System.out.println();
            System.out.println("Меню");
            System.out.println("1. Добавить запись");
            System.out.println("2. Просмотреть записи");
            System.out.println("3. Редактировать запись");
            System.out.println("4. Удалить запись");
            System.out.println("5. Выход");
            System.out.print("Сделайте выбор: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCountry();
                    break;

                case 2:
                    if(getSize() != 0) {
                        showCountries();
                    }
                    else
                    {
                        System.out.println("\nНет записей в БД!");
                    }
                    break;

                case 3:
                    if(getSize() != 0) {
                        editCountry();
                    }
                    else
                    {
                        System.out.println("\nНет записей в БД!");
                    }
                    break;

                case 4:
                    if(getSize() != 0) {
                        deleteCountry();
                    }
                    else
                    {
                        System.out.println("\nНет записей в БД!");
                    }
                    break;

                case 5:
                    break;

                default:
                    System.out.println("\nНеверный выбор!");
            }
        }
    }

    public static void addCountry() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        System.out.println();
        transaction = session.beginTransaction();
        Faculty faculty = new Faculty();
        scanner.nextLine();
        System.out.print("Введите название факультета: "); faculty.setName(scanner.nextLine());
        System.out.print("Введите ФИО декана: "); faculty.setDean(scanner.nextLine());
        System.out.print("Введите количество кафедр: "); faculty.setCountDep(scanner.nextInt());
        System.out.print("Введите количество обучающихся студентов: "); faculty.setCountEmp(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Введите месторасположение факультета: "); faculty.setAddress(scanner.nextLine());
        session.save(faculty);
        transaction.commit();
        session.close();
    }

    public static int getSize() {
        List<Faculty> countries = listCountries();
        return countries.size();
    }

    public static void showCountries() {
        System.out.println();
        List<Faculty> countries = listCountries();
        for (Faculty faculty : countries) {
            System.out.println(faculty);
        }
    }

    public static  List<Faculty> listCountries() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List <Faculty> countries = session.createQuery("FROM Faculty").list();

        transaction.commit();
        session.close();
        return countries;
    }


    public static void editCountry() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        showCountries();
        System.out.println();
        int id;
        System.out.print("Выберите id записи, которую хотите отредактировать: ");
        id = scanner.nextInt();

        Faculty faculty = (Faculty) session.get(Faculty.class, id);

        int choice = 0;
        while(choice != 6) {
            System.out.println();
            System.out.println("Поля: ");
            System.out.println("1. Название");
            System.out.println("2. Декан");
            System.out.println("3. Количество кафедр");
            System.out.println("4. Количество студентов");
            System.out.println("5. Месторасположение");
            System.out.println("6. Назад");
            System.out.print("Сделайте выбор: "); choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Название: " + faculty.getName());
                    scanner.nextLine();
                    System.out.print("Введите новое название: ");
                    faculty.setName(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("ФИО декана: " + faculty.getDean());
                    scanner.nextLine();
                    System.out.print("Введите новое ФИО декана: ");
                    faculty.setDean(scanner.nextLine());
                    break;

                case 3:
                    System.out.println("Количество кафедр: " + faculty.getCountDep());
                    System.out.print("Введите новое количество кафедр: ");
                    faculty.setCountDep(scanner.nextInt());
                    break;

                case 4:
                    System.out.println("Количество студентов: " + faculty.getCountEmp());
                    System.out.print("Введите новое количество студентов: ");
                    faculty.setCountEmp(scanner.nextInt());
                    break;

                case 5:
                    System.out.println("Месторасположение: " + faculty.getAddress());
                    scanner.nextLine();
                    System.out.print("Введите новое месторасположения: ");
                    faculty.setAddress(scanner.nextLine());
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Неверный выбор!");
            }
        }

        session.update(faculty);
        transaction.commit();
        session.close();
    }


    public static void deleteCountry() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        showCountries();
        System.out.println();
        int id;
        System.out.print("Выберите id записи, которую хотите удалить: ");
        id = scanner.nextInt();

        Faculty faculty = (Faculty) session.get(Faculty.class, id);

        session.delete(faculty);
        transaction.commit();
        session.close();
    }
}
