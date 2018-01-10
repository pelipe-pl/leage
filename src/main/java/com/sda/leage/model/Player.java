package com.sda.leage.model;

import java.security.InvalidParameterException;

public class Player {


    private final String firstName;
    private final String lastName;

    public Player(String firstName, String lastName) throws InvalidParameterException {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
