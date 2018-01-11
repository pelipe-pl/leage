package com.sda.leage.model;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


public class TeamLoaderTest {

    @Test
    public void shouldReadFileAndCreateTeamWithName() throws IOException {

        TeamLoader teamLoader = new TeamLoader();
        assertThat(teamLoader.read("src\\main\\resources\\Barca.txt").getName()).isEqualTo("Barca");
    }

    @Test

    public void shouldReturnTeamPlayerReadFromFile() throws IOException {
        TeamLoader teamLoader = new TeamLoader();
        assertThat(teamLoader.read("src\\main\\resources\\Barca.txt")
                .getPlayers().contains(new Player("Jan", "Kowalski")));
    }

    @Test
    public void shouldThrowExceptionWhenNoFile() {
        TeamLoader teamLoader = new TeamLoader();
        assertThatThrownBy(()-> teamLoader.read("src\\main\\resources\\randomasaa.txt"))
                .isInstanceOf(IOException.class);

    }
}