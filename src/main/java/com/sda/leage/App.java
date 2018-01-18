package com.sda.leage;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import com.sda.leage.model.LeaderBoard;
import com.sda.leage.reader.LeageDirectoryLoader;
import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException, PlayerAlreadyExistsException {


        LeaderBoard premierLeague = new LeaderBoard();
        LeageDirectoryLoader leageDirectoryLoader = new LeageDirectoryLoader();

        leageDirectoryLoader.loadTeamsFromDirectory(premierLeague, "src/main/resources/teams");
        leageDirectoryLoader.loadMatchesFromDirectory(premierLeague, "src/main/resources/matches");

        System.out.println("LEAGE TABLE:");
        System.out.println(premierLeague.getCurrentTableByPoints());
        System.out.println("");
        System.out.println("GOAL SCORERS TABLE:");
        System.out.println(premierLeague.getScorersList());
        System.out.println("");

    }
}
