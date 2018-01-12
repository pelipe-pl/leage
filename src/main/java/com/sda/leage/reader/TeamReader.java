package com.sda.leage.reader;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import com.sda.leage.model.Team;

import java.io.IOException;

public interface TeamReader {


    Team read(String filePath) throws IOException, PlayerAlreadyExistsException;

}

