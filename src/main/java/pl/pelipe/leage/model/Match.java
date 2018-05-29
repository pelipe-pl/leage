package pl.pelipe.leage.model;

import pl.pelipe.leage.enums.MatchResult;

import java.util.List;

public class Match {

    private Team hostTeam;
    private Team guestTeam;
    private MatchResult matchResult;
    private List<Player> hostScorers;
    private List<Player> guestScorers;

    public Match(Team hostTeam, Team guestTeam, List<Player> hostScorers, List<Player> guestScorers)
            throws IllegalArgumentException {
        this.hostTeam = hostTeam;
        this.guestTeam = guestTeam;

        if (this.hostTeam.getPlayers().containsAll(hostScorers)) {
            this.hostScorers = hostScorers;
        } else throw new IllegalArgumentException("The host team scorers list contains wrong player");

        if (guestTeam.getPlayers().containsAll(guestScorers)) {
            this.guestScorers = guestScorers;
        } else throw new IllegalArgumentException("The guest team scorers list contains wrong player");

        if (hostScorers.size() > guestScorers.size()) {
            this.matchResult = MatchResult.HOSTS_WIN;
        }
        else if (hostScorers.size() < guestScorers.size()) {
            this.matchResult = MatchResult.GUESTS_WIN;
        } else {
            this.matchResult = MatchResult.DRAW;
        }
    }

    @Override
    public String toString() {
        return "Match{" +
                "hostTeam=" + hostTeam +
                ", guestTeam=" + guestTeam +
                ", matchResult=" + matchResult +
                ", hostScorers=" + hostScorers +
                ", guestScorers=" + guestScorers +
                '}';
    }

    public Team getHostTeam() {
        return hostTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public List<Player> getHostScorers() {
        return hostScorers;
    }

    public List<Player> getGuestScorers() {
        return guestScorers;
    }
}

