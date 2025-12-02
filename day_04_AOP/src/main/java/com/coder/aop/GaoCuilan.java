package com.coder.aop;

public class GaoCuilan implements Fight{
    @Override
    public void fightPig() {
        System.out.println("高翠兰打不过猪八戒");
    }

    @Override
    public void catchPig() {
        System.out.println("高翠兰抓不住猪八戒");
    }
}
