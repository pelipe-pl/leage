package com.sda.leage.reader;


import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import com.sda.leage.model.Player;
import org.junit.Test;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public abstract class AbstractTeamReaderTest {

    private final TeamReader teamReader;

    public AbstractTeamReaderTest(TeamReader teamReader) {
        this.teamReader = teamReader;}

    @Test
    public void shouldReadFileAndCreateTeamWithName() throws IOException, PlayerAlreadyExistsException {

        assertThat(teamReader.read("src\\main\\resources\\Barca.txt").getName()).isEqualTo("Barca");
    }

    @Test

    public void shouldReturnTeamPlayerReadFromFile() throws IOException, PlayerAlreadyExistsException {

        assertThat(teamReader.read("src\\main\\resources\\Barca.txt")
                .getPlayers()).contains(new Player("Adam", "Nowak"));
    }

    @Test

    public void shouldNotReturnTeamPlayerNotReadFromFile() throws IOException, PlayerAlreadyExistsException {

        assertThat(teamReader.read("src\\main\\resources\\Barca.txt")
                .getPlayers()).doesNotContain(new Player("Robert", "Lewandowski"));
    }

    @Test
    public void shouldThrowExceptionWhenNoFile() {

        assertThatThrownBy(() -> teamReader.read("src\\main\\resources\\Barcaaaaaaaaaaaa.txt"))
                .isInstanceOf(IOException.class);

    }
}