package com.sda.leage.model;

import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PlayerTest {

    @Test

    public void forEmptyFirstNameThrowsException() {
        ThrowableAssert.ThrowingCallable shpuldRaiseThroable =
                () -> new Player(null, "LastName");
        assertThatThrownBy(() -> new Player(null, "LastName")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void forEmptyLastNameThrowsException() {
        ThrowableAssert.ThrowingCallable shpuldRaiseThroable =
                () -> new Player("First name", null);
        assertThatThrownBy(() -> new Player("First name", null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void forEmptyFullNameThrowsException() {
        ThrowableAssert.ThrowingCallable shpuldRaiseThroable =
                () -> new Player(null, null);
        assertThatThrownBy(() -> new Player(null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void forValidParametersPlayerIsCreated() {
        Player player = new Player("First name", "Last name");
        assertThat(player.getFirstName()).isEqualTo("First name");
        assertThat(player.getLastName()).isEqualTo("Last name");
    }
}