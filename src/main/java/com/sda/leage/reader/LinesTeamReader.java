package com.sda.leage.reader;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import com.sda.leage.model.Team;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LinesTeamReader extends AbstractTeamLeader implements TeamReader {

    @Override
    public Team read(String filePath) throws IOException, PlayerAlreadyExistsException {

        File file = getFile(filePath);
        Team team = createTeam(file);
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines) {
            team.addPlayer(lineToPlayer(line));
        }

        return team;




    }
}
