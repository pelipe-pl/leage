package com.sda.leage;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import com.sda.leage.model.LeaderBoard;
import com.sda.leage.reader.LeageDirectoryLoader;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class App {

    public static void main(String[] args) throws IOException, PlayerAlreadyExistsException {


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        LeaderBoard myLeage = new LeaderBoard();
        LeageDirectoryLoader leageDirectoryLoader = new LeageDirectoryLoader();

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                leageDirectoryLoader.loadTeamsFromDirectory
                        (myLeage, "src/main/resources/teams");
            } catch (IOException | PlayerAlreadyExistsException e) {
                e.printStackTrace();
            }
        }, 0, 30, TimeUnit.SECONDS);


        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                leageDirectoryLoader.loadMatchesFromDirectory(myLeage, "src/main/resources/matches");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 5, 30, TimeUnit.SECONDS);


        scheduledExecutorService.scheduleAtFixedRate(() -> printTables(myLeage),
                10, 10, TimeUnit.SECONDS);


    }

    private static void printTables(LeaderBoard myLeage) {
        System.out.println("LEAGE TABLE:");
        System.out.println(myLeage.getCurrentTableByPoints());
        System.out.println("");
        System.out.println("GOAL SCORERS TABLE:");
        System.out.println(myLeage.getScorersList());
        System.out.println("");

    }
}


