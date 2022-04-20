package com.example.handlers.entreprise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Administration_isRibKeyValid_Test {

    // GIVEN we have a NON-VALID Rib Key
    @ParameterizedTest
    // WHEN param is not in correct format
    @ValueSource(strings = {"", " "})
    void whenParamIsInvalidFormat(String args) {
        Administration handler = new Administration();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> handler.isRibKeyValid(args)
        );

        // THEN should throw an Error
        assertEquals("must be 23 alphaNumeric digits",
                exception.getMessage());
        assertEquals("java.lang.Throwable: != 23 alphaNumeric digits",
                exception.getCause().toString());
    }

    // GIVEN we have a NON-VALID Rib Key
    @ParameterizedTest
    // WHEN param is not in correct format
    @ValueSource(strings = {"15Bb7g6g3gCC9c4cC3Cc8K2"})
    void whenParamIsValid(String args) {
        Administration handler = new Administration();

        assertTrue(handler.isRibKeyValid(args));
    }
}