package com.coder;

import com.coder.config.SpringConfig;
import com.coder.service.TravelService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TravelTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        TravelService travelService = context.getBean(TravelService.class);

        travelService.travel("张三", "北京丰台区", "杭州西湖区");

        travelService.travel("李四", "成都锦江区", "上海浦东新区");

        travelService.travel("王五", "苏州工业园区", "南京玄武区");

        context.close();
    }
}
