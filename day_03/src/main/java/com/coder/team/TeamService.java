package com.coder.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class TeamService {
    @Autowired
    private TeamDao teamDao;

    public void addTeam(Team team) throws SQLException {
        teamDao.addTeam(team);
    }

    public void deleteTeam(String teamName) throws SQLException {
        teamDao.deleteTeam(teamName);
    }
}
