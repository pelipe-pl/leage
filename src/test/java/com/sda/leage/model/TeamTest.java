package com.sda.leage.model;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class TeamTest {

    @Test
    public void shouldAddTeam() {

        Team team = new Team("The team name");
        assertThat(team.getName()).isEqualTo("The team name");
    }

    @Test
    public void shouldAddPlayer() throws PlayerAlreadyExistsException {
        Team team = new Team("The team name");
        Player player = new Player("Jan", "Kowalski");
        team.addPlayer(player);
        assertThat(team.getPlayers()).isNotEmpty();
    }

    @Test
    public void shouldGiveEmptyPlayerList() {
        Team team = new Team("The team name");
        assertThat(team.getPlayers().isEmpty());
    }

    @Test
    public void shouldNotAddTwoSamePlayers() throws PlayerAlreadyExistsException {
        Team team = new Team("The team name");
        Player player = new Player("Jan", "Kowalski");
        Player player2 = player;
        team.addPlayer(player);

        assertThatThrownBy(() -> team.addPlayer(player2)).isInstanceOf(PlayerAlreadyExistsException.class)
                .hasMessage("Player already exists");
    }
}