package com.sda.leage.model;

import com.sda.leage.enums.MatchResult;

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

//        if (this.hostScorers.containsAll(this.hostTeam.getPlayers())) {
            this.hostScorers = hostScorers;
//        } else throw new IllegalArgumentException("The host team scorers list contains wrong player");

//
//        if (this.guestScorers.containsAll(guestTeam.getPlayers())) {
            this.guestScorers = guestScorers;
//        } else throw new IllegalArgumentException("The guest team scorers list contains wrong player");


        if (hostScorers.size() > guestScorers.size()) {
            matchResult = MatchResult.HOSTS_WIN;
        }
        if (hostScorers.size() < guestScorers.size()) {
            matchResult = MatchResult.GUESTS_WIN;
        } else {
            matchResult = MatchResult.DRAW;
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
}

