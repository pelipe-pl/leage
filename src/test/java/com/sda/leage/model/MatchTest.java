package com.sda.leage.model;


import com.sda.leage.enums.MatchResult;
import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class MatchTest {

    @Test

    public void shouldCreateMatchWithCorrectArguments() throws PlayerAlreadyExistsException {


        Player lewandowski = new Player("Robert", "Lewandowski");
        Player ronaldo = new Player("Cristiano", "Ronaldo");
        Player messi = new Player("Lionel", "Messi");
        Player iniesta = new Player("Andres", "Iniesta");

        Team realMadrid = new Team("Real Madryt");
        Team fcBarcelona = new Team("F.C. Barcelona");


        realMadrid.addPlayer(lewandowski);
        realMadrid.addPlayer(ronaldo);

        fcBarcelona.addPlayer(messi);
        fcBarcelona.addPlayer(iniesta);


        List<Player> realMadridScorers = new ArrayList<>();
        realMadridScorers.add(lewandowski);

        List<Player> fcBarcelonaScorers = new ArrayList<>();
        fcBarcelonaScorers.add(messi);

        Match match1 = new Match(realMadrid, fcBarcelona, realMadridScorers, fcBarcelonaScorers);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(match1.getMatchResult()).isEqualTo(MatchResult.DRAW);
        softly.assertThat(match1.getGuestScorers()).isEqualTo(fcBarcelonaScorers);
        softly.assertThat(match1.getHostScorers()).isEqualTo(realMadridScorers);
        softly.assertThat(match1.getHostTeam()).isEqualTo(realMadrid);
        softly.assertThat(match1.getGuestTeam()).isEqualTo(fcBarcelona);
        softly.assertAll();

    }

    @Test
    public void shouldThrowExceptionForArgumentWithWrongPlayer() throws PlayerAlreadyExistsException {
        Player lewandowski = new Player("Robert", "Lewandowski");
        Player ronaldo = new Player("Cristiano", "Ronaldo");
        Player messi = new Player("Lionel", "Messi");
        Player iniesta = new Player("Andres", "Iniesta");

        Team realMadrid = new Team("Real Madryt");
        Team fcBarcelona = new Team("F.C. Barcelona");


        realMadrid.addPlayer(lewandowski);
        realMadrid.addPlayer(ronaldo);

        fcBarcelona.addPlayer(messi);
        fcBarcelona.addPlayer(iniesta);


        List<Player> realMadridScorers = new ArrayList<>();
        realMadridScorers.add(lewandowski);

        List<Player> fcBarcelonaScorers = new ArrayList<>();
        fcBarcelonaScorers.add(messi);

        assertThatThrownBy(() -> new Match(realMadrid, fcBarcelona, fcBarcelonaScorers, realMadridScorers))
                .isInstanceOf(IllegalArgumentException.class);

    }
}