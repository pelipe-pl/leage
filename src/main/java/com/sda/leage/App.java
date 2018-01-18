package com.sda.leage;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import com.sda.leage.model.LeaderBoard;
import com.sda.leage.model.Team;
import com.sda.leage.reader.CSVTeamReader;
import com.sda.leage.reader.MatchReader;
import com.sda.leage.reader.TeamReader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class App {

    public static void main(String[] args) throws IOException, PlayerAlreadyExistsException {


        LeaderBoard premierLeague = new LeaderBoard();
        Map<String, Team> teams = new HashMap<>();

        File teamsDirectory = new File("src/main/resources/teams");
        if (teamsDirectory.isDirectory()) {
            File[] files = teamsDirectory.listFiles();
            TeamReader teamReader = new CSVTeamReader();
            if (files != null) {
                for (File file : files) {
                    premierLeague.addNewTeam(teamReader.read(file.getPath()));
                    teams.put(teamReader.read(file.getPath()).getName(),
                            teamReader.read(file.getPath()));
                }
            }
        }

        File matchesDirectory = new File("src/main/resources/matches");
        if (matchesDirectory.isDirectory()) {
            File[] files = matchesDirectory.listFiles();
            MatchReader matchReader = new MatchReader();
            if (files != null) {
                for (File file : files) {
                    premierLeague.addNewMatch(matchReader.read(file.getPath(), teams));
                }
            }
        }
    }
}
