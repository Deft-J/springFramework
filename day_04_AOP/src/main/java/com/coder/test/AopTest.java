package com.coder.test;

import com.coder.aop.Fight;
import com.coder.aop.SunWuKong;

public class AopTest {
    public static void main(String[] args) {
        Fight proxy=new SunWuKong();
        proxy.fightPig();
        proxy.catchPig();
    }
}
