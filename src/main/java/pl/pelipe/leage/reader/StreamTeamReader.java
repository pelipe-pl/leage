package pl.pelipe.leage.reader;

import pl.pelipe.leage.exceptions.PlayerAlreadyExistsException;
import pl.pelipe.leage.model.Team;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StreamTeamReader extends AbstractTeamReader implements TeamReader {

    @Override
    public Team read(String filePath) throws IOException, PlayerAlreadyExistsException {
        File file = getFile(filePath);
        Team team = createTeam(file);
        Files.lines(Paths.get(filePath)).map(line -> lineToPlayer(line)).forEach(player -> {
            try {
                team.addPlayer(player);
            } catch (PlayerAlreadyExistsException e) {
                e.printStackTrace();
            }
        });
        return team;
    }
}
