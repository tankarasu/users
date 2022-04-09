package com.example.handlers.environnement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EnvironnementHandlerTest {

    @Test
    void setInvalidEnv() {
        // GIVEN we want to set an ENV
        EnvironnementHandler handler = new EnvironnementHandler();

        // WHEN the name is not valid
        // THEN an error message should be sent
        assertEquals(handler.setEnv("invalid name"), "Unknown environnement " +
                "name");
    }

    @ParameterizedTest
    @ValueSource(strings = {"DEV", "PROD", "staging"})
    void setValidEnv(String name) {
        // GIVEN we want to set an ENV
        EnvironnementHandler handler = new EnvironnementHandler();

        // WHEN the is valid insensitive case
        // THEN the right ENV should be sent
        // AND no Error Message should be sent
        assertNotEquals(handler.setEnv(name), "Unknown environnement name");
    }
}