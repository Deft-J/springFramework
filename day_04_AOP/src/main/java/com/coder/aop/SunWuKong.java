package com.coder.aop;

public class SunWuKong implements Fight{

    private GaoCuilan gaoCuilan;

    public SunWuKong(){
        this.gaoCuilan = new GaoCuilan();
    }

    @Override
    public void fightPig() {
        gaoCuilan.fightPig();
        changeToGaoCuilan();
        System.out.println("孙悟空打赢了猪八戒");
    }

    @Override
    public void catchPig() {
        gaoCuilan.catchPig();
        System.out.println("孙悟空抓住了猪八戒");
    }

    private void changeToGaoCuilan() {
        System.out.println("孙悟空变为高翠兰");
    }
}
