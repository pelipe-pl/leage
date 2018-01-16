package com.sda.leage.model;

public class LeaderBoardValue {

    private Team team;
    private int wins;
    private int defeat;
    private int draw;
    private int points;

    public LeaderBoardValue(Team team) {
        this.team = team;
    }

    public int getWins() {
        return wins;
    }

    public void addWin() {
        wins++;
    }

    public int getDefeat() {
        return defeat;
    }

    public void addDefeat() {
        defeat++;
    }

    public int getDraw() {
        return draw;
    }

    public void addDraw() {
        draw++;
    }

    public int getPoints() {
        return points;
    }

    public void addOnePoint() {
        points++;
    }

    public void addThreePoints() {
        points = points + 3;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "LeaderBoardValue{" +
                "team=" + team +
                ", wins=" + wins +
                ", defeat=" + defeat +
                ", draw=" + draw +
                ", points=" + points +
                '}';
    }
}
