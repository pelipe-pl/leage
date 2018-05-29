package pl.pelipe.leage.reader;

import pl.pelipe.leage.enums.MatchResult;
import pl.pelipe.leage.exceptions.PlayerAlreadyExistsException;
import pl.pelipe.leage.model.Match;
import pl.pelipe.leage.model.Player;
import pl.pelipe.leage.model.Team;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MatchReaderTest {

    @Test
    public void shouldReadMathFromFile() throws PlayerAlreadyExistsException, IOException {

        Team liverpool = new Team("Liverpool F.C.");

        Player ronaldo = new Player("Cristiano", "Ronaldo");
        Player kowalski = new Player("Jan", "Kowalski");
        Player lewandowski = new Player("Robert", "Lewandowski");

        liverpool.addPlayer(ronaldo);
        liverpool.addPlayer(kowalski);
        liverpool.addPlayer(lewandowski);

        Team manchester = new Team("Manchester United");

        Player messi = new Player("Lionel", "Messi");
        Player nowak = new Player("Adam", "Nowak");

        manchester.addPlayer(messi);
        manchester.addPlayer(nowak);

        Map<String, Team> teams = new HashMap<>();

        teams.put("Liverpool F.C.", liverpool);
        teams.put("Manchester United", manchester);

        MatchReader matchReader = new MatchReader();
        Match match1 = matchReader.read("src\\main\\resources\\Match1.txt", teams);

        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(match1.getHostTeam()).isEqualTo(liverpool);
        soft.assertThat(match1.getGuestTeam()).isEqualTo(manchester);
        soft.assertThat(match1.getMatchResult()).isEqualTo(MatchResult.HOSTS_WIN);
        soft.assertAll();
    }
}