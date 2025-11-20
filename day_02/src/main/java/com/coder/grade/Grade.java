package com.coder.grade;

import java.util.Map;

public class Grade {
    private Map<String, Double> scores;

    public void setScores(Map<String, Double> scores) {
        this.scores = scores;
    }

    public double totalScore() {
        double total = 0;
        for (double score : scores.values()) {
            total += score;
        }
        return total;
    }

    public void upScores() {
        for (Map.Entry<String, Double> entry : scores.entrySet()) {
            if (entry.getValue() < 60) {
                double upscore = Math.round(entry.getValue() * 1.1*10)/10.0;
                entry.setValue(upscore);
            }
        }
    }

    public double upAverageScore() {
        double total =totalScore();
        return total / scores.size();
    }

    public void printScore() {
        System.out.println("初始成绩：" + scores);
        System.out.println("初始总成绩：" + totalScore());
        upScores();
        System.out.println("提升后成绩：" + scores);
        System.out.println("提升后平均成绩：" + upAverageScore());
    }
}