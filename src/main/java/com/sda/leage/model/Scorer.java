package com.sda.leage.model;

import java.util.Objects;

public class Scorer {

    private Player player;
    private Integer goals;

    public Scorer(Player player, Integer goals) {
        this.player = player;
        this.goals = goals;
    }

    public void addGoal() {
        goals++;
    }

    public Player getPlayer() {
        return player;
    }

    public Integer getGoals() {
        return goals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scorer scorer = (Scorer) o;
        return Objects.equals(player, scorer.player) &&
                Objects.equals(goals, scorer.goals);
    }

    @Override
    public int hashCode() {

        return Objects.hash(player, goals);
    }

    @Override
    public String toString() {
        return String.format("\nPLAYER %s %s, GOALS: %s", player.getFirstName(), player.getLastName(), goals);
    }
}
