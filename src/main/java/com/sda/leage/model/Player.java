package com.sda.leage.model;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Player {

    private final String firstName;
    private final String lastName;

    public Player(String firstName, String lastName) throws IllegalArgumentException {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public static Player fromLine(String line) {
        String[] data = line.split(";");
        return new Player(data[0], data[1]);
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';



    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(firstName, player.firstName) &&
                Objects.equals(lastName, player.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }
}

