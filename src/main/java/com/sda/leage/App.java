package com.sda.leage;


import com.sda.leage.model.TeamLoader;

import java.io.IOException;

public class App {


    public static void main(String[] args) throws IOException {


        TeamLoader teamLoader = new TeamLoader();

        teamLoader.read("src\\main\\resources\\Barca.txt");





    }

}
