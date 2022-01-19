package ru.sestanovov.spring_course.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* abc*(..))")
    public void allAddMethods() { }
}