package ru.sestanovov.spring_course.hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sestanovov.spring_course.hibernate_one_to_one.entity.Detail;
import ru.sestanovov.spring_course.hibernate_one_to_one.entity.Employee;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
//            Employee employee = new Employee(
//                    "Nikolay",
//                    "Ivanov",
//                    "HR",
//                    850
//            );
//            Detail detail = new Detail(
//                    "New-York",
//                    "125512515521",
//                    "niko@mail.com"
//            );
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
            session.beginTransaction();
//            session.save(detail);
            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
