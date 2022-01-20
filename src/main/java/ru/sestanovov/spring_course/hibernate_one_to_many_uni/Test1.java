package ru.sestanovov.spring_course.hibernate_one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sestanovov.spring_course.hibernate_one_to_many_uni.entity.Department;
import ru.sestanovov.spring_course.hibernate_one_to_many_uni.entity.Employee;

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
//                    "HR", 50, 1500
//            );
//            Employee employee1 = new Employee(
//                    "Oleg", "Ivanov", 800
//            );
//            Employee employee2 = new Employee(
//                    "Andrey", "Sidorov", 1000
//            );
//            department.addEmployee(employee1);
//            department.addEmployee(employee2);
//            session.save(department);
//            Department department = session.get(Department.class, 2);
//            System.out.println(department);
//            System.out.println(department.getEmps());
            Department department = session.get(Department.class, 3);
//            System.out.println(employee);
            session.delete(department);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
