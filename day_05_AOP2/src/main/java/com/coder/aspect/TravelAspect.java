package com.coder.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Aspect
@Component
public class TravelAspect {
    private List<String> getHighRiskAreas() throws IOException {
        Resource resource = new ClassPathResource("highRiskArea.properties");
        Properties properties = new Properties();
        properties.load(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        String areasStr = properties.getProperty("highRiskAreas");
        return Arrays.asList(areasStr.split(","));
    }

    @Around("execution(* com.coder.service.TravelService.travel(..))")
    public Object checkTravelRisk(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String userName = (String) args[0];
        String startPlace = (String) args[1];
        String endPlace = (String) args[2];

        List<String> highRiskAreas = getHighRiskAreas();

        if (highRiskAreas.contains(startPlace)) {
            System.out.printf("%s，您的出发地%s为疫情高风险区域，暂不允许出行%n", userName, startPlace);
            return null;
        }
        Object result = joinPoint.proceed();
        if (highRiskAreas.contains(endPlace)) {
            writeRiskLog(userName, startPlace, endPlace);
        }

        return result;
    }

    private void writeRiskLog(String userName, String startPlace, String endPlace) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowTime = LocalDateTime.now().format(formatter);
        String logContent = String.format("用户姓名：%s，出发地：%s，目的地：%s，出发时间：%s%n",
                userName, startPlace, endPlace, nowTime);
        File logFile = new File("risk_log.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(logContent);
        }
        System.out.printf("日志记录：%s，您的目的地%s为疫情高风险区域，已记录到出行日志%n",
                userName, endPlace);
    }
}
