package pl.pelipe.leage.reader;

import pl.pelipe.leage.exceptions.PlayerAlreadyExistsException;
import pl.pelipe.leage.model.Team;

import java.io.IOException;

public interface TeamReader {

    Team read(String filePath) throws IOException, PlayerAlreadyExistsException;
}

