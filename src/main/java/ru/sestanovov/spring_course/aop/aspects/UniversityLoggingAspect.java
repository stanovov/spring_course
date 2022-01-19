package ru.sestanovov.spring_course.aop.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.sestanovov.spring_course.aop.Student;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice : Логируем получение "
                + "списка студентов перед методом getStudents");
    }

//    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
//    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
//        Student firstStudent = students.get(0);
//        String nameSurname = firstStudent.getNameSurname();
//        nameSurname = "Mr. " + nameSurname;
//        firstStudent.setNameSurname(nameSurname);
//        double avgGrade = firstStudent.getAvgGrade();
//        avgGrade = avgGrade + 1;
//        firstStudent.setAvgGrade(avgGrade);
//        System.out.println("afterReturningGetStudentsLoggingAdvice : Логируем получение "
//                + "списка студентов после работы метода getStudents");
//    }

//    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения "
//                + exception);
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentLoggingAdvice() {
        System.out.println("afterGetStudentLoggingAdvice: логируем нормальное окончание "
                + "работы метода или выброс исключения");
    }
}
