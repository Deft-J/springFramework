package com.coder.team;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class AddTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        TeamService teamService = (TeamService) context.getBean(TeamService.class);

        Team team=new Team();
        team.setName("湖人");
        team.setAddress("洛杉矶");
        teamService.addTeam(team);
    }
}
