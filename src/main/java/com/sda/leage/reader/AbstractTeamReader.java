package com.sda.leage.reader;

import com.sda.leage.model.Player;
import com.sda.leage.model.Team;

import java.io.File;

abstract class AbstractTeamReader {

    protected File getFile(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Path cannot be null.");
        }
        return new File(path);
    }

    protected Team createTeam(File file) {
        return new Team(file.getName().replace(".txt", ""));
    }

    protected Player lineToPlayer(String line) {
        String[] playerData = line.split(";");

        return new Player(playerData[0], playerData[1]);
    }
}
