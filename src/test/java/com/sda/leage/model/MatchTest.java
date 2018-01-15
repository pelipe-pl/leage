package com.sda.leage.model;


import com.sda.leage.exceptions.PlayerAlreadyExistsException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class MatchTest {

    @Test

    public void shouldCreateMatchWithCorrectArguments() throws PlayerAlreadyExistsException {

        Team realMadrid = new Team("Real Madryt");
        Team fcBarcelona = new Team("F.C. Barcelona");

        Player lewandowski = new Player("Robert", "Lewandowski");
        Player ronaldo = new Player("Cristiano", "Ronaldo");
        Player messi = new Player("Lionel", "Messi");
        Player iniesta = new Player("Andres", "Iniesta");


        realMadrid.addPlayer(lewandowski);
        realMadrid.addPlayer(ronaldo);
        fcBarcelona.addPlayer(messi);
        fcBarcelona.addPlayer(iniesta);



        List realMadridShooters = new ArrayList();
        realMadridShooters.add(lewandowski);

        List fcBarcelonaShooters = new ArrayList();
        fcBarcelonaShooters.add(messi);

        Match match1 = new Match(realMadrid, fcBarcelona, realMadridShooters, fcBarcelonaShooters );

        System.out.println(match1);


    }


}