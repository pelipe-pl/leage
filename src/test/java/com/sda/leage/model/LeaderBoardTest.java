package com.sda.leage.model;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import com.sda.leage.reader.MatchReader;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LeaderBoardTest {

    @Test
    public void shouldAddNewTeamToLeaderBoard() throws PlayerAlreadyExistsException {

        Team liverpool = new Team("Liverpool F.C.");

        Player ronaldo = new Player("Cristiano", "Ronaldo");
        Player kowalski = new Player("Jan", "Kowalski");
        Player lewandowski = new Player("Robert", "Lewandowski");

        liverpool.addPlayer(ronaldo);
        liverpool.addPlayer(kowalski);
        liverpool.addPlayer(lewandowski);

        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.addNewTeam(liverpool);

        assertThat(leaderBoard.getCurrentTableMap().containsKey(liverpool));
    }

    @Test
    public void shouldAddNewMatch() throws PlayerAlreadyExistsException, IOException {

        Team liverpool = new Team("Liverpool F.C.");

        Player ronaldo = new Player("Cristiano", "Ronaldo");
        Player kowalski = new Player("Jan", "Kowalski");
        Player lewandowski = new Player("Robert", "Lewandowski");

        liverpool.addPlayer(ronaldo);
        liverpool.addPlayer(kowalski);
        liverpool.addPlayer(lewandowski);

        Team manchester = new Team("Manchester United");

        Player messi = new Player("Lionel", "Messi");
        Player nowak = new Player("Adam", "Nowak");

        manchester.addPlayer(messi);
        manchester.addPlayer(nowak);

        Map<String, Team> teams = new HashMap<>();

        teams.put("Liverpool F.C.", liverpool);
        teams.put("Manchester United", manchester);

        MatchReader matchReader = new MatchReader();
        Match match1 = matchReader.read("src\\main\\resources\\Match1.txt", teams);

        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.addNewTeam(manchester);
        leaderBoard.addNewTeam(liverpool);

        leaderBoard.addNewMatch(match1);

        System.out.println(leaderBoard.getCurrentTableByPoints());
    }
}