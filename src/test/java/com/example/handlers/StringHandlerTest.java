package com.example.handlers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StringHandlerTest {

    @ParameterizedTest
    @ValueSource(strings = {"foo", "anApplePie", "XMLHttpRequest"})
    void convertToUpperSnakeCase(String name) {
        // GIVEN we want to convert a String
        StringHandler handler = new StringHandler();
        List<String> expected = List.of("FOO", "AN_APPLE_PIE",
                "XML_HTTP_REQUEST");

        // WHEN we invoke the method
        // THEN the string should be converted
        assertTrue(expected.contains(handler.convertToUpperSnakeCase(name)));
    }
}
