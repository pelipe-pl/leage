package com.sda.leage.model;


import com.opencsv.CSVReader;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class TeamLoader {


    public Team read(String filePath) throws IOException {


        File file = new File(filePath);
        CSVReader csvReader = new CSVReader(new FileReader(filePath), ';');

        Set<Player> players = new HashSet<>();

        for (String[] row : csvReader.readAll()) {
            players.add(new Player(row[0], row[1]));
        }

        String teamName = file.getName().substring(0, (file.getName().length()-4));

        return new Team(teamName, players);

    }

}
