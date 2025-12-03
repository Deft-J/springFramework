package com.coder.service.impl;


import com.coder.service.TravelService;
import org.springframework.stereotype.Service;

@Service
public class TravelServiceImpl implements TravelService {

    @Override
    public void travel(String userName, String startPlace, String endPlace) {
        System.out.printf("您好，%s，欢迎您乘坐从%s到%s航班%n", userName, startPlace, endPlace);
    }
}
