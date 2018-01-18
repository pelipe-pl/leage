package com.sda.leage.reader;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import com.sda.leage.model.LeaderBoard;
import java.io.File;
import java.io.IOException;

public class LeageDirectoryLoader {


    public void loadMatchesFromDirectory(LeaderBoard premierLeague, String directoryPath) throws IOException {
        File matchesDirectory = new File(directoryPath);
        if (matchesDirectory.isDirectory()) {
            File[] files = matchesDirectory.listFiles();
            MatchReader matchReader = new MatchReader();

            if (files != null) {
                for (File file : files) {
                    premierLeague.addNewMatch(matchReader.read(file.getPath(), premierLeague.getTeamsMap()));
                }
            }
        }
    }

    public void loadTeamsFromDirectory(LeaderBoard leaderBoard, String directoryPath) throws IOException, PlayerAlreadyExistsException {
        File teamsDirectory = new File(directoryPath);
        if (teamsDirectory.isDirectory()) {
            File[] files = teamsDirectory.listFiles();
            TeamReader teamReader = new CSVTeamReader();
            if (files != null) {
                for (File file : files) {
                    leaderBoard.addNewTeam(teamReader.read(file.getPath()));
                }
            }
        }
    }
}
