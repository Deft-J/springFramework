package com.coder.team;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DeleteTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        TeamService teamService = (TeamService) context.getBean(TeamService.class);

        String deleteTeamName = "湖人";
        teamService.deleteTeam(deleteTeamName);
    }
}
