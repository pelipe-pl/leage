package pl.pelipe.leage.reader;

import pl.pelipe.leage.exceptions.PlayerAlreadyExistsException;
import pl.pelipe.leage.model.Team;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LinesTeamReader extends AbstractTeamReader implements TeamReader {

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
