package com.sda.leage.reader;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import com.sda.leage.model.Team;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamTeamReader extends AbstractTeamReader implements TeamReader {


    //TODO

    @Override
    public Team read(String filePath) throws IOException, PlayerAlreadyExistsException {
        File file = getFile(filePath);
        Team team = createTeam(file);
        Stream<String> lines = Files.lines(Paths.get(filePath));


        return team;
    }
}
