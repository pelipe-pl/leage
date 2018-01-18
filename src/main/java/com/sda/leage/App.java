package com.sda.leage;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import com.sda.leage.model.LeaderBoard;
import com.sda.leage.reader.LeageDirectoryLoader;
import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException, PlayerAlreadyExistsException {


        LeaderBoard myLeage = new LeaderBoard();
        LeageDirectoryLoader leageDirectoryLoader = new LeageDirectoryLoader();

        leageDirectoryLoader.loadTeamsFromDirectory(myLeage, "src/main/resources/teams");
        leageDirectoryLoader.loadMatchesFromDirectory(myLeage, "src/main/resources/matches");

        System.out.println("LEAGE TABLE:");
        System.out.println(myLeage.getCurrentTableByPoints());
        System.out.println("");
        System.out.println("GOAL SCORERS TABLE:");
        System.out.println(myLeage.getScorersList());
        System.out.println("");

    }
}
