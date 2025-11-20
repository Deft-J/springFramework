package com.coder.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        LibraryManage manager = (LibraryManage) context.getBean("libraryManage");
        manager.landBook();
    }
}
