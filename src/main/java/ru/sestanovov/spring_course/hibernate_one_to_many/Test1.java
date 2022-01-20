package ru.sestanovov.spring_course.hibernate_one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sestanovov.spring_course.hibernate_one_to_many.entity.Department;
import ru.sestanovov.spring_course.hibernate_one_to_many.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
//            Department department = new Department(
//                    "Sales", 800, 1500
//            );
//            Employee employee1 = new Employee(
//                    "Semyon", "Stanovov", 800);
//            Employee employee2 = new Employee(
//                    "Elena", "Smirnova", 1500);
//            Employee employee3 = new Employee(
//                    "Anton", "Sidorov", 1200);
//            department.addEmployee(employee1);
//            department.addEmployee(employee2);
//            department.addEmployee(employee3);
//            session.save(department);
            System.out.println("Get department");
            Department department = session.get(Department.class, 4);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Подгрузим наших работников");
            department.getEmps().get(0);
//            Employee employee = session.get(Employee.class, 3);
//            session.delete(employee);
            session.getTransaction().commit();
            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
