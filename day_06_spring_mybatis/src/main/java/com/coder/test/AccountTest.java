package com.coder.test;

import com.coder.entity.Account;
import com.coder.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = context.getBean(AccountService.class);

        //新增帐户
        service.addAccount(new Account().setAccount("test1").setPassword("123456").setCoupon(100));

        //查询所有帐户
        List<Account> accountList = service.listAllAccount();
        System.out.println("帐户信息：");
        accountList.forEach(System.out::println);

        //用户登录
        Account loginUser = service.userLogin("test1", "123456");
        if (loginUser != null) {
            System.out.println("登录成功" + loginUser);
        } else {
            System.out.println("帐号或密码错误");
        }

        //充值点券（触发事务超时回滚）
        try {
            service.rechargeCoupon("test1", 500);
            System.out.println("充值成功");
        } catch (Exception e) {
            System.out.println("充值失败事务回滚" + e.getMessage());
        }

        //消费点券
        service.consumeCoupon("test1", 300);
        System.out.println("消费成功，最新帐户信息：" + service.userLogin("test1", "123456"));
    }
}

