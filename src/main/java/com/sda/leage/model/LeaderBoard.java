package com.sda.leage.model;

import com.sda.leage.enums.MatchResult;

import java.util.*;
import java.util.stream.Collectors;

public class LeaderBoard {

    private Map<Team, LeaderBoardValue> leaderBoardMap = new HashMap<>();


    public void addNewTeam(Team team) {
        this.leaderBoardMap.put(team, new LeaderBoardValue(team));
    }

    public void addNewMatch(Match match) throws IllegalArgumentException {

        if (!leaderBoardMap.containsKey(match.getHostTeam()) ||
                !leaderBoardMap.containsKey(match.getGuestTeam())) {
            throw new IllegalArgumentException("These teams match should not be in this table");
        } else {

            if (match.getMatchResult() == MatchResult.DRAW) {

                this.leaderBoardMap.get(match.getHostTeam()).addDraw();
                this.leaderBoardMap.get(match.getHostTeam()).addOnePoint();
                this.leaderBoardMap.get(match.getGuestTeam()).addDraw();
                this.leaderBoardMap.get(match.getGuestTeam()).addOnePoint();
            }
            if (match.getMatchResult() == MatchResult.HOSTS_WIN) {

                leaderBoardMap.get(match.getHostTeam()).addWin();
                leaderBoardMap.get(match.getHostTeam()).addThreePoints();
            }

            if (match.getMatchResult() == MatchResult.GUESTS_WIN) {

                leaderBoardMap.get(match.getGuestTeam()).addWin();
                leaderBoardMap.get(match.getGuestTeam()).addThreePoints();
            }
        }
    }

    public List getCurrentTableByPoints() {

        List<LeaderBoardValue> list = new ArrayList<>(leaderBoardMap.values());

        return list.stream().sorted(Comparator.comparingInt(LeaderBoardValue::getPoints).reversed())
                .collect(Collectors.toList());
    }

    public Map<Team, LeaderBoardValue> getCurrentTableMap() {
        return leaderBoardMap;
    }
}
