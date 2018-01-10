package com.sda.leage.model;

import com.sda.leage.exceptions.PlayerAlreadyExistsException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Team {

    private final String name;
    private final Set<Player> players = new HashSet<>();

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) throws PlayerAlreadyExistsException {

        if (!players.contains(player))
            players.add(player);

        else throw new PlayerAlreadyExistsException();
    }

    public String getName() {
        return name;
    }


    public Set<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) &&
                Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, players);
    }
}
