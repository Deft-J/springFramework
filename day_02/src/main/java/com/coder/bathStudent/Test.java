package com.coder.bathStudent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Bath manager = (Bath) context.getBean("bathManage");
        manager.check();
    }
}
