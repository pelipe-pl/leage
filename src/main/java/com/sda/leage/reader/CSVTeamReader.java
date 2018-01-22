package com.sda.leage.reader;

import com.opencsv.CSVReader;
import com.sda.leage.model.Player;
import com.sda.leage.model.Team;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CSVTeamReader extends AbstractTeamReader implements TeamReader {

    @Override
    public Team read(String filePath) throws IOException {


        File file = new File(filePath);
        CSVReader csvReader = new CSVReader(new FileReader(filePath), ';');


        Set<Player> players = new HashSet<>();

        for (String[] row : csvReader.readAll()) {
            players.add(new Player(row[0], row[1]));
        }

        String teamName = file.getName().substring(0, (file.getName().length() - 4));
        csvReader.close();
        return new Team(teamName, players);

    }
}
