package com.coder.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class TeamDao {
    @Autowired
    private DataSource dataSource;

    public void addTeam(Team team) throws SQLException {
        String sql = "insert into team(name,address) values(?,?)";
        Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, team.getName());
        ps.setString(2, team.getAddress());
        ps.executeUpdate();
    }

    public void deleteTeam(String teamName) throws SQLException {
        String sql = "delete from team where name=?";
        Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, teamName);
        ps.executeUpdate();
    }
}
