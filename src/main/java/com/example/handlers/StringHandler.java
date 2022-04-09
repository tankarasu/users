package com.example.handlers;

import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class StringHandler {
    public StringHandler() {
        // No-args Constructor
    }

    /**
     * this method convert String anApplePie to AN_APPLE_PIE,
     * original separator is Upper cased letter, destination separator is _
     *
     * @param string to be converted
     * @return {String} the result is in upperCase
     */
    public String convertToUpperSnakeCase(String string) {
        char[] charArray = string.toCharArray();

        // WHY? because we need that strings containing acronym like
        // "XMLHttpRequest" work as intended with this method
        for (int i = 0; i < charArray.length; i++) {
            if (i != 0) {
                boolean isPreviousCharUpperCase = Character.isUpperCase(string.charAt(i - 1));
                if (Character.isUpperCase(string.charAt(i))) {
                    if (isPreviousCharUpperCase)
                        charArray[i] = Character.toLowerCase(charArray[i]);
                } else {
                    if (isPreviousCharUpperCase)
                        charArray[i - 1] = Character.toUpperCase(charArray[i - 1]);
                }
            }
        }

        String threatenParam = String.valueOf(charArray);
        String[] strArray = threatenParam.split("(?=[A-Z])");
        String result = stream(strArray).map(Objects::toString)
                .collect(Collectors.joining("_"));

        return result.toUpperCase();
    }
}
