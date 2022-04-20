package com.example.handlers.entreprise;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * We can use this class for some special handling concern French
 * Administration.
 */
public class Administration {
    public Administration() {
        // No-args Constructor
    }

    /**
     * Method used to check if a SIREN or a SIRET is valid.
     *
     * @param siren the SIREN 9 digit or SIRET 14 digit to check
     * @return true if it's valid otherwise false
     */
    public Boolean isSirenOrSiretValid(@NotNull String siren) throws IllegalArgumentException {
        String[] charArray = new StringBuffer(siren)
                .reverse().toString().split("");

        int[] intArray = new int[charArray.length];
        int sum = 0;
        checkFormat(siren, charArray, intArray);

        return luhnAlgorithm(intArray, sum);
    }

    public boolean isRibKeyValid(String rib) throws IllegalArgumentException {
        rib = rib.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder(rib);
        formatRib(stringBuilder);

        Pattern regex = Pattern.compile("([0-9]{5})([0-9]{5})" +
                "([0-9]{11})([0-9]{2})");
        Matcher matcher = regex.matcher(stringBuilder);

        if (matcher.matches()) {
            return (Integer.parseInt(matcher.group(1), 10) * 89
                    + Integer.parseInt(matcher.group(2), 10) * 15
                    + Double.parseDouble(matcher.group(3)) * 3
                    + Integer.parseInt(matcher.group(4), 10))
                    % 97 == 0;
        } else {
            throw new IllegalArgumentException(
                    "must be 23 alphaNumeric digits",
                    new Throwable("!= 23 alphaNumeric digits")
            );
        }
    }

    private void formatRib(StringBuilder stringBuilder) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            String currentLetter = String.valueOf(stringBuilder.charAt(i));
            switch (currentLetter) {
                case "A":
                case "J":
                    stringBuilder.setCharAt(i, '1');
                    break;
                case "B":
                case "K":
                case "S":
                    stringBuilder.setCharAt(i, '2');
                    break;
                case "C":
                case "L":
                case "T":
                    stringBuilder.setCharAt(i, '3');
                    break;
                case "D":
                case "M":
                case "U":
                    stringBuilder.setCharAt(i, '4');
                    break;
                case "E":
                case "N":
                case "V":
                    stringBuilder.setCharAt(i, '5');
                    break;
                case "F":
                case "O":
                case "W":
                    stringBuilder.setCharAt(i, '6');
                    break;
                case "G":
                case "P":
                case "X":
                    stringBuilder.setCharAt(i, '7');
                    break;
                case "H":
                case "Q":
                case "Y":
                    stringBuilder.setCharAt(i, '8');
                    break;
                case "I":
                case "R":
                case "Z":
                    stringBuilder.setCharAt(i, '9');
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * This method check if string in argument contains no-Alpha digit. it
     * also checks that the length of the argument is 9 or 14.
     *
     * @param siren     SIREN or SIRET
     * @param charArray array containing all characters of the string
     * @param intArray  array needed to process String -> Int
     */
    private void checkFormat(@NotNull String siren, String[] charArray, int[] intArray) {
        try {
            Double.parseDouble(siren);
        } catch (IllegalArgumentException e) {
            notNumericStringError();
        }

        if (siren.length() == 9 || siren.length() == 14) {
            for (int i = 0; i < charArray.length; i++)
                intArray[i] = Integer.parseInt(charArray[i], 10);
        } else {
            notNumericStringError();
        }
    }

    /**
     * This method throws an Error when a param contains Alphabetic characters.
     */
    private void notNumericStringError() {
        throw new IllegalArgumentException(
                "must be 9 or 14 numeric digits",
                new Throwable("9 or 14 numeric digits"));
    }

    /**
     * this method use the luhnAlgorithm to process an Array of integers.
     * He's not limited to SIREN or SIRET.
     *
     * @param intArray Array with all integers
     * @param sum      the sum that will be handled
     * @return true if the array contains valid integers according the
     * criteria of the algorithm otherwise false.
     */
    private boolean luhnAlgorithm(int[] intArray, int sum) {
        for (int i = 0; i < intArray.length; i++) {
            if (i % 2 == 0) sum += intArray[i];
            else {
                if (intArray[i] * 2 > 9) sum += (intArray[i] * 2 - 9);
                else sum += (intArray[i] * 2);
            }
        }
        return sum % 10 == 0;
    }
}
