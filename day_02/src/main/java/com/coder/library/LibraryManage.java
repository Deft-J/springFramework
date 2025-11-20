package com.coder.library;

import java.util.List;

public class LibraryManage {
    private List<StudentCard> Card;

    public void setCard(List<StudentCard> Card) {
        this.Card = Card;
    }

    public void landBook() {
        for (StudentCard card : Card) {
            String book;
            switch (card.getCard()) {
                case "红色A类":
                    book = "java基础图书";
                    break;
                case "红色B类":
                    book = "html";
                    break;
                case "蓝色A类":
                    book = "oracle数据库";
                    break;
                default:
                    book = "三国演义";
            }
            System.out.println(card.getName() +"\t"+ card.getCard()+"\t"+book);
        }
    }
}
