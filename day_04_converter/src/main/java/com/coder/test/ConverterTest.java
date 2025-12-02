package com.coder.test;

import com.coder.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConverterTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user", User.class);
        System.out.println("用户名：" + user.getName());
        System.out.println("工资（BigDecimal类型）：" + user.getSalary());
    }
}
