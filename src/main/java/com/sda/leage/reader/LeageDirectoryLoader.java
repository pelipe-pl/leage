package com.sda.leage.reader;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import com.sda.leage.model.LeaderBoard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeageDirectoryLoader {


    public void loadMatchesFromDirectory(LeaderBoard premierLeague, String directoryPath) throws IOException {
        File matchesDirectory = new File(directoryPath);
        if (matchesDirectory.isDirectory()) {
            File[] files = matchesDirectory.listFiles();
            MatchReader matchReader = new MatchReader();

            if (files != null) {
                for (File file : files) {
                    try {
                        if (file.isFile()) {
                            premierLeague.addNewMatch(matchReader.read(file.getPath(), premierLeague.getTeamsMap()));
                            Files.move(Paths.get(file.getPath()), Paths.get("src/main/resources/matches/processed/"
                                    + file.getName()));
                        }
                    } catch (Exception e) {
                        System.out.println("There was a problem loading match: " + file.getName());
                        e.printStackTrace();

                        try {
                            Files.move(Paths.get(file.getPath()), Paths.get("src/main/resources/matches/error/"
                                    + file.getName()));
                        } catch (IOException e1) {
                            System.out.println("There was a problem moving file " + file.getName() + " to 'error' folder");
                            e1.printStackTrace();

                        }

                    }
                }
            }
        }
    }


    public void loadTeamsFromDirectory(LeaderBoard leaderBoard, String directoryPath)
            throws IOException, PlayerAlreadyExistsException {

        File teamsDirectory = new File(directoryPath);
        if (teamsDirectory.isDirectory()) {
            File[] files = teamsDirectory.listFiles();
            TeamReader teamReader = new CSVTeamReader();
            if (files != null) {

                for (File file : files) {
                    if (file.isFile()) {
                        leaderBoard.addNewTeam(teamReader.read(file.getPath()));
                        Files.move(Paths.get(file.getPath()), Paths.get("src/main/resources/teams/processed/"
                                + file.getName()));
                    }
                }
            }
        }
    }
}
