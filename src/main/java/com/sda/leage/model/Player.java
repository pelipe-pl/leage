package com.sda.leage.model;

import java.security.InvalidParameterException;

public class Player {

    private final String firstName;
    private final String lastName;

    public Player(String firstName, String lastName) throws IllegalArgumentException {
        if (firstName == null){throw new IllegalArgumentException("First name cannot be null");}
        if (lastName == null){throw new IllegalArgumentException("Last name cannot be null");}
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
