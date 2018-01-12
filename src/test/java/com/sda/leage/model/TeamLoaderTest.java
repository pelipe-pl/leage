package com.sda.leage.model;

import com.sda.leage.reader.CSVTeamReader;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


public class TeamLoaderTest {

    @Test
    public void shouldReadFileAndCreateTeamWithName() throws IOException {

        CSVTeamReader CSVTeamReader = new CSVTeamReader();
        assertThat(CSVTeamReader.read("src\\main\\resources\\Barca.txt").getName()).isEqualTo("Barca");
    }

    @Test

    public void shouldReturnTeamPlayerReadFromFile() throws IOException {
        CSVTeamReader CSVTeamReader = new CSVTeamReader();
        assertThat(CSVTeamReader.read("src\\main\\resources\\Barca.txt")
                .getPlayers()).contains(new Player("Adam", "Nowak"));
    }

    @Test

    public void shouldNotReturnTeamPlayerNotReadFromFile() throws IOException {
        CSVTeamReader CSVTeamReader = new CSVTeamReader();
        assertThat(CSVTeamReader.read("src\\main\\resources\\Barca.txt")
                .getPlayers()).doesNotContain(new Player("Robert", "Lewandowski"));
    }

    @Test
    public void shouldThrowExceptionWhenNoFile() {
        CSVTeamReader CSVTeamReader = new CSVTeamReader();
        assertThatThrownBy(() -> CSVTeamReader.read("src\\main\\resources\\Barcaaaaaaaaaaaa.txt"))
                .isInstanceOf(IOException.class);

    }
}