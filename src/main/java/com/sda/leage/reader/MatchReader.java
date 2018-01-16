package com.sda.leage.reader;

import com.sda.leage.enums.MatchResult;
import com.sda.leage.model.Match;
import com.sda.leage.model.Player;
import com.sda.leage.model.Team;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class MatchReader {

    public Match read(String filePath, Map<String, Team> teams) throws IOException {

        checkNotNull(filePath, "Path cannot be null");
        checkNotNull(teams, "Teams collection cannot be null");
        checkArgument(teams.size() >= 2, "There must be at least 2 teams.");

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        String hostName = determineTeamName(lines.stream(), "host:");
        checkState(teams.containsKey(hostName), "%s does not contains host %s", teams, hostName);
        String guestName = determineTeamName(lines.stream(), "guest:");
        checkState(teams.containsKey(guestName), "%s does not contains guest %s", teams, guestName);

        List<Player> hostScores = determineScores(lines.stream(), "host-score:");
        List<Player> guestScores = determineScores(lines.stream(), "guest-score:");

        return new Match(teams.get(hostName), teams.get(guestName), hostScores, guestScores);
    }

    private String determineTeamName(Stream<String> lines, String prefix) {
        return lines.filter(p -> p.startsWith(prefix))
                .map(l -> l.replace(prefix, ""))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    private List<Player> determineScores(Stream<String> lines, String prefix) {
        return lines.filter(p -> p.startsWith(prefix))
                .map(l -> l.replace(prefix, ""))
                .map(Player::fromLine)
                .collect(Collectors.toList());
    }


}
