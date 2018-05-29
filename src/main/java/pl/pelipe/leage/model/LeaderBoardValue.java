package pl.pelipe.leage.model;

public class LeaderBoardValue {

    private Team team;
    private int wins;
    private int defeat;
    private int draw;
    private int points;
    private int goals;
    private int lostGoals;

    LeaderBoardValue(Team team) {
        this.team = team;
    }

    public void addGoals(int goalsAmount) {
        goals = goals + goalsAmount;
    }

    public void addLostGoals(int goalsAmount) {
        lostGoals = lostGoals + goalsAmount;
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
        return String.format("\nTEAM: %s (WINS-%s DRAWS-%s DEFEATS-%s GOALS-%s LOSTGOALS-%s) POINTS: %s",
                team.getName(), wins, draw, defeat, goals, lostGoals, points);
    }
}
