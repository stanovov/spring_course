package ru.sestanovov.spring_course.hibernate_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sestanovov.spring_course.hibernate_many_to_many.entity.Child;
import ru.sestanovov.spring_course.hibernate_many_to_many.entity.Section;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();

//            Section section1 = new Section("Dance");
//            Child child1 = new Child("Olya", 12);
//            Child child2 = new Child("Grisha", 8);
//            Child child3 = new Child("Pavel", 9);
//            section1.addChild(child1);
//            section1.addChild(child2);
//            section1.addChild(child3);
//            //**************************************
//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Igor", 10);
//            child1.addSection(section1);
//            child1.addSection(section2);
//            child1.addSection(section3);

            session.beginTransaction();

//            session.persist(section1);
//            //**************************************
//            session.save(child1);
//            //**************************************
//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//            //**************************************
//            Child child = session.get(Child.class, 4);
//            System.out.println(child);
//            System.out.println(child.getSections());
//            //**************************************
//            Section section = session.get(Section.class, 1);
//            session.delete(section);
//            //**************************************
//            Section section = session.get(Section.class, 7);
//            session.delete(section);
//            //**************************************
            Child child = session.get(Child.class, 5);
            session.delete(child);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }

    }
}
