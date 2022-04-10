package com.example.handlers.devises;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeviseHandlerTest {

    @ParameterizedTest
    // GIVEN we have some devises to check
    // WHEN those devises are valid
    @ValueSource(strings = {"AFG", "ZAF", "ALA"})
    void whenDeviseIsValid(String devise) {
        DeviseHandler handler = new DeviseHandler(deviseList);

        // THEN should return true
        assertTrue(handler.isDeviseValid(devise));
    }

    @Test()
    // GIVEN we pass a non-valid devise
    // WHEN we instantiate method
    void whenDeviseIsNotValid() {
        DeviseHandler handler = new DeviseHandler(deviseList);

        // THEN should throw a NullPointerException
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> handler.isDeviseValid("invalid")
        );

        assertEquals("This devise doesn't exist: ->invalid<-", exception.getMessage());

    }

    List<String> deviseList = List.of("AFG", "ZAF", "ALA", "AND", "AGO", "AIA");
}