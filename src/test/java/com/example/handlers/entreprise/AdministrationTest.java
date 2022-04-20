package com.example.handlers.entreprise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AdministrationTest {
    Administration handler = new Administration();

    @ParameterizedTest
    // GIVEN we want to check valid SIREN & SIRET
    @ValueSource(strings = {"732829320", "73282932000074"})
    void whenSirenOrSiretIsValid(String numbers) {
        // THEN should be true
        assertTrue(handler.isSirenOrSiretValid(numbers));
    }

    @ParameterizedTest
    // GIVEN we want to check INVALID SIREN & SIRET
    // WHEN params are in the GOOD format but NOT VALID
    @ValueSource(strings = {"732829321", "73282932000071"})
    void whenSumIsNotValid(String numbers) {
        // THEN should be false
        assertFalse(handler.isSirenOrSiretValid(numbers));
    }

    @ParameterizedTest
    // GIVEN we want to check NON-VALID SIREN & SIRET
    // WHEN params have only NON-VALID FORMAT
    @ValueSource(strings = {"INVALID","73e82932t","234" })
    void whenSirenOrSiretIsInvalid(String args) {
        Administration handler = new Administration();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> handler.isSirenOrSiretValid(args)
        );

        // THEN should an Error be thrown
        assertEquals("must be 9 or 14 numeric digits", exception.getMessage());
        assertEquals("java.lang.Throwable: 9 or 14 numeric digits",
                exception.getCause().toString());
    }
}